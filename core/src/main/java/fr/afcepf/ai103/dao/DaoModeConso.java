package fr.afcepf.ai103.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.ModeConso;

@Stateless
@Local
public class DaoModeConso implements IDaoModeConso {
	
	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoModeConso() {
		
	}
    
    /* (non-Javadoc)
	 * @see fr.afcepf.ai103.dao.IDaoModeConso#getModeConsoById(java.lang.Integer)
	 */
    @Override
	public ModeConso getModeConsoById(Integer id)
	{
		return entityManager.createQuery("SELECT m FROM ModeConso m WHERE m.id_mode= :id", ModeConso.class)
		.setParameter("id", id)
		.getSingleResult();
	}
    
    

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
