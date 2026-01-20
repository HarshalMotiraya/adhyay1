package ui;

import serial.SerialManager;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame
 * -------------------------
 * Main window for the Adhyay-1 Robot Dashboard.
 * Hosts ControlPanel and SensorPanel.
 */
public class MainFrame extends JFrame {

    private JComboBox<String> portSelector;
    private JButton connectButton;
    private boolean connected = false;

    public MainFrame() {

        setTitle("Adhyay-1 Robot Dashboard");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        /* ==========================
           TOP BAR – SERIAL CONTROL
           ========================== */

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createTitledBorder("Connection"));

        portSelector = new JComboBox<>(SerialManager.listAvailablePorts());
        connectButton = new JButton("Connect");

        connectButton.addActionListener(e -> toggleConnection());

        topPanel.add(new JLabel("Port:"));
        topPanel.add(portSelector);
        topPanel.add(connectButton);

        /* ==========================
           MAIN PANELS
           ========================== */

        ControlPanel controlPanel = new ControlPanel();
        SensorPanel sensorPanel = new SensorPanel();

        add(topPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.WEST);
        add(sensorPanel, BorderLayout.CENTER);
    }

    private void toggleConnection() {

        if (!connected) {
            String port = (String) portSelector.getSelectedItem();

            if (port == null) {
                JOptionPane.showMessageDialog(this,
                        "No serial port selected",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean success = SerialManager.connect(port, 115200);

            if (success) {
                connected = true;
                connectButton.setText("Disconnect");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to connect to " + port,
                        "Connection Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {
            SerialManager.disconnect();
            connected = false;
            connectButton.setText("Connect");
        }
    }

    /* ==========================
       APPLICATION ENTRY POINT
       ========================== */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}


// how the every this connected now 
// MainFrame
//  ├── ControlPanel  → CommandSender → SerialManager → Pico
//  └── SensorPanel   ← DataParser    ← SerialManager ← Pico
