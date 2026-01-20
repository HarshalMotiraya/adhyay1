The Adhyay-1 Robot Dashboard project aims to design and implement a computer-based dashboard application that enables real-time control and monitoring of a robot. The system uses a Java Swing desktop application to send commands to a robot controlled by a Raspberry Pi Pico running MicroPython firmware. Communication between the dashboard and robot is achieved using USB serial communication, with Bluetooth as a secondary wireless option.
The dashboard allows the user to control motors, servo, LED, buzzer, and monitor sensor data such as ultrasonic distance, temperature, humidity, IMU data, and IR array values. The project follows a modular and scalable architecture suitable for embedded systems applications and internship-level evaluation.


OBJECTIVES

To design a Java-based robot control dashboard

To implement serial communication between PC and microcontroller

To integrate multiple sensors and actuators

To display live sensor data on the dashboard

To build a modular and scalable system



SYSTEM ARCHITECTURE
4.1 Block Diagram

(PC → USB Serial → Pico → Sensors & Actuators)

4.2 Description

Java Dashboard (UI + logic)

Pico Firmware (hardware control)

Communication flow



HARDWARE DESCRIPTION
5.1 Microcontroller – Raspberry Pi Pico
5.2 Actuators

DC Motors

Servo Motor

RGB LED

Buzzer & Speaker

OLED Display

5.3 Sensors

Ultrasonic Sensors

IR Array

IMU (MPU6050)

DHT11

LDR

Push Button

IR Remote

Bluetooth Module



SOFTWARE DESIGN
6.1 Firmware Design (MicroPython)

Main loop

Command parsing

Actuator control

Sensor reading

6.2 Java Dashboard Design

Swing UI

SerialManager

CommandSender

DataParser