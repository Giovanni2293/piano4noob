package motor;

import java.util.ArrayList;

import jm.music.data.Note;
import utilidad.Aleatorios;

public abstract class InterfazAcorde extends Modo{

	protected final int numeroDeSecuencias = 50;
	protected ArrayList<String[]> cancionString;
	protected Aleatorios a;
	protected static int indice = 0;
	
	public InterfazAcorde()
	{
		a = new Aleatorios();
	}
	

	/*public static void main(String[] args) {
		InterfazAcorde p = new PracticaAcorde();
		p.generarGrupoAcordesMayor();
		String[] xd  = new String[3];
		xd[0] = "C4";
		xd[1] = "E4";
		xd[2] = "G4";
        String[] pr = p.getAcordeProfe().get(0);
		System.out.println("prof1: " + pr[0] + " prof2:" + pr[1] + " prof3:" + pr[2]);
		System.out
				.println(p.Comparar(xd) + " Score: " + Puntuacion.getPuntuacion() + " Rate:" + Puntuacion.rateLetra());
		
		p.terminarDeEvaluar();

	}*/
	public void terminarDeEvaluar() {
		resetIndice();
	}
	
	public static void resetIndice() {
		indice = 0;
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

	public void generarGrupoAcordesAumentado() {
		cancionString = new ArrayList<>();
		for (int i = 0; i < numeroDeSecuencias; i++) {
			String temp[] = null;
			temp = a.getRandomAcordeAumentado();
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
	
	public  Note[] getNoteArray()
	{
		return null;
	}

}
