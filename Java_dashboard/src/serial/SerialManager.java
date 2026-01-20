package serial;

import com.fazecast.jSerialComm.SerialPort;
import protocol.DataParser;

/**
 * SerialManager
 * -------------------------
 * Handles USB Serial communication with Raspberry Pi Pico.
 *
 * Responsibilities:
 * - Open/close serial port
 * - Send commands
 * - Read incoming data continuously
 *
 * Uses jSerialComm library.
 */
public class SerialManager {

    private static SerialPort serialPort;
    private static Thread readThread;
    private static boolean running = false;

    /* ==========================
       CONNECTION METHODS
       ========================== */

    public static boolean connect(String portName, int baudRate) {
        serialPort = SerialPort.getCommPort(portName);
        serialPort.setBaudRate(baudRate);
        serialPort.setComPortTimeouts(
                SerialPort.TIMEOUT_READ_SEMI_BLOCKING,
                100,
                0
        );

        if (!serialPort.openPort()) {
            System.out.println("Failed to open port: " + portName);
            return false;
        }

        System.out.println("✅ Connected to " + portName);
        startReadThread();
        return true;
    }

    public static void disconnect() {
        running = false;

        if (readThread != null) {
            readThread.interrupt();
        }

        if (serialPort != null && serialPort.isOpen()) {
            serialPort.closePort();
            System.out.println("🔌 Serial port closed");
        }
    }

    /* ==========================
       WRITE METHOD
       ========================== */

    public static void write(String data) {
        if (serialPort == null || !serialPort.isOpen()) {
            System.out.println("⚠ Serial not connected");
            return;
        }

        byte[] bytes = data.getBytes();
        serialPort.writeBytes(bytes, bytes.length);
    }

    /* ==========================
       READ THREAD
       ========================== */

    private static void startReadThread() {
        running = true;

        readThread = new Thread(() -> {
            byte[] buffer = new byte[1024];

            while (running && serialPort.isOpen()) {
                int bytesRead = serialPort.readBytes(buffer, buffer.length);

                if (bytesRead > 0) {
                    String received = new String(buffer, 0, bytesRead).trim();

                    // Split multiple lines if present
                    String[] lines = received.split("\\r?\\n");
                    for (String line : lines) {
                        if (!line.isEmpty()) {
                            System.out.println("⬇ " + line);
                            DataParser.parse(line);
                        }
                    }
                }
            }
        });

        readThread.setDaemon(true);
        readThread.start();
    }

    /* ==========================
       UTILITY
       ========================== */

    public static String[] listAvailablePorts() {
        SerialPort[] ports = SerialPort.getCommPorts();
        String[] names = new String[ports.length];

        for (int i = 0; i < ports.length; i++) {
            names[i] = ports[i].getSystemPortName();
        }
        return names;
    }
}
