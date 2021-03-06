package motor;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Rest;
import jm.util.Play;
import jm.music.data.Score;


/**
 * Esta clase se encarga de reproducir pistas(aun no se ha implementado esta funcion) y sonidos
 * del piano en cuanto se accionan
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 */

public class Reproduccion {
	
	private static Piano piano; //Es un objeto unico que inicializa las teclas y sus respectivos sonidos 
	
	private int velocidad;  //Parametro que se usara para reproduccion de pistas(Aun no esta en uso)
	private static String temp = ""; //una variable que ayuda a simular la pulsación de la tecla, es usada en Libre
	private static Reproduccion repro; //El objeto piano cumple el patron singleton por lo tanto este parametro se refiere a un objeto statico
	
	
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
		
		 Play.midiCycle(piano.getTecla(nota).getSonido()); //La clase Play pertenece a la libreria JMusic, el metodo midiCycle reproduce el sonido de la nota
	     Play.stopMidiCycle();//metodo de la clase Play que se encaarga de detener la reproducion iniciada en midiCycle
	     temp = nota;
	     
	     
		}
	     
	}
	
	/**
	 * Reproduce el sonido de una parte hasta que este termine.
	 * @param p
	 */
	public void reproducirParte(Part p)
	{ 
		if (p!=null)Play.midi(p);
	}
	
	
	public static void setTemp(String temp) {
		Reproduccion.temp = temp;
	}
    
	/**
	 * Esta clase crea un objeto unico de tipo Reproducion 
	 * @return repro de tipo Reproducion
	 */
	public static Reproduccion getRepro(){
		if (repro == null){
			repro = new Reproduccion();
		}
		return repro;
	}
}
