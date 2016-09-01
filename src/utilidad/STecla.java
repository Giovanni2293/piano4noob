package utilidad;

import motor.Reproduccion;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Rest;
public class STecla {

	private Reproduccion r; //Elemento necesario para reproducir los sonidos de las teclas del piano que se accionan, las cuales estan asociadas al teclado
    private String nota;
	public STecla()
	{
		r = r.getRepro(); //Devuelve un objeto unico de tipo Reproduccion
	}
     public String getNota(){
		return nota;
	}
	
	/**
	 * Metodo que se va a usar en conjunto con el escuchador de teclado para en base a la tecla accionada reproducir un sonido
	 * @param s  parametro asociado a la tecla del computador, es decir cada una de estas teclas tendra su sonido asociado al accionarlas
	 */
     public void selectTecla(String s)
 	{
 		switch (s) {
 		case "Q":
 			r.play("Fa3");
 			nota="Fa3";
 			break;
 		case "2":
 			r.play("FaS3");
 			nota="FaS3";
 			break;
 		case "W":
 			r.play("Sol3");
 			nota="Sol3";
 			break;
 		case "3":
 			r.play("SolS3");
 			nota="SolS3";
 			break;
 		case "E":
 			r.play("La3");
 			nota="La3";
 			break;
 		case "4":
 			r.play("LaS3");
 			nota="LaS3";
 			break;
 		case "R":
 			r.play("Si3");
 			nota="Si3";
 			break;
 		case "T":
 			r.play("Do4");
 			nota="Do4";
 			break;
 		case "6":
 			r.play("DoS4");
 			nota="DoS4";
 			break;
 		case "Y":
 			r.play("Re4");
 			nota="Re4";
 			break;
 		case "7":
 			r.play("ReS4");
 			nota="ReS4";
 			break;
 		case "U":
 			r.play("Mi4");
 			nota="Mi4";
 			break;
 		case "I":
 			r.play("Fa4");
 			nota="Fa4";
 			break;
 		case "9":
 			r.play("FaS4");
 			nota="FaS4";
 			break;
 		case "O":
 			r.play("Sol4");
 			nota="Sol4";
 			break;
 		case "0":
 			r.play("SolS4");
 			nota="SolS4";
 			break;
 		case "P":
 			r.play("La4");
 			nota="La4";
 			break;
 		case "Comilla":
 			r.play("LaS4");
 			nota="LaS4";
 			break;
 		case "Acento Agudo Muerto":
 			r.play("Si4");
 			nota="Si4";
 			break;
 		case "Z":
 			r.play("Do5");
 			nota="Do5";
 			break;
 		case "S":
 			r.play("DoS5");
 			nota="DoS5";
 			break;
 		case "X":
 			r.play("Re5");
 			nota="Re5";
 			break;
 		case "D":
 			r.play("ReS5");
 			nota="ReS5";
 			break;
 		case "C":
 			r.play("Mi5");
 			nota="Mi5";
 			break;
 		case "V":
 			r.play("Fa5");
 			nota="Fa5";
 			break;
 		case "G":
 			r.play("FaS5");
 			nota="FaS5";
 			break;
 		case "B":
 			r.play("Sol5");
 			nota="Sol5";
 			break;
 		case "H":
 			r.play("SolS5");
 			nota="SolS5";
 			break;
 		case "N":
 			r.play("La5");
 			nota="La5";
 			break;
 		case "J":
 			r.play("LaS5");
 			nota="LaS5";
 			break;
 		case "M":
 			r.play("Si5");
 			nota="Si5";
 			break;
 		case "Coma":
 			r.play("Do6");
 			nota="Do6";
 			break;
 		default:
 			break;
 		}
 	}
     
	
    
}
