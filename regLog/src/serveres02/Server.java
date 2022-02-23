package serveres02;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.io.FileNotFoundException;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//scrittura file
            FileWriter myWriter = new FileWriter("credenziali.txt");

            String nome = in.readLine();

            myWriter.write(nome);

            myWriter.close();

            String password = in.readLine();

            myWriter.write(password);

            myWriter.write(nome);
//fine scrittura

//lettura file
            File cred = new File("credenziali.txt");
             Scanner myReader = new Scanner(cred);
             while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        myReader.close();
      }
//fine lettura            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
