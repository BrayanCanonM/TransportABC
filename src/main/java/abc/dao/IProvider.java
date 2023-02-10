package abc.dao;

import java.util.List;

import abc.entities.Provider;

public interface IProvider 
{
	public List<Provider> get();
	
	public Provider getById(int pId);
	
	public String add(Provider pProvider);
	
	public String update(Provider pProvider);
	
	public String delete(Provider pProvider);
}
