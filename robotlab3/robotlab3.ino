/*
 * Line-following code for the Pololu Zumo Robot
 *
 * This code will follow a black line on a light background, using a
 * PID-based algorithm.  
 */

#include <Wire.h>
#include <ZumoShield.h>

ZumoBuzzer buzzer;
ZumoReflectanceSensorArray reflectanceSensors;
ZumoMotors motors;
Pushbutton button(ZUMO_BUTTON);
int lastError = 0;
int lastPosition = 0;

// This is the maximum speed the motors will be allowed to turn.
// (400 lets the motors go at top speed; decrease to impose a speed limit)
const int MAX_SPEED = 300;


void setup()
{
  // Play a little welcome song
  buzzer.play(">g32>>c32");

  // Initialize the reflectance sensors module
  reflectanceSensors.init();

  // Wait for the user button to be pressed and released
  button.waitForButton();

  // Turn on LED to indicate we are in calibration mode
  pinMode(13, OUTPUT);
  digitalWrite(13, HIGH);

  // Wait 1 second and then begin automatic sensor calibration
  // by rotating in place to sweep the sensors over the line
  delay(1000);
  int i;
  for(i = 0; i < 80; i++)
  {
    if ((i > 10 && i <= 30) || (i > 50 && i <= 70))
      motors.setSpeeds(-200, 200);
    else
      motors.setSpeeds(200, -200);
    reflectanceSensors.calibrate();

    // Since our counter runs to 80, the total delay will be
    // 80*20 = 1600 ms.
    delay(20);
  }
  motors.setSpeeds(0,0);

  // Turn off LED to indicate we are through with calibration
  digitalWrite(13, LOW);
  buzzer.play(">g32>>c32");

  // Wait for the user button to be pressed and released
  button.waitForButton();

  // Play music and wait for it to finish before we start driving.
  buzzer.play("L16 cdegreg4");
  while(buzzer.isPlaying());
}

void loop()
{
  unsigned int sensors[6];

  // Calling the followLine() function returns the position of the line.  
  // Note that we *must* provide the "sensors" argument to followLine() here, 
  // even though we are not interested in the individual sensor readings
  int position = followLine(sensors,lastPosition); 
  // lastPosition = position; // Store last position for use in next loop
  
  // Our "error" is how far we are away from the center of the line.
  // The center of the line (from “position”) corresponds to position 2500.
  // int error = position - 2500; // complete the calculation to determine the error

  // Calculate the motor speed difference using proportional and derivative PID terms.
  // (the integral term is generally not very useful for line following).
  // Here we are using a proportional constant of 1/4 and a derivative
  // constant of 6, which should work decently for many Zumo motor choices.
   
  // int speedDifference = .25*error + 6*(lastError-error); // complete the calculation to determine the speed difference

  // lastError = error;  // used to calculate change in error for derivative term

  // Get individual motor speeds.  The sign of speedDifference
  // determines if the robot turns left or right to adjust to the line.
int m1Speed = 100;
int m2Speed = 100;
if(position != 0 && position != 5000){
  motors.setSpeeds(-100,-100);
  delay(200);
  if(position < 2500)
    motors.setSpeeds(100,0);
  else
    motors.setSpeeds(0,100);
  delay(200);
}

  // Here we constrain our motor speeds to be between 0 and MAX_SPEED.  
  // Add “if” statements to ensure your motor speeds are within this range
 // if(m1Speed<0)
//  m1Speed = 0;
// if(m1Speed > MAX_SPEED)
//  m1Speed = MAX_SPEED;
// if(m2Speed<0)
//  m2Speed = 0;
// if(m2Speed > MAX_SPEED)
//  m2Speed = MAX_SPEED;
 // Use the “setSpeeds” function (you used this function in Robot Lab #1)
// to set the motor speeds
 motors.setSpeeds(m1Speed,m2Speed);

}

int followLine(int sensorArray[], int lastValue)
{
  // Returns position (in a range of 0 to 5000) with respect to black line,
  // using a weighted average of the sensor array values.
  // Values of exactly 0,1000 ,2000, etc indicate that the line
  // is directly below one of the sensors, and intermediate
  // values indicated that the line is between sensors.
  // The formula is:
  //
  //    0*value0 + 1000*value1 + 2000*value2 + ...
  //   --------------------------------------------
  //         value0  +  value1  +  value2 + ...

  unsigned char i, on_line = 0;
  unsigned long avg; // numerator of weighted average formula
  unsigned int sum; // denominator of weighted average formula
  unsigned char numberOfSensors = 6;
  reflectanceSensors.readCalibrated(sensorArray);
  avg = 0; sum = 0;

  for(i = 0; i < numberOfSensors; i++) {
    int value =  sensorArray[i];// set “value” to current sensor index
    if(value > 200) { // Is the line visible?
      // set the proper variable
      on_line = 1;
    }
    if(value > 50) { // Is the reading above a noise threshold?
      // calculate updated numerator value of weighted avg (store in “avg” variable)
      avg = avg + long(value)*i*1000;
      // calculate updated denominator value of weighted avg (store in “sum” variable)
      sum = sum + value;
    }
  }
  if(!on_line) {
    if(lastValue < (numberOfSensors-1)*1000/2) // If last position was left of center
      // Return minimum position
      return 0;
    else // If last position was right of center
      // Return maximum position
      return 5000;
  }
  lastValue = avg/sum;
  return lastValue;
}
