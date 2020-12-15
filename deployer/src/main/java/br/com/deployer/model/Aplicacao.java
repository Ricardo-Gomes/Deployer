package br.com.deployer.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "aplicacao", schema = "deployer")
@ToString
public class Aplicacao implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_servidor", referencedColumnName = "id")
	private Servidor servidor;
	
	@ManyToOne
	@JoinColumn(name = "fk_servlet_container", referencedColumnName = "id")
	private ServletContainer servletContainer;
	
	@Column(name = "caminho_contexto")
	private String caminhoContexto;
	
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;
	
    @ManyToOne
    @JoinColumn(name = "fk_usuario_cadastro", referencedColumnName = "id")
    private Usuario usuarioCadastro;
    
	@Transient
	private Arquivo war;
	
	@Transient
	private TomcatListObject informacoes;
	
}
