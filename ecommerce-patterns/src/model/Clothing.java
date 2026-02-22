/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, double basePrice, String size) {
        super(name, basePrice, "Clothing");
        this.size = size;
    }

    @Override
    public double calculateShipping() {
        return 2.99; // Envío fijo para ropa
    }

    @Override
    public String getDescription() {
        return name + " [Ropa] - Talla: " + size;
    }
}
