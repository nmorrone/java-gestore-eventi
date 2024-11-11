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
		// inizializzo evento per fase successiva di verifica
		Evento nuovoEvento = null;
		try {
			System.out.println("Inserisci il titolo dell'Evento");
			String nomeEvento = scan.nextLine();

			System.out.println("Inserisci la data dell'evento nel formato dell'esempio\n(YYYY-MM-GG)(es: 2024-01-24");
			String dataEvento = scan.nextLine();

			System.out.println("Inserisci numeri posti disponibili per l'evento");
			int postiEvento = scan.nextInt();

			LocalDate dataJavaFormat = LocalDate.parse(dataEvento);

			nuovoEvento = new Evento(nomeEvento, dataJavaFormat, postiEvento);

		} catch (InputMismatchException e) {
			System.err.println("Input Sbagliato! Inserisci un numero intero >0 per i Posti Disponibili...");
		} catch (DateTimeParseException e) {
			System.err.println("Formato data inserita sbagliata, seguire le istruzione di inserimento!");
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}

		if (nuovoEvento != null) {
			System.out.println("Vuoi effettuare prenotazioni?\n digita il numero per scegliere\n1) Si!\n2) No!");
			int scelta = scan.nextInt();
			
			if (scelta == 1 && nuovoEvento.getPostiPrenotati() < nuovoEvento.getPostiDisponibili()) {
				System.out.println("Inserisci il numero di prenotazioni che vuoi effettuare");
				int numeroPrenotazioni = scan.nextInt();
				if(numeroPrenotazioni <= nuovoEvento.getPostiDisponibili()) {
					for (int i = 0; i < numeroPrenotazioni; i++) {
					nuovoEvento.prenota();
					}
					System.out.println("Prenotazioni Effettuate!\nPosti diponibili rimasti: "
					+ nuovoEvento.getPostiDisponibili() + "\nPosti prenotati: " + nuovoEvento.getPostiPrenotati());
				}
				
				else if (numeroPrenotazioni > nuovoEvento.getPostiDisponibili()) {
					
					System.out.println("Mi dispiace ma il numero di prenotazioni richiesto supera la disponibilità dell'evento!");
				}
				
				
			} 
			else if(scelta == 2){
				
				System.out.println("Ecco le info sul tuo Evento:\n" + nuovoEvento.infoEvento());
			}
			

		} else {
			System.out.println("Mi dispiace, ma non risulta presente nessun evento");
		}

		if (nuovoEvento.getPostiPrenotati() > 0) {
			System.out.println("Vuoi effettuare delle disdette?\n digita il numero per scegliere\n1) Si!\n2) No!");
			int scelta2 = scan.nextInt();
			switch (scelta2) {
			case 1:
				System.out.println("Inserisci il numero di disdette che vuoi effettuare");
				int numeroDisdette = scan.nextInt();
				for (int i = 0; i < numeroDisdette; i++) {
					nuovoEvento.disdici();
				}
				System.out.println("Disdette Effettuate!\nPosti diponibili rimasti: "
						+ nuovoEvento.getPostiDisponibili() + "\nPosti prenotati: " + nuovoEvento.getPostiPrenotati());
				break;
			case 2:
				System.out.println("Non hai voluto effettuare disdette.\nEcco le info sul tuo Evento:\n"
						+ nuovoEvento.infoEvento());
				break;
			}

		}

	}
	


}
