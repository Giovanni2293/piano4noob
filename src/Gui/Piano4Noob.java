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
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Read;
import jm.util.Write;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import motor.AprendizajePista;
import motor.Modo;
import motor.Piano;
import motor.Puntuacion;
import motor.Reproduccion;
import utilidad.BotonTecla;
import utilidad.Hilo;
import utilidad.STecla;
import utilidad.Tutor;
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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JSlider;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Piano4Noob implements KeyListener, MouseListener {

	private JFrame frmPianonoobs;
	private JLabel etiquetaDeEstado;
	private JLabel lblTeclaTocada;
	private STecla stec;
	private Reproduccion r; // Elemento necesario para reproducir los sonidos de
							// las teclas del piano que se accionan, las cuales
							// estan asociadas al teclado
	private UbicarTeclas guiTeclado;
	private Toolkit t;
	private Color colorBoton; // almacena temporalmente el color de las teclas para los
						// cambios dinamicos de color
	private BotonTecla[] Teclas; // arreglo que contiene los botones de la gui con su
							// respectiva ubicacion

	private String[] textoLbLibre; // arreglo que contine los string que representan las
							// ultimas teclas tocadas
	private Traductor tr; // elemento traductor
	private static JFileChooser fileChooser = new JFileChooser("src\\multimedia");
	private JLabel lblFileSelect; // etiqueta con el nombre de la pista
	private Note[] allSongNotes;
	private static String teclaPresionada;
// Control de reproduccion
	private boolean detenido;
	private Note[] tempNotas;
	private Tutor temp; // implementa un observer que tiene un hilo
						// para darle vida al
	// tutor

	private Note[] notasFullSong;

	// Dimensiones
	private int anchoPanelTeclas;
	private int anchoDePantalla;
	private int anchoParaBotones;
	private static Modo modo;
	private static JLabel lblTtAciertos;
	private static JLabel lblTtFallos;

	

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
		t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		anchoDePantalla = (int) screenSize.getWidth() - 50;
		anchoPanelTeclas = anchoDePantalla - 40;
		anchoParaBotones = (anchoDePantalla - 40) / 19;

		r = Reproduccion.getRepro(); // Devuelve un objeto unico de tipo
										// Reproduccion
		guiTeclado = new UbicarTeclas(anchoParaBotones, 235, this);
		Teclas = new BotonTecla[31];
		Teclas = guiTeclado.getArPiano();

		stec = new STecla();
		frmPianonoobs = new JFrame();
		frmPianonoobs.setTitle("Piano4Noobs");
		frmPianonoobs.setAutoRequestFocus(false);
		frmPianonoobs.setResizable(false);

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
		modo=new AprendizajePista(1);
		JMenuItem abrir = new JMenuItem("Abrir");
		abrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				File fil = openFile();
				allSongNotes = desglosarPista(fil);
				if (Tutor.getCreado() == false) {
					temp = new Tutor(allSongNotes, Teclas);
					temp.iniciar();
				} else {

					JOptionPane.showMessageDialog(null, "Debe detener primero la pista para poder cargar una nueva\n"
							+ "para detener la pista use el menu Reproducci�n, luego detener");

				}

			}
		});
		Archivo.add(abrir);

		JMenu Reproduccin = new JMenu("Reproducci\u00F3n");
		menuBar.add(Reproduccin);

		JMenuItem reanudar = new JMenuItem("Reanudar");
		reanudar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				temp.reanudar();
			}
		});
		Reproduccin.add(reanudar);

		JMenuItem pausar = new JMenuItem("Pausar");
		pausar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				temp.pausarHilo();
			}
		});
		Reproduccin.add(pausar);

		JMenuItem detenerPista = new JMenuItem("Detener Pista");
		Reproduccin.add(detenerPista);

		JMenu mnModo = new JMenu("Modo");
		menuBar.add(mnModo);
		
		JMenuItem mntmAprendizajenotas = new JMenuItem("aprendizaje(notas)");
		mntmAprendizajenotas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				modo= new AprendizajePista(20);
				tempNotas= modo.getNoteArray();
				Phrase p= new Phrase(tempNotas);
				Score s = new Score(new Part(p));
				Write.midi(s,"src\\multimedia\\pruebaAprendizajepista.midi");
			}
		});
		mnModo.add(mntmAprendizajenotas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDePianonoob = new JMenuItem("Acerca de Piano4noob");
		mntmAcercaDePianonoob.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "PIANO4NOOB \nVersion 0.1 \nBeta \nIngenieria del Software 3 \n2016 \nDe noobs para noobs ");
			}
		});
		mnAyuda.add(mntmAcercaDePianonoob);
		detenerPista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (temp != null) {
					temp.setCreado(false);
					temp.detener();

				} else if (detenido == true) {
					JOptionPane.showMessageDialog(null, "La pista ya esta detenida");

				} else {
					JOptionPane.showMessageDialog(null,
							"Es necesario cargar una pista" + "\n antes de intentar detenerla");

				}

			}
		});

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

		final JSlider velocidad = new JSlider();
		velocidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valor = velocidad.getValue();
				if (Tutor.getCreado() == true) {
					if (valor == 0) {
						temp.aumentarVelocidad(3);
					} else if (valor == 1) {
						temp.aumentarVelocidad(2);
					} else if (valor == 2) {

						temp.aumentarVelocidad(1);

					} else if (valor == 3) {
						temp.disminuirVelicidad(2);
					} else {
						temp.disminuirVelicidad(3);
					}
				}

			}
		});
		velocidad.setValue(2);
		velocidad.setMaximum(4);
		velocidad.setBorder(new EmptyBorder(0, 5, 0, 5));
		velocidad.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelIntVelocidad.add(velocidad);

		JPanel panelIntPista = new JPanel();
		panelDificultad.add(panelIntPista);
		panelIntPista.setLayout(null);

		JLabel lblPista = new JLabel("Pista");
		lblPista.setBounds(0, 20, 50, 20);
		lblPista.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPista.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelIntPista.add(lblPista);

		lblFileSelect = new JLabel("browse your flie");
		lblFileSelect.setBounds(new Rectangle(55, 20, 145, 20));
		lblFileSelect.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelIntPista.add(lblFileSelect);

		JButton BrowseFile = new JButton("...");
		BrowseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File fil = openFile();
				allSongNotes = desglosarPista(fil);
				if (Tutor.getCreado() == false) {
					temp = new Tutor(allSongNotes, Teclas);
					temp.iniciar();
				} else {

					JOptionPane.showMessageDialog(null, "Debe detener primero la pista para poder cargar una nueva\n"
							+ "para detener la pista use el menu Reproducci�n, luego detener");

				}

			}
		});
		BrowseFile.setBounds(210, 20, 30, 20);
		panelIntPista.add(BrowseFile);

		JPanel display = new JPanel();
		display.setBackground(Color.DARK_GRAY);
		display.setBounds(300, 65, 650, 143);
		panelDeControles.add(display);
		display.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelUsuario = new JPanel();
		display.add(panelUsuario);
		panelUsuario.setLayout(new GridLayout(0, 1, 0, 0));

		lblTeclaTocada = new JLabel("");
		lblTeclaTocada.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTeclaTocada.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTeclaTocada.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 32));
		panelUsuario.add(lblTeclaTocada);
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

		lblTtAciertos = new JLabel("000");
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

		lblTtFallos = new JLabel("000");
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

		// Tama�o para botones // Apartir de aqu� agregar botones

		for (int i = 31; 0 <= i; i--) {
			// for (int i = 31; 0 <= i; i--) {
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
		tr = new Traductor();
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
		teclaPresionada =e.getKeyText(e.getKeyCode());
		stec.selectTecla(e.getKeyText(e.getKeyCode())); // Segun la tecla
														// presionada se
														// reproduce un sonido
														// qen respuesta
		etiquetaDeEstado.setText(stec.getNota());
		actualizaLLibre(tr.getMapaDeNotas().get(e.getKeyText(e.getKeyCode())));
		for (BotonTecla t : Teclas) {
			String s = t.getTecla();
			String s2 = e.getKeyText(e.getKeyCode());
			if (s.equals(s2)) {
				t.setBackground(Color.gray);
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
			// if (t.getBackground().equals(Color.gray)) {

			if (t.getText().length() > 2)
				t.setBackground(Color.black);
			else
				t.setBackground(Color.WHITE);
			// qeq}
		}

		r.setTemp("");

	}
	public static String getTeclaPresionada() {
		return teclaPresionada;
	}

	public static Modo getModo() {
		return modo;
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
	public static JLabel getLblTtAciertos() {
		return lblTtAciertos;
	}
	public static JLabel getlblTtFallos() {
		return lblTtFallos;
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
		if (s != null) {
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

	/**
	 * Open function: open a file chooser to select a new image file, and then
	 * display the chosen image.
	 */
	private File openFile() {

		FileNameExtensionFilter filter = new FileNameExtensionFilter("MIDI", "midi", "mid");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(frmPianonoobs);

		if (returnVal != JFileChooser.APPROVE_OPTION) {
			return null; // cancelled
		}
		File selectedFile = fileChooser.getSelectedFile();
		Puntuacion.reset();
		int index = selectedFile.getName().lastIndexOf('.');
		lblFileSelect.setText(selectedFile.getName().substring(0, index));
		return selectedFile;
	}

	public Note[] desglosarPista(File selectedFile) {
		Score sco = Read.midiOrJmWithNoMessaging(selectedFile);

		notasFullSong = null;
		int tamPart, tamPhr, tamNota;
		tamPart = sco.getSize();
		Part[] partes = new Part[tamPart];
		partes = sco.getPartArray();

		ArrayList<Note> notasCancion = new ArrayList<Note>();
		int numeroNotas = 0;
		for (int i = 0; i < partes.length; i++) {

			if (partes[i].getInstrument() == 0) {
				tamPhr = partes[i].getSize();
				Phrase[] ph = new Phrase[tamPhr];
				ph = partes[i].getPhraseArray();
				for (int k = 0; k < ph.length; k++) {
					tamNota = ph[k].getSize();
					Note[] notasSong = new Note[tamNota];
					notasSong = ph[k].getNoteArray();
					for (int j = 0; j < notasSong.length; j++) {
						notasCancion.add(notasSong[j]);
					}
				}
			}
			/*
			*/
		}
		notasFullSong = new Note[notasCancion.size()];
		for (int i = 0; i < notasCancion.size(); i++) {
			notasFullSong[i] = notasCancion.get(i);

		}

		return notasFullSong;
	}
}
