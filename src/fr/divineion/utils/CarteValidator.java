package fr.divineion.utils;

import fr.divineion.cartes.IllegalCardValueException;

public class CarteValidator {
	/**
	 * @param valeur
	 * @throws IllegalCardValueException
	 */
	public static void validateCardValueExists(int valeur) throws IllegalCardValueException {
		if (valeur < 1 || valeur > 13)
			throw new IllegalCardValueException("Vous êtes hors jeu vec la carte " + valeur + " !\n Les valeurs des cartes doivent être comprises entre 1 (As) et 13 (Roi)");
	}
}
