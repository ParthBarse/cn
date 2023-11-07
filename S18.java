import java.io.*;
import java.net.*;

public class S18 {
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is waiting for a connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to a client.");

            // Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Create a BufferedReader to get messages from the user
            BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Receive data from the client
                String clientMessage = in.readLine();
                System.out.println("Received from client << : " + clientMessage);

                // Get a message from the user
                System.out.print("Enter a message to send to the client >> : ");
                String serverMessage = userIn.readLine();

                // Send the message to the client
                out.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
