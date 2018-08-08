package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Reponse;

public interface IDaoReponse {

public	List<Reponse> listeProduitDonnerByIdUtilisateur(int id_user);

}