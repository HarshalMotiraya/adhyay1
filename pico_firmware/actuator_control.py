import board
from adhyay1_servo import Adhyay1_Servo
from adhyay1_led import Adhyay1_LED
from adhyay1_buzzer import Adhyay1_Buzzer

servo = Adhyay1_Servo(board.GP26)
led = Adhyay1_LED(board.GP27, num_leds=1)
buzzer = Adhyay1_Buzzer(board.GP22, passive=True)

def set_servo_angle(angle):
    servo.set_angle(angle)

def led_on():
    led.on((0, 255, 0))

def led_off():
    led.off()

def buzzer_on():
    buzzer.on()

def buzzer_off():
    buzzer.off()
