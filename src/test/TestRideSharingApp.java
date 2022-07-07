package test;

import controller.RegistrationController;
import controller.RideController;
import domain.Ride;
import repository.RideManager;
import repository.UserManager;
import service.RideServiceImpl;
import service.UserServiceImpl;
import service.VehicleServiceImpl;
import util.SelectionStrategyType;

public class TestRideSharingApp {


    public static void main(String[] args) {
    	RideManager rideManager = new RideManager();
    	UserManager userManager = new UserManager();
    	
    	RideServiceImpl rideServiceImpl = new RideServiceImpl(userManager, rideManager);
    	UserServiceImpl userServiceImpl = new UserServiceImpl(userManager);
    	VehicleServiceImpl VehicleServiceImpl = new VehicleServiceImpl(userManager);
    	
    	RegistrationController registrationController = 
    			new RegistrationController(userServiceImpl, VehicleServiceImpl);
    	
    	RideController rideController = new RideController(rideServiceImpl);
    	
    	registrationController.registerUser("Rohan", 'M', 36);
    	VehicleServiceImpl.add_vehicle("Rohan", "Swift", "KA-01-12345");
    	
    	registrationController.registerUser("Shashank", 'M', 29);
    	registrationController.registerVehicle("Shashank", "Baleno", "TS-05-62395");
        
    	registrationController.registerUser("Nandini", 'F', 29);
        
    	registrationController.registerUser("Shipra", 'F', 27);
    	registrationController.registerVehicle("Shipra", "Polo", "KA-05-41491");
    	registrationController.registerVehicle("Shipra", "Activa", "KA-12-12332");
        
        registrationController.registerUser("Gaurav", 'M', 29);
        
        registrationController.registerUser("Rahul", 'M', 35);
        registrationController.registerVehicle("Rahul", "XUV", "KA-05-1234");
        
        
        
        rideController.offerRide("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");
        rideController.offerRide("Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore");
        rideController.offerRide("Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        rideController.offerRide("Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");
        rideController.offerRide("Rahul", "Hyderabad", 5, "XUV", "KA-05-1234", "Bangalore");
        rideController.offerRide("Rohan", "Bangalore", 1, "Swift", "KA-01-12345", "Pune");
        
        rideController.selectRide("Nandini", "Bangalore", "Mysore", 1, SelectionStrategyType.MOST_VACANT, "None");
        rideController.selectRide("Gaurav", "Bangalore", "Mysore", 1, SelectionStrategyType.PREFFERED, "Activa");
        rideController.selectRide("Rohan", "Mumbai", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Baleno");
        rideController.selectRide("Rohan", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Baleno");
        rideController.selectRide("Shashank", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFFERED, "Polo");
        
        
        rideController.endRide("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");
        rideController.endRide("Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore");
        rideController.endRide("Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        rideController.endRide("Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");
        rideController.printRideStats();
    	
    }
}