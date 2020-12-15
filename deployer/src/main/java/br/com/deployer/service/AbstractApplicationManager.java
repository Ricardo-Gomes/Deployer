package br.com.deployer.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Base64;

public abstract class AbstractApplicationManager implements ApplicationManager {

    public HttpHeaders createBasicAutenticationHeader(String user, String password) {
        String plainCreds = user+":"+password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("Authorization", "Basic " + base64Creds);

        return headers;
    }

}
