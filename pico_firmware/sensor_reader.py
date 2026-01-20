import board
from adhyay1_ultrasonic import Adhyay1_Ultrasonic
from adhyay1_dht import Adhyay1_DHT

ultrasonic = Adhyay1_Ultrasonic(board.GP8, board.GP9)
dht = Adhyay1_DHT(board.GP20, sensor_type="DHT11")

def read_all_sensors():
    return {
        "USM": ultrasonic.get_distance_cm(),
        "TEMP": dht.temperature(),
        "HUM": dht.humidity()
    }

def send_sensor_data(data):
    if data["USM"] != -1:
        print(f"USM:{data['USM']}")

    if data["TEMP"] is not None:
        print(f"TEMP:{data['TEMP']}")
        print(f"HUM:{data['HUM']}")
