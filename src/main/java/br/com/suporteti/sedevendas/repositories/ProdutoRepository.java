package br.com.suporteti.sedevendas.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.suporteti.sedevendas.domain.Categoria;
import br.com.suporteti.sedevendas.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	//posso fazer customizada como esta ou assim para sobrepor o metodo	findDistinctByNomeIgnoreCaseContainingAndCategoriasIn dando prioridade para a @Query
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat  WHERE obj.nome LIKE %:nome% AND cat IN :categorias")	
	//Page<Produto> findDistinctByNomeIgnoreCaseContainingAndCategoriasIn(@Param("nome") String nome,@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	// na chamado do POSTMAN  http://localhost:8080/produtos/page/?nome=ar&categorias=1,2   Tem que ter o /page
	
	@Transactional(readOnly = true)	
	Page<Produto> findDistinctByNomeIgnoreCaseContainingAndCategoriasIn( String nome, List<Categoria> categorias, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	public List<Produto> findAllByOrderByNome();
}
