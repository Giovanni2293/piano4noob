package utilidad;

import motor.Reproduccion;

import java.util.HashMap;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Rest;
public class STecla {

	private Reproduccion r; //Elemento necesario para reproducir los sonidos de las teclas del piano que se accionan, las cuales estan asociadas al teclado
    private String nota;
    private Traductor tradTecla;
    private HashMap<String ,String> teclas;
   
	public STecla()
	{
		r = r.getRepro(); //Devuelve un objeto unico de tipo Reproduccion
		tradTecla = new Traductor();
		teclas = tradTecla.getMapaDeNotas();
	}
     public String getNota(){
		return nota;
	}
	
	/**
	 * Metodo que se va a usar en conjunto con el escuchador de teclado para en base a la tecla accionada reproducir un sonido
	 * @param s  parametro asociado a la tecla del computador, es decir cada una de estas teclas tendra su sonido asociado al accionarlas
	 */
     public void selectTecla(String s)
 	{
    	 
    	
    	 nota =  teclas.get(s);
    	 if (nota != null){
    	 r.play(teclas.get(s));
    	 
    	 }else{
    		 nota=" ";
    	 } 	 
    	
 	}
    
     
}
