package blastGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import blast.BlastController;

public class BlastGUIMain extends JComponent {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {

		// Creamos el frame
		JFrame frame = new JFrame("GUI Blast");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		Visual newContentPane = new Visual();
		Events event = new Events(newContentPane);

		newContentPane.getResearchButton().addActionListener(event);
		// newContentPane.getTfPorcentaje().addActionListener(event);

		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

}
