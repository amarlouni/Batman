package fr.afcepf.ai103.service;

import java.util.Date;
import java.util.List;

import fr.afcepf.ai103.data.Stock;

public interface IServiceStock {

public	List<Stock> listeStockTotalByIdUtilisateur(int id_user);


public void consommerProduit(Integer id_prod_stock, Integer id_mode, Date date, Double quantite, Integer id_user);


}