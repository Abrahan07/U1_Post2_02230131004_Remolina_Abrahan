/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

public class RegularPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price; // Sin descuento
    }

    @Override
    public String getDescription() { return "Precio regular"; }
}
