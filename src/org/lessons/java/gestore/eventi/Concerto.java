package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalDateTime dataOrario;
	private double prezzo;

	Concerto(String titolo, LocalDate data, LocalTime h, int postiDisponibili, double c) {
		super(titolo, data, postiDisponibili);
		this.dataOrario = LocalDateTime.of(data, h);
		this.prezzo = c;

	}

	//getters and setters
	public double getPrezzo() {
		return this.prezzo;
	}
	protected void setPrezzo(double c) {
		this.prezzo = c;
	}

	protected void setDataOra(LocalDate d, LocalTime h) {
		this.dataOrario = LocalDateTime.of(d, h);
	}
	public LocalDateTime getDataOra() {
		return this.dataOrario;
	}
	
	//metodo prezzo formattato
	public String getPrezzoFormattato() {
		return String.format("%.2f", this.prezzo);
	}

	// metodo data e ora formattata con formattatore
	public String getOraDataFormattata() {
		DateTimeFormatter formattatoreOraData = DateTimeFormatter.ofPattern("EEEE-yyyy-MM-dd HH-mm");
		String dataOraFormattata = formattatoreOraData.format(dataOrario);
		return dataOraFormattata;
	}

	// metodo toString overridato
	@Override
	public String toString() {
		return String.format("Concerto: %s\nData e Orario : %s\nPrezzo €%s", getTitolo(), getOraDataFormattata(),
				getPrezzoFormattato());

	}

	// metodo per stampa tutti dettagli Concerto
	public String infoEvento() {
		return String.format("Concerto: %s\nData e Orario: %s\nPrezzo: %s\nPosti Disponibili: %s\nPosti Prenotati: %s",
				getTitolo(), getOraDataFormattata(), getPrezzoFormattato(), getPostiDisponibili(), getPostiPrenotati());
	}

	
	//test funzionalità
	public static void main(String[] args) {

		Concerto concerto1 = new Concerto("titolo3", LocalDate.of(2024, 11, 30), LocalTime.of(18, 00), 50, 49.50);

		System.out.print(concerto1.toString());
	}

}
