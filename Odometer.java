/*
 * Ylia Moridzadeh
 * This class keeps track of and displays the car's mileage at any point, as
 * well as resetting the odometer to 0 after hitting 99,999 miles
 */

public class Odometer
{
   private final int maxMileage = 999999; //max # of miles accepted on odometer
   private final int milesPerGallon = 24; //amount of miles driven per gallon gas
   private int miles;                   //amount of miles on odometer

   //creates new FuelGauge object
   FuelGauge gas = new FuelGauge();

   //initializing constructor setting starting amount of miles on car
   public Odometer()
   {
      miles = 999504;
   }

   /**
    * stores the amount of miles on the odometer
    * @param mileage - current amount of miles on car
    */
   public void setMileage(int mileage)
   {
      miles = mileage;
   }

   /**
    * returns the current amount of miles on odometer
    * @return miles - current mileage on odometer to be displayed
    */
   public int getMileage()
   {
      return miles;
   }

   /**
    * @return gas - current amount of gas in car
    */
   public FuelGauge getFuelGauge()
   {
      return gas;
   }


   /**
    * increases odometer by 1 mile until reaches maxMileage, then resets
    * odometer to 0 and begins counting from there.
    */
   public void incrementMiles()
   {
      if(miles == maxMileage)
      {
         miles = 0;
      }
      else
      {
         miles++;
      }
   }

   /**
    * decreases gas by 1 mile for every 24 miles driven.
    */
   public void decreaseGasByMiles()
   {
      do
      {
         for(int i = 0; i < milesPerGallon; i++)
         {
            incrementMiles();
         }
         gas.decrementFuel();
      }
      while(gas.getFuel() > 0);
   }
}
