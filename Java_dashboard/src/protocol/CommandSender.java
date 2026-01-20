package protocol;

import serial.SerialManager;

/**
 * CommandSender
 * -------------------------
 * This class is responsible for sending formatted commands
 * from the Java Dashboard to the Adhyay-1 robot via USB Serial.
 *
 * UI components should NEVER talk to SerialManager directly.
 * They must use this class.
 *
 * This design ensures:
 * - Clean separation of UI and communication logic
 * - Easy debugging
 * - Easy future extension (Bluetooth / Network)
 */
public class CommandSender {

    /**
     * Send a raw command string to the robot.
     * Automatically appends newline character.
     *
     * @param command Command to send (example: MOVE:FWD)
     */
    public static void send(String command) {
        if (command == null || command.isEmpty()) {
            return;
        }

        SerialManager.write(command + "\n");
    }

    /* ==========================
       HIGH-LEVEL HELPER METHODS
       ========================== */

    // ----- MOTOR COMMANDS -----

    public static void moveForward() {
        send("MOVE:FWD");
    }

    public static void moveBackward() {
        send("MOVE:BACK");
    }

    public static void moveLeft() {
        send("MOVE:LEFT");
    }

    public static void moveRight() {
        send("MOVE:RIGHT");
    }

    public static void stop() {
        send("STOP");
    }

    public static void setSpeed(int speed) {
        speed = clamp(speed, 0, 100);
        send("SPEED:" + speed);
    }

    // ----- SERVO COMMANDS -----

    public static void setServoAngle(int angle) {
        angle = clamp(angle, 0, 180);
        send("SERVO:" + angle);
    }

    // ----- LED COMMANDS -----

    public static void ledOn() {
        send("LED:ON");
    }

    public static void ledOff() {
        send("LED:OFF");
    }

    // ----- BUZZER COMMANDS -----

    public static void buzzerOn() {
        send("BUZZER:ON");
    }

    public static void buzzerOff() {
        send("BUZZER:OFF");
    }

    // ----- OLED COMMANDS -----

    public static void showOledText(String text) {
        if (text != null && !text.isEmpty()) {
            send("OLED:TEXT:" + text);
        }
    }

    // ----- SOUND COMMANDS -----

    public static void playSound(String name) {
        if (name != null && !name.isEmpty()) {
            send("SOUND:PLAY:" + name);
        }
    }

    /* ==========================
       UTILITY METHODS
       ========================== */

    private static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}
