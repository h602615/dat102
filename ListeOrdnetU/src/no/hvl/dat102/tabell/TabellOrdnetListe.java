package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste();
		bak--;
		liste[bak] = null;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste();

		for (int i = 0; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		liste[bak] = null;
		bak--;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		return resultat = liste[bak - 1];
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (bak == liste.length) {
			utvid();
		}

		int i = 0;
		while (i < antall() && element.compareTo(liste[i]) > 0) {
			i++;
		}
		for (int k = bak + 1; k > i; k--) {
			liste[k] = liste[k - 1];
		}
		liste[i] = element;
		bak++;

	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int i = finn(element);

		if (i <0) {
			for (int k = i; k < bak - 1; k++) {
				liste[k] = liste[k + 1];
			}
			bak--;
			liste[bak] = null;
			return element;
		}
		return null;
	}

	private int finn(T el) {
		if (erTom()) {
			throw new EmptyCollectionException("Ordnet liste");
		}
		for (int i = 0; i < bak; i++) {
			if (liste[i].equals(el)) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
