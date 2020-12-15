package br.com.deployer.service;

import org.springframework.http.ResponseEntity;

import java.io.File;

public interface ApplicationManager {

    ResponseEntity<?> deploy(String applicationPath, File warFile);
    ResponseEntity<?> undeploy(String applicationPath);
    ResponseEntity<?> start(String applicationPath);
    ResponseEntity<?> stop(String applicationPath);
    ResponseEntity<?> restart(String applicationPath);

}
