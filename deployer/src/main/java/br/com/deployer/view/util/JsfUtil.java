package br.com.deployer.view.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JsfUtil {

	public static void addMessage(String mensagem, Severity severity) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(severity, mensagem, mensagem));
	}
	
	public static void addErrorMessage(String mensagem) {
		addMessage(mensagem, FacesMessage.SEVERITY_ERROR);
	}

	public static void addSucessMessage(String mensagem) {
		addMessage(mensagem, FacesMessage.SEVERITY_INFO);
	}

	public static void addAlert(String mensagem) {
		addMessage(mensagem, FacesMessage.SEVERITY_WARN);
	}

	public static void redirect(String outcome) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(outcome);
		} catch (Exception e) {

		}
	}
}
