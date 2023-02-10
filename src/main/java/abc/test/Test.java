package abc.test;

import abc.dao.IProvider;
import abc.dao.IVehicle;
import abc.controller.Abc_LanguageController;
import abc.controller.DriverController;
import abc.controller.ProviderController;
import abc.controller.VehicleController;
import abc.dao.IAbc_Language;
import abc.dao.IDriver;
import abc.entities.Driver;
import abc.entities.Provider;
import abc.entities.Vehicle;
import abc.model.State;
import antlr.collections.List;

public class Test 
{
	public static void main(String[] args)
	{
		IProvider p = new ProviderController();
//		Provider prov = new Provider();
//		prov.setEmail("example@gmail.com");
//		prov.setAddress("Direction Generic");
//		prov.setNumVehicles(50);
//		prov.setProviderName("MAIN PROVIDER");
		
		IVehicle veh = new VehicleController();
		IDriver iDriv = new DriverController();
		
//		Vehicle newVehicle = new Vehicle();
//		newVehicle.setVehiclePlate("MNO-121");
//		newVehicle.setBrandName("Audi");
//		newVehicle.setModel("R8");
//		
//		newVehicle.setIdDriver(iDriv.get().get(0));
//		newVehicle.setState(State.ACTIVO.name());
		
//		Provider prov = new Provider();
//		prov.setProviderName("Proveedor A");
//		prov.setAddress("Dirección Genérica");
//		prov.setEmail("Prov@gmail.com");
//		prov.setNumVehicles(50);
//		
		
		
//		Vehicle x = veh.getById(6);
//		x.setBrandName("Audi");
		
		Provider pr = p.getById(1);
		pr.setProviderName("Proveedor A2");
		System.out.println(p.update(pr));
	}
}
