package service;

import domain.Ride;
import util.SelectionStrategyType;

public interface RideService {

    public void offer_ride(String userName,String origin, int availableSeats, String vehicleModel ,String vehicleNumber, String destination);
    
    public Ride select_ride(String userName,String origin, String destination, int seats, SelectionStrategyType strategy, String vehicle);
    
    public void end_ride(String userName,String origin, int availableSeats, String vehicleModel ,String vehicleNumber, String destination);
    
    public void print_ride_status();
}
