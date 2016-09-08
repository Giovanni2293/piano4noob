package motor;

import jm.music.data.Note;
import jm.music.data.Score;
import utilidad.Aleatorios;

public class AprendizajePista {

	public static Aleatorios ran = new Aleatorios();
	static AprendizajePista ap;
	public static Tecla[] tecArray;
	public Note[] noteArray;

	public AprendizajePista(int num) {
		tecArray = new Tecla[num];
		noteArray= new Note[num];
		for (int i = 0; i < num; i++) {
			tecArray[i]=ran.getRandomTecla();
			noteArray[i]=tecArray[i].getSonido();
		}
	}

	public static void main(String[] args) {
		ap = new AprendizajePista(50);
		ap.evaluar("",tecArray[0]);
		ap.evaluar(tecArray[1].getNombreNatural(),tecArray[1]);
		ap.evaluar("",tecArray[2]);
		ap.evaluar(tecArray[3].getNombreNatural(),tecArray[3]);
		System.out.println(Puntuacion.getPuntuacion());

	}

	public void evaluar(String tocada, Tecla sugerida) {
		
		if (tocada.equals(sugerida.getNombreNatural())) {
			Puntuacion.acierto();
			System.out.println("bien");
		} else {
			Puntuacion.fallos();
			System.out.println("mal");

		}
	}

}
