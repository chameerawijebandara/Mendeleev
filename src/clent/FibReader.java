/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clent;

/**
 *
 * @author wijebandara
 */
import java.io.*;
import java.net.*;

public class FibReader  {

    static Socket appSoc;
    static Socket clentSoc;
    static BufferedReader in;
    static PrintWriter out = null;
    static String message;

    public static void main(String argv[]) {
        try {
            
//            clentSoc = new Socket("127.0.0.1", 6000);
//            out = new PrintWriter(clentSoc.getOutputStream(),true);
//            
//            out.print("JOIN#");
//            out.flush();
//            clentSoc.close();
            
            ServerSocket s =new ServerSocket(7000);
            appSoc = s.accept();
            System.out.println(appSoc.getPort());
            in = new BufferedReader(new InputStreamReader(appSoc.getInputStream()));
            
            System.out.println(in.readLine());

            appSoc.close();

        } catch (Exception e) {
            System.out.println("Died... " + e.toString());
        }
    }
    
}
