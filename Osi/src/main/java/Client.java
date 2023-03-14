import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        try (Socket socketClient = new Socket("netology.homework", 8089);
             PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()))) {
            out.println("Ivan");
            out.println("Yes");
            String name = in.readLine();
            System.out.println(name);
            String age = in.readLine();
            System.out.println(age);
            String serverWord = in.readLine();
            System.out.println(serverWord);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}