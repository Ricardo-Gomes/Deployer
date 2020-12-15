package br.com.deployer.view.bean.servidor;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.deployer.model.Servidor;
import br.com.deployer.service.ServidorService;
import br.com.deployer.view.util.JsfUtil;

@ManagedBean
@ViewScoped
public class ServidorList {

	private Servidor servidorFiltro;
	private List<Servidor> resultado; 

	@ManagedProperty("#{servidorService}")
	private ServidorService service;
	
	
	public ServidorList() {
		this.servidorFiltro = new Servidor();
	}

	public String enviarParaEditar(Long id) {
		return "servidor-form?faces-redirect=true&id=" + id;
	}
		
	public void consultar() {
		this.resultado = service.pesquisarServidor(getServidorFiltro());
		if (resultado.isEmpty()) {
			JsfUtil.addAlert("Nenhum Registro Encontrado");
		}
	}
	
	public void excluir() {
		try {
			service.excluir(servidorFiltro);
			this.setServidorFiltro(servidorFiltro);
			this.resultado.remove(this.servidorFiltro);
		} catch (Exception e) {
			JsfUtil.addErrorMessage( "Não é possivel excluir o servidor pois está relacionado a um servlet.");
		}
	}

	public Servidor getServidorFiltro() {
		return servidorFiltro;
	}

	public void setServidorFiltro(Servidor servidorFiltro) {
		this.servidorFiltro = servidorFiltro;
	}

	public List<Servidor> getResultado() {
		return resultado;
	}

	public void setResultado(List<Servidor> resultado) {
		this.resultado = resultado;
	}

	public ServidorService getService() {
		return service;
	}

	public void setService(ServidorService service) {
		this.service = service;
	}
}
