package abc.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import abc.entities.Provider;
import abc.services.ProviderService;

@ManagedBean(name = "providerBean")
@ViewScoped
public class ProviderBean {

	private int idProvider;
	private String providerName;
	private String address;
	private String email;
	private int numVehicles;
	
	private Provider selectedProvider;
	
	ProviderService service = new ProviderService();
	
	private List<Provider> providersList = new ArrayList<Provider>();
	
	public ProviderBean() {
		
		this.providersList = service.getAllProviders();
	}
	
	
	
	
	public int getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumVehicles() {
		return numVehicles;
	}
	public void setNumVehicles(int numVehicles) {
		this.numVehicles = numVehicles;
	}
	
	public List<Provider> getProvidersList() {
		return providersList;
	}
	public void setProvidersList(List<Provider> providersList) 
	{
		this.providersList = service.getAllProviders();
	}
	public Provider getSelectedProvider() {
		return selectedProvider;
	}
	public void setSelectedProvider(Provider selectedProvider) {
		this.selectedProvider = selectedProvider;
	}
	
	public void openNew() 
	{
		this.selectedProvider = new Provider();
	}
	
	public void saveProvider() {
		if(this.selectedProvider.getAddress()!=null)
		{
			service.createProvider(selectedProvider);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor agregado con éxito (RELOAD PAGE)"));
		}
		
		PrimeFaces.current().executeScript("PF('manageProviderDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-provider");
	}
	
	public void updateProvider() {
		if(this.selectedProvider.getAddress()!=null)
		{
			service.update(selectedProvider);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor actualizado con éxito"));
		}
		
		PrimeFaces.current().executeScript("PF('manageProviderDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-provider");
	}
	
	public void deleteProvider() {
		if(this.selectedProvider.getAddress()!=null)
		{
			service.delete(selectedProvider);
			this.selectedProvider = null;
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proveedor Removido (RELOAD PAGE)"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-provider");
		}
	}
	
}
