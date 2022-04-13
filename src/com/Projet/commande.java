package com.Projet;

public class commande {
	private int num_de_commande;
	private int idclient;
	private static String panier[] = {"","","","","",""};

	public int get_num_commande() {
		return num_de_commande ;
	}
	
	public int get_idclient() {
		return idclient ;
	}
	
		
	public String[] get_panier() {
		return panier ;
	}

		
		public static void ajouter_au_panier(String article, int nombre_darticle) {
			panier[nombre_darticle]= article;
			System.out.println("Dans le panier, il y a : ");
			for (int i = 0; i<nombre_darticle+1; i++)
			System.out.println(panier[i]);
		}
			
		
		public static boolean status_de_livraison(int numero_de_commande) {
			return livreur.notifier_client(numero_de_commande);
		
	}
		
		public static void main(String[] args) {
			ajouter_au_panier( "Huile d'olive vierge extra Nice 75 cl", 0 );
			ajouter_au_panier( "Perceuse", 1 );
			ajouter_au_panier( "Savon de Marseille", 2 );
			status_de_livraison(45);
			
			
		}

}
