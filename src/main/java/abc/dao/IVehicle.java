package abc.dao;

import java.util.List;
import abc.entities.Vehicle;

public interface IVehicle
{
	public List<Vehicle> get();
	
	public Vehicle getById(int pId);
	
	public String add(Vehicle pVehicle);
	
	public String update(Vehicle pVehicle);
	
	public String delete(Vehicle pProvider);
}
