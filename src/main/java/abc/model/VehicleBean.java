package abc.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import abc.entities.Driver;
import abc.entities.Vehicle;
import abc.services.DriverService;
import abc.services.VehicleService;

@ManagedBean(name = "vehicleBean")
@ViewScoped
public class VehicleBean 
{
	private Vehicle selectedVehicle;
	
	private Driver selectedDriver;
	
	VehicleService service = new VehicleService();
	DriverService serviceDriver = new DriverService();
	private List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
	
	private List<Driver> driversList = new ArrayList<Driver>();
	
	private int idVehicle;
	private String vehiclePlate;
	private String brandName;
	private String model;
	private Driver idDriver;
	private String state;
	
	
	public VehicleBean() {
		
		this.vehiclesList = service.getAllVehicles();
		this.driversList  = serviceDriver.getAllDrivers();
	}
	
	public int getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
	public String getVehiclePlate() {
		return vehiclePlate;
	}
	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Driver getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(Driver idDriver) {
		this.idDriver = idDriver;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	public List<Vehicle> getVehiclesList() {
		return vehiclesList;
	}
	public void setVehiclesList() 
	{
		this.vehiclesList = service.getAllVehicles();
	}
	public Vehicle getSelectedVehicle() {
		return selectedVehicle;
	}
	public void setSelectedVehicle(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}
	
	public List<Driver> getDriversList() {
		return driversList;
	}

	public void setDriversList(List<Driver> driversList) {
		this.driversList = driversList;
	}
	
	public Driver getSelectedDriver() {
		return selectedDriver;
	}

	public void setSelectedDriver(Driver selectedDriver) {
		this.selectedDriver = selectedDriver;
	}

	
	
	
	public void openNew() 
	{
		this.selectedVehicle = new Vehicle();
		this.selectedDriver = new Driver();
	}
	
	public void saveVehicle() {
		if(this.selectedVehicle.getBrandName()!=null)
		{
			//selectedVehicle.setIdDriver(selectedDriver);
			service.createVehicle(selectedVehicle);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vehículo agregado con éxito (RELOAD PAGE)"));
		}
		
		//selectedDriver = null;
		this.vehiclesList = service.getAllVehicles();
		PrimeFaces.current().executeScript("PF('manageVehicleDialog').hide()");
        PrimeFaces.current().ajax().update("formVeh:messages", "formVeh:dt-vehicle");
	}
	
	public void updateVehicle() {
		if(this.selectedVehicle.getBrandName()!=null)
		{
			//selectedVehicle.setIdDriver(selectedDriver);
			service.updateVehicle(selectedVehicle);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vehículo actualizado con éxito "));
		}
		
		//selectedDriver = null;
		this.vehiclesList = service.getAllVehicles();
		PrimeFaces.current().executeScript("PF('manageVehicleDialog').hide()");
        PrimeFaces.current().ajax().update("formVeh:messages", "formVeh:dt-vehicle");
	}
	
	public void deleteVehicle() {
		if(this.selectedVehicle.getBrandName()!=null)
		{
			service.deleteVehicle(selectedVehicle);
			this.selectedVehicle = null;
			this.selectedDriver = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vehículo Removido con éxito (RELOAD PAGE)"));
	        PrimeFaces.current().ajax().update("formVeh:messages", "formVeh:dt-vehicle");
		}
	}
	
	
	
}
