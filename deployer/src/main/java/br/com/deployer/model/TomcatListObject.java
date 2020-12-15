package br.com.deployer.model;

import java.util.List;

public class TomcatListObject {

	public static final String STATUS_RUNNING = "running";
	public static final String STATUS_STOPPED = "stopped";
	
	private String contextPath;
	private String status;
	private Integer numeroSessoesAtivas;
	private String folderName;
	
	public TomcatListObject() {}

	public boolean isRunning() {
		return getStatus() != null && getStatus().equalsIgnoreCase(STATUS_RUNNING);
	}
	
	public boolean isStopped() {
		return getStatus() != null && getStatus().equalsIgnoreCase(STATUS_STOPPED);
	}
	
	public boolean isContextPath(String contextPath) {
		if (contextPath == null) return false;
		return getContextPath() != null && getContextPath().equalsIgnoreCase(contextPath);
	}
	
	public static TomcatListObject pesquisarPorContexto(String contexto, List<TomcatListObject> list) {
		if (list == null || list.isEmpty()) return null;
		for (TomcatListObject tomcatListObject : list) {
			if (tomcatListObject.isContextPath(contexto)) {
				return tomcatListObject;
			}
		}
		return null;
	}
	
	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumeroSessoesAtivas() {
		return numeroSessoesAtivas;
	}

	public void setNumeroSessoesAtivas(Integer numeroSessoesAtivas) {
		this.numeroSessoesAtivas = numeroSessoesAtivas;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	
}
