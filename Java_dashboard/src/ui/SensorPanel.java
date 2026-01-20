package ui;

import javax.swing.*;
import java.awt.*;

/**
 * SensorPanel
 * -------------------------
 * Displays live sensor values received from the robot.
 * Updated only via DataParser.
 */
public class SensorPanel extends JPanel {

    // ===== Public labels (updated by DataParser) =====
    public static JLabel tempLabel;
    public static JLabel humLabel;

    public static JLabel usMiddleLabel;
    public static JLabel usLeftLabel;
    public static JLabel usRightLabel;

    public static JLabel irLabel;
    public static JLabel imuLabel;
    public static JLabel switchLabel;

    public SensorPanel() {

        setLayout(new GridLayout(0, 1, 5, 5));
        setBorder(BorderFactory.createTitledBorder("Sensor Data"));

        // Initialize labels
        tempLabel = createLabel("Temperature: -- °C");
        humLabel = createLabel("Humidity: -- %");

        usMiddleLabel = createLabel("Front Distance: -- cm");
        usLeftLabel = createLabel("Left Distance: -- cm");
        usRightLabel = createLabel("Right Distance: -- cm");

        irLabel = createLabel("IR Array: --");
        imuLabel = createLabel("IMU: --");
        switchLabel = createLabel("Switch: --");

        // Add to panel
        add(tempLabel);
        add(humLabel);

        add(new JSeparator());

        add(usMiddleLabel);
        add(usLeftLabel);
        add(usRightLabel);

        add(new JSeparator());

        add(irLabel);
        add(imuLabel);
        add(switchLabel);
    }

    // Utility method to create labels consistently
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        return label;
    }
}
