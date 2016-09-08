package motor;

import java.util.ArrayList;


import utilidad.Aleatorios;

public class AprendizajeAcorde {

	private final int numeroDeSecuencias = 50;
	private ArrayList<String[]> cancionString;
	private Aleatorios a;
	private static int indice = 0;

	private AprendizajeAcorde() {

		a = new Aleatorios();
	}

	public static void main(String[] args) {
		AprendizajeAcorde a = new AprendizajeAcorde();
		a.generarGrupoAcordesMayor();
		a.test(a.getAcordeProfe());
		String[] xd = new String[3];
		xd[0]="G4";
		xd[1]="B4";
		xd[2]="D5";
		System.out.println(a.Comparar(xd));
		AprendizajeAcorde.resetIndice();

	}

	public boolean Comparar(String[] acordeEstudiante) {
		String[] acordeProfe = cancionString.get(indice);
		indice++; // campo independiente de la clase
		if (acordeEstudiante[0].equals(acordeProfe[0]) && acordeEstudiante[1].equals(acordeProfe[1])
				&& acordeEstudiante[2].equals(acordeProfe[2])) {// Entrada
																// correcta

			return true;
		} else {
			return false;
		}
	}



	public void terminarDeEvaluar() {
		resetIndice();
	}

	public static void resetIndice() {
		indice = 0;
	}

	public void generarGrupoAcordesAumentado() {
		cancionString = new ArrayList<>();
		for (int i = 0; i < numeroDeSecuencias; i++) {
			String temp[] = null;
			temp = a.getRandomAcordeAumentado();
			cancionString.add(temp);
		}
	}

	public ArrayList<String[]> getAcordeProfe() {
		return cancionString;
	}

	public void generarGrupoAcordesDisminuido() {
		cancionString = new ArrayList<>();
		for (int i = 0; i < numeroDeSecuencias; i++) {
			String temp[] = null;
			temp = a.getRandomAcordeDisminuido();
			cancionString.add(temp);
		}
	}

	public void generarGrupoAcordesMayor() {
		cancionString = new ArrayList<>();
		for (int i = 0; i < numeroDeSecuencias; i++) {
			String temp[] = null;
			temp = a.getRandomAcordeMayor();
			cancionString.add(temp);
		}
	}

	public void generarGrupoAcordesMenor() {
		cancionString = new ArrayList<>();
		for (int i = 0; i < numeroDeSecuencias; i++) {
			String temp[] = null;
			temp = a.getRandomAcordeMenor();
			cancionString.add(temp);
		}
	}

	public void test(ArrayList<String[]> a) {
		for (String[] temp : a) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print("-");
				System.out.print(temp[i]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

}
