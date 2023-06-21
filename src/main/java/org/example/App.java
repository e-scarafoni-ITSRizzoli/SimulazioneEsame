package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App
{

    static int portNumber = 1234;
    static ServerSocket serverSocket;

    static ArrayList<Car> cars = new ArrayList<>();

    static void buildList (ArrayList<Car> cars) {
        cars.add(new Car(123,"bmw",3594.9, 2));
        cars.add(new Car(3634,"audi",38346.9, 1));
        cars.add(new Car(135,"ferrari",130000,4));
        /*System.out.println(cars);
        for (Car c: cars
             ) {
            System.out.println(c.getId()  + " ; " + c.getBrand() + " ; " + c.getPrice());
        }*/
    }

    static Car mostExpensive (ArrayList<Car> cars) {
        double maxiValue = 0;
        Car mostExp = null;
        for (Car c: cars
             ) {
            if (c.getPrice() > maxiValue) {
                mostExp = c;
            }
        }

        return mostExp;
    }

    static String arrayAsJSON(ArrayList<Car> cars) {
        Gson g = new Gson();
        String toJson = g.toJson(cars);
        return toJson;
    }

    static boolean startServer() {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static void main( String[] args ) {
        System.out.println("Hello World!");
        buildList(cars);


        if(!startServer()) {
            return;
        }

        while(true) {

            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Thread th = new Thread(
                    () -> {
                        System.out.println(Thread.currentThread().threadId());
                        ClientHandler clientHandler = new ClientHandler(clientSocket);
                        if (!clientHandler.manage()) {
                            System.out.println("cannot run client");
                        }
                    }// end of λ
            );
            th.start();

        }
    }
}