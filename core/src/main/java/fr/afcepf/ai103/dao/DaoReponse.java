package fr.afcepf.ai103.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.Reponse;

@Stateless
@Local
public class DaoReponse implements IDaoReponse {

	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoReponse() {
		
	}
    
	
	@Override
	public List<Reponse> listeProduitDonnerByIdUtilisateur(int id_user){
		  
		return entityManager.createQuery("select rep from Reponse rep where  rep.utilisateur.id_user = :id_user", Reponse.class)
				.setParameter("id_user", id_user)
				.getResultList();
	}
    

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
