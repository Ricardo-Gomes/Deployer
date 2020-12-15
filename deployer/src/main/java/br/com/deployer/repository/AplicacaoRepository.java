package br.com.deployer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.deployer.model.Aplicacao;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long>{
	
	@Query(value = "select a from Aplicacao a where a.caminhoContexto =:caminhoContexto")
	Aplicacao findByContexto(@Param ("caminhoContexto") String caminhoContexto);
	
	@Query("select a from Aplicacao a join fetch a.usuarioCadastro u where u.id = :id")
	List<Aplicacao> findByUsuario(@Param("id") Long id);
}
