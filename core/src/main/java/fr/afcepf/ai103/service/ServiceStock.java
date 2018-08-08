package fr.afcepf.ai103.service;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.DaoModeConso;
import fr.afcepf.ai103.dao.IDaoConsommation;
import fr.afcepf.ai103.dao.IDaoModeConso;
import fr.afcepf.ai103.dao.IDaoProduit;
import fr.afcepf.ai103.dao.IDaoReponse;
import fr.afcepf.ai103.dao.IDaoStock;
import fr.afcepf.ai103.data.Consommation;
import fr.afcepf.ai103.data.Stock;

@Stateless
@Local
public class ServiceStock implements IServiceStock 
{
	
	 @EJB
	 private IDaoStock daoStock;
	 
	 @EJB
	 private IDaoConsommation daoConsommation;
	 
	 @EJB
	 private IDaoProduit daoProduit;
	 
	 @EJB
	 private IDaoReponse daoReponse;
	 
	 @EJB
	 private IDaoModeConso daoModeConso;
	 
	 	 
	//methode permet de recouperer la liste de mon stock totale a partir d'un id utilisateur
	@Override
	public List<Stock> listeStockTotalByIdUtilisateur(int id_user) 
	{
		
		return daoStock.listeStockTotalByIdUtilisateur(id_user);
		
	}
	
	
	
			// méthode manger/jeter produit
		    // mode_consommation = 1 pour "manger" ; = 2 pour "jeter"
			@Override
			
			public void consommerProduit(Integer id_prod_stock, Integer id_mode, Date date, Double quantite, Integer id_user)
			{
				Consommation conso = new Consommation();
				conso.setDate_conso(date);
				conso.setStock(daoStock.getStockByIdStock(id_prod_stock));
				
				if (id_mode == 1)
				{
					
					conso.setModeConso(daoModeConso.getModeConsoById(id_mode));
					conso.setQte_conso(quantite);
				}
				else if (id_mode == 2)
				{
					Double quantiteInitiale = daoStock.getQuantiteById(id_prod_stock, id_user);
					conso.setModeConso(daoModeConso.getModeConsoById(id_mode));
					conso.setQte_conso(quantiteInitiale);
				}
				
				daoConsommation.create(conso);

			}
	

	
}
