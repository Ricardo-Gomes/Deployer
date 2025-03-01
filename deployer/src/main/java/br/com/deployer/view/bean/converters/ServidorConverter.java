package br.com.deployer.view.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.deployer.model.Servidor;

@FacesConverter(forClass = Servidor.class)
public class ServidorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String idString) {
		if (idString == null) {
			return null;
		}
		Long id = Long.valueOf(idString);
		Servidor servidor = (Servidor) component.getAttributes().get(idString);
		return servidor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Servidor servidor = (Servidor) value;
		String idString = servidor.getId().toString();
		component.getAttributes().put(idString, servidor);
		return idString;
	}
}
