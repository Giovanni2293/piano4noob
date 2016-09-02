package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Rest;
import jm.util.Play;
import motor.Reproduccion;
import utilidad.BotonTecla;
import utilidad.STecla;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPasswordField;
import java.awt.Font;
public class Piano4Noob implements KeyListener , MouseListener{

	private JFrame frame;
    private STecla stec;
    private BotonTecla btnNewButton_1;
    private JLabel lblEstado;
	private Reproduccion r; //Elemento necesario para reproducir los sonidos de las teclas del piano que se accionan, las cuales estan asociadas al teclado


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Piano4Noob window = new Piano4Noob();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Piano4Noob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		r = r.getRepro(); //Devuelve un objeto unico de tipo Reproduccion
		
        stec = new STecla();
		frame = new JFrame();
//Le asocia el Escuchador de eventos de teclados a la ventana
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.RED, 3));
		frame.getContentPane().add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton_1 = new BotonTecla("Fa3","Q");
		btnNewButton_1.addKeyListener(this);
		btnNewButton_1.addMouseListener(this);
		btnNewButton_1.setBounds(317, 55, 91, 23);
		panel.add(btnNewButton_1);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(34, 59, 46, 14);
		panel.add(lblEstado);
		Play.midiCycle(new Rest(JMC.HALF_NOTE)); //La clase Play pertenece a la libreria JMusic, el metodo midiCycle reproduce el sonido de la nota
	    Play.stopMidiCycle();//metodo de la clase Play que se encaarga de detener la reproducion iniciada en midiCycle

	}
	/**
	 * Metodo de la interfaz KeyListener en este caso simplemente no se reescribio
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	/**
     * Metodo de la interfaz KeyListener reescrito para manejar el texto de la etiqueda de la gui y reproducir un sonido simultaneamente
     * Este metodo se activa cuando una tecla se presiona
     */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//l.setText(e.getKeyText(e.getKeyCode())); //Reemplaza el contenido de la etiqueta la gui por el simbolo de la tecla presionada
		
		stec.selectTecla(e.getKeyText(e.getKeyCode())); //Segun la tecla presionada se reproduce un sonido en respuesta
		lblEstado.setText(stec.getNota());
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla)
		{
			BotonTecla b = (BotonTecla)e.getSource();
			stec.selectTecla(b.getTecla()); //Segun la tecla presionada se reproduce un sonido en respuesta
			lblEstado.setText(stec.getNota());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla)
		{
			r.setTemp("");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
