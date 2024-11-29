package fr.divineion.cartes;

import java.util.InputMismatchException;
import java.util.Scanner;
import fr.divineion.cartes.Carte.Couleur;

public class TestPaquet {
	public static void main(String[] args) throws IllegalCardValueException {
		Paquet paquet = new Paquet();
		paquet.melanger();
		MainJoueur1 maMain = paquet.creerMain1();
		System.out.println("mon jeu " + maMain);
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Entrez une valeur de carte entre 1 (As) et 13 (Roi) :");
			try {
				int valeur = scanner.nextInt();
				System.out.print("Entrez une couleur de carte (\"pique\", \"coeur\", \"carreau\" ou \"trefle\") :");
			
				String couleurSaisie = scanner.next();
			
				Couleur couleur = Couleur.valueOf(couleurSaisie.toUpperCase());
				Carte carte = new Carte(valeur, couleur);
				if (maMain.contient(carte)) {
					System.out.println("La main contient la carte");
				} else
					System.out.println("La main ne contient pas la carte");
				} 
			catch(IllegalArgumentException e) {
				throw new IllegalCardValueException("Les couleurs admises sont \"pique\", \"coeur\", \"carreau\" et \"trefle\".");
			}
			catch(InputMismatchException e) {
				throw new IllegalCardValueException("La valeur saisie doit être un nombre entre 1 (As) et 13 (Roi)");
			}
		}	
	}
}