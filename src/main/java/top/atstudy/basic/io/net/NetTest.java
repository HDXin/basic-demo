package top.atstudy.basic.io.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetTest {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.jd.com");
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        is.close();

    }

}
