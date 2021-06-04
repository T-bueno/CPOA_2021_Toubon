package com.iut.as2021.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisie {
	
	/**
	 * Saisie d'un entier
	 * On boucle tant que la saisie n'est pas un nombre entier
	 * 
	 * @return l'enter saisi
	 */
	public static int saisieEntier() {
		
		return saisieEntier("Saisir un entier : ");
	}
	
	/**
	 * Saisie d'un entier, aprÃ¨s affichage d'un message d'invite
	 * On boucle tant que la saisie n'est pas un nombre entier
	 * 
	 * @param msg le message Ã  afficher avant la saisie
	 * @return l'entier saisi
	 */
	public static int saisieEntier(String msg) {
		
		boolean ok;
		int res = 0;
		do {
			ok = true;
			System.out.print(msg);
			try {
				@SuppressWarnings("resource")
				Scanner clavier = new Scanner(System.in);
				res = clavier.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println("Vous devez saisir un entier !");
				ok = false;
			}
		} while (!ok);
		
		return res;
	}
	
	/**
	 * Saisie d'une chaÃ®ne de caractÃ¨res
	 * 
	 * @return la chaÃ®ne saisie
	 */
	public static String saisieChaine() {
		
		return saisieChaine("Saisir une chaine : ");
	}

	/**
	 * Saisie d'une chaÃ®ne de caractÃ¨res, aprÃ¨s affichage d'un message d'invite
	 * 	 
	 * @param msg le message Ã  afficher avant la saisie
	 * @return la chaÃ®ne saisie
	 */
	public static String saisieChaine(String msg) {
		
		System.out.println(msg);
		
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);
		String ch = clavier.nextLine();
		
		return ch;
	}

	/**
	 * Saisie d'une chaÃ®ne qui doit Ãªtre en majuscules
	 * 
	 * @return la chaine saisie
	 */
	public static String saisieChaineMajuscules() {
		
		String ch;
		do {
			ch = saisieChaine();
		} while (!ch.equals(ch.toUpperCase()));
	
		return ch;
	}
	
	/**
	 * Saisie d'une chaÃ®ne qui doit Ãªtre alphabÃ©tique
	 * 
	 * @return la chaÃ®ne saisie
	 */
	public static String saisieChaineAlphabetique() {
		
		String ch;
		do {
			ch = saisieChaine();
		} while (!estAlphabetique(ch));
	
		return ch;
	}
	
	/**
	 * Saisie d'un tableau d'entiers
	 * 
	 * @param capacite la taille du tableau
	 * @return le tableau saisi
	 */
	public static int[] saisieTableauEntiers(int capacite) {
		
		int tab[] = new int[capacite];
		
		for (int i=0; i < capacite; i++) {
		
			tab[i] = saisieEntier("Saisir l'Ã©lÃ©ment " + i + " : ");
		}
		
		return tab;
	}


	/**
	 * Test permettant de savoir si une chaÃ®ne est composÃ©e uniquement de caractÃ¨res
	 * 
	 * @param ch la chaÃ®ne Ã  tester
	 * @return vrai si la chaÃ®ne n'est composÃ©e que de caractÃ¨res, faux sinon
	 */
	private static boolean estAlphabetique(String ch) {

        boolean ok = true;
        int i = 0;
        while (ok && i < ch.length()) {
            ok = Character.isAlphabetic(ch.charAt(i));
            i++;
        }

        return ok;
    }

}
