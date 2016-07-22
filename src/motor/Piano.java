package motor;

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Phrase;
import jm.util.Play;

public class Piano {

	private List<Tecla> teclas ;
	private static Piano piano;
    private String[][] natural = {{"F","FS","G","GS","A","AS","B","C","CS","D","DS","E"}
    ,{"Fa","FaS","Sol","SolS","La","LaS","Si","Do","DoS","Re","ReS","Mi"}};
	
	
	
	private Piano() {
		teclas = new ArrayList();
		construirPiano();
	}

	public static Piano getPiano()
	{
		if (piano==null)
		{
		    piano = new Piano();
		}
		
		return  piano;
	}

	private void construirPiano()
	{
		String nombre,nat;
		Tecla tecla;
		int cod=41;
		for (int i = 2 ; i<5 ; i++)
		{
			for (int h = 0 ; h<12; h++)
			{
				nombre = natural[0][h]+i;
				nat = natural[1][h]+i;
				tecla = new Tecla(nombre,cod,nat);
				cod++;
				teclas.add(tecla);
			}
			
		}
		tecla = new Tecla("C5",73,"Do5");
		teclas.add(tecla);
		System.out.println();
		}
	
	public Tecla getTecla(String nota)
	{
		for (Tecla t : teclas)
		{
			if (nota.equals(t.getNombreNatural()))
				return t;
		}
		
		return null;
		
	}
	
	public void imp()
	{
		for (Tecla t : teclas)
		{
			System.out.print(t.getNombreNatural() + " ");
			System.out.print(t.getNota() + "\n");
			
		}
		
	}
}
