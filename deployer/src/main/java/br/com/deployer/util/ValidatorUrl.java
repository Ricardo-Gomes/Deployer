package br.com.deployer.util;

public class ValidatorUrl {

	public static boolean isValida(String url) {
		if(url == null) 
			return false;
		
		String regexNormal = "(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
		String regexHostPort = "(https?://.*):(\\d*)\\/?(.*)";
		return url.matches(regexNormal) || url.matches(regexHostPort);
	}
}
