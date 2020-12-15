package br.com.deployer.service.tomcat;

public enum TomcatManagerApplicationActions {

    DEPLOY("/deploy", PARAMS.PATH, PARAMS.WAR),
    UNDEPLOY("/undeploy", PARAMS.PATH),
    START("/start", PARAMS.PATH),
    STOP("/stop", PARAMS.PATH),
    RESTART("/reload", PARAMS.PATH),
	LIST("/list");
	
    private String action;
    private PARAMS[] params;

    TomcatManagerApplicationActions(String action, PARAMS... params) {
        this.action = action;
        this.params = params;
    }

    public String getAction() {
        return action;
    }

    public PARAMS[] getParams() {
        return params;
    }

    public enum PARAMS {
        PATH("path"),
        WAR("war");

        private String param;

        PARAMS(String param){
            this.param = param;
        }

        public String getParam() {
            return param;
        }
    }

}
