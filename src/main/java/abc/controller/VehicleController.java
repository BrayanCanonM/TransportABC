package abc.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import abc.dao.IVehicle;
import abc.entities.Vehicle;

public class VehicleController implements IVehicle
{

	private EntityManager em;
	
	public VehicleController() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransportCompanyAbc");
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Vehicle> get() 
	{
		String sql = "SELECT l FROM Vehicle l";
		TypedQuery<Vehicle> tq = em.createQuery(sql, Vehicle.class);
		List<Vehicle> resultList = tq.getResultList();
		return resultList;
	}

	@Override
	public String add(Vehicle pVehicle) 
	{
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.persist(pVehicle);
			em.getTransaction().commit();
			
			rta = "Se registró exitosamente el vehículo";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error registrando el vehículo";
		}
		
		return rta;
	}

	@Override
	public String update(Vehicle pVehicle)
	{
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.merge(pVehicle);
			em.getTransaction().commit();
			
			rta = "Se actualizó exitosamente el vehículo";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error actualizando el vehículo";
		}
		
		return rta;
	}

	@Override
	public Vehicle getById(int pId) 
	{
		em.getTransaction().begin();
		Vehicle vehFound = em.find(Vehicle.class, pId);
		em.getTransaction().commit();
		
		return vehFound;
	}
	
	@Override
	public String delete(Vehicle pVehicle)
	{
		String rta = "";
		try 
		{
			em.getTransaction().begin();
			em.remove(pVehicle);
			em.getTransaction().commit();
			
			rta = "Se eliminó exitosamente el vehículo";
			return rta;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			rta = "Ocurrió un error eliminando el vehículo";
		}
		
		return rta;
	}

}
