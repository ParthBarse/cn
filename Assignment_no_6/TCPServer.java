import java.io.*;
import java.net.*;

class TCPServer { 

  public static void main(String argv[]) throws Exception
    {
      String clientSentence;
      String capitalizedSentence;

      ServerSocket welcomeSocket = new ServerSocket(6789);

      while(true) {

           Socket connectionSocket = welcomeSocket.accept();

           BufferedReader inFromClient =
             new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

           DataOutputStream  outToClient =
             new DataOutputStream(connectionSocket.getOutputStream());

           clientSentence = inFromClient.readLine();

           capitalizedSentence = clientSentence.toUpperCase() + '\n';

           System.out.println("<< Recived (From Client) - "+clientSentence);
           System.out.println("Sending (From Server) >> ");

           outToClient.writeBytes(capitalizedSentence);
        }
    }
}

// import java.io.*;
// import java.net.*;

// class TCPServer {
//     public static void main(String argv[]) throws Exception {
//         String clientSentence;
//         String capitalizedSentence;

//         int serverPort = 5025;

//         ServerSocket welcomeSocket = new ServerSocket(serverPort);

//         while (true) {
//             Socket connectionSocket = welcomeSocket.accept();

//             BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
//             DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

//             // Create a BufferedReader to read input from the server's console
//             BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

//             // Read a message from the server's console and send it to the client
//             String serverMessage = serverInput.readLine();
//             outToClient.writeBytes(serverMessage + '\n');

//             // Read the client's message
//             clientSentence = inFromClient.readLine();
//             System.out.println("<< Received (From Client) - " + clientSentence);

//             // Capitalize the client's message
//             capitalizedSentence = clientSentence.toUpperCase() + '\n';

//             // Send the capitalized message back to the client
//             System.out.println("Sending (From Server) >> " + capitalizedSentence);
//             outToClient.writeBytes(capitalizedSentence);
//         }
//     }
// }


