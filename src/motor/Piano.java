package motor;

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Phrase;
import jm.util.Play;

public class Piano {

	private List<Tecla> teclas ;
    private String[][] natural = {{"C","CS","D","DS","E","F","FS","G","GS","A","AS","B"}
    ,{"Do","DoS","Re","ReS","Mi","Fa","FaS","Sol","SolS","La","LaS","Si"}};
	
	
	
	public Piano() {
		teclas = new ArrayList();
		iniciarPiano();
	}

	public void repro()
	{
		Phrase phr = new Phrase();
	    for (Tecla t : teclas)
		{
	    	phr.addNote(t.getSonido()); 
		}
	    Play.midi(phr);
	}

	private void iniciarPiano()
	{
		String nombre,nat;
		Tecla tecla;
		int cod=36;
		for (int i = 2 ; i<7 ; i++)
		{
			for (int h = 0 ; h<12; h++)
			{
				nombre = natural[0][h]+i;
				nat = natural[1][h];
				tecla = new Tecla(nombre,cod,nat);
				cod++;
				teclas.add(tecla);
			}
			
		}
		tecla = new Tecla("C7",96,"Do7");
		teclas.add(tecla);
		
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
