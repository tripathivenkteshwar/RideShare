package domain;

import java.util.UUID;

public class Vehicle {

	private String vehicleNumber;
	private String vehicleModel;
	private String userName;
	private UUID id;

    public Vehicle(String userName, String vehicleModel, String vehicleNumber, UUID id) {
    	this.id = id;
        this.userName = userName;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
    }
    
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModel() {
		return vehicleModel;
	}

	public void setModel(String model) {
		this.vehicleModel = model;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
