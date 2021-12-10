import paronyan.Phone;

import java.io.*;
import java.net.ServerSocket;


public class Server {
    public static void main(String[] args) {


        try (ServerSocket server = new ServerSocket(8000)){
            System.out.println("Сервер запущен");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Клиент подключился");
                    System.out.println("Request " + request);
                    String response = "Привет из сервера " + request.length() ;
                    System.out.println("Response " + response);
                    phone.writeLine(response);
                }).start();
            }

        } catch (IOException  exception) {
            throw new RuntimeException(exception);
        }

    }
}
