package motor;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.music.data.Rest;
import jm.util.Play;
import jm.util.View;
import jm.music.tools.*;

public class Pista extends Thread {
	
	private Note n;
	private Phrase p;
	
	public Pista(){
		
		
	}
	
	public void estrellita(){
		p = new Phrase();
		
		n = new Rest(JMC.HALF_NOTE);
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
		
		
	
		View.notate(p);
		
		//Play.midi(p);
	}

	public void lilium(){
		
		
		Play.mid("src\\multimedia\\lilium.midi");
		
	}
	
	
}
