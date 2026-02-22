/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

public class BlackFridayPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.70; // 30% de descuento
    }

    @Override
    public String getDescription() { return "Black Friday (30% desc)"; }
}
