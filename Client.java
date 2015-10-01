/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    static Socket socket;
    static BufferedReader reader; 
    static Scanner scanner; 
    
    /**
     * @param port : Le port sur lequel écouter
     */
    public static void client(int port) {
        try {
            socket = new Socket("localhost", 3000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            scanner = new Scanner(System.in);

            while(true){
                //System.out.println(reader.readLine());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                /*out.println("EN");
                out.println("FR");
                System.out.println(reader.readLine());*/
                int chiffreLu = scanner.nextInt();
                out.println(chiffreLu);
                System.out.println(chiffreLu);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oups...client");
        }
    }
    
}
