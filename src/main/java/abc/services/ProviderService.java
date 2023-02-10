package abc.services;

import java.util.List;

import abc.controller.ProviderController;
import abc.dao.IProvider;
import abc.entities.Provider;

public class ProviderService 
{
	IProvider providerController;
	
	public ProviderService() {
		providerController = new ProviderController();
	}
	
	public List<Provider> getAllProviders()
	{
		return providerController.get();
	}
	
	public Provider getProviderById(int pId) 
	{
		return providerController.getById(pId);
	}
	
	public String createProvider(Provider pProvider) 
	{
		return providerController.add(pProvider);
	}
	
	public String update(Provider pProvider) 
	{
		return providerController.update(pProvider);
	}
	
	public String delete(Provider pProvider) 
	{
		return providerController.delete(pProvider);
	}
}
