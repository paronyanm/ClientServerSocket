import paronyan.Phone;


import java.io.*;


public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000);

        ){
            System.out.println("Мы подключились");
            String request = "Гавар";
            System.out.println("Запрос " + request);


            phone.writeLine(request);
            String response = phone.readLine();
            System.out.println("Получили " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
