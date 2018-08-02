package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Stock;
import fr.afcepf.ai103.data.Utilisateur;

public interface IDaoStock 
{
public List<Stock> listeDeMonStock(int id_user);
}
