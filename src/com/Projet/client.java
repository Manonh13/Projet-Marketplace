	package com.Projet;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class client {
	
	private static int numero_de_client ;
	private String adresse_de_facturation ;
	private String adresse_de_livraison ;
	private String statut ;
	public static Scanner sc = new Scanner(System.in);
	
	public String get_adresse_livraison() {
		return adresse_de_livraison ;
	}
	
	public String get_adresse_facturation() {
		return adresse_de_facturation;
	}
	
	public int get_numero() {
		return numero_de_client ;
	}
	
	public String get_statut() {
		return statut ;
	}
	
	
	public static void creer_compte() {
		System.out.print("Entrez votre nouvel identifiant");
		//Scanner scan = new Scanner (System.in);
		String identifiant = sc.nextLine();
		System.out.print("Entrez votre nouveau mot de passe");
		String motdepasse = sc.nextLine();
		Ecrire(identifiant,motdepasse);
		//scan.close();
	}
	
	
	public static void Ecrire (String identifiant, String motdepasse){
		try{
			FileWriter fw=new FileWriter("h:\\Desktop\\compte_client.csv",true);
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
		  // Scanner scan = new Scanner (System.in);
		   System.out.print("Entrez votre identifiant");
		   String identifiant = sc.nextLine();
		   System.out.print("Entrez votre mot de passe");
		   String motdepasse = sc.nextLine();
		   try{
			   FileReader fr=new FileReader("h:\\Desktop\\compte_client.csv");
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
	
	
	public static void consulter_produit(){
		  //String productNom = new String();
		  String line = new String();
		  //Scanner sc ;
		//sc = new Scanner(System.in);
		System.out.print("Entrez le nom du produit");
		String nom = sc.nextLine();
		//sc.close();
		  try{
		  FileReader fr=new FileReader("h:\\Desktop\\produits.csv");
		  BufferedReader br= new BufferedReader(fr);
		  while (br.ready())
		  line=br.readLine();
	      //String[] columns = line.split("/t");
	      //productNom = columns[1];
		     if ((line).equals(nom)) {
		      System.out.print(line);
		  } else {
		      System.out.print("Le produit recherché n'existe pas.");
		  }
		  br.close();
		  }
		  catch (Exception e)
		  {System.out.println("Erreur "+e);
		  }
		  //sc.close();
		}
	
	
	public static void ajouter_au_panier(String produit ) {
		consulter_produit();
		System.out.println("Voulez-vous ajouter au panier ? (O/N)");
		//Scanner sc ;
		//sc = new Scanner(System.in);
		String réponse= sc.nextLine();
		//sc.close();
		if (réponse.equals("O"))
			System.out.println("Produit ajouté au panier");
	}

	public static void optimisation_panier(int nombre_darticles) {  
		int[] prix = new int[nombre_darticles -1];
		Arrays.sort(prix);
		System.out.println(Arrays.toString(prix));
	}
	
	
	public static boolean valider_la_commande() {
		boolean validation = false;
		//Scanner sc ;
		//sc = new Scanner(System.in);
		System.out.println("Souhaitez vous valider la commande ? (O/N)");
		String réponse = sc.nextLine();		
		//sc.close();
			if (réponse.equals("O"))
				{validation = true; 
				System.out.println("Commande validée ! Merci ");}
				return validation;

			
	}
	
	public static boolean payer_la_commande() {
		boolean commandepayee = false;
		//Scanner sc ;
		//sc = new Scanner(System.in);
		System.out.println("Entrez votre numéro de carte");
		int numero_bancaire = sc.nextInt();
		//sc.close();
		if (numero_bancaire !=0)
			{commandepayee = true;
			System.out.println("Commande payée ! Merci ");}
		return commandepayee;
		
	}
	
	public static void suivre_le_colis(int numero_de_commande) {
		if (commande.status_de_livraison(numero_de_commande))
			System.out.println("Colis livré");
		else 
			System.out.println("En cours de livraison");
		
		}
	
	
	

	public static void main(String[] args) {
		creer_compte();
		s_identifier();
		consulter_produit();
		ajouter_au_panier("Perceuse percussion premium");
		optimisation_panier(3);
		valider_la_commande();
		payer_la_commande();
		suivre_le_colis(32);}
		


	
	
	
}