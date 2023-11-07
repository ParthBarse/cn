import java.net.*;
import java.io.*;

public class C06 {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Use the server's IP or hostname
        int serverPort = 12345;

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);

            while (true) {
                // Get a message from the user and send it to the server
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter a message to send to the server: ");
                String clientMessage = userInput.readLine();
                byte[] sendData = clientMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverInetAddress, serverPort);
                clientSocket.send(sendPacket);

                // Receive a response from the server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
