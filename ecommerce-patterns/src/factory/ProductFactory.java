/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import model.*;
import model.Clothing;
import model.Electronics;
import model.Food;
import model.Product;

public class ProductFactory {
    public static Product createProduct(String type, String name, double price) {
        return switch (type.toUpperCase()) {
            case "ELECTRONICS" -> new Electronics(name, price, 12);
            case "CLOTHING"    -> new Clothing(name, price, "M");
            case "FOOD"        -> new Food(name, price, 30);
            default -> throw new IllegalArgumentException("Tipo desconocido: " + type);
        };
    }
}