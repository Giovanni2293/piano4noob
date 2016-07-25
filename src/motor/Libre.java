package motor;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * Es uno de los modos de ejecucion de la aplicacion en el cual el usuario podra tocar libremente el piano emulando la experiencia de un piano real,
 * en este modo no se cuenta con ningun tipo de guia u orientacion al usuario, sino que se deja que el perimente por su cuenta
 *  
 * @Autor: Flores - Pereira - Prada
 * @version: 24/07/2016
 */

public class Libre implements KeyListener{

	private JFrame f; //Elemento de la gui
	private JLabel l; //Elemento de la gui
	private Reproduccion r; //Elemento necesario para reproducir los sonidos de las teclas del piano que se accionan, las cuales estan asociadas al teclado
	
	public Libre()
	{
		construirFrame(); //Construye la ventana
		f.addKeyListener(this);//Le asocia el Escuchador de eventos de teclados a la ventana
		r = r.getRepro(); //Devuelve un objeto unico de tipo Reproduccion
	}
	
	/**
	 * Metodo que construye la ventana de la gui y sus elementos
	 */
	public void construirFrame()
	{
		f = new JFrame();
		l = new JLabel("sample");
		Container c = f.getContentPane();
		c.add(l);
		f.pack();
		f.setVisible(true);
		
	}
	/**
	 * Metodo de la interfaz KeyListener en este caso simplemente no se reescribio
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
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
			break;
		case "2":
			r.play("FaS3");
			break;
		case "W":
			r.play("Sol3");
			break;
		case "3":
			r.play("SolS3");
			break;
		case "E":
			r.play("La3");
			break;
		case "4":
			r.play("LaS3");
			break;
		case "R":
			r.play("Si3");
			break;
		case "T":
			r.play("Do4");
			break;
		case "6":
			r.play("DoS4");
			break;
		case "Y":
			r.play("Re4");
			break;
		case "7":
			r.play("ReS4");
			break;
		case "U":
			r.play("Mi4");
			break;
		case "I":
			r.play("Fa4");
			break;
		case "9":
			r.play("FaS4");
			break;
		case "O":
			r.play("Sol4");
			break;
		case "0":
			r.play("SolS4");
			break;
		case "P":
			r.play("La4");
			break;
		case "Comilla":
			r.play("LaS4");
			break;
		case "Acento Agudo Muerto":
			r.play("Si4");
			break;
		case "Z":
			r.play("Do5");
			break;
		case "S":
			r.play("DoS5");
			break;
		case "X":
			r.play("Re5");
			break;
		case "D":
			r.play("ReS5");
			break;
		case "C":
			r.play("Mi5");
			break;
		case "V":
			r.play("Fa5");
			break;
		case "G":
			r.play("FaS5");
			break;
		case "B":
			r.play("Sol5");
			break;
		case "H":
			r.play("SolS5");
			break;
		case "N":
			r.play("La5");
			break;
		case "J":
			r.play("LaS5");
			break;
		case "M":
			r.play("Si5");
			break;
		case "Coma":
			r.play("Do6");
			break;
		default:
			break;
		}
	}
	
    /**
     * Metodo de la interfaz KeyListener reescrito para manejar el texto de la etiqueda de la gui y reproducir un sonido simultaneamente
     * Este metodo se activa cuando una tecla se presiona
     */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		l.setText(e.getKeyText(e.getKeyCode())); //Reemplaza el contenido de la etiqueta la gui por el simbolo de la tecla presionada
		selectTecla(e.getKeyText(e.getKeyCode())); //Segun la tecla presionada se reproduce un sonido en respuesta
	}
	/**
     * Metodo de la interfaz KeyListener reescrito para detener la reproducion de un sonido
     * Este metodo se activa cuando una tecla se suelta
     */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		r.setTemp("");
	}

}
