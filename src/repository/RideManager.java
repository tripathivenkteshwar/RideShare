package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import domain.Ride;
import exceptions.RideAlreadyExists;

public class RideManager {

    private Map<UUID,Ride> activeRides;

    public RideManager() {
        this.activeRides=new HashMap<>();
    }

    public Map<UUID,Ride> getActiveRides() {
        return activeRides;
    }
    
    public void addOfferRide(Ride ride, String userName)
    {
        for(Ride rideDetails: activeRides.values())
        {
            if(rideDetails.getVehicleNumber().equals(ride.getVehicleNumber()))
                throw new RideAlreadyExists("Ride already exist for vehicle : " + rideDetails.getVehicleNumber()+ " model : " + rideDetails.getVehicleModel());
        }
        activeRides.put(ride.getId(), ride);
    }
    
    public Ride endRide(String vehicleNumber)
    {
        for(Ride rideDetails: activeRides.values())
        {
            if(rideDetails.getVehicleNumber().equals(vehicleNumber))
                return rideDetails;
        }
        return null;
    }
    
    public void updateRide(Ride ride) {
        this.activeRides.put(ride.getId(), ride);
    }
    
}
