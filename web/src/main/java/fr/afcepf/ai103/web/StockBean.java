package fr.afcepf.ai103.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.DragDropEvent;

import fr.afcepf.ai103.data.Consommation;
import fr.afcepf.ai103.data.Produit;
import fr.afcepf.ai103.data.Stock;
import fr.afcepf.ai103.service.IServiceStock;


@ManagedBean
@SessionScoped
public class StockBean {
	
	

	private int id_prod;
	private int id_prod_stock;
	private String libelle_prod;
	private Produit produit;
	private Produit prodConsomme;

	private Stock stk;
	private Consommation cons;
	
	private List<Produit> produits;
	
	private List<Produit> prodConsommes;
	
	private List<Stock> stocks;
	
	//private List<Stock> stocksConsommer;
	
	private List<Stock> stockDrop = new ArrayList<Stock>();
	
//	private List<Consommation> consommations = new ArrayList<Consommation>();
	
	private List<Consommation> consoDrop = new ArrayList<Consommation>();
	
	

	@EJB
	private IServiceStock serviceStock;
	
	
	public StockBean() {
		
	}

	
	@PostConstruct
	public void listeLibeleProduit()
	{
		stocks = serviceStock.listeStockTotalByIdUtilisateur(1);
		
		
	}
	
	public void onCarDrop(DragDropEvent ddEvent) 
	{
        cons = ((Consommation) ddEvent.getData());
  
        consoDrop.add(cons);
       
    }
	
	//cette méthode permet de déplacer un produit de mon stock dans la liste stockDrop (jeter produit)
	public void deplacerProduit(DragDropEvent ddEvent) 
	{
         stk = ((Stock) ddEvent.getData());
  
        stockDrop.add(stk);
        stocks.remove(stk);
        consommerProduit(stk.getId_prod_stock());
        System.out.println("coucou consommé");        
       
    }
	
	//methode permet d'ajouter un produit dans la table consommation
	public void consommerProduit(Integer id_prod_stock)
	{
		serviceStock.consommerProduit(id_prod_stock, 2, new Date(), 1.0, 1);
	}
	
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public IServiceStock getServiceStock() {
		return serviceStock;
	}

	public void setServiceStock(IServiceStock serviceStock) {
		this.serviceStock = serviceStock;
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public int getId_prod_stock() {
		return id_prod_stock;
	}

	public void setId_prod_stock(int id_prod_stock) {
		this.id_prod_stock = id_prod_stock;
	}

	public String getLibelle_prod() {
		return libelle_prod;
	}

	public void setLibelle_prod(String libelle_prod) {
		this.libelle_prod = libelle_prod;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Produit getProdConsomme() {
		return prodConsomme;
	}



	public void setProdConsomme(Produit prodConsomme) {
		this.prodConsomme = prodConsomme;
	}



	public List<Produit> getProdConsommes() {
		return prodConsommes;
	}



	public void setProdConsommes(List<Produit> prodConsommes) {
		this.prodConsommes = prodConsommes;
	}



	public List<Consommation> getConsoDrop() {
		return consoDrop;
	}



	public void setConsoDrop(List<Consommation> consoDrop) {
		this.consoDrop = consoDrop;
	}



	public List<Stock> getStockDrop() {
		return stockDrop;
	}



	public void setStockDrop(List<Stock> stockDrop) {
		this.stockDrop = stockDrop;
	}



	public Stock getStk() {
		return stk;
	}



	public void setStk(Stock stk) {
		this.stk = stk;
	}


	public Consommation getCons() {
		return cons;
	}


	public void setCons(Consommation cons) {
		this.cons = cons;
	}


}