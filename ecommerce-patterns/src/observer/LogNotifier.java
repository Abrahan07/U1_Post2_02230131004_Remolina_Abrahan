/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogNotifier implements OrderObserver {
    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void update(String orderId, String oldStatus, String newStatus) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println("[LOG][" + timestamp + "] Orden #" + orderId +
            " | Estado anterior: " + oldStatus +
            " | Estado nuevo: " + newStatus);
    }
}
