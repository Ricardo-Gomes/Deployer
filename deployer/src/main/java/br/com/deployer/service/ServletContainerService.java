package br.com.deployer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.deployer.exception.ValidationException;
import br.com.deployer.model.Servidor;
import br.com.deployer.model.ServletContainer;
import br.com.deployer.repository.ServletContainerRepository;

@Service
public class ServletContainerService {

	@Autowired
	private ServletContainerRepository repository;

	@Transactional
	public void salvarLista(List<ServletContainer> servletContainers) {
		this.repository.saveAll(servletContainers);
	}

	public void validar(ServletContainer servletContainer) {
		List<String> checks = new ArrayList<String>();

		if (servletContainer.getNome() == null || servletContainer.getNome().trim().equals("")) {
			checks.add("O preenchimento do campo Nome Servlet Container é obrigatório");
		}

		if (servletContainer.getLabel() == null || servletContainer.getLabel().trim().equals("")) {
			servletContainer.setLabel("/");
		}

		if (servletContainer.getUsuario() == null || servletContainer.getUsuario().trim().equals("")) {
			checks.add("O preenchimento do campo Usuário Servlet Container é obrigatório");
		}

		if (servletContainer.getSenha() == null || servletContainer.getSenha().trim().equals("")) {
			checks.add("O preenchimento do campo Senha Servlet Container é obrigatório");
		}

		if (!checks.isEmpty()) {
			throw new ValidationException(checks);
		}
	}

	public List<ServletContainer> listarServletContainersPorServidor(Servidor servidor) {
		return this.repository.findByServidorId(servidor.getId());
	}
	
	@Transactional
	public void deletar(List<ServletContainer> listaServletContainers) {
		this.repository.deleteAll(listaServletContainers);
	}
}
