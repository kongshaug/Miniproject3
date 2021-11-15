package dk.cb.contractservice.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.jsoup.*;
import org.jsoup.nodes.*;
import  org.jsoup.parser.*;

@Service
public class RestNamesClient {

    public String getGender(String firstname) throws MalformedURLException, IOException {
        URL url = new URL("http://www.thomas-bayer.com/restnames/name.groovy?name="+ firstname);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/xml;charset=UTF-8");
        Scanner scan = new Scanner(con.getInputStream());
        String xmlStr = "";
        while (scan.hasNext()) {
            xmlStr += scan.nextLine();
        }
        scan.close();

        //str is the xml string
        Document doc = Jsoup.parse(xmlStr, "", Parser.xmlParser());
        String gender = doc.select("gender").text();

        if(gender.equals("male first name")) {
            return "Mr";
        }
        else if(gender.equals("female first name")) {
            return "Ms";
        }
        else {
            return "Mx";
        }
    }

}
