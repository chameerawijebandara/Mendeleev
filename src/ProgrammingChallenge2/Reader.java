/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgrammingChallenge2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wijebandara
 */
public class Reader extends Observable implements Runnable {

    private ServerSocket server;

    public Reader(ServerSocket server) {
        this.server = server;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = null;
                BufferedReader in;
                try {

                    try {
                        socket = server.accept();
                    } catch (IOException ex) {
                        Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    Communicator.putMessage(in.readLine());
                    setChanged();
                    notifyObservers();
                } catch (IOException ex) {
                    Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
                }
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
