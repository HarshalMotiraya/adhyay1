import sys
import time

from command_handler import handle_command
from sensor_reader import read_all_sensors, send_sensor_data

print("🚀 Adhyay-1 Pico Firmware Started")

while True:
    # Read command from USB / Bluetooth
    if sys.stdin.in_waiting:
        cmd = sys.stdin.readline().strip()
        if cmd:
            handle_command(cmd)

    # Periodically read sensors and send to PC
    sensor_data = read_all_sensors()
    send_sensor_data(sensor_data)

    time.sleep(0.2)
