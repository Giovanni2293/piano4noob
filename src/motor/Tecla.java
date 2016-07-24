package motor;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
/**
 * Esta clase define objetos que continen la informacion que debe llebar cada tecla como el simbolo de la nota, el nombre de la misma y tambien
 * por medio de la libreria JMusic se asigna en el constructor de manera parametrica el archivo de sonido correspondiente a la nota
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 * 
 */

public class Tecla {

	private String nota;  // El simbolo que representa la nota: 'C''D''E''F''G''A''B'
	private Note sonido;  // Clase de la libreria Jmusic en la que se puede asignar un archivo de sonido, la duracion de la nota y otros parametros
	private String nombreNatural; //El nombre de la nota: 'Do''Re'Mi''Fa''Sol''La''Si'
    
	
	/**
	 * Constructor de la clase Tecla
	 * @param nota El simbolo de la tecla
	 * @param l    Entero corresponiente a el sonido de la tecla (ver las constantes de pitch en la Api de JMusic)
	 * @param n    El nombre de la nota
	 */
	public Tecla(String nota , int l ,String n) {
		sonido = new Note();
		sonido.setPitch(l);//Tiene como parametro un entero, el cual es una constante que se asigna al sonido de la nota
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
