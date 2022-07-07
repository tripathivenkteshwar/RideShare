package controller;

import domain.Ride;
import repository.RideManager;
import repository.UserManager;
import service.RideServiceImpl;
import service.UserServiceImpl;
import service.VehicleServiceImpl;
import util.SelectionStrategyType;

public class RideController {

	private RideServiceImpl rideService;


	public RideController(RideServiceImpl rideService) {
		this.rideService = rideService;
	}
	
	public void offerRide(String userName, String origin, int availableSeats, String vehicleModel,
			String vehicleNumber, String destination) {
		
		this.rideService.offer_ride(userName, origin, 
				availableSeats, vehicleModel, vehicleNumber, destination);
	}
	
	public Ride selectRide(String userName, String origin, String destination, int seats,
			SelectionStrategyType strategy, String vehicle) {
		
		return this.rideService.select_ride(userName, origin,
				destination, seats, strategy, vehicle);
	}
	
	public void endRide(String userName, String origin, int availableSeats, String vehicleModel,
			String vehicleNumber, String destination) {
		
		this.rideService.end_ride(userName, origin, availableSeats, 
				vehicleModel, vehicleNumber, destination);
	}
	
	public void printRideStats() {
		this.rideService.print_ride_status();
	}
}
