import java.io.*;
import java.net.*;

public class S09 {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;

        try {
            serverSocket = new DatagramSocket(9876); // Server port

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);
            String filename = new String(receivePacket.getData(), 0, receivePacket.getLength());

            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File not found.");
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            byte[] sendData = new byte[1024];
            DatagramPacket sendPacket;

            while (fis.read(sendData) != -1) {
                sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
                sendData = new byte[1024];
            }
            fis.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}