package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        int port = 12345;
        //spustime server
        try (ServerSocket serverSocket = new ServerSocket(port)){

            System.out.println("Server is listening on port " + port);

            //pro toho, kdo se zkousi pripojit
            try(Socket clientSocket = serverSocket.accept()){
                System.out.println("Connected to client");

                //Streamy na cteni + psani
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                //cteni vstupu a echo zpet
                String inputLine;

                while ((inputLine = in.readLine()) != null){
                    System.out.println("Client: " + inputLine);//co prislo
                    out.println(inputLine);// echo zpet

                    if (inputLine.equals("fin")){
                        break;
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
