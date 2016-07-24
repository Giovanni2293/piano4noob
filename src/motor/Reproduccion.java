package motor;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.music.data.Score;

import utilidad.MediadorHR;

public class Reproduccion {
	
	private static Piano piano;
	private MediadorHR m;
	private int velocidad;
	private static String temp = "";
	private static Reproduccion repro;
	
	
	private Reproduccion()
	{
		//this.piano = piano;
		this.piano = Piano.getPiano();
	}
	
	public void play(String n)
	{
		if(temp != n ){
		String nota = n;
		//Play.midi(piano.getTecla(nota).getSonido());
		
		 Play.midiCycle(piano.getTecla(nota).getSonido());
	     Play.stopMidiCycle();
	     temp = nota;
	     
		}
	     
	}
	
	
	public static void setTemp(String temp) {
		Reproduccion.temp = temp;
	}

	public static Reproduccion getRepro(){
		if (repro == null){
			repro = new Reproduccion();
		}
		return repro;
	}
}
