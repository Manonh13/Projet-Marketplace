package com.Projet;

import java.util.Scanner;
// Import the File class
// Import the IOException class to handle errors
import java.io.*;

public class vendeur {
	private int id;
	private  String status;
	private  String name;
	public static Scanner sc = new Scanner(System.in);


	public vendeur (int id, String status, String name) {
		this.id = id;
		this.status = status;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getName() {
		return name;
	}

	public void set_id(int id) {
		this.id=id;
	}
	
	public void set_status (String status) {
		this.status=status;
	}
	
	public void set_name(String name) {
		this.name=name;
	}
	
	
	public static void creer_compte() {
		System.out.print("Entrez votre nouvel identifiant");
		//Scanner scan = new Scanner (System.in);
		String identifiant = sc.nextLine();
		System.out.print("Entrez votre nouveau mot de passe");
		String motdepasse = sc.nextLine();
		ecrire(identifiant,motdepasse);
		//scan.close();
	}
	
	
	public static void ecrire (String identifiant, String motdepasse){
		try{
			FileWriter fw=new FileWriter("h:\\Desktop\\compte_vendeur.csv",true);
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
			   FileReader fr=new FileReader("h:\\Desktop\\compte_vendeur.csv");
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
	

	public static void ajouter_produit() {
		//Scanner sc ;
		//sc = new Scanner(System.in);
		System.out.print("Entrez l'id du produit");
		int id = sc.nextInt();
		System.out.print("Entrez le nom du produit");
		String nom = sc.nextLine();
		System.out.print("Entrez le vendeur");
		String vendeur =sc.nextLine();
		System.out.print("Entrez le prix");
		int prix = sc.nextInt();
		System.out.print("Entrez le statut du produit");
		String statut =sc.nextLine();
		//sc.close();
		/*produit nouveauProduit ;
		nouveauProduit = new produit(id, nom, vendeur, prix,statut); */
		try{
		FileWriter fw=new FileWriter("h:\\..\\produits.csv",true);
		BufferedWriter bw= new BufferedWriter(fw);
		bw.newLine();
		bw.write(id+","+nom+","+vendeur+","+prix+","+statut);
		bw.close();
		}
		catch (Exception e){
		System.out.println("Erreur "+e);
		}
		}
	
	
	
	public static void modifier_produit() {
		String productID = new String();
		String line = new String();
		Scanner sc ;
		sc = new Scanner(System.in);
		System.out.print("Entrez l'id du produit");
		String id = sc.nextLine();
		  try{
		  FileReader fr=new FileReader("h:\\Desktop\\produits.csv");
		  BufferedReader br= new BufferedReader(fr);
		  while (br.ready())
		  line=br.readLine();
	      String[] columns = line.split("/t");
	      productID = columns[0];
		     if ((productID).equals(id)) {
		 		System.out.print("Entrez le nom du produit");
		 		String nom = sc.nextLine();
		 		System.out.print("Entrez le vendeur");
		 		String vendeur =sc.nextLine();
		 		System.out.print("Entrez le prix");
		 		int prix = sc.nextInt();
		 		System.out.print("Entrez le statut du produit");
		 		String statut =sc.nextLine();
		 		sc.close();
		 		FileWriter fw=new FileWriter("h:\\Desktop\\produits.csv",true);
				BufferedWriter bw= new BufferedWriter(fw);
				bw.newLine();
				bw.write(id+","+nom+","+vendeur+","+prix+","+statut);
				bw.close();
		  }
		  br.close();
		  }
		catch (Exception e){
		System.out.println("Erreur "+e);
		}
		}
	
	
	public static void supprimer_produit() {
		  Scanner sc ;
		  //String productID = new String();
		  String line = new String();
		sc = new Scanner(System.in);
		System.out.print("Entrez l'id du produit");
		String id = sc.nextLine();
		sc.close();
		  try{
		  FileReader fr=new FileReader("h:\\Desktop\\produits.csv");
		  BufferedReader br= new BufferedReader(fr);
		  while (br.ready())
			  line=br.readLine();
		      //String[] columns = line.split("/t");
		      //productID = columns[1];
		     if ((line).equals(id)) {
		      FileWriter fw=new FileWriter("h:\\Desktop\\produits.csv");
		      BufferedWriter bw= new BufferedWriter(fw);
		      bw.write(""+""+""+""+"");
		      bw.close();
		  }
		  br.close();
		  }
		  catch (Exception e)
		  {System.out.println("Erreur "+e);
		  }
		  System.out.println("Produit supprimé");
		  //sc.close();
		}
	
	
	public static void suivre_ventes()
	{	
		try{
			  FileReader fr=new FileReader("h:\\Desktop\\vente.csv");
			  BufferedReader br= new BufferedReader(fr);
			  while (br.ready())
				  System.out.println(br.readLine());
			  br.close();
	}
		catch (Exception e)
		  {System.out.println("Erreur "+e);
		  }
	
}
	public static void main (String[] args) {
	creer_compte();
	s_identifier();
	supprimer_produit();
	suivre_ventes();
	}
}
