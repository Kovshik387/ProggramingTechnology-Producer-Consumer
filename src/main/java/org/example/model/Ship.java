package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
// Генерация get'еров и set'еров
@Data
// Генерация конструктора со всеми параметрами
@AllArgsConstructor
public class Ship {
    private int id;
    private double[] coordinates;
    private String name;
    private double capacity;

    @Override
    public String toString(){
        return "Объект id: " + id + " Координаты: " + Arrays.toString(coordinates) +
                " Имя: " + name + " Грузоподъёмность: " + capacity;
    }
}
