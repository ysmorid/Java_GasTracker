/*
 * Ylia Moridzadeh
 * This class assigns, displays, increases and decreases the amount of gas
 * in a car.
 */

public class FuelGauge
{
   private final int maxFuel = 15;  //max tank capacity is 15 gallons
   private int fuel;                //stores amount of gas in car at any point

   /**
    * stores amount of gas in car
    * @param gas - gallons of gas in car
    */
   public void setFuel(int gas)
   {
      fuel = gas;
   }

   /**
    * Returns amount of gas in car to display
    * @return fuel - amount of gas currently in car
    */
   public int getFuel()
   {
      return fuel;
   }

   /**
    * increments fuel by 1 gallon until/unless tank is full.
    */
   public void incrementFuel()
   {
      while (fuel < maxFuel)
      {
         fuel++;
      }
   }

   /**
    * decrements fuel by 1 gallon until/unless tank is empty.
    */
   public void decrementFuel()
   {
      if(fuel != 0)
      {
      fuel--;
      }
   }
}
