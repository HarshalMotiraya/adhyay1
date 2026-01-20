from motor_control import move, stop, set_speed
from actuator_control import (
    set_servo_angle,
    led_on, led_off,
    buzzer_on, buzzer_off
)

current_speed = 60

def handle_command(cmd):
    global current_speed

    if cmd == "MOVE:FWD":
        move("FWD", current_speed)

    elif cmd == "MOVE:BACK":
        move("BACK", current_speed)

    elif cmd == "MOVE:LEFT":
        move("LEFT", current_speed)

    elif cmd == "MOVE:RIGHT":
        move("RIGHT", current_speed)

    elif cmd == "STOP":
        stop()

    elif cmd.startswith("SPEED:"):
        current_speed = int(cmd.split(":")[1])
        set_speed(current_speed)

    elif cmd.startswith("SERVO:"):
        angle = int(cmd.split(":")[1])
        set_servo_angle(angle)

    elif cmd == "LED:ON":
        led_on()

    elif cmd == "LED:OFF":
        led_off()

    elif cmd == "BUZZER:ON":
        buzzer_on()

    elif cmd == "BUZZER:OFF":
        buzzer_off()

    else:
        print("UNKNOWN_CMD:", cmd)
