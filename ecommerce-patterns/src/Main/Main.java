/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import observer.EmailNotifier;
import observer.SMSNotifier;
import observer.LogNotifier;
import service.OrderService;
import strategy.RegularPricing;
import strategy.BlackFridayPricing;
import strategy.MemberPricing;
import strategy.BulkPricing;
import model.Product;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== E-COMMERCE CON PATRONES DE DISENO ==========\n");

        // a) Crear productos usando Factory
        System.out.println("--- Creacion de productos con Factory Method ---");
        OrderService service = new OrderService("ORD-001", new BlackFridayPricing());

        // b) Suscribir observadores
        service.addObserver(new EmailNotifier());
        service.addObserver(new SMSNotifier());
        service.addObserver(new LogNotifier());

        // Agregar uno de cada tipo
        Product laptop  = service.addProduct("ELECTRONICS", "Laptop Dell", 1200.00);
        Product shirt   = service.addProduct("CLOTHING", "Camisa Polo", 35.00);
        Product coffee  = service.addProduct("FOOD", "Cafe Molido 500g", 12.00);

        System.out.println("Productos creados:");
        System.out.println("  " + laptop.getDescription());
        System.out.println("  " + shirt.getDescription());
        System.out.println("  " + coffee.getDescription());

        // b) Cálculo de precios con diferentes estrategias
        System.out.println("\n--- Comparacion de estrategias de precio (Laptop $1200) ---");
        double base = laptop.getBasePrice();
        System.out.printf("  Regular:     $%.2f%n", new RegularPricing().calculateFinalPrice(base));
        System.out.printf("  Miembro:     $%.2f%n", new MemberPricing().calculateFinalPrice(base));
        System.out.printf("  Black Friday:$%.2f%n", new BlackFridayPricing().calculateFinalPrice(base));
        System.out.printf("  Volumen x10: $%.2f%n", new BulkPricing(10).calculateFinalPrice(base));

        // c) Cambios de estado con notificaciones
        System.out.println("\n--- Cambios de estado del pedido ---");
        service.changeStatus("PROCESSING");
        service.changeStatus("SHIPPED");
        service.changeStatus("DELIVERED");

        // d) Resumen final
        service.printSummary();
    }
}
