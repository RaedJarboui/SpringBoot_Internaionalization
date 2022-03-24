package com.translate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableEurekaClient
@ComponentScan({"com.translate.controller", "com.translate.service", "com.translate.security",
		"com.translate.security.jwt", "com.translate.security.services"})
@EntityScan("com.translate.entity")
@EnableJpaRepositories("com.translate.repository")

public class AcmCrmTranslateApiApplication {
	// private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
	// private static final String CLIENT_SECRET = "PUBLIC_SECRET";
	// private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

	public static void main(String[] args) {

		/*
		 * String fromLang = "en"; String toLang = "fr"; String text = "Let's have some fun!";
		 */
		SpringApplication.run(AcmCrmTranslateApiApplication.class, args);

		/*
		 * try { AcmCrmTranslateApiApplication.translate(fromLang, toLang, text); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	/*
	 * public static void translate(String fromLang, String toLang, String text) throws Exception {
	 * // TODO: Should have used a 3rd party library to make a JSON string from an object String
	 * jsonPayload = new StringBuilder().append("{").append("\"fromLang\":\"")
	 * .append(fromLang).append("\",").append("\"toLang\":\"").append(toLang).append("\",")
	 * .append("\"text\":\"").append(text).append("\"").append("}").toString(); URL url = new
	 * URL(ENDPOINT); HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	 * conn.setDoOutput(true); conn.setRequestMethod("POST");
	 * conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
	 * conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
	 * conn.setRequestProperty("Content-Type", "application/json"); OutputStream os =
	 * conn.getOutputStream(); os.write(jsonPayload.getBytes()); os.flush(); os.close(); int
	 * statusCode = conn.getResponseCode(); System.out.println("Status Code: " + statusCode);
	 * BufferedReader br = new BufferedReader(new InputStreamReader( (statusCode == 200) ?
	 * conn.getInputStream() : conn.getErrorStream())); String output; while ((output =
	 * br.readLine()) != null) { System.out.println(output); } conn.disconnect(); }
	 */

}
