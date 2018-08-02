package fr.afcepf.ai103.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.Stock;
import fr.afcepf.ai103.data.Utilisateur;

@Stateless
@Local
public class DaoStock implements IDaoStock {
	
	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoStock() {
		
	}

	@Override
	
	//avec le createQuery
	public List<Stock> listeDeMonStock(int id_user) {
		//requet pour récuperer la liste de mon stock alimentaires 
		String maListeProduits = "select ut, st, pr, sca, ca, unt,consr, conso, an, rep"        
															+ "FROM utilisateur ut"
															+ "INNER JOIN Stock st"
															+ "INNER JOIN produit pr"
															+ "INNER JOIN sous_categorie sca"
															+ "INNER JOIN categorie ca"
															+ "INNER JOIN unite unt"
															+ "INNER JOIN conservation consr"
															+ "INNER JOIN consommation conso"
															+ "INNER JOIN annonce an"
															+ "INNER JOIN reponse rep"
				                  + "where ut.id_user = :id_user "
				                  + "and co.id_conso = :id_conso"
				                  + "and rep.date_transaction = date_transaction";
		
		return entityManager.createQuery(maListeProduits, Stock.class)
				.setParameter("id_user", id_user)
				.setParameter("id_conso", null)
				.setParameter("date_transaction", null)
				.getResultList();
	}

	/*public List<Stock> listeDeMonStock(int id_user) {
		return entityManager.createNamedQuery("Stock.parIdUser", Stock.class )
				.setParameter("id_user", id_user)
				.getResultList();
		
	}*/
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
