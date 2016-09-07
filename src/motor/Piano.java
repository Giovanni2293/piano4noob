package motor;

import java.util.ArrayList;
import java.util.List;

import jm.music.data.Phrase;
import jm.util.Play;
/**
 * clase principal de la aplicacion, en ella se podra elejir el modo de ejecucion de la aplicacion entre
 * modo libre, aprendizaje y practica( En esta version solo existe el modo libre )
 *@Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 */

public class Piano {

	private List<Tecla> teclas ; // Esta lista corresponde al arreglo de las teclas pertenecientes al teclado del piano
	private static Piano piano; //Objeto unico de la clase Piano (patron singleton)
    private String[][] natural = {{"C","CS","D","DS","E","F","FS","G","GS","A","AS","B"}
    ,{"Do","DoS","Re","ReS","Mi","Fa","FaS","Sol","SolS","La","LaS","Si"}}; //Arreglo matricial que contiene los simbolos y nombres de las notas
	
	
	
	private Piano() {
		teclas = new ArrayList(); //Define la lista como un array list y lo inicializa
		construirPiano(); //Metodo que ayuda en la creacion del teclado del piano
	}
    /**
     * Metodo qe retorna un elemento unico de tipo Piano
     * @return piano
     */
	public static Piano getPiano()
	{
		if (piano==null)
		{
		    piano = new Piano();
		}
		
		return  piano;
	}
    /**
     * Metodo que se usa en la construccion del objeto piano
     */
	private void construirPiano()
	{
		String nombre,nat;  //Simbolo y nombre de las notas asignadas a una tecla, ambas almacenan los nombres temporalmente
		Tecla tecla; //Objeto temporal para asignar las diferentes teclas al arreglo 'teclas'
		int cod=36; // Entero qe se usa como constate en la definicion del sonido de cada tecla(ver la api de JMusic en constantes para Pitch) 
		for (int i = 2 ; i<7 ; i++)
		{
			for (int h = 0 ; h<12; h++)
			{
				nombre = natural[0][h]+i;
				nat = natural[1][h]+i;
				tecla = new Tecla(nombre,cod,nat); // Asi se inicializa cada tecla del piano
				cod++; //Los codigos de las constantes estan distribuidos secuencialmente de izquierda a derecha si comparamos con un teclado de un piano
				teclas.add(tecla);// Se añade la tecla recien creada al arreglo que tiene todas las teclas del piano
			}
			
		}
		tecla = new Tecla("C7",96,"Do7"); //La ultima tecla del lado derecho del piano
		teclas.add(tecla);//Se añade esa ultima tecla
		
		}
	
	
	/**
	 * Este metodo que nos devuelve la tecla cuyo nombre natural coincide con el parametro
	 * @param nota un String que se espera que coincida con un nombre natural de alguna tecla 
	 * @return t un objeto de clase Tecla
	 */
	public Tecla getTecla(String nota)
	{
		for (Tecla t : teclas)
		{
			if (nota.equals(t.getNota()))
				return t;
		}
		
		return null;
		
	}
	

	 /**
	  * Metodo creado para imprimir el nombre y simbolo de todo el arreglo de teclas del piano
	  */
	public void imp()
	{
		for (Tecla t : teclas)
		{
			System.out.print(t.getNombreNatural() + " ");
			System.out.print(t.getNota() + "\n");
			
		}
		
	}
}

