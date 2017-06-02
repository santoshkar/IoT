import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(18,GPIO.OUT)

from gpiozero import MotionSensor

pir = MotionSensor(24)
GPIO.output(18,GPIO.LOW)

counter = 0;

while True:
  time.sleep(2);
  if pir.motion_detected:
    counter = 0;
    GPIO.output(18,GPIO.HIGH)
  else:    
    print("Not detected so stopping");
    
    print(counter);
    if counter>30:
      GPIO.output(18,GPIO.LOW)
    else:
      counter+=1;
