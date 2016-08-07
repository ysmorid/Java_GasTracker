/*
 * Ylia Moridzadeh
 * 11/25/13
 * Assignment 9 - creates objects using FuelGauge and Odometer classes to
 * simulate a car being filled with gas, driving until the tank is full, then
 * reporting the levels of gas and miles driven.
 */

import java.io.*;          //import for file writer
import java.util.Scanner;  //import for scanning user input

public class DriveMain
{
   public static void main(String[] args) throws IOException
   {
      int userInput = 1;       //stores user input
      String userReply;    //stores user input as string

      //scanner object to read user input
      Scanner keyboard = new Scanner(System.in);
      //new Odometer object
      Odometer miles = new Odometer();

      //Displays current mileage, amount of gas and simulates driving until
      //user exits program.
      do
      {
         StatementOutput("Your current mileage is: " + miles.getMileage() + ".");
         StatementOutput("You currently have " + miles.getFuelGauge().getFuel() +
            " gallons in your car.");
         if(miles.getFuelGauge().getFuel() == 0)
         {
            StatementOutput("Would you like to fill up your gas tank?");
            do
            {
               StatementOutput("Enter 1 for yes and 0 for no.");
               userInput = keyboard.nextInt();
               userReply = Integer.toString(userInput);
               StatementOutput(userReply);
                  if(userInput < 0 || userInput > 1)
                  {
                     StatementOutput("I'm sorry. That is an invalid response.");
                  }
            }
            while (userInput < 0 || userInput > 1);
            if(userInput == 1)
            {
               miles.getFuelGauge().incrementFuel();
               StatementOutput("You now have " + miles.getFuelGauge().getFuel() +
                  " gallons in your car.");
               StatementOutput("Simulating driving.");
               miles.decreaseGasByMiles();
            }
            else
            {
               StatementOutput("Have a nice day!");
            }
         }
      }
      while (userInput != 0);
   }

   //Displays all statements, user input and duplicates data into an output file
   public static void StatementOutput(String sentence) throws IOException
   {
      //Create an output file to store user data and results
      FileWriter Assignment9Output = new FileWriter("C:\\Users\\Devi\\Google " +
         "Drive\\School\\Computer Science\\Homework\\Assignment9\\" +
         "Assignment9 Output.txt", true);
      PrintWriter outputFile = new PrintWriter(Assignment9Output);

      //Displays system message as well as sending to output file
      System.out.println(sentence);
      outputFile.println(sentence);

      outputFile.close();
   }
}
