package clientes2;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientEs2 {

    public static void main(String[] args) {
        try {
            Scanner tastiera = new Scanner(System.in);
            Socket clientSocket = new Socket("192.168.56.1", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            boolean fine = false;
            String lettura, messaggio;

            do {
                System.out.println("voui registrare un nuovo utente o loggare"
                        + "\n[reg/log]");
                lettura = tastiera.next();
                if (lettura.equals("reg")) {
                    System.out.println("inserire nome");
                    messaggio = tastiera.next();
                    out.println(messaggio);
                    System.out.println("inserire password");
                    messaggio = tastiera.next();
                    out.println(messaggio);
                    
                }
              fine=true;
            } while (!fine);
            in.readLine();
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientEs2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
