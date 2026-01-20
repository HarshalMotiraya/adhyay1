HOW TO RUN THE ADHYAY-1 ROBOT DASHBOARD PROJECT

-------------------------------------------------
PART A: HARDWARE & FIRMWARE SETUP (ROBOT SIDE)
✅ Step 1: Hardware Connections

Ensure all components are connected correctly to Adhyay-1 robot:

Motors → Motor driver → Pico

Servo → GPIO 26

RGB LED → GPIO 27

Buzzer → GPIO 22

Ultrasonic Sensor → GPIO 8 (Trig), GPIO 9 (Echo)

DHT11 → GPIO 20

Power supply connected properly

✔ Verify wiring before powering ON

----------------------------------------------------
✅ Step 2: Install MicroPython / CircuitPython on Pico

Connect Raspberry Pi Pico to PC while holding BOOTSEL button

Pico appears as a USB drive

Copy MicroPython (.uf2) firmware to Pico

Pico restarts automatically

✔ MicroPython installed successfully
----------------------------------------------

Step 3: Upload Firmware Files to Pico

Open Thonny IDE

Select interpreter:

Tools → Options → Interpreter → MicroPython (Raspberry Pi Pico)


Copy all files from:

pico_firmware/


into Pico root directory

Files required:

main.py

command_handler.py

motor_control.py

actuator_control.py

sensor_reader.py

✔ Firmware uploaded

---------------------------------------------------
Step 4: Verify Firmware Output

Open Thonny Shell

Reset Pico

You should see:

Adhyay-1 Pico Firmware Started


✔ Pico firmware running
----------------------------------

PART B: JAVA DASHBOARD SETUP (PC SIDE)
✅ Step 5: Install Java (JDK 11 or above)

Check Java:

java -version


If not installed:

Install OpenJDK 11

Restart PC

✔ Java ready

--------------------------------------------------

Step 6: Add jSerialComm Library

Download jSerialComm JAR

Add it to your Java project:

Eclipse / IntelliJ → Add to Build Path

✔ USB serial support added

------------------------------------------

Step 7: Open Java Dashboard Project

Open IDE (Eclipse / IntelliJ)

Import project folder:

java_dashboard/


Verify packages:

ui

serial

protocol

✔ Project loaded
---------------------------------------

Step 8: Run the Dashboard

Run:

MainFrame.java


Dashboard window opens

✔ Dashboard launched
---------------------------------


\PART C: CONNECT & CONTROL
✅ Step 9: Connect Pico to Dashboard

Connect Pico via USB cable

Select correct COM port in dashboard

Click Connect

You should see:

Connected to COMx


✔ Connection established

------------------------------

Step 10: Control the Robot

Click Forward / Back / Left / Right

Move Speed slider

Adjust Servo slider

Toggle LED & Buzzer

Robot responds immediately

✔ Command execution verified

------------------------------------

Step 11: Monitor Sensor Data

Watch live updates on dashboard:

Temperature & Humidity

Ultrasonic distance

IR sensor data

✔ Sensor monitoring working

---------------------------

PART E: SHUTDOWN PROCEDURE
✅ Step 13: Safe Shutdown

Click STOP

Click Disconnect

Close dashboard

Unplug Pico

✔ Safe shutdown complete