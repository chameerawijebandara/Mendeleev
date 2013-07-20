/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wijebandara
 */
public class RequestHandler extends Thread {

    @Override
    public void run() {
        while (true) {
            waitForCal();
            send(AI.getRequest());
//            int a =((int)(Math.random()*100))%4;
//            System.out.println(a);
//            switch(a)
//            {
//                case 0:
//                    AI.putRequest("SHOOT#");
//                    break;
//                case 1:
//                    AI.putRequest("RIGHT#");    
//                    break;
//                case 2:
//                    AI.putRequest("LEFT#");
//                    break;
//                case 3:
//                    AI.putRequest("UP#");
//                    break;
//                case 4:
//                    AI.putRequest("DOWN#");
//                    break;
//            }

        }


    }

    synchronized void waitForCal() {
        try {
            wait(1005);
        } catch (InterruptedException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void send(String request) {

        Properties prop = new Properties();
        String serverIp = null;
        int serverPort = 0;
        try {
            //load a properties file
            prop.load(new FileInputStream("config.properties"));

            //get the property value and print it out
            serverIp = prop.getProperty("ServerIP");
            serverPort = Integer.parseInt(prop.getProperty("ServerPort"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Sender sender = new Sender(serverIp, serverPort, request);
        sender.start();
    }
}
