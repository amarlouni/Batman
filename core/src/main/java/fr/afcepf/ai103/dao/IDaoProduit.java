package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Produit;

public interface IDaoProduit {

public	List<Produit> listeProduitByIdUtilisateur(int id_user);

}