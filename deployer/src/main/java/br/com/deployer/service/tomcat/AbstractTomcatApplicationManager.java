package br.com.deployer.service.tomcat;

import br.com.deployer.service.AbstractApplicationManager;

public abstract class AbstractTomcatApplicationManager extends AbstractApplicationManager {

    public static final String REST_URL = "/manager/text";

    public AbstractTomcatApplicationManager() {}

    public String getDeployApplicationURI(String host) {
        return generateActionApplicationURI(host, TomcatManagerApplicationActions.DEPLOY);
    }

    public String getUndeployApplicationURI(String host) {
        return generateActionApplicationURI(host, TomcatManagerApplicationActions.UNDEPLOY);
    }

    public String getStartApplicationURI(String host) {
        return generateActionApplicationURI(host, TomcatManagerApplicationActions.START);
    }

    public String getStopApplicationURI(String host) {
        return generateActionApplicationURI(host, TomcatManagerApplicationActions.STOP);
    }

    public String getRestartApplicationURI(String host) {
        return generateActionApplicationURI(host, TomcatManagerApplicationActions.RESTART);
    }
    
    public String getListApplicationURI(String host) {
		return generateActionApplicationURI(host, TomcatManagerApplicationActions.LIST);
    }

    private String generateActionApplicationURI(String host, TomcatManagerApplicationActions action) {
        return host+REST_URL+action.getAction();
    }

}
