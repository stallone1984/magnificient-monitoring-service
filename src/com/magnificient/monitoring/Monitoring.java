package com.magnificient.monitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

public class Monitoring {
	
	final static Logger logger = Logger.getLogger(Monitoring.class);
	
	public static void main(String[] args) throws Exception {
		while(true){
			new Monitoring().startMonitoring();
			Thread.sleep(5000);
		}
	}

	public void startMonitoring() {

		try {
			String url = "http://localhost:12345";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			logger.info(response.toString());
		} catch (Exception e) {
			logger.error(e);
		}

	}
}
