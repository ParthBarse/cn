import java.net.*;
import java.util.Scanner;

public class Dns14 {
    public static void main(String[] args) {
        String host;
        Scanner ch = new Scanner(System.in);
        System.out.print("1. Enter Host Name\n2. Enter IP address\nChoice=");
        int choice = ch.nextInt();

        if (choice == 1) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.print("\nEnter host name: ");
                host = input.nextLine();
                try {
                    InetAddress address = InetAddress.getByName(host);
                    System.out.println("IP address: " + address.getHostAddress());
                    System.out.println("Host name: " + address.getHostName());
                    System.out.println("Host name and IP address: " + address.toString());
                } catch (UnknownHostException ex) {
                    System.out.println("Could not find " + host);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (choice == 2) {
            try (Scanner input = new Scanner(System.in)) {
                System.out.print("\nEnter IP address: ");
                host = input.nextLine();
                try {
                    InetAddress address = InetAddress.getByName(host);
                    System.out.println("Host name: " + address.getHostName());
                    System.out.println("IP address: " + address.getHostAddress());
                    System.out.println("Host name and IP address: " + address.toString());
                } catch (UnknownHostException ex) {
                    System.out.println("Could not find " + host);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }
}
