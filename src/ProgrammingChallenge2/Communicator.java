/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wijebandara
 */
public class Communicator {

    private int clentPort;
    private int localPort;
    private ServerSocket clent;
    private static String message;

    public Communicator() {
        System.out.println("WELCOME_TO_MENDELEEV#");
        readPropFile();
        AI ai = new AI();


        try {
            clent = new ServerSocket(clentPort);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        }

        Reader reader = new Reader(clent);

        reader.addObserver(ai);

        new Thread(reader).start();

    }

    private void readPropFile() {
        Properties prop = new Properties();

        try {
            //load a properties file
            prop.load(new FileInputStream("config.properties"));
            //get the property value and print it out
            clentPort = Integer.parseInt(prop.getProperty("ClentPort"));
            localPort = Integer.parseInt(prop.getProperty("LocalPort"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    protected static synchronized void putMessage(String mgs) {
        message = mgs;
    }

    public static synchronized String getMessage() {
        return message;
    }
}
