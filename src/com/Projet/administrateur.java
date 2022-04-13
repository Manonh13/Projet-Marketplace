package com.Projet;

import java.io.*;
import java.util.Scanner;

public class administrateur {
	
	private static int id ;
	private String nom ; 
	public static Scanner sc = new Scanner(System.in);
	
	
	public String get_nom ()
	{
		return nom;
	}
	
	
	public int get_id() {
		return id;
	}
	
	public void set_nom (String nom)
	{
		this.nom=nom;
	}
	
		
	public static void creer_compte() {
		System.out.print("\n Entrez votre nouvel identifiant");
		//Scanner scan = new Scanner (System.in);
		String identifiant = sc.nextLine();
		System.out.print("Entrez votre nouveau mot de passe");
		String motdepasse = sc.nextLine();
		ecrire(identifiant,motdepasse);
		
	}
	
	
	public static void ecrire (String identifiant, String motdepasse){
		try{
			FileWriter fw=new FileWriter("h:\\Desktop\\compte_administrateur.csv",true);
			BufferedWriter bw= new BufferedWriter(fw);
			bw.newLine();
			bw.write(identifiant+motdepasse);
			bw.close();
			}
		catch (Exception e){ 
			System.out.println("Erreur "+e);
			}
	
	}
	
	
	public static void s_identifier(){
		   String line = new String();
		   //Scanner scan = new Scanner (System.in);
		   System.out.print("\n Entrez votre identifiant");
		   String identifiant = sc.nextLine();
		   System.out.print("Entrez votre mot de passe");
		   String motdepasse = sc.nextLine();
		   try{
			   FileReader fr=new FileReader("h:\\Desktop\\compte_administrateur.csv");
			   BufferedReader br= new BufferedReader(fr);
			   while (br.ready())
				  line = br.readLine();
			      if ((identifiant+motdepasse).equals(line)) {
			       System.out.print("Identification réussie");
			   } else {
			       System.out.print("Erreur.Réessayer.");
			   }	
			   br.close();
			   }
		   catch (Exception e)
		   {System.out.println("Erreur "+e);
		   }
		   //scan.close();
	}
		
		
	public static contrat ajouter_vendeur() {
		//Scanner sc ;
		//sc = new Scanner(System.in);
		
		System.out.println("\n Entrer l'id du vendeur");
		int idVendeur = sc.nextInt();
		System.out.println("Entrer l'id du contract");
		int idContrat = sc.nextInt();
		System.out.println("Entrer la durée");
		int durée=sc.nextInt();
		System.out.println("Entrer la commission");
		float commission=sc.nextFloat();
		contrat nouveauContrat;
		nouveauContrat = new contrat(idContrat, durée, commission, idVendeur);
		return nouveauContrat;
			}
	
	
	public static void ajouter_produit() {
		//Scanner sc ;
		//sc = new Scanner(System.in);
		System.out.print("Entrez le nom du produit");
		String nom = sc.nextLine();
		System.out.print(" \n Entrez le statut du produit");
		String statut =sc.nextLine();
		System.out.print(" Entrez le vendeur");
		String vendeur =sc.nextLine();
		System.out.print("Entrez l'id du produit");
		int id = sc.nextInt();
		System.out.print("Entrez le prix");
		int prix = sc.nextInt();
		//sc.close();
		produit nouveauProduit ;
		nouveauProduit = new produit(id, nom, vendeur, prix,statut);
		System.out.println(nouveauProduit);
		try{
		FileWriter fw=new FileWriter("h:\\Desktop\\produit.csv",true);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.newLine();
		bw.write(id+","+nom+","+vendeur+","+prix+","+statut);
		bw.close();
		}
		catch (Exception e){
		System.out.println("Erreur "+e);
		}
		}
	
	
	public static void afficher_chiffre_affaires() {
		float CA=0;
		 String line = new String();
		   try {
			   FileReader fr=new FileReader("h:\\Desktop\\vente.csv");
			   BufferedReader br= new BufferedReader(fr);
			   while (br.ready()) {
				   line = br.readLine();
				   float commission = Float.valueOf(line);
			       CA=CA+commission;
			   }	
			   br.close();
			   }
		   catch (Exception e)
		   {System.out.println("Erreur "+e);
		   }
	}
		
		
	public static boolean expedier_commande(int validation){
		boolean prete_à_livrer = false;
		if (validation == 1)
			prete_à_livrer = true;
		return prete_à_livrer;
		
	}
	

	
	public static void main (String[] args) {
		creer_compte();
		s_identifier();
		ajouter_vendeur();
		ajouter_produit();
		expedier_commande(0);
			
	} 
	
	
	

}
