package protocol;

import javax.swing.SwingUtilities;
import ui.SensorPanel;

/**
 * DataParser
 * -------------------------
 * Parses incoming serial data from the Adhyay-1 robot
 * and updates the UI components safely.
 *
 * Expected formats:
 *  TEMP:28
 *  HUM:62
 *  USM:15
 *  USL:23
 *  USR:40
 *  IR:1,1,0,1,1
 *  SWITCH:PRESSED
 */
public class DataParser {

    /**
     * Parse one line of incoming data.
     *
     * @param line single line received from serial
     */
    public static void parse(String line) {

        // Always update Swing UI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            try {
                if (line.startsWith("TEMP:")) {
                    SensorPanel.tempLabel.setText(
                            "Temperature: " + line.substring(5) + " °C"
                    );

                } else if (line.startsWith("HUM:")) {
                    SensorPanel.humLabel.setText(
                            "Humidity: " + line.substring(4) + " %"
                    );

                } else if (line.startsWith("USM:")) {
                    SensorPanel.usMiddleLabel.setText(
                            "Front Distance: " + line.substring(4) + " cm"
                    );

                } else if (line.startsWith("USL:")) {
                    SensorPanel.usLeftLabel.setText(
                            "Left Distance: " + line.substring(4) + " cm"
                    );

                } else if (line.startsWith("USR:")) {
                    SensorPanel.usRightLabel.setText(
                            "Right Distance: " + line.substring(4) + " cm"
                    );

                } else if (line.startsWith("IR:")) {
                    SensorPanel.irLabel.setText(
                            "IR Array: " + line.substring(3)
                    );

                } else if (line.startsWith("SWITCH:")) {
                    SensorPanel.switchLabel.setText(
                            "Switch: " + line.substring(7)
                    );

                } else if (line.startsWith("IMU:")) {
                    SensorPanel.imuLabel.setText(
                            "IMU: " + line.substring(4)
                    );

                } else {
                    // Unknown data (can be logged later)
                    System.out.println("⚠ Unknown data: " + line);
                }

            } catch (Exception e) {
                System.err.println("❌ Data parse error: " + e.getMessage());
            }
        });
    }
}
