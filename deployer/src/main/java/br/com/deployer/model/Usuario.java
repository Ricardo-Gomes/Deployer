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

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario", schema = "controle_acesso")
@ToString
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String login;	
	
	@Column
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario_cadastro", referencedColumnName = "id")
	private Usuario usuarioCadastro;
	
    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;
    
    public void criptografarSenha(PasswordEncoder encoder) {
    	if(this.senha != null) {
    		this.setSenha(encoder.encode(this.senha));
    	}
    }

}
