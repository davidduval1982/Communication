/*
TO DO
 */
package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serveur {

    static Socket socket;
    static PrintWriter out;
    static BufferedReader input;
    /**
     * @param port: Le numéro de port à utiliser
     * OUT : Une instance de serveur
     */
    public static void serveur(int port) {        
        try {
            ServerSocket server = new ServerSocket(port);
            while(true){
                socket = server.accept();
                out = new PrintWriter(socket.getOutputStream(), true);
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            }
        } catch (IOException ioe) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ioe);
            System.out.println("On est sorti!");
            System.out.println("Oups...");
            System.out.println("Erreur en IO: " + ioe.toString());
        }
    }
    
    public String lireString(){
        String resultat = null;
        try{
            resultat = input.readLine();
        }catch (IOException ioe){
            System.out.println("Erreur de lecture en IO: " + ioe.toString());
        }
        return resultat;
    }
    
    public int lireInt(){
        int resultat = 0;
        boolean valide = false;
        try{
            resultat = Integer.parseInt(input.readLine());
            valide = true;
        }catch (IOException ioe){
            System.out.println("Erreur de lecture en IO " + ioe.toString());
            valide = false;
        }
        
        if (valide){
            return resultat;
        }else{
            throw new NumberFormatException();
        }
    }
    
    public void envoyer(String message){
        out.println(message);
    }
        
    
}
