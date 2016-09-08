package motor;

import jm.music.data.CPhrase;
import jm.music.data.Note;
import jm.music.data.Part;
import utilidad.Acorde;
import utilidad.Aleatorios;

public class AprendizajeAcorde {

	private final int numeroDeSecuencias = 50;
	private CPhrase[] pista;
	private Aleatorios a;
	private AprendizajeAcorde(){
		pista = new CPhrase[numeroDeSecuencias];
		a = new Aleatorios();
	}

	
	public boolean Evaluar(String notaEntrada)
	{
		return false;
	}
	
	public void generarPista()
	{
		for (int i=0;i<numeroDeSecuencias;i++)
		{
			String temp[] = null;
			temp=a.getRandomAcordeAumentado();
			pista[i]=Acorde.obtenerPiezaMusical(temp);
			
			
		}
		
	}
	
	
}
