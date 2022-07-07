package controller;

import domain.User;
import domain.Vehicle;
import exceptions.UserNotFound;
import repository.RideManager;
import repository.UserManager;
import service.RideServiceImpl;
import service.UserServiceImpl;
import service.VehicleServiceImpl;

public class RegistrationController {

	private UserServiceImpl userService;
	private VehicleServiceImpl vehicleService;


	public RegistrationController(UserServiceImpl userService, VehicleServiceImpl vehicleService) {
		this.userService = userService;
		this.vehicleService = vehicleService;
	}

	public void registerUser(String name, char gender, int age) {
		this.userService.add_user(name,gender,age);
    }
    
    public void registerVehicle(String userName, String model, String vehicleNumber) {

    	this.vehicleService.add_vehicle(userName, model, vehicleNumber);
    }
}
