package br.com.deployer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.deployer.model.Servidor;

public interface ServidorRepository extends JpaRepository<Servidor, Long>{
	
	@Query("select s from Servidor s where upper(s.nome) like upper(:nome) and upper(s.label) like upper(:label)")
	List<Servidor> findByNomeAndLabel(@Param("nome") String nome, @Param("label") String label);
	
	@Query("select s from Servidor s where s.nome = :nome")
	Servidor findByNome(@Param ("nome") String nome);
	
	@Query("select s from Servidor s where s.label = :label")
	Servidor findByLabel(@Param ("label") String label);
	
	@Query("select s from Servidor s where s.url = :url")
	Servidor findByUrl(@Param ("url") String url);
}
