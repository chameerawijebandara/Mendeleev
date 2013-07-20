/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wijebandara
 */
public class Sender extends Thread {

    private Socket threadSoc;
    private String massage;

    Sender(String serverIp, int serverPort, String massage) {
        try {
            threadSoc = new Socket(serverIp, serverPort);
        } catch (IOException ex) {

            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.massage = massage;
    }

    @Override
    public void run() {
        PrintStream Out = null;
        try {
            Out = new PrintStream(threadSoc.getOutputStream());
            Out.print(massage);
            Out.close();
            threadSoc.close();
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}