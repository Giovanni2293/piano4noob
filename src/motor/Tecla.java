package motor;

import jm.JMC;
import jm.music.data.Note;
import jm.util.Play;

public class Tecla {

	private String nota;
	private Note sonido;
	private String nombreNatural;
	
	public Tecla(String nota , int l ,String n) {
		sonido = new Note();
		sonido.setPitch(l);
		nombreNatural = n;
		this.nota = nota;
	}
	
	public void run()
	{
		Play.midi(sonido);
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Note getSonido() {
		return sonido;
	}

	public void setSonido(Note sonido) {
		this.sonido = sonido;
	}

	public String getNombreNatural() {
		return nombreNatural;
	}

	public void setNombreNatural(String nombreNatural) {
		this.nombreNatural = nombreNatural;
	}
	
	
	
	
	
	

	
}
