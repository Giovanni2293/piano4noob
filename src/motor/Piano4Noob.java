package motor;
import java.util.Scanner;
/**
 * Es la clase principal de la aplicacion y la puerta de entrada 
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 */
public class Piano4Noob {
	/**
	 * Despliega en consola un menu en el cual se puede ir al modo libre o al Reproductor de pistas
	 * @param args
	 */
	public static void main (String[] args)
	{
		int entrada,pista;
		Scanner in = new Scanner(System.in);//Espera un entero entre 1 ó 2
		
		System.out.print("########################################################\n");
		System.out.print("#Bienvenido a piano4noobs por favor seleccione la tarea#\n");
		System.out.print("----------ModoLibre: Para ingresar presione 1-----------\n");// ir al modo libre (ap. en la gui)
		System.out.print("-----Reproductor de pistas: Para ingresar presione 2----\n");// ir al reproductor de pistas(ap. de consola)
		System.out.print("------------------Para salir presione 0-----------------\n");
		System.out.print("########################################################\n");
	    entrada=in.nextInt();
	    if (entrada==1)//modo libre
	    {
	    	Libre l = new Libre();
	    }
	    else
	    {
	    	if (entrada ==2) //Reproductor de pistas
	    	{
	    		Pista p = new Pista();
	    		System.out.print("###############Por favor seleccione la opcion###########\n");
	    		System.out.print("------------------------1: Estrellita-------------------\n");//Pista 'estrellita'
	    		System.out.print("------------------------2: lilium-----------------------\n");//Pista 'lilium'
	    		System.out.print("########################################################\n");
	    		pista=in.nextInt();
	    		p.selector(pista);//Seleciona una pista entre las opciones
	    	}
	    	else
	    	{
	    		if (entrada ==0)
	    		{
	    			System.exit(0);//cierra la aplicacion
	    		}
	    		else
	    		{
	    			System.out.println("Entrada incorrecta");
	    		}
	    	}
	    }
	}
}
