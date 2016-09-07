package utilidad;

import java.util.HashMap;
import java.util.LinkedHashMap;

//no esta en uso
public class Traductor {
	private LinkedHashMap<String, String> Notas;
	private LinkedHashMap<String, String> Teclas;
	 private LinkedHashMap<String, String> PitchToTecla;
	
	public Traductor() {

		crearMapaDeNotas();
		crearMapaDeTeclas();
		pitchesToTeclas() ;
	}
	/**
	 * Guarda una tecla como clave y una nota como valor
	 */
	public void crearMapaDeNotas() {

		Notas = new LinkedHashMap();
		Notas.put("Z", "F3");
		Notas.put("S", "FS3");
		Notas.put("X", "G3");
		Notas.put("D", "GS3");
		Notas.put("C", "A3");
		Notas.put("F", "AS3");
		Notas.put("V", "B3");
		Notas.put("B", "C4");
		Notas.put("H", "CS4");
		Notas.put("N", "D4");
		Notas.put("J", "DS4");
		Notas.put("M", "E4");
		Notas.put("Coma", "F4");
		Notas.put("L", "FS4");
		Notas.put("Q", "G4");
		Notas.put("2", "GS4");
		Notas.put("W", "A4");
		Notas.put("3", "AS4");
		Notas.put("E", "B4");
		Notas.put("R", "C5");
		Notas.put("5", "CS5");
		Notas.put("T", "D5");
		Notas.put("6", "DS5");
		Notas.put("Y", "E5");
		Notas.put("U", "F5");
		Notas.put("8", "FS5");
		Notas.put("I", "G5");
		Notas.put("9", "GS5");
		Notas.put("O", "A5");
		Notas.put("0", "AS5");
		Notas.put("P", "B5");
		Notas.put("Acento Agudo Muerto", "C6");

	}
	/**
	 * Guarda una Nota como clave y una tecla como valor;
	 */
	public void crearMapaDeTeclas() {
		Teclas = new LinkedHashMap();
		Teclas.put( "F3","Z");
		Teclas.put( "FS3","S");
		Teclas.put( "G3","X");
		Teclas.put( "GS3","D");
		Teclas.put( "A3","C");
		Teclas.put( "AS3","F");
		Teclas.put( "B3","V");
		Teclas.put( "C4","B");
		Teclas.put( "CS4","H");
		Teclas.put( "D4","N");
		Teclas.put( "DS4","J");
		Teclas.put( "E4","M");
		Teclas.put( "F4","Coma");
		Teclas.put( "FS4","L");
		Teclas.put( "G4", "Q");
		Teclas.put( "GS4","2");
		Teclas.put( "A4","W");
		Teclas.put( "AS4","3");
		Teclas.put( "B4","E");
		Teclas.put( "C5","R");
		Teclas.put( "CS5","5");
		Teclas.put( "D5","T");
		Teclas.put( "DS5","6");
		Teclas.put( "E5","Y");
		Teclas.put( "F5","U");
		Teclas.put( "FS5","8");
		Teclas.put( "G5","I");
		Teclas.put( "GS5","9");
		Teclas.put( "A5","O");
		Teclas.put( "AS5","0");
		Teclas.put( "B5","P");
		Teclas.put( "C6", "Acento Agudo Muerto");
	}
	/**
	 * Guarda una Nota como clave y una tecla como valor;
	 */
	public void pitchesToTeclas() {
		PitchToTecla = new LinkedHashMap();
		PitchToTecla.put( "53","Z");
		PitchToTecla.put( "54","S");
		PitchToTecla.put( "55","X");
		PitchToTecla.put( "56","D");
		PitchToTecla.put( "57","C");
		PitchToTecla.put( "58","F");
		PitchToTecla.put( "59","V");
		PitchToTecla.put( "60","B");
		PitchToTecla.put( "61","H");
		PitchToTecla.put( "62","N");
		PitchToTecla.put( "63","J");
		PitchToTecla.put( "64","M");
		PitchToTecla.put( "65","Coma");
		PitchToTecla.put( "66","L");
		PitchToTecla.put( "67", "Q");
		PitchToTecla.put( "68","2");
		PitchToTecla.put( "69","W");
		PitchToTecla.put( "70","3");
		PitchToTecla.put( "71","E");
		PitchToTecla.put( "72","R");
		PitchToTecla.put( "73","5");
		PitchToTecla.put( "74","T");
		PitchToTecla.put( "75","6");
		PitchToTecla.put( "76","Y");
		PitchToTecla.put( "77","U");
		PitchToTecla.put( "78","8");
		PitchToTecla.put( "79","I");
		PitchToTecla.put( "80","9");
		PitchToTecla.put( "81","O");
		PitchToTecla.put( "82","0");
		PitchToTecla.put( "83","P");
		PitchToTecla.put( "84", "Acento Agudo Muerto");
	}
	
	public LinkedHashMap<String, String> getMapaDeTeclas() {
		return Teclas;
	}
	public LinkedHashMap<String, String> getMapaDeNotas(){
		return Notas;
	}
	public LinkedHashMap<String, String> getPitchesToTeclas(){
		return PitchToTecla;
	}

}
