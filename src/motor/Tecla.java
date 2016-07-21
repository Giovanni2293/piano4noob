package motor;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;

public class Tecla {

	private String nota;
	private Note sonido;
	private Phrase sonido2;
	private String nombreNatural;
	
	public Tecla(String nota , int l ,String n) {
		sonido = new Note();
		sonido.setPitch(l);
		sonido.setLength(6);//duracion de la nota
		nombreNatural = n;
		this.nota = nota;
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
