/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadhin
 */
import java.net.*;
import java.io.*;

public class URLReader {

    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://www.google.com.bd/#q=read+html+file+in+java+from+website");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
//            System.out.println("WOW");
        }
        in.close();
    }
}
