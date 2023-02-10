package abc.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import abc.dao.IDriver;
import abc.entities.Driver;

public class DriverController implements IDriver
{

	private EntityManager em;
	
	public DriverController() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransportCompanyAbc");
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Driver> get() 
	{
		String sql = "SELECT l FROM Driver l";
		TypedQuery<Driver> tq = em.createQuery(sql, Driver.class);
		List<Driver> resultList = tq.getResultList();
		return resultList;
	}

}
