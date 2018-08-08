package fr.afcepf.ai103.dao;


import java.util.List;

import fr.afcepf.ai103.data.Consommation;

public interface IDaoConsommation {

public	List<Consommation> listeProduitConsommerByIdUtilisateur(int id_user);

public Consommation create(Consommation c);

}