package org.example;

import org.example.Pattern.Consumer;
import org.example.Pattern.DataQueue;
import org.example.Pattern.Producer;

public class Main {
    public static void main(String[] args) {
        int size = 20; // максимальное количество элементов коллекции
        DataQueue dataQueue = new DataQueue(size);

        Producer producer = new Producer(dataQueue); // добавление поставщика
        Thread producerThread = new Thread(producer);
        producerThread.start();

        for (int i = 1; i < 6; i++){ // добавление получателей
            Consumer consumer = new Consumer(dataQueue,"Получатель: " + i);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }

    }
}