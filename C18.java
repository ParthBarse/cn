import java.io.*;
import java.net.*;

public class C18 {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Use the server's IP or hostname
        int serverPort = 12345;

        try {
            Socket clientSocket = new Socket(serverAddress, serverPort);

            // Create input and output streams for communication
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a BufferedReader to get messages from the user
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Get a message from the user and send it to the server
                System.out.print("Enter a message to send to the server >> : ");
                String clientMessage = userIn.readLine();
                out.println(clientMessage);

                // Receive a response from the server
                String serverResponse = in.readLine();
                System.out.println("Received from server << : " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
