/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String name, double basePrice, int warrantyMonths) {
        super(name, basePrice, "Electronics");
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateShipping() {
        return basePrice * 0.05; // 5% del precio por fragilidad
    }

    @Override
    public String getDescription() {
        return name + " [Electronica] - Garantia: " + warrantyMonths + " meses";
    }
}