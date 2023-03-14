import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    String name = in.readLine();
                    String age = in.readLine();

                    out.println(String.format("Write your name: " + name, clientSocket.getPort()));
                    out.flush();

                    out.println(String.format("Are you child? " + age, clientSocket.getPort()));
                    out.flush();
                    if (age.equals("Yes")) {
                        out.println(String.format("Welcome to the kids area, " + name + " Let's play!", clientSocket.getPort()));
                        out.flush();

                    } else if (age.equals("No")) {
                        out.println(String.format("Welcome to the adult zone," + name + "Have a good rest, or a good working day!", clientSocket.getPort()));
                        out.flush();

                    }

                }
            }
        }
    }

}
