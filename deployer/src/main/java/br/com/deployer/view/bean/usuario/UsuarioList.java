package br.com.deployer.view.bean.usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.deployer.model.Usuario;
import br.com.deployer.service.UsuarioService;
import br.com.deployer.view.util.JsfUtil;

@ManagedBean
@ViewScoped
public class UsuarioList {

	private Usuario usuarioFiltro;
	private List<Usuario> resultado;

	@ManagedProperty("#{usuarioService}")
	private UsuarioService service;

	public UsuarioList() {
		this.usuarioFiltro = new Usuario();
	}

	public String enviarParaEditar(Long id) {
		return "usuario-form?faces-redirect=true&id=" + id;
	}

	public void consultar() {
		this.resultado = service.pesquisarUsuarios(getUsuarioFiltro());
		if (resultado.isEmpty()) {
			JsfUtil.addAlert("Nenhum Registro Encontrado");
		}
	}

	public void excluir() {
		try {
			service.excluir(usuarioFiltro);
			this.setUsuarioFiltro(usuarioFiltro);
			this.resultado.remove(this.usuarioFiltro);
			JsfUtil.addSucessMessage("Excluido com sucesso!");
		} catch (Exception e) {
			JsfUtil.addErrorMessage("Erro ao excluir!");
		}
	}

	public Usuario getUsuarioFiltro() {
		return usuarioFiltro;
	}

	public void setUsuarioFiltro(Usuario usuarioFiltro) {
		this.usuarioFiltro = usuarioFiltro;
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	public List<Usuario> getResultado() {
		return resultado;
	}

	public void setResultado(List<Usuario> resultado) {
		this.resultado = resultado;
	}
}
