package com.Projet;

public class contrat {
	
	    private final int id;
	    private final int duration;
	    private final float marketplaceFee;
	    private final int vendeur; 

	    public contrat (int id, int duration, float marketplaceFee, int vendeur) {
	        this.id = id;
	        this.duration = duration;
	        this.marketplaceFee = marketplaceFee;
	        this.vendeur=vendeur; }

	    public int getId() {
	        return id;
	    }

	    public int getDuration() {
	        return duration;
	    }

	    public float getMarketplaceFee() {
	        return marketplaceFee;
	    }

	    public int getVendeur() {
	        return vendeur;
	    }
	    
	 
	}


