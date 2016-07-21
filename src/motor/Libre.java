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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		l.setText(e.getKeyText(e.getKeyCode()));
		switch (e.getKeyText(e.getKeyCode())) {
		case "Q":
			r.play("Do2");
			break;
		case "2":
			r.play("DoS2");
			break;
		case "3":
			r.play("ReS2");
			break;
		case "W":
			r.play("Re2");
			break;
		case "E":
			r.play("Mi2");
			break;
		case "O":
			r.play("Sol4");
			break;

		default:
			break;
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		r.Stop();
		r.setTemp("");
	}

}
