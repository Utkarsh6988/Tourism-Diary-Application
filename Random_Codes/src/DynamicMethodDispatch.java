

//Base class
class Vehicle {
 void start() {
     System.out.println("Vehicle is starting");
 }
 
 void stop() {
     System.out.println("Vehicle is stopping");
 }
}

//Subclass 1
class Car extends Vehicle {
 @Override
 void start() {
     System.out.println("Car starts with ignition");
 }
 
 void honk() {
     System.out.println("Car honks: Beep Beep!");
 }
}

//Subclass 2
class Bike extends Vehicle {
 @Override
 void start() {
     System.out.println("Bike starts with kick");
 }
 
 void ringBell() {
     System.out.println("Bike rings bell: Ting Ting!");
 }
}

//Subclass 3
class ElectricScooter extends Vehicle {
 @Override
 void start() {
     System.out.println("Scooter starts with button press");
 }
 
 void showBattery() {
     System.out.println("Battery level: 80%");
 }
}

public class DynamicMethodDispatch {
 public static void main(String[] args) {
     Vehicle myVehicle;
     
     // Dynamic dispatch - actual object type determines method called
     myVehicle = new Car();
     myVehicle.start();  
     myVehicle.stop();   
     // myVehicle.honk(); // Error - can't access Car-specific method
     
     myVehicle = new Bike();
     myVehicle.start();  
     
     myVehicle = new ElectricScooter();
     myVehicle.start(); 
     
     // Array of different vehicles demonstrating polymorphism
     Vehicle[] garage = {new Car(), new Bike(), new ElectricScooter()};
     
     System.out.println("\nStarting all vehicles:");
     for (Vehicle v : garage) {
         v.start();  // Calls appropriate version for each vehicle
     }
 }
}