package fr.afcepf.ai103.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai103.data.Consommation;

@Stateless
@Local
public class DaoConsommation implements IDaoConsommation {

	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoConsommation() {
		
	}
    
    @Override
	public List<Consommation> listeProduitConsommerByIdUtilisateur(int id_user) {
		
		return entityManager.createQuery("select conso from Consommation conso where conso.stock.utilisateur.id_user = :id_user ", Consommation.class )
				.setParameter("id_user", id_user)
				.getResultList();
		}
    
    
 // methode create pour "manger" / "jeter" (cf methode consommerProduitStock de StockService.java
 	// mode_consommation = 1 pour "manger" ; = 2 pour "jeter"
    @Override
	public Consommation create(Consommation c)
	{
		entityManager.persist(c);
		return c;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
