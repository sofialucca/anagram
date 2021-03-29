package it.polito.tdp.angram.model;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

	//interfaccia pubblica
	public List<String> anagrammi(String parola) {
		
		List<String> risultato=new ArrayList<>();
		permuta("",parola,0,risultato); //inizializzo la ricorsione
		//cancella dala lista le parole non valide(leggendo dizionario)
		return risultato;
	}
	
	//metodo interno che fa il lavro sporco
	
	//livello= lunghezza della soluzione parziale
	//lievello iniziale=0
	//parziale=stringa che contiene anagramma incompleto i fase di costruzione
	//lettere=numero di lettere rimaste da mettere in soluzione
	
	
	private void permuta(String parziale,String lettere,int livello, List<String> risultato) {
		if(lettere.length()==0) { //caso terminale
			
			//la soluzione parziale è anche sol completa
			
			
			//if(parziale è una parola valida?){ -->bisogna dargli accesso a dizionario
			risultato.add(parziale);
			
		}else {
			//fai ricorsione
			//sottoproblema== una lettera(un singolo carattere) di 'lettere'
			for(int pos=0;pos<lettere.length();pos++) {
				char tentativo= lettere.charAt(pos);
				
				String nuovaParziale=parziale+tentativo;
				String nuovaLettere= lettere.substring(0,pos)+ lettere.substring(pos+1);
				
				
				//if(nuovaParziale è un Prefisso valido di almeno una parola nel dizionario){
					//esempio aqz-->NO car-->SI
				permuta(nuovaParziale, nuovaLettere, livello+1,risultato);
				
				//backtracking -->si può escludere introducendo nuove parziali senza toccare i parametri di input
				//rimettere a posto parziale
				//rimettere a posto lettere
			}
		}
	}
}
