package abc.services;

import java.util.List;

import abc.controller.VehicleController;
import abc.dao.IVehicle;
import abc.entities.Vehicle;

public class VehicleService 
{
	IVehicle vehicleController;
	
	public VehicleService() 
	{
		vehicleController = new VehicleController();
	}
	
	public List<Vehicle> getAllVehicles()
	{
		return vehicleController.get();
	}
	
	public Vehicle getVehicleById(int pId)
	{
		return vehicleController.getById(pId);
	}
	
	public String createVehicle(Vehicle pVehicle)
	{
		return vehicleController.add(pVehicle);
	}
	
	public String updateVehicle(Vehicle pVehicle) 
	{
		return vehicleController.update(pVehicle);
	}
	
	public String deleteVehicle(Vehicle pVehicle) 
	{
		return vehicleController.delete(pVehicle);
	}
}
