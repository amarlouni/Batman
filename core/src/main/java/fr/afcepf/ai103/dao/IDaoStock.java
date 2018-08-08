package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Stock;

public interface IDaoStock 
{

public List<Stock> listeStockTotalByIdUtilisateur(int id_user);

public Stock getStockByIdStock(Integer id);

public Double getQuantiteById(Integer id_prod_stock, Integer id_user);




}
