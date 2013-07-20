/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clent;

/**
 *
 * @author wijebandara
 */
import java.net.*;

public class PortScanner {

    public static void main(String args[]) {
        int startPortRange = 6000;
        int stopPortRange = 7000;



        for (int i = startPortRange; i <= stopPortRange; i+=1000) {
            try {
                Socket ServerSok = new Socket("127.0.0.1", i);
                System.out.println("Port in use: " + i);
                ServerSok.close();
            } catch (Exception e) {
               // e.printStackTrace();
            }
            System.out.println("Port not in use: " + i);
        }
    }
}
