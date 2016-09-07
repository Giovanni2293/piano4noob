package motor;

import java.util.Scanner;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.music.data.Rest;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;
import jm.music.tools.*;
/**
 * Esta es una clase de apoyo encargara de cargar diferentes pistas(Arreglos de sonidos) se usara en la implementacion de aprendizaje y practica 
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 * 
 */
public class Pista {
	
	private Note n; // Objeto de la clase de la libreria JMusic en la que se puede asignar un archivo de sonido, la duracion de la nota y otros parametros
	private Phrase p; //Objeto de la clase de la libreria JMusic que almacena un arreglo de objetos Note
	
	public Pista(){
	}
	/**
	 * Metodo en consola que permite elejir entre las pistas actualmente disponibles en la aplicacion
	 * @param n  Un entero que representa la pista elejida por el usuario
	 */
	public void selector(int n)
	{
		String status = "";
		switch (n) {
		case 1: //El usuario escoje la pista 'estrellita'
			estrellita();
			status="estrellita";
			break;
		case 2: //El usuario escoje la pista 'lilium'
			lilium();
			status="lilium";
			break;
		default: //No hay ninguna pista asociada 
			status="Pista inexistente. La lista de pistas actual es 1 (estrellita) y 2 (lilium)";
			break;
		}
		System.out.println("");
		System.out.print("Reproduciendo: " + status);
	}
	
	public void estrellita(){
		p = new Phrase(); //inicializa el arreglo de notas
		
		n = new Rest(JMC.HALF_NOTE); //Crea un silencio
		p.add(n); //agrega el silencio al arreglo
		
		n = new Note(JMC.C4,JMC.CROTCHET);// Creacion de una nota con los parametros pitch(constante de tecla) y duracion
		p.add(n);//agrega la nota al arreglo
		n = new Note(JMC.C4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.A4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.A4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.HALF_NOTE);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.C4,JMC.HALF_NOTE);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.HALF_NOTE);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.HALF_NOTE);
		p.add(n);
		n = new Note(JMC.C4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.C4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.A4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.A4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.G4,JMC.HALF_NOTE);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.F4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.E4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.D4,JMC.CROTCHET);
		p.add(n);
		n = new Note(JMC.C4,JMC.HALF_NOTE);
		p.add(n);
		Write.midi(p,"src\\multimedia\\estrellita.midi");
		
	
		//View.notate(p);
		Play.midi(p); //Reproduce el arreglo de notas
	}
	
	/**
	 * Este metodo carga y reproduce un archivo del paquete multimedia llamado lilium
	 */
	public void lilium(){
		//Play.mid("src\\multimedia\\lilium.midi");
		Play.mid("src\\multimedia\\rollingGirl.midi");
	}
	/**
	 * Detiene una reproduccion
	 */
	public void detener()
	{
		Play.stopMidi();
	}
}
