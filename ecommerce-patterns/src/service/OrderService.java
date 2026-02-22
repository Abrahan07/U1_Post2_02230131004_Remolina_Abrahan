/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import factory.ProductFactory;
import model.Order;
import model.Product;
import observer.OrderObserver;
import strategy.PricingStrategy;

public class OrderService {
    private Order order;
    private PricingStrategy pricingStrategy;

    public OrderService(String orderId, PricingStrategy pricingStrategy) {
        this.order = new Order(orderId);
        this.pricingStrategy = pricingStrategy;
    }

    public void addObserver(OrderObserver observer) {
        order.subscribe(observer);
    }

    public Product addProduct(String type, String name, double price) {
        Product product = ProductFactory.createProduct(type, name, price);
        order.addProduct(product);
        return product;
    }

    public void changeStatus(String newStatus) {
        order.setStatus(newStatus);
    }

    public double calculateTotal() {
        return order.getProducts().stream()
            .mapToDouble(p -> pricingStrategy.calculateFinalPrice(p.getBasePrice())
                            + p.calculateShipping())
            .sum();
    }

    public void printSummary() {
        System.out.println("\n===== RESUMEN DEL PEDIDO =====");
        System.out.println("Pedido #: " + order.getOrderId());
        System.out.println("Estado:   " + order.getStatus());
        System.out.println("Estrategia: " + pricingStrategy.getDescription());
        System.out.println("Productos:");
        for (Product p : order.getProducts()) {
            double finalPrice = pricingStrategy.calculateFinalPrice(p.getBasePrice());
            double shipping   = p.calculateShipping();
            System.out.printf("  - %s | Precio: $%.2f | Envio: $%.2f | Total: $%.2f%n",
                p.getDescription(), finalPrice, shipping, finalPrice + shipping);
        }
        System.out.printf("TOTAL: $%.2f%n", calculateTotal());
        System.out.println("==============================\n");
    }
}
