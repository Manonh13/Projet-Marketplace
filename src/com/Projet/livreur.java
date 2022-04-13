package com.Projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class livreur {

	private int id_livreur;
	private String nom_livreur;
	public static Scanner sc = new Scanner(System.in);
	
	public int get_id() {
		return id_livreur ;
	}
	
	public String get_nom() {
		return nom_livreur ;
	}
	
	
	public static void creer_compte() {
		System.out.print("Entrez votre nouvel identifiant");
		//Scanner scan = new Scanner (System.in);
		String identifiant = sc.nextLine();
		System.out.print("Entrez votre nouveau mot de passe");
		String motdepasse = sc.nextLine();
		ecrire(identifiant,motdepasse);
		//sc.close();
	}
	
	
	public static void ecrire (String identifiant, String motdepasse){
		try{
			FileWriter fw=new FileWriter("h:\\Desktop\\compte_livreur.csv",true);
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
		   System.out.print("Entrez votre identifiant");
		   String identifiant = sc.nextLine();
		   System.out.print("Entrez votre mot de passe");
		   String motdepasse = sc.nextLine();
		   try{
			   FileReader fr=new FileReader("h:\\Desktop\\compte_livreur.csv");
			   BufferedReader br= new BufferedReader(fr);
			   while (br.ready())
				  line = br.readLine();
			      if ((identifiant+motdepasse).equals(line)) {
			       System.out.print("Identification r�ussie");
			   } else {
			       System.out.print("Erreur.R�essayer.");
			   }	
			   br.close();
			   }
		   catch (Exception e)
		   {System.out.println("Erreur "+e);
		   }
		   //scan.close();
	}
	
	
		public static void afficher_commande_�_livrer() {
		if (client.payer_la_commande()==true) 
			System.out.println("La commande est � livrer");
		else {
			System.out.println("La commande n'a pas encore �t� pay�e.");
		}
		}
		
		
	public static boolean notifier_client(int numero_de_commande) {
		boolean commande_livr�e = false;
		System.out.println("La commande num�ro " + numero_de_commande + " est-elle livr�e ? (O/N)");
		//Scanner sc ;
		//sc = new Scanner(System.in);
		String r�ponse = sc.nextLine();
		sc.close();
		if (r�ponse.equals("O"))
			{commande_livr�e = true;
			System.out.println("Commande livr�e !");
			}	
		System.out.println("Commande en cours de livraison");
		return commande_livr�e;
	}
	
	public static void main (String[] args) {
		creer_compte();
		s_identifier();
		afficher_commande_�_livrer();
		notifier_client(12);
		}

}