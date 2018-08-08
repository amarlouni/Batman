package fr.afcepf.ai103.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.Stock;


@Stateless
@Local
public class DaoStock implements IDaoStock {
	
	
	
	
	@PersistenceContext(unitName="core")
	public EntityManager entityManager;
	
    public DaoStock() {
		
	}

	
    @Override
	public List<Stock> listeStockTotalByIdUtilisateur(int id_user) {
		
		return entityManager.createQuery("select st from Stock st where st.utilisateur.id_user = :id_user ", Stock.class)
				.setParameter("id_user", id_user)
				.getResultList();
		
	}


    @Override
	public Stock getStockByIdStock(Integer id)
	{
		return entityManager.createQuery("SELECT s FROM Stock s WHERE s.id_prod_stock= :id", Stock.class)
		.setParameter("id", id)
		.getSingleResult();
	}
    
    
    @Override
	public Double getQuantiteById(Integer id_prod_stock, Integer id_user) {
		Stock prod = entityManager.createQuery("SELECT s FROM Stock s WHERE s.id_prod_stock = :id_prod_stock",Stock.class)
		.setParameter("id_prod_stock", id_prod_stock)
		.getSingleResult();
		return prod.getQte_initiale();
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


}
