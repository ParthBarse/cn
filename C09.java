import java.io.*;
import java.net.*;

public class C09 {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;

        try {
            clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getLocalHost();
            int serverPort = 9876; // Server port

            String filename = "sample.txt"; // File to request from the server
            byte[] requestData = filename.getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, serverPort);

            clientSocket.send(requestPacket);

            File receivedFile = new File("C:\\Users\\Parth\\Desktop\\cn\\Assignment_no_6\\received_" + filename);
            FileOutputStream fos = new FileOutputStream(receivedFile);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while (true) {
                clientSocket.receive(receivePacket);
                fos.write(receivePacket.getData(), 0, receivePacket.getLength());
                fos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}