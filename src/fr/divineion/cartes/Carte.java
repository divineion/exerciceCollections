package fr.divineion.cartes;

import java.util.Objects;

import fr.divineion.utils.CarteValidator;
/**
 * This class define each Card object in the application.
 * It represents a playing card with a value and a suit. 
 * The suit is represented by an enum called "Couleur" which can be accessed in other classes. 
 * 
 * The class provide methods to :
 *  - access and modify the card's attributes (value and suit);
 *  - compare cards for equality
 *  - represent the card as a formatted string
 *  - define duplicate cards (same value and same color)
 */
public class Carte {
	public enum Couleur {
		PIQUE, TREFLE, COEUR, CARREAU;
	}
	
	private int valeur;
	private Couleur couleur;

	/**
	 * @param valeur
	 * @param couleur
	 * @throws IllegalCardValueException
	 */
	public Carte(int valeur, Couleur couleur) throws IllegalCardValueException {
		CarteValidator.validateCardValueExists(valeur);
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}
	
	public String getValeurFormatee() {
		return switch (this.getValeur()) {
			case 1 -> "As";
			case 11 -> "Valet";
			case 12 -> "Dame";
			case 13 -> "Roi";
			default -> String.valueOf(this.getValeur());
		};
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	/**
	 * @param obj
	 * @return boolean
	 * 
	 * Prevents having duplicate in a Card Set.
	 * Returns : 
	 *  - true if this object and the obj argument are the same reference or have the same attributes; 
	 *  - false otherwise. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		return couleur.equals(other.couleur) && valeur == other.valeur;
	}
	
	/**
	 * @return int : the hashCode of the object, computed from the "couleur" and "valeur" attributes.
	 * 
	 * Ensure that two cards with the same "couleur" and "valeur" attributes values have the same hashCode. 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(couleur, valeur);
	}
	
	@Override
	public String toString() {
		return valeur + " de " + couleur;
	}
}
