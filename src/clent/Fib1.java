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
import java.io.*;

public class Fib1 {

    public static void main(String argv[]) {
    
        try {
            ServerSocket sSoc = new ServerSocket(7000);
            
            while(true) {
                Socket inSoc = sSoc.accept();
                
                FibThread FibT = new FibThread(inSoc);
                FibT.start();}
        }
        catch (Exception e) {
            System.out.println("Oh Dear! " +e.toString());
        }
    }
}

class FibThread extends Thread {

    Socket threadSoc;

    int F1 = 1;
    int F2 = 1;

    FibThread(Socket inSoc) {
        threadSoc = inSoc;
    }
    
    @Override
    public void run() {
        try {
            PrintStream FibOut = new
              PrintStream(threadSoc.getOutputStream());
                        
            for (int i=0; i < 100; i++) {
                int temp;
                
                temp = F1;
                FibOut.println(F1);

                F1 = F2;
                F2 = temp + F2;
            }
        }
        catch (Exception e) {
            System.out.println("Whoops! " +e.toString());
        }
        
        try {
            threadSoc.close();
        }
        catch (Exception e) {
            System.out.println("Oh no! " +e.toString());
        }
    }
}