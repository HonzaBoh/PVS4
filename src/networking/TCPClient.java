package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        int port = 12345;
        String host = "127.0.0.1";//localhost

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))
                ){
            System.out.println("Connected on port " + port);

            String userLine;
            while ((userLine = userIn.readLine()) != null){
                out.println(userLine);//co posilam

                System.out.println("Server: " + in.readLine());//co mi prislo

                if (userLine.equals("fin")){
                    break;
                }
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
