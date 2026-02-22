/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import observer.OrderObserver;
import observer.OrderSubject;
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderSubject {
    private String orderId;
    private String status;
    private List<Product> products;
    private List<OrderObserver> observers;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "CREATED";
        this.products = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId, String oldStatus, String newStatus) {
        for (OrderObserver observer : observers) {
            observer.update(orderId, oldStatus, newStatus);
        }
    }

    public void setStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        notifyObservers(orderId, oldStatus, newStatus);
    }

    public void addProduct(Product product) { products.add(product); }
    public String getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public List<Product> getProducts() { return products; }
}
