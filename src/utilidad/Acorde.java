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
		getAcordeMenor("C3");
		getAcordeMenor("C3");
		getAcordeMenor("C3");
		getAcordeMenor("C3");
		getAcordeMenor("C3");
		
		
	}
	
	public static String[] getAcordeMayor(String raiz) {
		String[] acorde = new String[3];
		Part acordeP;
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 4) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 3) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		acordeP=obtenerParte(acorde);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		r.reproducirParte(acordeP);
		return acorde;
	}

	public static String[] getAcordeMenor(String raiz) {
		String[] acorde = new String[3];
		Part acordeP;
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 3) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 4) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		acordeP=obtenerParte(acorde);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		r.reproducirParte(acordeP);
		return acorde;

	}

	public static String[] getAcordeAumentado(String raiz) {
		String[] acorde = new String[3];
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 4) % 32;
		Part acordeP;
		acordeP=obtenerParte(acorde);
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 4) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		r.reproducirParte(acordeP);
		return acorde;
	}

	public static String[] getAcordeDisminuido(String raiz) {
		String[] acorde = new String[3];
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 3) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 3) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		return acorde;
	}

	public static String getElementByIndex(int i) {
		return l.get(l.keySet().toArray()[i]);
	}

	public static int getPosArreglo(String raiz) {
		Iterator<String> i = arreglo.iterator();
		int n = 0, encontrado = 0;
		while (i.hasNext()) {
			String s = (String) i.next();
			if (raiz.equals(s)) {
				encontrado = n;
			}
			n++;
		}
		return encontrado;
	}
	

	/**
	 * Metodo encargado de obtener una parte con el acorde de 3 notas ingresado previamente. Si se crea el arreglo de notas
	 * con un tamaño superior a tres crea una nota que no suena.
	 * @param a (Arreglo de tamaño 3 con las 3 notas del acorde)
	 * @return Part (Parte a reproducirse mediante Play.midi)
	 */
	private static Part obtenerParte(String[] a)
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
	
	

}
