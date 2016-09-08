package motor;

import java.util.ArrayList;

import jm.music.data.Note;
import jm.music.data.Score;
import utilidad.Aleatorios;

public abstract class InterfacePista {

	public Aleatorios ran = new Aleatorios();
	protected static InterfacePista ap;
	private static Tecla[] tecArray;
	public static Note[] noteArray;
	

	public static Tecla getTecArray(int i) {
		return tecArray[i];
	}

	public Note getNoteArray(int i) {
		return noteArray[i];
	}

	public InterfacePista(int num) {
		tecArray = new Tecla[num];
		noteArray = new Note[num];
		for (int i = 0; i < num; i++) {
			tecArray[i] = ran.getRandomTecla();
			noteArray[i] = tecArray[i].getSonido();
		}
	}
	protected abstract void evaluar(String tocada, Tecla sugerida) ;


}
