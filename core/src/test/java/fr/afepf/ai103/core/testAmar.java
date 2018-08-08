package fr.afepf.ai103.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import org.junit.Test;



import fr.afcepf.ai103.dao.DaoConsommation;
import fr.afcepf.ai103.dao.DaoProduit;
import fr.afcepf.ai103.dao.DaoReponse;
import fr.afcepf.ai103.dao.DaoStock;

import fr.afcepf.ai103.data.Consommation;
import fr.afcepf.ai103.data.Evaluation;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.data.Reponse;
import fr.afcepf.ai103.data.Stock;
import fr.afcepf.ai103.data.Utilisateur;


public class testAmar 
{
	//@Test
	public void monStockTest()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("core");
		
		
		DaoStock daoStock = new DaoStock();
		
		daoStock.setEntityManager(emf.createEntityManager());
		daoStock.getEntityManager().getTransaction().begin();
		
		
		DaoProduit daoProduit = new DaoProduit();
		
		daoProduit.setEntityManager(emf.createEntityManager());
		daoProduit.getEntityManager().getTransaction().begin();
		
		DaoConsommation daoConsommation = new DaoConsommation();
		
		daoConsommation.setEntityManager(emf.createEntityManager());
		daoConsommation.getEntityManager().getTransaction().begin();
		
		
		DaoReponse daoReponse = new DaoReponse();
		
		daoReponse.setEntityManager(emf.createEntityManager());
		daoReponse.getEntityManager().getTransaction().begin();
		
		
		
		
		
		//la liste de consommation pour un utilisateur 1
		List<Stock> stocks = daoStock.listeStockTotalByIdUtilisateur(1);
		//List<Produit> produits = daoStock.listeProduitByIdUtilisateur(1);
		List<Consommation> consommations = daoConsommation.listeProduitConsommerByIdUtilisateur(1);
		
		List<Reponse> reponses = daoReponse.listeProduitDonnerByIdUtilisateur(1);
		
		//for(Stock stock : stocks) 
		//{
		List<Integer> idConsommations = new ArrayList<Integer>();
		Integer idConso;
		
		List<Integer> idReponses = new ArrayList<Integer>();
		Integer idRep;
		
			
					for(Consommation conso : consommations) 
					{
						
					    idConso = conso.getStock().getId_prod_stock(); 
						idConsommations.add(idConso);
						//System.out.println("consommation : " + idConso);
						
					}
					
					
					for(Reponse rep : reponses)
					{
						if(rep.getDate_transaction() != null)
						{
							idRep = rep.getAnnonce().getStock().getId_prod_stock();
							//idReponses.add(idRep);
							idConsommations.add(idRep);
							//System.out.println("reponse : " + idRep);
						}
						else {
							idRep = null;
							System.out.println("ya rien ");
						}
						
					}
					
					System.out.println("maliste : " + idConsommations);
					
					Integer id = null ;
					
					
					/*for(Stock stock : stocks)
					{
						
						if(idConsommations.get(stock.getId_prod_stock()) == null)
						{
						
						System.out.println("id2 : " + stock.getId_prod_stock());
						}
						
						else
						{
							System.out.println("cooucou");
						}
					}*/
					
					for(Integer idConsommation : idConsommations)
					{
						
						for(Stock stock : stocks)
						{
							if(idConsommation != stock.getId_prod_stock());
							//System.out.println("aaaaa : " + stock.getId_prod_stock());
							
						}
						
						
					}
					
					
				
					
					
					
		
		//}
		
		
		
		
		
		
		
		//List<Produit> produits = daoProduit.listeProduitByIdUtilisateur(1);
		//List<Utilisateur> utilisateurs = daoUtilisateur.listeDetailsUserByIdUtilisateur(1);
		//List<Evaluation> evaluations = daoUtilisateur.evaluationUserByIdUtilisateur(1);
	/*	Integer idConso=null	;
		Integer idRep=null;
		Date dateTrransaction;
		
		for(Stock stock : stocks) 
		{
			
			
					for(Consommation conso : consommations) 
					{
						
						 idConso = conso.getStock().getId_prod_stock(); 
						
					}
					
					for(Reponse rep : reponses) 
					{
						
						if(rep.getDate_transaction() != null)
						{
						 idRep = rep.getAnnonce().getStock().getId_prod_stock();
							
						}
						
					}	
					
							if(idConso != stock.getId_prod_stock()  && idRep != stock.getId_prod_stock()) 
							{
								
								System.out.println("mon stock :  " + stock.getId_prod_stock());
						
							}
			
			
		
		
			}*/
		}
	
	
	public Integer identifiant()
	{
		List<Integer> idConsommations = new ArrayList<Integer>();
		Integer id = null ;
		
		for(Integer idConsommation : idConsommations)
		{
			id = idConsommation;
			//System.out.println("id1 : " + id);
			
		}
		
		return id;
	}
	
}
			
		
		
		
		
		
		
	

