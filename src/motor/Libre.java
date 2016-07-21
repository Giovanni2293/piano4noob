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
		r = new Reproduccion();
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
		case "A":
			r.play("Sol2");
			break;
		case "B":
			r.play("La2");
			break;

		default:
			break;
		}
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
