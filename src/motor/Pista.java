package motor;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.View;
import jm.music.tools.*;

public class Pista extends Thread {
	
	public static void main (String[] args)
	{
		//C2 a C7
	    Piano p = new Piano();
	    p.imp();
	    p.repro();
	}

}
