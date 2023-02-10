package abc.services;

import java.util.List;

import abc.controller.DriverController;
import abc.dao.IDriver;
import abc.entities.Driver;

public class DriverService 
{
	IDriver driverController;
	public DriverService() 
	{
		driverController = new DriverController();
	}
	
	public List<Driver> getAllDrivers()
	{
		return driverController.get();
	}
}
