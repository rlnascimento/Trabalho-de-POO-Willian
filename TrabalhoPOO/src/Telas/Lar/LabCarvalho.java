package Telas.Lar;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;

public class LabCarvalho extends JFrame implements ActionListener{
	
	JFrame janela = new JFrame ("Laboratorio Professor Oak");	
	ImageIcon fundoSala = new ImageIcon (getClass().getResource("Fundo.jpg"));
	ImageIcon casa      = new ImageIcon (getClass().getResource("OakLab.png"));
	ImageIcon borda     = new ImageIcon (getClass().getResource("Borda.png"));
	JLabel lFundo          = new JLabel (fundoSala);
	JLabel lSala           = new JLabel (casa);
	JLabel lBorda          = new JLabel (borda);
	JButton btnInfoPoke = new JButton("Info Pokemon");
	
	LabCarvalho(){
		editarComponentes();
		editarJanela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void editarComponentes() {
		lFundo.setBounds(0, 0, 463, 559);
		lBorda.setBounds(21, 91, 419, 363);
		lSala.setBounds(21, 91, 419, 363);		
	}
	
	public void editarJanela() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(477, 601);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(lBorda);
		getContentPane().add(lSala);
		getContentPane().add(lFundo);
	}
}
