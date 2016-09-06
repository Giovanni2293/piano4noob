package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.Toolkit;

import jm.JMC;
import jm.music.data.Rest;
import jm.util.Play;
import motor.Reproduccion;
import utilidad.BotonTecla;
import utilidad.STecla;
import utilidad.Traductor;
import utilidad.UbicarTeclas;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Piano4Noob implements KeyListener, MouseListener {

	private JFrame frmPianonoobs;
	JLabel etiquetaDeEstado;
	JLabel lblTeclaTocada;
	private STecla stec;
	private Reproduccion r; // Elemento necesario para reproducir los sonidos de
							// las teclas del piano que se accionan, las cuales
							// estan asociadas al teclado
	private UbicarTeclas guiTeclado;
	private Toolkit t;
	Color colorBoton; // almacena temporalmente el color de las teclas para los
						// cambios dinamicos de color
	BotonTecla[] Teclas; // arreglo que contiene los botones de la gui con su
							// respectiva ubicacion
	BotonTecla bTemp; // almacena una tecla temporalmente para cambiar el color
						// en keypresed
	String[] textoLbLibre; // arreglo que contine los string que representan las
							// ultimas teclas tocadas
	Traductor tr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Piano4Noob window = new Piano4Noob();

					window.frmPianonoobs.setVisible(true);

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
		frmPianonoobs.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		r = Reproduccion.getRepro(); // Devuelve un objeto unico de tipo
										// Reproduccion
		int anchoPanelTeclas;
		int anchoDePantalla;
		stec = new STecla();
		frmPianonoobs = new JFrame();
		frmPianonoobs.setTitle("Piano4Noobs");
		frmPianonoobs.setAutoRequestFocus(false);
		frmPianonoobs.setResizable(false);
		t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		anchoDePantalla = (int) screenSize.getWidth() - 50;

		anchoPanelTeclas = anchoDePantalla - 40;
		frmPianonoobs.addKeyListener(this);// Le asocia el Escuchador de eventos
											// de
		// teclados a la ventana
		frmPianonoobs.setBounds(100, 100, 0 + anchoDePantalla, 550);

		frmPianonoobs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPianonoobs.getContentPane().setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		frmPianonoobs.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu Archivo = new JMenu("Archivo");
		menuBar.add(Archivo);

		JMenuItem abrir = new JMenuItem("Abrir");
		Archivo.add(abrir);

		JPanel panelContenedor = new JPanel();
		frmPianonoobs.getContentPane().add(panelContenedor);
		panelContenedor.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panelDeControles = new JPanel();
		panelContenedor.add(panelDeControles);
		panelDeControles.setBackground(Color.LIGHT_GRAY);
		panelDeControles.setLayout(null);

		JPanel panelDificultad = new JPanel();
		panelDificultad.setBounds(1000, 34, 250, 174);
		panelDeControles.add(panelDificultad);
		panelDificultad.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel Dificultada = new JLabel("Dificultad");
		Dificultada.setFont(new Font("Arial", Font.PLAIN, 14));
		Dificultada.setHorizontalAlignment(SwingConstants.CENTER);
		panelDificultad.add(Dificultada);
		JPanel panelIntVelocidad = new JPanel();
		panelDificultad.add(panelIntVelocidad);
		panelIntVelocidad.setLayout(new BoxLayout(panelIntVelocidad, BoxLayout.X_AXIS));

		JLabel lblVelocidad = new JLabel("Velocidad");

		lblVelocidad.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelIntVelocidad.add(lblVelocidad);
		lblVelocidad.setBorder(new EmptyBorder(5, 10, 5, 10));

		JSlider slider = new JSlider();
		slider.setBorder(new EmptyBorder(0, 5, 0, 5));
		slider.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelIntVelocidad.add(slider);

		JPanel panelIntPista = new JPanel();
		panelDificultad.add(panelIntPista);
		panelIntPista.setLayout(new BoxLayout(panelIntPista, BoxLayout.X_AXIS));

		JLabel lblPista = new JLabel("Pista");
		lblPista.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPista.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelIntPista.add(lblPista);

		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new EmptyBorder(15, 5, 15, 5));
		panelIntPista.add(comboBox);

		JPanel difucultad = new JPanel();
		difucultad.setBackground(Color.DARK_GRAY);
		difucultad.setBounds(300, 65, 650, 143);
		panelDeControles.add(difucultad);
		difucultad.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("New label");
		difucultad.add(lblNewLabel);

		JPanel panel = new JPanel();
		difucultad.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		lblTeclaTocada = new JLabel("");
		lblTeclaTocada.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 32));
		panel.add(lblTeclaTocada);
		lblTeclaTocada.setSize(new Dimension(610, 60));
		lblTeclaTocada.setBorder(new EmptyBorder(10, 10, 10, 10));
		textoLbLibre = new String[6];

		JPanel aciertos = new JPanel();
		aciertos.setBounds(100, 37, 150, 80);
		panelDeControles.add(aciertos);
		aciertos.setLayout(new BorderLayout(0, 0));

		JLabel lblAciertos = new JLabel("Aciertos");
		lblAciertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAciertos.setAlignmentX(Component.CENTER_ALIGNMENT);
		aciertos.add(lblAciertos, BorderLayout.NORTH);

		JLabel lblTtAciertos = new JLabel("000");
		lblTtAciertos.setFont(new Font("Arial Black", Font.PLAIN, 28));
		lblTtAciertos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTtAciertos.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblTtAciertos.setAlignmentX(Component.CENTER_ALIGNMENT);
		aciertos.add(lblTtAciertos, BorderLayout.CENTER);

		JPanel errores = new JPanel();
		errores.setBounds(100, 128, 150, 80);
		panelDeControles.add(errores);
		errores.setLayout(new BorderLayout(0, 0));

		JLabel lblFallos = new JLabel("Fallos");
		lblFallos.setHorizontalAlignment(SwingConstants.CENTER);
		errores.add(lblFallos, BorderLayout.NORTH);

		JLabel lblTtFallos = new JLabel("000");
		lblTtFallos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTtFallos.setFont(new Font("Arial Black", Font.PLAIN, 28));
		errores.add(lblTtFallos, BorderLayout.CENTER);

		JPanel panelDeTeclado = new JPanel() {
			// Esta instruccion ayuda a que los botones traslapados
			// no cambien su trasposicion tras pasar el mouse
			// IMPORTANTE
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};

		panelContenedor.add(panelDeTeclado);
		panelDeTeclado.setBackground(Color.GRAY);

		panelDeTeclado.setLayout(null);

		JPanel negras = new JPanel();
		negras.setOpaque(false);
		negras.setBounds(18, 0, anchoPanelTeclas, 235);
		negras.setBackground(Color.WHITE);
		panelDeTeclado.add(negras);
		negras.setLayout(null);

		JPanel blancas = new JPanel();
		blancas.setBounds(18, 0, anchoPanelTeclas, 235);
		panelDeTeclado.add(blancas);
		blancas.setLayout(null);

		JButton bordeIzquierdo = new JButton("");
		bordeIzquierdo.setEnabled(false);
		bordeIzquierdo.setBackground(Color.LIGHT_GRAY);
		bordeIzquierdo.setBounds(0, 0, 20, 240);
		bordeIzquierdo.setBorder(null);
		panelDeTeclado.add(bordeIzquierdo);

		JButton bordeDerecho = new JButton("");
		bordeDerecho.setEnabled(false);
		bordeDerecho.setBackground(Color.LIGHT_GRAY);
		bordeDerecho.setBounds(1290, 0, 20, 240);
		bordeDerecho.setBorder(null);
		panelDeTeclado.add(bordeDerecho);

		// Tamaño para botones // Apartir de aquí agregar botones
		int anchoParaBotones = (anchoDePantalla - 40) / 19;

		guiTeclado = new UbicarTeclas(anchoParaBotones, 235, this);
		Teclas = new BotonTecla[31];
		Teclas = guiTeclado.getArPiano();
		//for (int i = 31; 0 <= i; i--) {
			for (int i = 31; 0 <= i; i--) {
			
			if (i <= 18) {
				blancas.add(Teclas[i]);
			} else {
				negras.add(Teclas[i]);
			}

		}

		Panel panelDeEstado = new Panel();
		FlowLayout fl_panelDeEstado = (FlowLayout) panelDeEstado.getLayout();
		fl_panelDeEstado.setVgap(1);
		fl_panelDeEstado.setHgap(2);
		fl_panelDeEstado.setAlignment(FlowLayout.LEADING);
		frmPianonoobs.getContentPane().add(panelDeEstado, BorderLayout.SOUTH);

		etiquetaDeEstado = new JLabel(" ");
		panelDeEstado.add(etiquetaDeEstado);
		etiquetaDeEstado.setFont(new Font("Arial", Font.PLAIN, 10));
		etiquetaDeEstado.setBackground(Color.LIGHT_GRAY);
		etiquetaDeEstado.setVerticalAlignment(SwingConstants.BOTTOM);
		etiquetaDeEstado.setHorizontalAlignment(SwingConstants.LEFT);

		Play.midiCycle(new Rest(JMC.HALF_NOTE)); // La clase Play pertenece a la
													// libreria JMusic, el
													// metodo midiCycle
													// reproduce el sonido de la
													// nota
		Play.stopMidiCycle();// metodo de la clase Play que se encaarga de
								// detener la reproducion iniciada en midiCycle

	}

	/**
	 * Metodo de la interfaz KeyListener en este caso simplemente no se
	 * reescribio
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo de la interfaz KeyListener reescrito para manejar el texto de la
	 * etiqueda de la gui y reproducir un sonido simultaneamente Este metodo se
	 * activa cuando una tecla se presiona
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// la etiqueta la gui por el simbolo de la tecla presionada
		stec.selectTecla(e.getKeyText(e.getKeyCode())); // Segun la tecla
														// presionada se
														// reproduce un sonido
														// qen respuesta
		etiquetaDeEstado.setText(stec.getNota());
		actualizaLLibre(e.getKeyText(e.getKeyCode()));
		for (BotonTecla t : Teclas) {
			String s = t.getTecla();
			String s2 = e.getKeyText(e.getKeyCode());
			if (s.equals(s2)) {
				bTemp = t;
				bTemp.setBackground(Color.gray);
			}
		}
	}

	/**
	 * Metodo de la interfaz KeyListener reescrito para detener la reproducion
	 * de un sonido Este metodo se activa cuando una tecla se suelta
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(bTemp.getText());
		for (BotonTecla t : Teclas) {
			//if (t.getBackground().equals(Color.gray)) {
				
				if (t.getText().length() >2)
					t.setBackground(Color.black);
				else
					t.setBackground(Color.WHITE);
			//qeq}
		}

		r.setTemp("");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla)// prevencion. clases anonimas >
												// otras
		{
			BotonTecla b = (BotonTecla) e.getSource();
			stec.selectTecla(b.getTecla()); // Segun la tecla presionada se
											// reproduce un sonido en respuesta
			etiquetaDeEstado.setText(stec.getNota());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof BotonTecla) {
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

	public void actualizaLLibre(String s) {
		String tlblibre = " "; // String que se muestra en la marquesina de
								// libre
		for (int i = 0; i < textoLbLibre.length; i++) {
			if (i < textoLbLibre.length - 1) {
				textoLbLibre[i] = textoLbLibre[i + 1];
			} else {
				textoLbLibre[i] = s;
			}
			if (textoLbLibre[i] != null)
				tlblibre += textoLbLibre[i] + "  ";
		}

		lblTeclaTocada.setText(tlblibre);
	}

}
