package fr.afcepf.ai103.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.Produit;


@Stateless
@Local
public class DaoProduit implements IDaoProduit {

	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoProduit() {
		
	}
    
 
	@Override
	public List<Produit> listeProduitByIdUtilisateur(int id_user) {
		
		return entityManager.createQuery("select pr from Stock st, Produit pr where pr.id_prod = st.produit.id_prod and st.utilisateur.id_user = :id_user" , Produit.class )
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

