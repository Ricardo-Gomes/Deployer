package br.com.deployer.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@NoArgsConstructor
@Entity
@Table(name = "servidor", schema = "deployer")
@ToString(exclude = {"servletContainers", "servletContainersDeletar"})
public class Servidor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String label;
	
	@Column
	private String url;
	
	@OneToMany(mappedBy = "servidor")
	private List<ServletContainer> servletContainers;
	
	@Transient
	private List<ServletContainer> servletContainersDeletar;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario_cadastro", referencedColumnName = "id")
	private Usuario usuarioCadastro;
	
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;
	
}
