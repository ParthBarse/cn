import java.net.*;
import java.io.*;

public class S20 {
    public static void main(String[] args) {
        int port = 12345;

        try {
            DatagramSocket serverSocket = new DatagramSocket(port);
            System.out.println("Server is listening on port " + port);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while (true) {
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientMessage);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Get a message from the user
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter a message to send to the client: ");
                String serverMessage = userInput.readLine();

                // Send the server's message to the client
                byte[] sendData = serverMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                // Receive a response from the client
                receivePacket.setLength(receiveData.length); // Reset the packet length
                serverSocket.receive(receivePacket);
                String clientResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
