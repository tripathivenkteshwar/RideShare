package service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.User;
import domain.Vehicle;
import exceptions.VehicleAlreadyExists;
import repository.UserManager;

public class VehicleServiceImpl implements VehicleService {

	private UserManager userManager;
	
	public VehicleServiceImpl(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void add_vehicle(String userName, String model, String vehicleNumber) {

		UUID id = UUID.randomUUID();
        try{
            Vehicle vehicle = new Vehicle(userName, model, vehicleNumber, id);
            User user= userManager.getUser(userName);
            if (!user.getVehicles().isEmpty()) {
            	for (Vehicle vehicleDetails: user.getVehicles()) {
            		if (vehicleDetails.getVehicleNumber().equalsIgnoreCase(vehicleNumber) && vehicleDetails.getModel().equalsIgnoreCase(model)) {
            			throw new VehicleAlreadyExists();
            		}
            	}
            	
                userManager.getUser(userName).addVehicle(vehicle);
            } else {
                userManager.getUser(userName).addVehicle(vehicle);
            }
                      
            System.out.println("Vehicle "+vehicleNumber+" for user "+userName+" added");
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }

	}

}
