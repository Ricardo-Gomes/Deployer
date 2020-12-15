package br.com.deployer.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Arquivo implements Serializable{
	
	private byte[] conteudo;
	private String nomeArquivo;
	private Long tamanho;

}
