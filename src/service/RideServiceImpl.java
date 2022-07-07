package service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import domain.Ride;
import domain.User;
import domain.Vehicle;
import exceptions.InvalidVehicle;
import exceptions.VehicleAlreadyExists;
import exceptions.RideNotFound;
import repository.RideManager;
import repository.UserManager;
import util.SelectionStrategyType;

public class RideServiceImpl implements RideService {

	private UserManager userManager;
	private RideManager rideManager;
	
	public RideServiceImpl(UserManager userManager, RideManager rideManager) {
		this.userManager = userManager;
		this.rideManager = rideManager;
	}

	
	@Override
	public void offer_ride(String userName, String origin, int availableSeats, String vehicleModel,
			String vehicleNumber, String destination) {
        try
        {
            Ride newRide= new Ride(userName, origin, destination, availableSeats, vehicleNumber,vehicleModel );
            User user=userManager.getUser(userName);

            if(!valiadteVehicle(user, vehicleNumber, vehicleModel))
                throw new InvalidVehicle();

            rideManager.addOfferRide(newRide,user.getName());
            //user.addSharedRide(newRide);
            System.out.println("Ride offered by "+userName+" from "+origin+" to "+destination+". Available Seats "+
                    availableSeats+" vehicle "+vehicleModel+ " vehicleNumber "+vehicleNumber);
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
		
	}

	@Override
	public Ride select_ride(String userName, String origin, String destination, int seats,
			SelectionStrategyType strategy, String vehicle) {
        
		Ride bestRide=null;
        
        try{
        	bestRide = findRide(origin, destination, seats, vehicle, strategy);
        	
            if(bestRide!=null)
            {
                bestRide.addPassenger(userName, seats);
                rideManager.updateRide(bestRide);
            }
            else
                throw new RideNotFound();
            System.out.println(bestRide.toString());
            
        }catch(RuntimeException e)
        {
            System.out.println(e);
        }
        return bestRide;
	}

	@Override
	public void end_ride(String userName, String origin, int availableSeats, String vehicleModel, 
			String vehicleNumber, String destination) {
        Ride ride=rideManager.endRide(vehicleNumber);
        ride.endRide();
        
        rideManager.updateRide(ride);
        
        String sharedBy=ride.getSharedBy();
        List<String> passengers=ride.getSelectedBy();
        
        User user=userManager.getUser(sharedBy);
        user.addSharedRide(ride);
        
        for(String pessenger: passengers)
        {
            user=userManager.getUser(pessenger);
            user.addConsumedRide(ride);
            userManager.updateUser(user);
        }
		
	}

	@Override
	public void print_ride_status() {
        Collection<User> users=userManager.getUsers();
        users.forEach((user) -> {
            System.out.println(user.getName()+": "+user.getConsumedRides().size()+" Taken "+user.getSharedRides().size()+" Offered");
        });
		
	}

	public boolean valiadteVehicle(User user, String vehicleNumber, String vehicleModel) {
        boolean flag=false;
        
        if (user.getVehicles().isEmpty()) {
        	return flag;
        } else {
        	for (Vehicle vehicleDetails: user.getVehicles()) {
        		if (vehicleDetails.getVehicleNumber().equalsIgnoreCase(vehicleNumber) && vehicleDetails.getModel().equalsIgnoreCase(vehicleModel)) {
        			return true;
        		}
        	} 
        }
        return flag;
	}
	
	public Ride findRide(String origin, String destination, int seats, String vehicle, SelectionStrategyType strategy) {
		
		Map<UUID, Ride> activeRides=rideManager.getActiveRides();
		
        Ride bestRide=null;
        int maxAvailabilty=0;
        for(Ride rideDetails: activeRides.values()) {
        	if(rideDetails.getDestination().equals(destination) && rideDetails.getOrigin().equals(origin) && rideDetails.getSeats()>=seats) {
        		
                if(strategy.equals(SelectionStrategyType.MOST_VACANT) && rideDetails.getSeats()>maxAvailabilty)
                {
                    maxAvailabilty=rideDetails.getSeats();
                    bestRide=rideDetails;
                }
                
                if(strategy.equals(SelectionStrategyType.PREFFERED) && rideDetails.getVehicleModel().equals(vehicle))
                {
                    bestRide=rideDetails;
                    return bestRide;
                }
        	}
        	
        }
        return bestRide;
	}
}
