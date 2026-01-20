# Adhyay-1 Robot Dashboard 🚀

## 📌 Project Overview
The Adhyay-1 Robot Dashboard is a Java-based desktop application that allows
real-time control and monitoring of a robot using USB serial communication.

The robot is controlled by a Raspberry Pi Pico running MicroPython firmware.
The dashboard sends commands and receives live sensor data.

---

## 🧠 System Architecture
PC (Java Swing Dashboard)
↕ USB Serial
Raspberry Pi Pico (MicroPython Firmware)
↕
Sensors & Actuators

---

## 🔧 Hardware Used
- Raspberry Pi Pico / Pico W
- DC Motors (Left & Right)
- Servo Motor
- RGB LED
- OLED Display
- Buzzer & Speaker
- Ultrasonic Sensors
- IR Array
- IMU (MPU6050)
- DHT11 (Temperature & Humidity)
- LDR
- Push Button
- Bluetooth Module

---

## 💻 Software Stack
### Dashboard
- Java
- Java Swing
- jSerialComm (USB Serial)

### Firmware
- MicroPython / CircuitPython
- Adhyay-1 hardware libraries

---

## 🔌 Communication Protocol
### Commands (PC → Robot)
