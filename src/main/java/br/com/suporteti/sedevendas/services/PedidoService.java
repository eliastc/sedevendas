package br.com.suporteti.sedevendas.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.suporteti.sedevendas.domain.Cliente;
import br.com.suporteti.sedevendas.domain.ItemPedido;
import br.com.suporteti.sedevendas.domain.PagamentoComBoleto;
import br.com.suporteti.sedevendas.domain.PagamentoComCartao;
import br.com.suporteti.sedevendas.domain.PagamentoaVista;
import br.com.suporteti.sedevendas.domain.Pedido;
import br.com.suporteti.sedevendas.domain.enums.EstadoPagamento;
import br.com.suporteti.sedevendas.repositories.ItemPedidoRepository;
import br.com.suporteti.sedevendas.repositories.PagamentoRepository;
import br.com.suporteti.sedevendas.repositories.PedidoRepository;
import br.com.suporteti.sedevendas.security.UserSS;
import br.com.suporteti.sedevendas.services.exceptions.AuthorizationException;
import br.com.suporteti.sedevendas.services.exceptions.ObjectNaoFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private CartaoService cartaoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EmailService emailService;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNaoFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		else if (obj.getPagamento() instanceof PagamentoComCartao) {
			PagamentoComCartao pagto2 = (PagamentoComCartao) obj.getPagamento();
			cartaoService.pagarComCartao(pagto2, obj.getInstante());
		
		}
		else if (obj.getPagamento() instanceof PagamentoaVista) {
			PagamentoaVista pagto3 = (PagamentoaVista) obj.getPagamento();
			vistaService.pagaraVista(pagto3, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}

		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		return obj;
	}


	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente = clienteService.find(user.getId());
		return repo.findByCliente(cliente, pageRequest);
	}
	
	public List<Pedido> findAll() {
		return repo.findAll();
	}

}
