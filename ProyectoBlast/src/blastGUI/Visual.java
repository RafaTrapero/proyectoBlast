package blastGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Visual extends JPanel {

	private JPanel cbPanel;
	private JPanel buttonPanel;
	private JPanel researchPanel;

	private JRadioButton proteinsButton;
	private JRadioButton nucleotidsButton;

	private JButton researchButton;

	private ButtonGroup buttonGroup;

	private JComboBox<String> cbBaseDeDatos;
	private JComboBox<String> cbIndices;
	private JComboBox<String> cbSecuenciaDeConsulta;

	private JLabel buttonTag;
	private JLabel bddTag;
	private JLabel indicesTag;
	private JLabel secuenciaDeConsultaTag;
	private JLabel porcentajeTag;

	private JTextField tfPorcentaje;

	private JTextArea taResult;

	private JScrollPane scroll;

	public Visual() {

		// BUTTON PANEL
		// añadimos radiobuttons
		proteinsButton = new JRadioButton("Proteinas");
		nucleotidsButton = new JRadioButton("Nucleotidos");
		proteinsButton.setSelected(true);

		// Creamos grupo para los radiobuttons
		buttonGroup = new ButtonGroup();
		buttonGroup.add(nucleotidsButton);
		buttonGroup.add(proteinsButton);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 1));
		buttonTag = new JLabel("Secuencias:");

		buttonPanel.add(buttonTag);
		buttonPanel.add(proteinsButton);
		buttonPanel.add(nucleotidsButton);

		this.add(buttonPanel);

		// COMBOBOX PANEL
		cbBaseDeDatos = new JComboBox<String>();
		cbIndices = new JComboBox<String>();
		cbSecuenciaDeConsulta = new JComboBox<String>();

		bddTag = new JLabel("Base de datos: ");
		indicesTag = new JLabel("Indices: ");
		secuenciaDeConsultaTag = new JLabel("Secuencia de consulta: ");
		porcentajeTag = new JLabel("Porcentaje:");
		tfPorcentaje = new JTextField();

		cbBaseDeDatos.addItem("yeast.aa");
		cbIndices.addItem("yeast.aa.indexs");
		cbSecuenciaDeConsulta.setEditable(true);

		cbPanel = new JPanel();
		cbPanel.setLayout(new GridLayout(4, 2));
		cbPanel.add(bddTag);
		cbPanel.add(cbBaseDeDatos);
		cbPanel.add(indicesTag);
		cbPanel.add(cbIndices);
		cbPanel.add(secuenciaDeConsultaTag);
		cbPanel.add(cbSecuenciaDeConsulta);
		cbPanel.add(porcentajeTag);
		cbPanel.add(tfPorcentaje);

		this.add(cbPanel);

		// RESEARCH PANEL
		researchPanel = new JPanel();
		researchButton = new JButton("Buscar");
		researchPanel.add(researchButton);
		this.add(researchPanel);

		// RESULT
		taResult = new JTextArea(40, 40);
		taResult.setEditable(false);
		taResult.setBackground(Color.GRAY);
		// añadimos un scrollpane para poder ver el resultado de la busqueda
		// correctamente
		scroll = new JScrollPane(taResult);
		this.add(scroll);

	}

	// creamos los getter de todos los elementos que hemos añadido a los paneles
	public JRadioButton getProteinsButton() {
		return proteinsButton;
	}

	public JRadioButton getNucleotidsButton() {
		return nucleotidsButton;
	}

	public JButton getResearchButton() {
		return researchButton;
	}

	public JComboBox<String> getCbBaseDeDatos() {
		return cbBaseDeDatos;
	}

	public JComboBox<String> getCbIndices() {
		return cbIndices;
	}

	public JComboBox<String> getCbSecuenciaDeConsulta() {
		return cbSecuenciaDeConsulta;
	}

	public JTextField getTfPorcentaje() {
		return tfPorcentaje;
	}

	public JTextArea getTaResult() {
		return taResult;
	}
}
