package motor;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.music.data.Score;

import utilidad.MediadorHR;

public class Reproduccion {
	
	private static Piano piano;
	private MediadorHR m;
	private int velocidad;
	
	
	public Reproduccion()
	{
		//this.piano = piano;
		this.piano = Piano.getPiano();
	}
	
	public void play(String n)
	{
		String nota = n;
		//Play.midi(piano.getTecla(nota).getSonido());
		 Play.midiCycle(piano.getTecla(nota).getSonido());
	     Play.stopMidiCycle();
	}
}
