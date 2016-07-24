package motor;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



public class Libre implements KeyListener{

	private JFrame f;
	private JLabel l;
	private Reproduccion r;
	
	public Libre()
	{
		construirFrame();
		f.addKeyListener(this);
		r = r.getRepro();
	}
	
	public void construirFrame()
	{
		f = new JFrame();
		l = new JLabel("sample");
		Container c = f.getContentPane();
		c.add(l);
		f.pack();
		f.setVisible(true);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
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
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		l.setText(e.getKeyText(e.getKeyCode()));
		selectTecla(e.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		r.setTemp("");
	}

}
