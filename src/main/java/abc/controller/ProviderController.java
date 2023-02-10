package abc.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import abc.dao.IProvider;
import abc.entities.Provider;

public class ProviderController implements IProvider
{

	private EntityManager em;
	
	public ProviderController() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransportCompanyAbc");
		
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Provider> get() 
	{
		String sql = "SELECT l FROM Provider l";
		TypedQuery<Provider> tq = em.createQuery(sql, Provider.class);
		List<Provider> resultList = tq.getResultList();
		return resultList;
	}

	@Override
	public String add(Provider pVehicle) 
	{
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.persist(pVehicle);
			em.getTransaction().commit();
			
			rta = "Se registró exitosamente el proveedor";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error registrando el proveedor";
		}
		
		return rta;
	}

	@Override
	public String update(Provider pVehicle)
	{
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.merge(pVehicle);
			em.getTransaction().commit();
			
			rta = "Se actualizó exitosamente el proveedor";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error actualizando el proveedor";
		}
		
		return rta;
	}

	@Override
	public Provider getById(int pId) 
	{
		em.getTransaction().begin();
		Provider vehFound = em.find(Provider.class, pId);
		em.getTransaction().commit();
		
		return vehFound;
	}

	@Override
	public String delete(Provider pProvider) {
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.remove(pProvider);
			em.getTransaction().commit();
			
			rta = "Se eliminó exitosamente el proveedor";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error eliminando el proveedor";
		}
		
		return rta;
	}

}
