package fr.divineion.cartes;

import java.util.ArrayList;
import java.util.Collections;

import fr.divineion.cartes.Carte.Couleur;

public class Paquet {
	private ArrayList<Carte> paquetComplet = new ArrayList<Carte>();
	
	public Paquet() throws IllegalCardValueException {
		for (int i = 1; i <= 13; i++) {
			for (Couleur couleur : Carte.Couleur.values()) {
				Carte carte = new Carte(i, couleur);
				paquetComplet.add(carte);
			}
		}
	}
	
	public ArrayList<Carte> getPaquetComplet() {
		return paquetComplet;
	}
	
	public void melanger() {
		Collections.shuffle(paquetComplet);
	}
	
	public String toString() {
		return paquetComplet.toString();
	}
	
	public MainJoueur1 creerMain1() {
		MainJoueur1 main = new MainJoueur1();
		for (int i = 0; i<5 ; i++) {
			main.add(paquetComplet.get(i));
		}
		return main;	
	}
}
