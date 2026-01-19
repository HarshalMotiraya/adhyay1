
# 🤖 Adhyay-1 Robot Dashboard

The **Adhyay-1 Robot Dashboard** is a Java-based desktop application designed to **control and monitor a robot in real time**.  
It was developed as part of a **1-month internship project** and demonstrates practical integration of **embedded systems and desktop software**.

---

## 📌 Project Summary

This project allows a user to:
- Send control commands to a robot
- Control motors, servo, LED, and buzzer
- Read live sensor data from the robot
- View all information on a simple desktop dashboard

The robot is controlled by a **Raspberry Pi Pico** running **MicroPython**, while the dashboard is built using **Java Swing** and communicates via **USB serial**.

---

## 🧠 System Architecture

Java Dashboard (PC)
↓ USB Serial
Raspberry Pi Pico
↓
Sensors & Actuators

---------------------------------------------------------------------


- Java handles **UI and communication**
- Pico handles **hardware control**
- Clean separation between software and hardware

---

## 🔧 Technologies Used

- **Microcontroller:** Raspberry Pi Pico / Pico W  
- **Firmware:** MicroPython / CircuitPython  
- **Dashboard:** Java (Swing)  
- **Communication:** USB Serial (Primary), Bluetooth (Secondary)  

---

## ⚙️ Hardware Overview

**Actuators**
- DC Motors, Servo Motor
- RGB LED, Buzzer, Speaker
- OLED Display

**Sensors**
- Ultrasonic Sensors
- IR Array
- IMU (MPU6050)
- DHT11 (Temperature & Humidity)
- LDR, Push Button, IR Remote

---

## ▶️ How to Run (Quick Steps)

1. Flash MicroPython on Raspberry Pi Pico  
2. Upload firmware files to Pico  
3. Open Java project and add `jSerialComm` library  
4. Run `MainFrame.java`  
5. Connect Pico via USB and select COM port  
6. Control robot and monitor sensors from dashboard  

---

## 🎓 Learning Outcome

This project provided hands-on experience in:
- Embedded systems programming
- Serial communication
- Java desktop application development
- System integration and debugging

---

## 🚀 Future Scope

- AI-based navigation
- Cloud / Wi-Fi dashboard
- Mobile application control
- Autonomous robot modes

---

## 👨‍💻 Author

**Harshal Motiraya**  
M.Tech – Computer Science  
Internship Project  

---

## 📜 Note

This project is intended for **educational and academic use**.
