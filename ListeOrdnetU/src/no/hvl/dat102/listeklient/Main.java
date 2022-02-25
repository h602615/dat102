package no.hvl.dat102.listeklient;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class Main {

	public static void main(String[] args) {

		OrdnetListeADT<Person> Kjedetlist = new KjedetOrdnetListe<>();
		OrdnetListeADT<Person> list = new TabellOrdnetListe<>();

//		Person s1 = new Person(showInputDialog("fornavn:"), null, 0);


		Scanner scanner = new Scanner(System.in);
		System.out.print("antall personer: ");
		int antall = scanner.nextInt();
		int i = 0;
		while (i < antall) {

			System.out.println("fornavn: ");String fornavn = scanner.next();
			System.out.print("etternavn: ");String etternavn = scanner.next();
			System.out.print("fødselsår: ");int fødselsår = scanner.nextInt();
			
			Person person = new Person(fornavn, etternavn, fødselsår);
			Kjedetlist.leggTil(person);
			list.leggTil(person);i++;
			
		}
		scanner.close();
		
		
		System.out.println(Kjedetlist.toString());
		System.out.println(list);

	}
}
