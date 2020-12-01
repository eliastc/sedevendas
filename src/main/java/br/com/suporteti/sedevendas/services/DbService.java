package br.com.suporteti.sedevendas.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.suporteti.sedevendas.domain.Categoria;
import br.com.suporteti.sedevendas.domain.Cidade;
import br.com.suporteti.sedevendas.domain.Cliente;
import br.com.suporteti.sedevendas.domain.Endereco;
import br.com.suporteti.sedevendas.domain.Estado;
import br.com.suporteti.sedevendas.domain.Produto;
import br.com.suporteti.sedevendas.domain.enums.Perfil;
import br.com.suporteti.sedevendas.domain.enums.TipoCliente;
import br.com.suporteti.sedevendas.domain.enums.UnidProd;
import br.com.suporteti.sedevendas.repositories.CategoriaRepository;
import br.com.suporteti.sedevendas.repositories.CidadeRepository;
import br.com.suporteti.sedevendas.repositories.ClienteRepository;
import br.com.suporteti.sedevendas.repositories.EnderecoRepository;
import br.com.suporteti.sedevendas.repositories.EstadoRepository;
import br.com.suporteti.sedevendas.repositories.ProdutoRepository;


@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository prodRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Aluminio");
		Categoria cat2 = new Categoria(null, "Automotivo");
		Categoria cat3 = new Categoria(null, "Bazar");
		Categoria cat4 = new Categoria(null, "Cabeleireiros");
		Categoria cat5 = new Categoria(null, "Cabeleireiros - Escobel");
		Categoria cat6 = new Categoria(null, "Cabeleireiros - Higibelle");
		Categoria cat7 = new Categoria(null, "Cabeleireiros - Merheje");
		Categoria cat8 = new Categoria(null, "Cabeleireiros - Santa Clara");
		Categoria cat9 = new Categoria(null, "Costura");
		Categoria cat10 = new Categoria(null, "Eletricidade");
		Categoria cat11 = new Categoria(null, "Eletricidade - Empalux");
		Categoria cat12 = new Categoria(null, "Eletricidade - GE");
		Categoria cat13 = new Categoria(null, "Escolar");
		Categoria cat14 = new Categoria(null, "Escolar - Astral");
		Categoria cat15 = new Categoria(null, "Escolar - Compactor");
		Categoria cat16 = new Categoria(null, "Escolar - Foroni");
		Categoria cat17 = new Categoria(null, "Escolar - Jandaia");
		Categoria cat18 = new Categoria(null, "Escolar - Maped");
		Categoria cat19 = new Categoria(null, "Escolar - Maripel");
		Categoria cat20 = new Categoria(null, "Escolar - Maxima");
		Categoria cat21 = new Categoria(null, "Escolar - Tilibra");
		Categoria cat22 = new Categoria(null, "Expositores");
		Categoria cat23 = new Categoria(null, "Ferragens");
		Categoria cat24 = new Categoria(null, "festas");
		Categoria cat25 = new Categoria(null, "Higiene");
		Categoria cat26 = new Categoria(null, "Higiene - Multlink");
		Categoria cat27 = new Categoria(null, "Higieneb - Sergyene");
		Categoria cat28 = new Categoria(null, "Higiene - Gillete");
		Categoria cat29 = new Categoria(null, "Infantil");
		Categoria cat30 = new Categoria(null, "Infantil - Cefisa");
		Categoria cat31 = new Categoria(null, "Infantil - Murano");
		Categoria cat32 = new Categoria(null, "Infantil - Ternurinha Bebe");
		Categoria cat33 = new Categoria(null, "Inox");
		Categoria cat34 = new Categoria(null, "Inox - Dinamika");
		Categoria cat35 = new Categoria(null, "Inox - Premiere");
		Categoria cat36 = new Categoria(null, "Inox - Simonaggio");
		Categoria cat37 = new Categoria(null, "Inox - Tramontina");
		Categoria cat38 = new Categoria(null, "Inox - Trinox");
		Categoria cat39 = new Categoria(null, "Isopor");
		Categoria cat40 = new Categoria(null, "Limpeza");
		Categoria cat41 = new Categoria(null, "Limpeza - Bettanin");
		Categoria cat42 = new Categoria(null, "Limpeza - Espumil");
		Categoria cat43 = new Categoria(null, "Limpeza - K&M");
		Categoria cat44 = new Categoria(null, "Limpeza - Lustrelar");
		Categoria cat45 = new Categoria(null, "Limpeza - Lustrelar Premium");
		Categoria cat46 = new Categoria(null, "Limpeza - Oriental");
		Categoria cat47 = new Categoria(null, "Limpeza - Soin");
		Categoria cat48 = new Categoria(null, "Perfumaria");
		Categoria cat49 = new Categoria(null, "Perfumaria - Acapulco");
		Categoria cat50 = new Categoria(null, "Perfumaria - Farmax");
		Categoria cat51 = new Categoria(null, "Perfumaria - Guararapes");
		Categoria cat52 = new Categoria(null, "Perfumaria - Ideal");
		Categoria cat53 = new Categoria(null, "Perfumaria - Memphis");
		Categoria cat54 = new Categoria(null, "Perfumaria - Natu Hair");
		Categoria cat55 = new Categoria(null, "Perfumaria - Skala");
		Categoria cat56 = new Categoria(null, "Plasticos");
		Categoria cat57 = new Categoria(null, "Plasticos - Mb");
		Categoria cat58 = new Categoria(null, "Plasticos - Milplastic");
		Categoria cat59 = new Categoria(null, "Plasticos Acrylic Line");
		Categoria cat60 = new Categoria(null, "Plasticos");
		Categoria cat61 = new Categoria(null, "Plasticos Explanflex");
		Categoria cat62 = new Categoria(null, "Plasticos Gedex");
		Categoria cat63 = new Categoria(null, "Plasticos Icasa");
		Categoria cat64 = new Categoria(null, "Plasticos Injetemp");
		Categoria cat65 = new Categoria(null, "Plasticos Jaguar");
		Categoria cat66 = new Categoria(null, "Plasticos Plasduran");
		Categoria cat67 = new Categoria(null, "Plasticos Plasnorthon");
		Categoria cat68 = new Categoria(null, "Plasticos Plastigel");
		Categoria cat69 = new Categoria(null, "Plasticos Plasutil");
		Categoria cat70 = new Categoria(null, "Plasticos Polyutil");
		Categoria cat71 = new Categoria(null, "Plasticos Toyplast");
		Categoria cat72 = new Categoria(null, "Plasticos Tritec");
		Categoria cat73 = new Categoria(null, "Plasticos Daivak");
		Categoria cat74 = new Categoria(null, "Produtos Promocionais");
		Categoria cat75 = new Categoria(null, "Tabela - Extra");
		Categoria cat76 = new Categoria(null, "Utilidade - Stolf");
		Categoria cat77 = new Categoria(null, "Utilidades");
		Categoria cat78 = new Categoria(null, "Utilidades - Adomes");
		Categoria cat79 = new Categoria(null, "Utilidades - Decor-Util");
		Categoria cat80 = new Categoria(null, "Utilidades - Original");
		Categoria cat81 = new Categoria(null, "Utilidades - Sj Lar");
		Categoria cat82 = new Categoria(null, "Utilidades - Utimil");
		Categoria cat83 = new Categoria(null, "Utilidades Domama");
		Categoria cat84 = new Categoria(null, "Vidros");
		

		
		
		Produto p1 = new Produto(null, "APLICADOR 160ML R.330 DOMPEL UN", 1.33, UnidProd.UN);
		Produto p2 = new Produto(null, "FORMA P/BAURU VISON R.10.011 UN", 9.80, UnidProd.UN);
		Produto p3 = new Produto(null, "FORMA P/BAURU VISON R.10.011 DZ", 117.63, UnidProd.DZ);
		Produto p4 = new Produto(null, "GARFO CARNE C.MD.VIS.R.10.004 UN", 3.35, UnidProd.UN);
		Produto p5 = new Produto(null, "GARFO CARNE C.MD.VIS.R.10.004 DZ", 40.15, UnidProd.DZ);
		Produto p6 = new Produto(null, "AROMAT.MONZA GEL CARRO N60G UN", 6.02, UnidProd.UN);
		Produto p7 = new Produto(null, "AROMAT.MONZA GEL CARRO N60G CX", 144.43, UnidProd.CX);
		Produto p8 = new Produto(null, "AROMAT.MONZA GEL LAVANDA N60G UN", 6.02, UnidProd.UN);
		Produto p9 = new Produto(null, "AROMAT.MONZA GEL LAVANDA N60G CX", 144.43, UnidProd.CX);
		Produto p10 = new Produto(null, "AROMAT.MONZA GEL MORANGO N60G UN", 6.02, UnidProd.UN);
		Produto p11 = new Produto(null, "AROMAT.MONZA GEL MORANGO N60G CX", 144.43, UnidProd.CX);
		Produto p12 = new Produto(null, "AROMAT.MONZA GEL TUTFRUT N60G UN", 6.02, UnidProd.UN);
		Produto p13 = new Produto(null, "AROMAT.MONZA GEL TUTFRUT N60G CX", 144.43, UnidProd.CX);
		Produto p14 = new Produto(null, "AROMAT.MONZA GEL UVA N60G UN", 6.02, UnidProd.UN);
		Produto p15 = new Produto(null, "AROMAT.MONZA GEL UVA N60G CX", 144.43, UnidProd.CX);
		Produto p16 = new Produto(null, "AROMAT.MONZA 10ML UN", 6.02, UnidProd.UN);
		Produto p17 = new Produto(null, "AROMAT.MONZA 10ML CX", 168.67, UnidProd.CX);
		
		
		//corrigir fazendo com que as categorias conheçam seus produtos associados
		cat1.getProdutos().addAll(Arrays.asList(p2,p3,p4,p5));
		cat77.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat77));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat1));
		p6.getCategorias().addAll(Arrays.asList(cat2));
		p7.getCategorias().addAll(Arrays.asList(cat2));
		p8.getCategorias().addAll(Arrays.asList(cat2));
		p9.getCategorias().addAll(Arrays.asList(cat2));
		p10.getCategorias().addAll(Arrays.asList(cat2));
		p11.getCategorias().addAll(Arrays.asList(cat2));
		p12.getCategorias().addAll(Arrays.asList(cat2));
		p13.getCategorias().addAll(Arrays.asList(cat2));
		p14.getCategorias().addAll(Arrays.asList(cat2));
		p15.getCategorias().addAll(Arrays.asList(cat2));
		p16.getCategorias().addAll(Arrays.asList(cat2));
		p17.getCategorias().addAll(Arrays.asList(cat2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11,
				cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20, cat21, cat22, cat23, cat24, cat25, cat26,
				cat27, cat28, cat29, cat30, cat31, cat32, cat33, cat34, cat35, cat36, cat37, cat38, cat39, cat40, cat41,
				cat42, cat43, cat44, cat45, cat46, cat47, cat48, cat49, cat50, cat51, cat52, cat53, cat54, cat55, cat56,
				cat57, cat58, cat59, cat60, cat61, cat62, cat63, cat64, cat65, cat66, cat67, cat68, cat69, cat70, cat71,
				cat72, cat73, cat74, cat75, cat76, cat77, cat78, cat79, cat80, cat81, cat82, cat83, cat84));
		
		prodRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17));
		
		
		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "Alagoas");
		Estado est3 = new Estado(null, "Bahia");
		Estado est4 = new Estado(null, "Ceará");
		Estado est5 = new Estado(null, "Maranhão");
		Estado est6 = new Estado(null, "Paraíba");
		Estado est7 = new Estado(null, "Piauí");
		Estado est8 = new Estado(null, "Rio Grande do Norte");
		Estado est9 = new Estado(null, "Sergipe");
		Estado est10 = new Estado(null, "Minas Gerais");
		Estado est11 = new Estado(null, "Paraná");
		Estado est12 = new Estado(null, "Rio Grande do Sul");
		Estado est13 = new Estado(null, "Santa Catarina");
		Estado est14 = new Estado(null, "Goiás");
		Estado est15 = new Estado(null, "São Paulo");
		Estado est16 = new Estado(null, "Amazonas");
		Estado est17 = new Estado(null, "Pará");
		Estado est18 = new Estado(null, "Espírito Santo");
		Estado est19 = new Estado(null, "Mato Grosso");
		Estado est20 = new Estado(null, "Mato Grosso do Sul");
		Estado est21 = new Estado(null, "Acre");
		Estado est22 = new Estado(null, "Roraima");
		Estado est23 = new Estado(null, "Rio de Janeiro");
		Estado est24 = new Estado(null, "Tocatins");
		Estado est25 = new Estado(null, "Rondônia");
		Estado est26 = new Estado(null, "Amapá");
		
		
		
		Cidade c1 = new Cidade(null, "Recife", est1);
		Cidade c2 = new Cidade(null, "Olinda", est1);
		Cidade c3 = new Cidade(null, "Jaboatão dos Guararapes", est1);
		Cidade c4 = new Cidade(null, "Caruaru", est1);
		Cidade c5 = new Cidade(null, "Petrolina", est1);
		Cidade c6 = new Cidade(null, "Garanhuns", est1);
		Cidade c7 = new Cidade(null, "Goiana", est1);
		Cidade c8 = new Cidade(null, "Bezerros", est1);
		Cidade c9 = new Cidade(null, "Paulista", est1);
		Cidade c10 = new Cidade(null, "Gravatá", est1);
		Cidade c11 = new Cidade(null, "Pesqueira", est1);
		Cidade c12 = new Cidade(null, "Camaragibe", est1);
		Cidade c13 = new Cidade(null, "Palmares", est1);
		Cidade c14 = new Cidade(null, "Serra Talhada", est1);
		Cidade c15 = new Cidade(null, "Arcoverde", est1);
		Cidade c16 = new Cidade(null, "Belo Jardim", est1);
		Cidade c17 = new Cidade(null, "Bonito", est1);
		Cidade c18 = new Cidade(null, "Vitória de Santo Antão", est1);
		Cidade c19 = new Cidade(null, "Alagoinha", est1);
		Cidade c20 = new Cidade(null, "Igarassu", est1);
		Cidade c21 = new Cidade(null, "Brejo da Madre de Deus", est1);
		Cidade c22 = new Cidade(null, "Sirinhaém", est1);
		Cidade c23 = new Cidade(null, "São Caetano", est1);
		Cidade c24 = new Cidade(null, "Bom Conselho", est1);
		Cidade c25 = new Cidade(null, "Salgueiro", est1);
		Cidade c26 = new Cidade(null, "Abreu e Lima", est1);
		Cidade c27 = new Cidade(null, "Lajedo", est1);
		Cidade c28 = new Cidade(null, "Terezinha", est1);
		Cidade c29 = new Cidade(null, "Taquaritinga do Norte", est1);
		Cidade c30 = new Cidade(null, "São Vicente Ferrer", est1);
		Cidade c31 = new Cidade(null, "Triunfo", est1);
		Cidade c32 = new Cidade(null, "Tamandaré", est1);
		Cidade c33 = new Cidade(null, "Lagoa dos Gatos", est1);
		Cidade c34 = new Cidade(null, "Jaqueira", est1);
		Cidade c35 = new Cidade(null, "Ilha de Itamaracá", est1);
		Cidade c36 = new Cidade(null, "João Alfredo", est1);
		Cidade c37 = new Cidade(null, "Afogados da Ingazeira", est1);
		Cidade c38 = new Cidade(null, "Custódia", est1);
		Cidade c39 = new Cidade(null, "Correntes", est1);
		Cidade c40 = new Cidade(null, "Floresta", est1);
		Cidade c41 = new Cidade(null, "Flores", est1);
		Cidade c42 = new Cidade(null, "Petrolândia", est1);
		Cidade c43 = new Cidade(null, "Afrânio", est1);
		Cidade c44 = new Cidade(null, "Cabrobó", est1);
		Cidade c45 = new Cidade(null, "Belém de São Francisco", est1);
		Cidade c46 = new Cidade(null, "Surubim", est1);
		Cidade c47 = new Cidade(null, "Itapetim", est1);
		Cidade c48 = new Cidade(null, "Nazaré da Mata", est1);
		Cidade c49 = new Cidade(null, "Glória do Goitá", est1);
		Cidade c50 = new Cidade(null, "Granito", est1);
		Cidade c51 = new Cidade(null, "Cabo de Santo Agostinho", est1);
		Cidade c52 = new Cidade(null, "São Lourenço da Mata", est1);
		Cidade c53 = new Cidade(null, "Santa Cruz do Capibaribe", est1);
		Cidade c54 = new Cidade(null, "Ipojuca", est1);
		Cidade c55 = new Cidade(null, "Araripina", est1);
		Cidade c56 = new Cidade(null, "Carpina", est1);
		Cidade c57 = new Cidade(null, "Escada", est1);
		Cidade c58 = new Cidade(null, "Ouricuri", est1);
		Cidade c59 = new Cidade(null, "Moreno", est1);
		Cidade c60 = new Cidade(null, "São Bento do Una", est1);
		Cidade c61 = new Cidade(null, "Buíque", est1);
		Cidade c62 = new Cidade(null, "Paudalho", est1);
		Cidade c63 = new Cidade(null, "Limoeiro", est1);
		Cidade c64 = new Cidade(null, "Timbaúba", est1);
		Cidade c65 = new Cidade(null, "Ribeirão", est1);
		Cidade c66 = new Cidade(null, "Toritama", est1);
		Cidade c67 = new Cidade(null, "Catende", est1);
		Cidade c68 = new Cidade(null, "Água Belas", est1);
		Cidade c69 = new Cidade(null, "Bom Jardim", est1);
		Cidade c70 = new Cidade(null, "Aliança", est1);
		Cidade c71 = new Cidade(null, "Bodocó", est1);
		Cidade c72 = new Cidade(null, "Água Preta", est1);
		Cidade c73 = new Cidade(null, "Itambé", est1);
		Cidade c74 = new Cidade(null, "Sertânia", est1);
		Cidade c75 = new Cidade(null, "São José do Belmonte", est1);
		Cidade c76 = new Cidade(null, "São josé do Egito", est1);
		Cidade c77 = new Cidade(null, "Vicência", est1);
		Cidade c78 = new Cidade(null, "Exu", est1);
		Cidade c79 = new Cidade(null, "Ipubi", est1);
		Cidade c80 = new Cidade(null, "Trindade", est1);
		Cidade c81 = new Cidade(null, "Gameleira", est1);
		Cidade c82 = new Cidade(null, "Ibimirim", est1);
		Cidade c83 = new Cidade(null, "Passira", est1);
		Cidade c84 = new Cidade(null, "Caetés", est1);
		Cidade c85 = new Cidade(null, "Tabira", est1);
		Cidade c86 = new Cidade(null, "Tupanatinga", est1);
		Cidade c87 = new Cidade(null, "Pombos", est1);
		Cidade c88 = new Cidade(null, "Itapissuma", est1);
		Cidade c89 = new Cidade(null, "Panelas", est1);
		Cidade c90 = new Cidade(null, "Itaíba", est1);
		Cidade c91 = new Cidade(null, "Sanharó", est1);
		Cidade c92 = new Cidade(null, "Condado", est1);
		Cidade c93 = new Cidade(null, "Quipapá", est1);
		Cidade c94 = new Cidade(null, "Tacaratu", est1);
		Cidade c95 = new Cidade(null, "Lagoa Grande", est1);
		Cidade c96 = new Cidade(null, "Macaparana", est1);
		Cidade c97 = new Cidade(null, "Agrestina", est1);
		Cidade c98 = new Cidade(null, "Canhotinho", est1);
		Cidade c99 = new Cidade(null, "Cupira", est1);
		Cidade c100 = new Cidade(null, "Orobó", est1);
		Cidade c101 = new Cidade(null, "Rio Formoso", est1);
		Cidade c102 = new Cidade(null, "Inajá", est1);
		Cidade c103 = new Cidade(null, "Altinho", est1);
		Cidade c104 = new Cidade(null, "Amaraji", est1);
		Cidade c105 = new Cidade(null, "São Jõao", est1);
		Cidade c106 = new Cidade(null, "Parnamirim", est1);
		Cidade c107 = new Cidade(null, "Pedra", est1);
		Cidade c108 = new Cidade(null, "Feira Nova", est1);
		Cidade c109 = new Cidade(null, "Chã Grande", est1);
		Cidade c110 = new Cidade(null, "Manari", est1);
		Cidade c111 = new Cidade(null, "Lagoa de Itaenga", est1);
		Cidade c112 = new Cidade(null, "São Joaquim do Monte", est1);
		Cidade c113 = new Cidade(null, "São José da Coroa Grande", est1);
		Cidade c114 = new Cidade(null, "Vertente", est1);
		Cidade c115 = new Cidade(null, "Belém do São Francisco", est1);
		Cidade c116 = new Cidade(null, "Riacho das Almas", est1);
		Cidade c117 = new Cidade(null, "Araçoiaba", est1);
		Cidade c118 = new Cidade(null, "Cachueirinha", est1);
		Cidade c119 = new Cidade(null, "Capoeiras", est1);
		Cidade c120 = new Cidade(null, "Carnaíba", est1);
		Cidade c121 = new Cidade(null, "Iati", est1);
		Cidade c122 = new Cidade(null, "Serrita", est1);
		Cidade c123 = new Cidade(null, "Dormentes", est1);
		Cidade c124 = new Cidade(null, "Camocim de São Felix", est1);
		Cidade c125 = new Cidade(null, "Venturosa", est1);
		Cidade c126 = new Cidade(null, "Itaquitinga", est1);
		Cidade c127 = new Cidade(null, "Lagoa do Carro", est1);
		Cidade c128 = new Cidade(null, "Jataúba", est1);
		Cidade c129 = new Cidade(null, "Machados", est1);
		Cidade c130 = new Cidade(null, "Joaquim Nabuco", est1);
		Cidade c131 = new Cidade(null, "São Benedito do Sul", est1);
		Cidade c132 = new Cidade(null, "Saloá", est1);
		Cidade c133 = new Cidade(null, "Frei Miguelinho", est1);
		Cidade c134 = new Cidade(null, "Mirandiba", est1);
		Cidade c135 = new Cidade(null, "Jurema", est1);
		Cidade c136 = new Cidade(null, "Primavera", est1);
		Cidade c137 = new Cidade(null, "Orocó", est1);
		Cidade c138 = new Cidade(null, "Jupi", est1);
		Cidade c139 = new Cidade(null, "Jatobá", est1);
		Cidade c140 = new Cidade(null, "Xexéu", est1);
		Cidade c141 = new Cidade(null, "Santa Filomena", est1);
		Cidade c142 = new Cidade(null, "Barra de Guabiraba", est1);
		Cidade c143 = new Cidade(null, "Casinhas", est1);
		Cidade c144 = new Cidade(null, "Santa Maria do Cambucá", est1);
		Cidade c145 = new Cidade(null, "Tracunhaém", est1);
		Cidade c146 = new Cidade(null, "Chã de Alegria", est1);
		Cidade c147 = new Cidade(null, "Buenos Aires", est1);
		Cidade c148 = new Cidade(null, "Lagoa do Ouro", est1);
		Cidade c149 = new Cidade(null, "Carnaubeira da Penha", est1);
		Cidade c150 = new Cidade(null, "Tacaimbó", est1);
		Cidade c151 = new Cidade(null, "Betânia", est1);
		Cidade c152 = new Cidade(null, "Santa Cruz da Baixa Verde", est1);
		Cidade c153 = new Cidade(null, "Cortês", est1);
		Cidade c154 = new Cidade(null, "Iguaracy", est1);
		Cidade c155 = new Cidade(null, "Ferreiros", est1);
		Cidade c156 = new Cidade(null, "Belém de Maria", est1);
		Cidade c157 = new Cidade(null, "Santa Terezinha", est1);
		Cidade c158 = new Cidade(null, "Cedro", est1);
		Cidade c159 = new Cidade(null, "Paranatama", est1);
		Cidade c160 = new Cidade(null, "Maraial", est1);
		Cidade c161 = new Cidade(null, "Jucati", est1);
		Cidade c162 = new Cidade(null, "Poção", est1);
		Cidade c163 = new Cidade(null, "Moreilândia", est1);
		Cidade c164 = new Cidade(null, "Calçado", est1);
		Cidade c165 = new Cidade(null, "Angelim", est1);
		Cidade c166 = new Cidade(null, "Salgadinho", est1);
		Cidade c167 = new Cidade(null, "Cumaru", est1);
		Cidade c168 = new Cidade(null, "Terra Nova", est1);
		Cidade c169 = new Cidade(null, "Sairé", est1);
		Cidade c170 = new Cidade(null, "Verdejante", est1);
		Cidade c171 = new Cidade(null, "Brejão", est1);
		Cidade c172 = new Cidade(null, "Camutanga", est1);
		Cidade c173 = new Cidade(null, "Tuparetama", est1);
		Cidade c174 = new Cidade(null, "Ibirajuba", est1);
		Cidade c175 = new Cidade(null, "Palmeirinha", est1);
		Cidade c176 = new Cidade(null, "Vertente do Lério", est1);
		Cidade c177 = new Cidade(null, "Brejinho", est1);
		Cidade c178 = new Cidade(null, "Quixaba", est1);
		Cidade c179 = new Cidade(null, "Solidão", est1);
		Cidade c180 = new Cidade(null, "Calumbi", est1);
		Cidade c181 = new Cidade(null, "Itacuruba", est1);
		Cidade c182 = new Cidade(null, "Ingazeira", est1);
		Cidade c183 = new Cidade(null, "Fernando de Noronha", est1);
		Cidade c184 = new Cidade(null, "Barreiros", est1);
		Cidade c185 = new Cidade(null, "Santa Maria da Boa Vista", est1);
		
		
		
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, 
				est13, est14, est15, est16, est17, est18, est19, est20, est21, est22, est23, est24, est25, est26));
		
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22,
				c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50,
				c51, c52, c53, c54, c55, c56, c57, c58, c59, c60, c61, c62, c63, c64, c65, c66, c67, c68, c69, c70, c71, c72, c73, c74, c75, c76, c77, c78, c79, c80,
				c81, c82, c83, c84, c85, c86, c87, c88, c89, c90, c91, c92, c93, c94, c95, c96, c97, c98, c99, c100, c101, c102, c103, c104, c105, c106, c107, c108,
				c109, c110, c111, c112, c113, c114, c115, c116, c117, c118, c119, c120, c121, c122, c123, c124, c125, c126, c127, c128, c129, c130, c131, c132, c133, 
				c134, c135, c136, c137, c138, c139, c140, c141, c142, c143, c144, c145, c146, c147, c148, c149, c150, c151, c152, c153, c154, c155, c156, c157, c158, c159,
				c160, c161, c162, c163, c164, c165, c166, c167, c168, c169, c170, c171, c172, c173, c174, c175, c176, c177, c178, c179, c180, c181, c182, c183, c184, c185));
		
		
		Cliente cli1 = new Cliente(null, "Elias Teotonio", "eliascalado@hotmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));	
		cli1.getTelefones().addAll(Arrays.asList("3446.5893", "98824.3638"));
		cli1.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Rua Souza Bandeira" , "211", "null", "Cordeiro", "50011-150", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1));
	}

}
