// Lab03v100.java
// Student starting version of the Lab03 assignment.
// Resave this program as Lab03v80 for the 80 point version.
// Resave this program as Lab03v100 for the 100 point version.


public class Lab03v100
{
    public static void main(String args[])
    {
        int startMilli;
        startMilli = 10000123;
        
        System.out.println("Lab03, 100 Point Version\n");
        System.out.println("Starting milli-seconds:  " + startMilli); 
        System.out.println("Hours:                   " + (startMilli / 3600000));
        int HoursRemainMilli = (startMilli % 3600000);
        System.out.println("Minutes:                 " + HoursRemainMilli / 60000);
        int MinutesRemainMilli = (HoursRemainMilli % 60000);
        System.out.println("Seconds:                 " + MinutesRemainMilli / 1000);
        System.out.println("Milli Seconds:           " + MinutesRemainMilli % 1000);


    }


}
