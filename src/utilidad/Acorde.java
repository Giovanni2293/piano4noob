package utilidad;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;


import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;

import motor.Piano;
import motor.Reproduccion;


public class Acorde {

	private static LinkedHashMap<String, String> l = new Traductor().getMapaDeNotas();
	private static ArrayList<String> arreglo = new ArrayList<>(l.values());
	private static Reproduccion r = Reproduccion.getRepro();
	private Acorde() {
		
	}
	
	
	public static void main(String[] args) {


		getAcordeDisminuido("C6");

		
		
	}
	
	public static String[] getAcordeMayor(String raiz) {
		return generarAcorde(raiz,4,7);
	}

	public static String[] getAcordeMenor(String raiz) {
		
		return generarAcorde(raiz,3,7);

	}

	public static String[] getAcordeAumentado(String raiz) {
		return generarAcorde(raiz,4,8);
	}

	public static String[] getAcordeDisminuido(String raiz) {
		return generarAcorde(raiz,3,6);
	}

	/**
	 * Metodo que devuelve un elemento por su indice directamente desde un hashmap 
	 * No se esta utilizando pero es interesante.
	 * @param i
	 * @return
	 */
	private static String getElementByIndex(int i) {
		return l.get(l.keySet().toArray()[i]);
	}

	/**
	 * Metodo encargado de obtener una parte con el acorde de 3 notas ingresado previamente. Si se crea el arreglo de notas
	 * con un tamaño superior a tres crea una nota que no suena.
	 * @param a (Arreglo de tamaño 3 con las 3 notas del acorde)
	 * @return Part (Parte a reproducirse mediante Play.midi)
	 */
	private static Part obtenerPiezaMusical(String[] a)
	{
		Part p = new Part();
		if (a.length==3)
		{
		Piano piano = Piano.getPiano();
		Note[] notas = new Note[3];
		notas[0] = piano.getTecla(a[0]).getSonido();
		notas[1] = piano.getTecla(a[1]).getSonido();
		notas[2] = piano.getTecla(a[2]).getSonido();
		CPhrase acorde = new CPhrase();
		acorde.addChord(notas);
		p.addCPhrase(acorde);
		}
		return p;
		
	}
	
	public static String[] generarAcorde(String raiz,int pos1,int pos2)
	{
		String[] acorde = new String[3];
		Part acordeP;
		int posicion = arreglo.indexOf(raiz);
		System.out.println( arreglo.indexOf(raiz));
		int desplazamiento = posicion + pos1;
		int desTemp;
	    if(desplazamiento>31)
	    {
	    	desplazamiento = desplazamiento-12;
	    }
		acorde[0] = raiz;
		acorde[1] = arreglo.get(desplazamiento);
		desTemp = posicion+pos2;
		if (desTemp>31)
		{
			desplazamiento = desTemp- 12;
			System.out.println(desplazamiento);
		}
		acorde[2] = arreglo.get(desplazamiento);
		acordeP=obtenerPiezaMusical(acorde);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		r.reproducirParte(acordeP);
		return acorde;
	}

}
