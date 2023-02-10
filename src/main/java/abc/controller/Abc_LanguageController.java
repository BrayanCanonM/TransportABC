package abc.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import abc.dao.IAbc_Language;
import abc.entities.Abc_Language;

public class Abc_LanguageController implements IAbc_Language
{

	private EntityManager em;
	
	public Abc_LanguageController() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TransportCompanyAbc");
		
		em = emf.createEntityManager();
	}
	
	@Override
	public List<Abc_Language> get() 
	{
		String sql = "SELECT l FROM Abc_Language l";
		TypedQuery<Abc_Language> tq = em.createQuery(sql, Abc_Language.class);
		List<Abc_Language> resultList = tq.getResultList();
		return resultList;
	}

}
