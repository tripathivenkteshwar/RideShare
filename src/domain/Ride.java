package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.RideStatus;

public class Ride {

	private UUID id;
	private String sharedBy;
	private List<String> selectedBy;
	private String origin;
	private String destination;
	private RideStatus status;
	private String vehicleNumber;
	private String vehicleModel;
	private int seats;
	
    public Ride(String sharedBy, String origin, String destination, int seats, String vehicleNumber, String vehicleModel) {
        this.sharedBy = sharedBy;
        this.selectedBy = new ArrayList<>();
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
        this.status=RideStatus.INPROGRESS;
        this.vehicleNumber=vehicleNumber;
        this.vehicleModel=vehicleModel;
        this.id = UUID.randomUUID();
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(String sharedBy) {
		this.sharedBy = sharedBy;
	}

	public List<String> getSelectedBy() {
		return selectedBy;
	}

	public void setSelectedBy(List<String> selectedBy) {
		this.selectedBy = selectedBy;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
    public void addPassenger(String passenger, int seats)
    {
        selectedBy.add(passenger);
        this.seats-=seats;
    }
    
    public void endRide()
    {
        this.status=RideStatus.END;
    }
	
    @Override
    public String toString() {
        return "Ride details:- Ride created by "+sharedBy;
    }

}
