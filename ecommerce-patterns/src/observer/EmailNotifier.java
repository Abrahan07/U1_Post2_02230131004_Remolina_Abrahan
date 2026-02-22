/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

public class EmailNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        System.out.println("[EMAIL] Pedido #" + orderId +
            " cambio de " + oldStatus + " a " + newStatus +
            ". Se ha enviado un correo al cliente.");
    }
}
