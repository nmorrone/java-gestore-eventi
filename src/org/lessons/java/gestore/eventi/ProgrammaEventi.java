package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {

	private String titoloProgramma;
	List<Evento> eventi;

	ProgrammaEventi(String t) {
		this.titoloProgramma = t;
		this.eventi = new ArrayList<>();
	}

//metodo per aggiungere evento alla Lista
	public void aggiungiEvento(Evento e) {
		this.eventi.add(e);
	}

//metodo selezione eventi su data selezionata e creazione nuova lista con gli stessi
	public List <Evento> eventiDataSelezionata(LocalDate d) {
		List <Evento> eventiInData = new ArrayList<>();
		Evento eventoControllo;
		for (int i = 0; i < eventi.size(); i++) {
			if (eventi.get(i).getData().equals(d)) {
				eventoControllo = eventi.get(i);
				eventiInData.add(eventoControllo);

			} else {
				
			}
		}
		
		return eventiInData;
		

	}

//metodo restituzione quantità eventi in lista
	public int numeroEventiInLista() {
		int numeroEventi = eventi.size();
		return numeroEventi;
	}

//metodo che svuota lista eventi
	public void svuotaListaEventi() {
			eventi.removeAll(eventi);
		
	}
	
	
//metodo ordinamento eventi del programma per data
	
	public String listaEventiOrdinata() {
		
		Collections.sort(eventi, Comparator.comparing(Evento :: getData));
		
		StringBuilder stringaEventiOrdinata = new StringBuilder();
		
		for(Evento e : eventi) {
			stringaEventiOrdinata.append(e.toString()).append("\n");
		}
		
		return stringaEventiOrdinata.toString();
	}

	public static void main(String[] args) {

		Evento evento1 = new Evento("titolo1", LocalDate.of(2024, 11, 30), 40);
		Evento evento2 = new Evento("titolo2", LocalDate.of(2024, 12, 31), 30);
		Concerto concerto1 = new Concerto("titolo3", LocalDate.of(2024, 11, 25), LocalTime.of(18, 00), 50, 49.50);

		ProgrammaEventi programma1 = new ProgrammaEventi("Programma 1");

		programma1.aggiungiEvento(evento1);
		programma1.aggiungiEvento(evento2);
		programma1.aggiungiEvento(concerto1);

		System.out.println(programma1.eventi.get(0));
		System.out.println(programma1.eventi.get(1));
		System.out.println(programma1.eventi.get(2));

		System.out.println(programma1.eventiDataSelezionata(LocalDate.of(2024, 12, 31)));

		System.out.println(programma1.numeroEventiInLista());

		ProgrammaEventi programma2 = new ProgrammaEventi("Programma 2");
		programma2.aggiungiEvento(evento1);
		programma2.aggiungiEvento(evento2);
		programma2.aggiungiEvento(concerto1);
		
		for (int i = 0; i < programma2.eventi.size(); i++) {
			System.out.println(programma2.eventi.get(i));
		}

		programma2.svuotaListaEventi();
		System.out.println(programma2.eventi.isEmpty());
		
		System.out.println(programma1.listaEventiOrdinata());

	}
}
