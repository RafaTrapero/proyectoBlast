package blastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import blast.BlastController;

public class Events implements ActionListener {
	private Visual visual;

	private String secuencia;
	private String textoPorcentaje;
	private String resultado;

	private float porcentaje;
	private BlastController bCnt;

	public Events(Visual visual) {
		this.visual = visual;
	}

	public void actionPerformed(ActionEvent e) {
		// resultadoBusqueda (al pulsar boton "Buscar")
		bCnt = new BlastController();
		resultado = "";
		if (visual.getNucleotidsButton().isSelected()) {

			visual.getTaResult().setText("Error: búsqueda de secuencias de nucleótidos no disponible");

		} else if (visual.getProteinsButton().isSelected()) {
			try {
				resultado = bCnt.blastQuery('p', visual.getCbBaseDeDatos().getSelectedItem().toString(),
						visual.getCbIndices().getSelectedItem().toString(), porcentaje(), secuenciaDeConsulta());
			} catch (Exception ex) {
				visual.getTaResult().setText("Error: no ha sido posible realizar la búsqueda");
			}
			visual.getTaResult().setText(resultado);
			porcentaje(); // para que salte error si el porcentaje no es valido
		}
	}

	public String secuenciaDeConsulta() {
		try {
			secuencia = visual.getCbSecuenciaDeConsulta().getSelectedItem().toString().toUpperCase(); // elegimos la que
																										// queramos de
																										// la lista
		} catch (NullPointerException ex) {

			boolean secuenciaGuardada = false;
			for (int i = 0; i < visual.getCbSecuenciaDeConsulta().getItemCount(); i++) {
				if (visual.getCbSecuenciaDeConsulta().getItemAt(i).equals(secuencia)) {
					secuenciaGuardada = true;
				}
			}
			if (secuenciaGuardada == false) {
				visual.getCbSecuenciaDeConsulta().addItem(secuencia);
			}
		}
		return secuencia;
	}

	public float porcentaje() {

		textoPorcentaje = visual.getTfPorcentaje().getText();
		porcentaje = Float.parseFloat(textoPorcentaje);

		if (porcentaje < 0 || porcentaje > 1 || textoPorcentaje.equals("")) {

			visual.getTaResult().setText("Error: porcentaje debe estar entre 0 y 1");
		}
		return porcentaje;
	}

}
