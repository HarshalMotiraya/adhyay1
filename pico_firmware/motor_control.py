import board
from adhyay1_motors import Adhyay1_Motor

left_motor = Adhyay1_Motor(board.GP11, board.GP10)
right_motor = Adhyay1_Motor(board.GP14, board.GP15)

def move(direction, speed):
    if direction == "FWD":
        left_motor.forward(speed)
        right_motor.forward(speed)

    elif direction == "BACK":
        left_motor.reverse(speed)
        right_motor.reverse(speed)

    elif direction == "LEFT":
        left_motor.stop()
        right_motor.forward(speed)

    elif direction == "RIGHT":
        right_motor.stop()
        left_motor.forward(speed)

def stop():
    left_motor.stop()
    right_motor.stop()

def set_speed(speed):
    # speed is handled dynamically during movement
    pass
