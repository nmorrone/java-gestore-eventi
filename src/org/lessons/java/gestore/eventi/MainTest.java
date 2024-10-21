package org.lessons.java.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {

	/*
	 * Step-2 faccio istanziare un evento all'utente tramite Console e Scanner
	 */

	public static void main(String[] args) {
		System.out.println("Benvenuto in Console\n" + "Cominciamo con l'inserimento dell'Evento");
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Inserisci il titolo dell'Evento");
			String nomeEvento = scan.nextLine();

			System.out.println("Inserisci la data dell'evento nel formato dell'esempio\n(YYYY-MM-GG)(es: 2024-01-24");
			String dataEvento = scan.nextLine();

			System.out.println("Inserisci numeri posti disponibili per l'evento");
			int postiEvento = scan.nextInt();

			LocalDate dataJavaFormat = LocalDate.parse(dataEvento);

			Evento nuovoEvento = new Evento(nomeEvento, dataJavaFormat, postiEvento);
			System.out.println("Ecco il tuo Evento\n" + nuovoEvento.infoEvento());

		} catch (InputMismatchException e) {
			System.err.println("Input Sbagliato! Inserisci un numero intero >0 per i Posti Disponibili...");
		} catch (DateTimeParseException e) {
			System.err.println("Formato data inserita sbagliata, seguire le istruzione di inserimento!");
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
		finally {
			scan.close();
		}

		System.out.println("Vuoi effettuare prenotazioni?\n digita il numero per scegliere\n1) si!\n2) no!");

	}

}
