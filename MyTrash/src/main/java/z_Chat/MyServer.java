/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package z_Chat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

/**
 *
 * @author MartyMcAir
 */
public class MyServer {

    private final static int PORT = 4403; // 4403 or 4403 or 3345 or 11111 or 8080
    public static LinkedList<ServerSomthing2> serverList = new LinkedList<>(); // список всех нитей
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedWriter out; // отвечаем юзеру через out
    private BufferedReader in; // in читаем что нам прислал юзер

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
        myServer.connectV2();

//        myServer.connectMultiThreading();
        //        try {
//            myClient.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {   // обеспечиваем закрытие close() при любом исходе
//            try {
//                myClient.socket.close();
//                myClient.in.close();
//                myClient.out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void connectMultiThreading() {
        try (ServerSocket server = new ServerSocket(PORT);) {
            while (true) {
                Socket socket = server.accept(); // Блокируется до возникновения нового соединения:
                serverList.add(new ServerSomthing2(socket)); // добавить новое соединенние в список
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectV2() {
        System.out.println("(в консоли сервера) сервер запущен.");
        try (ServerSocket serverSocket2 = new ServerSocket(PORT); // создали серв
                Socket clientSocket2 = serverSocket2.accept(); // ждем клиента и получаем от него потоки
                // отвечаем юзеру через out
                BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(clientSocket2.getOutputStream()));
                // in читаем, то что получили от юзера
                BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));) {
            System.out.println("(в консоли сервера) объект, сервер создан.");

            System.out.print("getRemoteSocketAddress: " // /127.0.0.1:59937
                    + clientSocket2.getRemoteSocketAddress() + "\n"
                    + //                    "getChannel: " + clientSocket2.getChannel() + "\n" + // NullPointerException
                    "getInetAddress: " // /127.0.0.1
                    + clientSocket2.getInetAddress() + "\n"
                    + "getPort: " // 59937 _ при кажд нов подключении меняется
                    + clientSocket2.getPort() + "\n");
            System.out.print("getLocalSocketAddress: " // /127.0.0.1:4403
                    + clientSocket2.getLocalSocketAddress() + "\n"
                    + "getLocalAddress: " // /127.0.0.1
                    + clientSocket2.getLocalAddress() + "\n"
                    + "getLocalPort: " // 4403
                    + clientSocket2.getLocalPort() + "\n");

            while (!clientSocket2.isClosed()) {   // держим соединение пока юзер, сам его неразорвет
                String word = in2.readLine(); // ждём пока клиент что-нибудь напишет
                System.out.println("(в консоли сервера) юзер написал: " + word);
                out2.write("(отправлено юзеру) вы написали: " + word + "\n"); // отвечает клиенту
                out2.flush(); // выталкиваем все из буфера
            }
        } //        catch (UnknownHostException e) {   }
        catch (SocketException e) {
            System.out.println("Клиент разорвал соединение.");
        } catch (IOException e) {   // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
