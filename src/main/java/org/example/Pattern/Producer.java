package org.example.Pattern;

import org.example.model.Ship;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private final DataQueue dataQueue;
    private int counter = 0;
    private final Random random;

    private final List<String> names = List.of("Белый","Красный","Синий");

    public Producer(DataQueue dataQueue) {this.dataQueue = dataQueue; random = new Random();}
    @Override
    public void run() {
        produce();
    }
    // Реализация функционала добавление кораблей
    private void produce(){
        try{
            while(true){
                counter++;
                dataQueue.add(generateShip());
                System.out.println("Объект добавлен поставщиком его id: " + counter);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Вспомогательный метод для генерации кораблей
    private Ship generateShip() {
        return new Ship(counter,
                new double[]{random.nextInt(1,10000) + random.nextDouble(), random.nextInt(1,10000) + random.nextDouble(), random.nextInt(1,10000) + random.nextDouble()},
                names.get(random.nextInt(0,2)),
                random.nextInt(4000,10000) + random.nextDouble()
                );
    }
}
