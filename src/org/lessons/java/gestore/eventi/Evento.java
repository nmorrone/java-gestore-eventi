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
		if ((d == LocalDate.now() || d.isAfter(LocalDate.now())) && (p > 0)) {
			this.titolo = t;
			this.data = d;
			this.postiDisponibili = p;
			this.postiPrenotati = 0;
		}

		// lancio eccezione
		else if (d.isBefore(LocalDate.now())) {

			throw new IllegalStateException("Errore inserimento evento! È stata inserita una data già passata.\n");
		}

		else {

			throw new IllegalStateException("Errore inserimento evento!, il numero dei posti deve essere > 0.\n");
		}
	}

	// Metodo per prenotazione posti con controllo data e posti
	public void prenota() {

		if ((this.data == LocalDate.now() || this.data.isAfter(LocalDate.now()))
				&& (postiPrenotati <= postiDisponibili)) {
			this.postiPrenotati = postiPrenotati + 1;
			this.postiDisponibili = postiDisponibili - 1;
			/*
			 * System.out.println("Prenotazione effettuata \nPosti Prenotati :" +
			 * getPostiPrenotati() + "\nPosti Ancora Dispomibili; " +
			 * getPostiDisponibili());
			 */
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

		if ((this.data == LocalDate.now() || this.data.isAfter(LocalDate.now())) && (postiPrenotati > 0)) {

			this.postiPrenotati = postiPrenotati - 1;
			this.postiDisponibili = postiDisponibili + 1;
			/*
			 * System.out.println("Disdetta effettuata \nPosti Prenotati :" +
			 * getPostiPrenotati() + "\nPosti Ancora Dispomibili; " +
			 * getPostiDisponibili());
			 */
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

	public void setTitolo(String a) {
		this.titolo = a;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setData(LocalDate d) {
		this.data = d;
	}

	public LocalDate getData() {
		return this.data;
	}

	// meotodo data formattata
	public String getDataFormattata() {
		DateTimeFormatter formattatore = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
		String dataFormattata = formattatore.format(this.data);
		return dataFormattata;
	}

	// metodo toString overridato
	@Override
	public String toString() {
		return String.format("Evento : %s\nData : %s", getTitolo(), getDataFormattata());
	}

	// metodo stamp info evento completa
	// stampa tutti i dettagli
	public String infoEvento() {
		return String.format("Evento: %s\nData Evento: %s\nPosti Disponibili: %s\nPosti Prenotati: %s", getTitolo(),
				getDataFormattata(), getPostiDisponibili(), getPostiPrenotati());
	}

}
