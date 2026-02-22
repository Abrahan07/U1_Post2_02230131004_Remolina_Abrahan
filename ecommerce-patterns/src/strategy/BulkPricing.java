/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

public class BulkPricing implements PricingStrategy {
    private int quantity;

    public BulkPricing(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateFinalPrice(double price) {
        if (quantity >= 10) return price * 0.75;      // 25% desc
        else if (quantity >= 5) return price * 0.85;  // 15% desc
        else return price;                             // Sin descuento
    }

    @Override
    public String getDescription() {
        return "Precio por volumen (cantidad: " + quantity + ")";
    }
}
