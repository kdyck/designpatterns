package com.qarepo.view;

import java.awt.*;

public class MessageTrayIcon {

    public void displayTray(String caption, String message) {
        // Check the SystemTray is supported
        if (SystemTray.isSupported()) {
            final Image image = Toolkit.getDefaultToolkit().createImage("./msg.png");
            final TrayIcon trayIcon = new TrayIcon(image, "message-icon");
            final SystemTray tray = SystemTray.getSystemTray();
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("New Alert");
            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(caption, message, TrayIcon.MessageType.INFO);
            } catch (Exception e) {
                System.out.println("TrayIcon could not be added.");
                e.printStackTrace();
            }
        }
    }
}
