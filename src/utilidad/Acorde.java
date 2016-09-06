package utilidad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Acorde {

	private static LinkedHashMap<String, String> l = new Traductor().getMapaDeNotas();
	private static ArrayList<String> arreglo = new ArrayList<>(l.values());

	private Acorde() {
		
	}

	public static String[] getAcordeMayor(String raiz) {
		String[] acorde = new String[3];
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 4) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 3) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		return null;
	}

	public static String[] getAcordeMenor(String raiz) {
		String[] acorde = new String[3];
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 3) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 4) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		return null;

	}

	public static String[] getAcordeAumentado(String raiz) {
		String[] acorde = new String[3];
		int posicion = getPosArreglo(raiz);
		int desplazamiento = (posicion + 4) % 32;
		acorde[0] = raiz;
		acorde[1] = getElementByIndex(desplazamiento);
		desplazamiento = (desplazamiento + 4) % 32;
		acorde[2] = getElementByIndex(desplazamiento);
		System.out.println(acorde[0]);
		System.out.println(acorde[1]);
		System.out.println(acorde[2]);
		return null;
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
		return null;
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

}
