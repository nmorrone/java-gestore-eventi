package org.lessons.java.gestore.eventi;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int postiDisponibili;
	private int postiPrenotati;

	// costruttore con parametri
	Evento(String t, LocalDate d, int p) {

		try {
			if ((d == LocalDate.now() || d.isAfter(LocalDate.now())) && (p > 0)) {
				this.titolo = t;
				this.data = d;
				this.postiDisponibili = p;
				this.postiPrenotati = 0;
			}

			// lancio eccezione
			else if (d.isBefore(LocalDate.now())){
				System.err.println("Errore inserimento evento!");
				throw new IllegalStateException("è stata inserita una data già passata");
			}
			
			else {
				System.err.println("Errore inserimento evento");
				throw new IllegalStateException("Impossibile creare un Evento, i posti devono essere > di 0");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// Metodo per prenotazione posti con controllo data e posti
	public void prenota() {

		int tentativoPrenotazione = postiPrenotati + 1;

		if ((this.data == LocalDate.now() || this.data.isAfter(LocalDate.now()))
				&& (tentativoPrenotazione <= postiDisponibili)) {

			this.postiPrenotati = tentativoPrenotazione;
			this.postiDisponibili = postiDisponibili - postiPrenotati;
			System.out.println("Prenotazione effettuata \nPosti Prenotati :" + getPostiPrenotati()
					+ "\nPosti Ancora Dispomibili; " + getPostiDisponibili());
		}

		else if (this.data.isBefore(LocalDate.now())) {
			System.out.println(
					"Impossibile effettuare prenotazioni, l'Evento " + String.valueOf(getTitolo()) + " è gia passato!");
		}

		else {
			System.out.println("Impossibile effettuare prenotazione, i posti disponibili per "
					+ String.valueOf(getTitolo()) + " sono terminati!");

		}

	}

	// Metodo per disdetta posti con controllo data e posti
	public void disdici() {

		int tentativoDisdetta = postiPrenotati - 1;

		if ((this.data == LocalDate.now() || this.data.isAfter(LocalDate.now())) && (tentativoDisdetta >= 0)) {

			this.postiPrenotati = tentativoDisdetta;
			this.postiDisponibili = postiDisponibili - postiPrenotati;
			System.out.println("Disdetta effettuata \nPosti Prenotati :" + getPostiPrenotati()
					+ "\nPosti Ancora Dispomibili; " + getPostiDisponibili());
		}

		else if (this.data.isBefore(LocalDate.now())) {
			System.out.println(
					"Impossibile effettuare disdette, l'Evento " + String.valueOf(getTitolo()) + " è gia passato!");
		}

		else {
			System.out.println(
					"Impossibile completare disdetta, non ci sono prenotazione per " + String.valueOf(getTitolo()));

		}

	}

	// metodi setter e getter
	public int getPostiDisponibili() {
		return this.postiDisponibili;
	}

	public int getPostiPrenotati() {

		return this.postiPrenotati;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String a) {
		this.titolo = a;
	}

	public LocalDate getData() {
		return this.data;
	}
	//meotodo data formattata
	public String getDataFormattata() {
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
		String dataFormattata = formattatore.format(this.data);
		return dataFormattata;
	}

	public void setData(LocalDate d) {
		this.data = d;
	}

	// metodo toString overridato
	@Override
	public String toString() {
		return String.format("Evento : %s\nData : %s", getTitolo(), getDataFormattata());
	}
	//metodo stamp info evento completa
	// stampa tutti i dettagli
	public String infoEvento() {
		return String.format("Evento :%s\nTitolo :%s\nPosti Disponibili :%s\nPosti Prenotati :%s", getTitolo(),
				getDataFormattata(), getPostiDisponibili(), getPostiPrenotati());
	}

	public static void main(String[] args) {

		/*Evento evento1 = new Evento("titolo", LocalDate.of(2024, 5, 5), 30);
		evento1.prenota();
		evento1.prenota();

		System.out.println(evento1.getData());

		System.out.println(evento1.toString());

		evento1.infoEvento(); 

		Evento controlloData = new Evento("Titolo di Prova", LocalDate.of(2024, 10, 25), 30);

		controlloData.prenota();
		
		System.out.println(controlloData.toString());
		
		
		Evento controlloPosti = new Evento("Titolo di Prova 2", LocalDate.of(2024, 10, 30), 0); */
	
	}

}
