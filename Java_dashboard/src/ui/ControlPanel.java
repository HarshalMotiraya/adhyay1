package ui;

import javax.swing.*;
import java.awt.*;
import protocol.CommandSender;

/**
 * ControlPanel
 * -------------------------
 * Provides UI controls to send commands to the robot.
 * Uses CommandSender for all communication.
 */
public class ControlPanel extends JPanel {

    public ControlPanel() {

        setLayout(new GridLayout(0, 1, 8, 8));
        setBorder(BorderFactory.createTitledBorder("Robot Controls"));

        /* ==========================
           MOTOR CONTROLS
           ========================== */

        JButton forwardBtn = new JButton("Forward");
        JButton backBtn = new JButton("Backward");
        JButton leftBtn = new JButton("Left");
        JButton rightBtn = new JButton("Right");
        JButton stopBtn = new JButton("STOP");

        forwardBtn.addActionListener(e -> CommandSender.moveForward());
        backBtn.addActionListener(e -> CommandSender.moveBackward());
        leftBtn.addActionListener(e -> CommandSender.moveLeft());
        rightBtn.addActionListener(e -> CommandSender.moveRight());
        stopBtn.addActionListener(e -> CommandSender.stop());

        add(new JLabel("Movement"));
        add(forwardBtn);
        add(backBtn);
        add(leftBtn);
        add(rightBtn);
        add(stopBtn);

        add(new JSeparator());

        /* ==========================
           SPEED CONTROL
           ========================== */

        JLabel speedLabel = new JLabel("Speed: 60%");
        JSlider speedSlider = new JSlider(0, 100, 60);

        speedSlider.setMajorTickSpacing(20);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);

        speedSlider.addChangeListener(e -> {
            int value = speedSlider.getValue();
            speedLabel.setText("Speed: " + value + "%");
            CommandSender.setSpeed(value);
        });

        add(speedLabel);
        add(speedSlider);

        add(new JSeparator());

        /* ==========================
           SERVO CONTROL
           ========================== */

        JLabel servoLabel = new JLabel("Servo Angle: 90°");
        JSlider servoSlider = new JSlider(0, 180, 90);

        servoSlider.setMajorTickSpacing(30);
        servoSlider.setPaintTicks(true);
        servoSlider.setPaintLabels(true);

        servoSlider.addChangeListener(e -> {
            int angle = servoSlider.getValue();
            servoLabel.setText("Servo Angle: " + angle + "°");
            CommandSender.setServoAngle(angle);
        });

        add(servoLabel);
        add(servoSlider);

        add(new JSeparator());

        /* ==========================
           LED CONTROLS
           ========================== */

        JButton ledOnBtn = new JButton("LED ON");
        JButton ledOffBtn = new JButton("LED OFF");

        ledOnBtn.addActionListener(e -> CommandSender.ledOn());
        ledOffBtn.addActionListener(e -> CommandSender.ledOff());

        add(new JLabel("RGB LED"));
        add(ledOnBtn);
        add(ledOffBtn);

        add(new JSeparator());

        /* ==========================
           BUZZER CONTROLS
           ========================== */

        JButton buzzerOnBtn = new JButton("Buzzer ON");
        JButton buzzerOffBtn = new JButton("Buzzer OFF");

        buzzerOnBtn.addActionListener(e -> CommandSender.buzzerOn());
        buzzerOffBtn.addActionListener(e -> CommandSender.buzzerOff());

        add(new JLabel("Buzzer"));
        add(buzzerOnBtn);
        add(buzzerOffBtn);
    }
}
