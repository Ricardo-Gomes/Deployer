package br.com.deployer.view.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.deployer.model.Usuario;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String idString) {
		if (idString == null) {
			return null;
		}
		Long id = Long.valueOf(idString);
		Usuario usuario = (Usuario) component.getAttributes().get(idString);
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Usuario usuario = (Usuario) value;
		String idUsuario = usuario.getId().toString();
		component.getAttributes().put(idUsuario, usuario);
		return idUsuario;
		
	}

}
