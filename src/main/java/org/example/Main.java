package org.example;

import org.example.pattern.Consumer;
import org.example.pattern.DataQueue;
import org.example.pattern.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int size = 20; // максимальное количество элементов коллекции
        DataQueue dataQueue = new DataQueue(size);

        Producer producer = new Producer(dataQueue); // добавление поставщика
        Thread producerThread = new Thread(producer);
        producerThread.start();

        List<Thread> consumersTreads = new ArrayList<>();
        for (int i = 1; i < 6; i++){ // добавление получателей
            Consumer consumer = new Consumer(dataQueue,"Получатель: " + i);
            Thread consumerThread = new Thread(consumer);
            consumersTreads.add(consumerThread);
        }
        for (var item : consumersTreads) { item.start();}
    }
}