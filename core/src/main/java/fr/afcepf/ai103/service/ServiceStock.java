package fr.afcepf.ai103.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.IDaoStock;
import fr.afcepf.ai103.data.Stock;

@Stateless
@Local
public class ServiceStock 
{

 @EJB
 private IDaoStock daoStock;
 
 public List<Stock> listeStockParIdUser(int id_user){
	 
	 return daoStock.listeDeMonStock(id_user);
 }
	
}
