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

            myWriter.write("nome \n" + nome);

            String password = in.readLine();

            myWriter.write("\npassword \n" + password);

            myWriter.close();
//fine scrittura

//lettura file
            
            Scanner myReader = new Scanner( (Readable) myWriter);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                out.println(data);

            }
            myReader.close();
//fine lettura  
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
