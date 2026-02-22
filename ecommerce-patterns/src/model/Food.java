/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Food extends Product {
    private int weightGrams;

    public Food(String name, double basePrice, int weightGrams) {
        super(name, basePrice, "Food");
        this.weightGrams = weightGrams;
    }

    @Override
    public double calculateShipping() {
        return weightGrams * 0.001 * 1.5; // $1.5 por kg
    }

    @Override
    public String getDescription() {
        return name + " [Alimento] - Peso: " + weightGrams + "g";
    }
}
