package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class User {

	private UUID id;
	private String name;
	private char gender;
	private int age;
	private List<Vehicle> vehicles;
	private List<Ride> sharedRides;
	private List<Ride> consumedRides;

	public User(String name, char gender, int age, UUID id) {
		this.name = name;
		this.gender = gender;
		this.age = age;
        this.vehicles = new ArrayList<>();
        this.consumedRides = new ArrayList<>();
        this.sharedRides = new ArrayList<>();
        this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Ride> getSharedRides() {
		return sharedRides;
	}

	public void setSharedRides(List<Ride> sharedRides) {
		this.sharedRides = sharedRides;
	}

	public List<Ride> getConsumedRides() {
		return consumedRides;
	}

	public void setConsumedRides(List<Ride> consumedRides) {
		this.consumedRides = consumedRides;
	}
	
    public void addConsumedRide(Ride ride)
    {
        consumedRides.add(ride);
    }
    public void addSharedRide(Ride ride)
    {
        sharedRides.add(ride);
    }
    
    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

}
