/**
 * 
 */
package view;

import interfaces.CwBrowser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;

/**
 * @author Jakub Fortunka
 *
 */
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493604451193932925L;
	
	/**
	 * glowny panel programu
	 */
	private JPanel contentPane;
	/**
	 * obiekt klasy {@link CwBrowser} zarzadzajacy krzyzowkami
	 */
	private CwBrowser crosswords;
	/**
	 * Panel klasy {@link CrosswordPanel} w ktorym znajduje sie wyswietlana krzyzowka
	 */
	private CrosswordPanel crosswordPanel;
	/**
	 * Panel {@link JPanel} w ktorym znajduja sie podpowiedzi do hasel
	 */
	private JPanel cluePanel;
	/**
	 * {@link JTextArea} w ktorym znajduja sie podpowiedzi do hasel
	 */
	private JTextArea clueTextArea;
	/**
	 * Panel do otoczenia listy krzyzowek
	 */
	private JPanel listPanel;
	/**
	 * Lista wszystkich mozliwych do wyswietlenia krzyzowek
	 */
	private JList<String> cwList;
	/**
	 * Panel otaczajacy {@link #listPanel} dzieki ktoremu przy malym rozmiarze pojawia sie paski do przewijania
	 */
	private JScrollPane scrollPane;
	/**
	 * Label do listy krzyzowek (zeby ladnie wygladalo)
	 */
	private JLabel listLabel;

	/**
	 * main - odpala aplikacje
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor tworzacy glowne okno. Tworzy rowniez wszystkie potrzebne panele.
	 */
	public Window() {
		setTitle("Program do generowania krzyzowek");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		crosswordPanel = new CrosswordPanel();
		crosswordPanel.setBackground(new Color(211, 211, 211));
		crosswordPanel.setBorder(null);
		contentPane.add(crosswordPanel, BorderLayout.CENTER);
		
		
		cluePanel = new JPanel();
		cluePanel.setBackground(Color.WHITE);
		contentPane.add(cluePanel, BorderLayout.SOUTH);
		
		clueTextArea = new JTextArea();
		clueTextArea.setBackground(Color.WHITE);
		clueTextArea.setEditable(false);
		cluePanel.add(clueTextArea);
		
		listPanel = new JPanel();
		contentPane.add(listPanel, BorderLayout.WEST);
		listPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		scrollPane = new JScrollPane();
		listPanel.add(scrollPane);
		
		cwList = new JList<String>();
		scrollPane.setViewportView(cwList);
		cwList.setVisibleRowCount(10);
		cwList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		OptionPanel optionPanel = new OptionPanel(crosswordPanel,this,clueTextArea,cwList);
		
		listLabel = new JLabel("Krzy\u017C\u00F3wki");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(listLabel);
		contentPane.add(optionPanel, BorderLayout.NORTH);
	}

	/**
	 * @return obiekt {@link CwBrowser} zarzadzajacy krzyzowkami
	 */
	public CwBrowser getCrosswords() {
		return crosswords;
	}

	/**
	 * @return glowny panel programu
	 */
	public JPanel getContentPane() {
		return contentPane;
	}


}
