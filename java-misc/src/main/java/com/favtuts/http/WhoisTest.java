package com.favtuts.http;

import java.io.IOException;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.net.whois.WhoisClient;

public class WhoisTest {

    private static Pattern pattern;
    private Matcher matcher;

    // regex whois parser
	private static final String WHOIS_SERVER_PATTERN = "Whois Server:\\s(.*)";
	static {
		pattern = Pattern.compile(WHOIS_SERVER_PATTERN);
	}

    public static void main(String[] args) {
        
        
        WhoisTest obj = new WhoisTest();

        // Simple Whois
		// System.out.println(obj.getWhoisSimple("favtuts.com"));

        // Complex Whois
        System.out.println(obj.getWhois("google.com"));

		System.out.println("Done");

    }
    
    public String getWhoisSimple(String domainName) {

        StringBuilder result = new StringBuilder("");

        WhoisClient whois = new WhoisClient();

        try {
            
            // default is internic.net
            whois.connect(WhoisClient.DEFAULT_HOST);
            String whoisData1 = whois.query("=" + domainName);
            result.append(whoisData1);
            whois.disconnect();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }



    // example google.com
	public String getWhois(String domainName) {

		StringBuilder result = new StringBuilder("");

		WhoisClient whois = new WhoisClient();
		try {

            whois.connect(WhoisClient.DEFAULT_HOST);

            // whois =google.com
            String whoisData1 = whois.query("=" + domainName);

            // append first result
            result.append(whoisData1);
            whois.disconnect();

            // get the google.com whois server - whois.markmonitor.com
            String whoisServerUrl = getWhoisServer(whoisData1);
            if (!whoisServerUrl.equals("")) {

                // whois -h whois.markmonitor.com google.com
                String whoisData2 = 
                                queryWithWhoisServer(domainName, whoisServerUrl);

                // append 2nd result
                result.append(whoisData2);
            }

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}


    private String queryWithWhoisServer(String domainName, String whoisServer) {

		String result = "";
		WhoisClient whois = new WhoisClient();
		try {

			whois.connect(whoisServer);
			result = whois.query(domainName);
			whois.disconnect();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}


    private String getWhoisServer(String whois) {

		String result = "";

		matcher = pattern.matcher(whois);

		// get last whois server
		while (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}
}
