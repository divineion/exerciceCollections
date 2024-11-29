package fr.divineion.cartes;

import java.util.HashSet;
/**
 * The class MainJoueur1 represents a player's hand picked from a deck. 
 * It provides methods to add cards to the hand and check if the hand contains a given card.  
 * 
 * An object MainJoueur1 is instantiated in the creerMain1() method in the class Paquet. 
 * 
 */
public class MainJoueur1 {
	private HashSet<Carte> main;
		
	public MainJoueur1() {
		this.main = new HashSet<Carte>();
	}
	
	public boolean add(Carte carte) {
		return this.main.add(carte);
	}
	
	public boolean contient(Carte carte) {
		return this.main.contains(carte);
	}

	public String toString() {	
		return main.toString();
	}
}
