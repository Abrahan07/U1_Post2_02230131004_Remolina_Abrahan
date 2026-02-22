/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

public class SMSNotifier implements OrderObserver {
    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        System.out.println("[SMS] Pedido #" + orderId +
            " actualizado: " + oldStatus + " -> " + newStatus +
            ". Mensaje de texto enviado.");
    }
}
