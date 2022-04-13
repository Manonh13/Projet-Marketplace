package com.Projet;

public class produit {
	    
 	private static int id ;
	private String nom;
	private String vendeur;
	private double prix;
	private String statut;
	

	
	public produit (int idBase, String nomBase, String vendeurBase, double prixBase, String statutBase) {
		id = idBase;
		nom = nomBase;
		vendeur= vendeurBase;
		prix=prixBase;
		statut=statutBase;
		}

	public static int get_id() {
		return id ;
	}
	
	public String get_nom() {
		return nom ;
	}
	
	public String get_vendeur() {
		return vendeur ;
	}
	public double get_prix() {
		return prix ;
	}
	public String get_statut() {
		return statut ;
	}
	
	public static void main(String[] args) {
		id=17;
		System.out.println(get_id());
		produit nouveauProduit ; 
		nouveauProduit = new produit(id, "Perceuse nouvelle génération", "Leroy Merlin", 54, "externe");
		System.out.println(nouveauProduit.nom );
		
	}




}
