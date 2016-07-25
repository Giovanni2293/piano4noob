package motor;
import java.util.Scanner;

public class Piano4Noob {
	public static void main (String[] args)
	{
		int entrada,pista;
		Scanner in = new Scanner(System.in);
		
		System.out.print("########################################################\n");
		System.out.print("#Bienvenido a piano4noobs por favor seleccione la tarea#\n");
		System.out.print("----------ModoLibre: Para ingresar presione 1-----------\n");
		System.out.print("-----Reproductor de pistas: Para ingresar presione 2----\n");
		System.out.print("------------------Para salir presione 0-----------------\n");
		System.out.print("########################################################\n");
	    entrada=in.nextInt();
	    if (entrada==1)
	    {
	    	Libre l = new Libre();
	    }
	    else
	    {
	    	if (entrada ==2) 
	    	{
	    		Pista p = new Pista();
	    		System.out.print("###############Por favor seleccione la opcion###########\n");
	    		System.out.print("------------------------1: Estrellita-------------------\n");
	    		System.out.print("------------------------2: lilium-----------------------\n");
	    		System.out.print("########################################################\n");
	    		pista=in.nextInt();
	    		p.selector(pista);
	    	}
	    	else
	    	{
	    		if (entrada ==0)
	    		{
	    			System.exit(0);
	    		}
	    		else
	    		{
	    			System.out.println("Entrada incorrecta");
	    		}
	    	}
	    }
	}
}
