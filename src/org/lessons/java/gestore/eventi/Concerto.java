package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	
	private LocalDateTime dataOrario;
	private double prezzo;
	
	
	Concerto(String titolo, LocalDate data, LocalTime h, int postiDisponibili, double c) {
		super(titolo, data, postiDisponibili);
		this.dataOrario = LocalDateTime.of(data, h);
		this.prezzo = c;
		
	}
	
	//Apro metodi getter e setter per data/orario e prezzo
	public String getPrezzo() {
		return String.format("%,2f", this.prezzo);
	}
	
	protected void setPrezzo(double c) {
		this.prezzo = c;
	}
	
	protected void setDataOra(LocalDate d, LocalTime h) {
		this.dataOrario = LocalDateTime.of(d, h);
	}
	
	//metodo data e ora formattata con formattatore
	public String getOraDataFormattata() {
		DateTimeFormatter formattatoreOraData = DateTimeFormatter.ofPattern("EEEE-yyyy-MM-dd HH-mm");
		String dataOraFormattata = formattatoreOraData.format(dataOrario);
		return dataOraFormattata;
	}
	
	//metodo toString overridato
	@Override
	public String toString() {
		return String.format("Concerto: %s\nData e Orario : %s\nPrezzo €%d", getTitolo(), getOraDataFormattata(), getPrezzo());
		
	}
	
	//metodo per stampa tutti dettagli Concerto
	@Override
	public String infoEvento() {
		return String.format("Concerto: %s\nData e Orario: %s\nPrezzo: %s\nPosti Disponibili: %s\nPosti Prenotati: %s", getTitolo(),
				getOraDataFormattata(), getPrezzo(), getPostiDisponibili(), getPostiPrenotati());
	}
	
	
	
}





