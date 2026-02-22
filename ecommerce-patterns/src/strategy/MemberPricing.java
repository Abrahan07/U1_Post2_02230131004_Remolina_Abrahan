/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

public class MemberPricing implements PricingStrategy {
    @Override
    public double calculateFinalPrice(double price) {
        return price * 0.90; // 10% de descuento
    }

    @Override
    public String getDescription() { return "Precio miembro (10% desc)"; }
}
