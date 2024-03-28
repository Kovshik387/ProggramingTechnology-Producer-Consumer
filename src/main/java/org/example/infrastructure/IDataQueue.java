package org.example.infrastructure;

import org.example.model.Ship;

public interface IDataQueue {
    public void add(Ship model) throws InterruptedException;
    public Ship get() throws InterruptedException;
}
