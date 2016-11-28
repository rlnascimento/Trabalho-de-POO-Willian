package Telas.Lar;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.net.URL;
import java.awt.Color;
import Telas.Lar.House;

import Mente.PokeChoice;;

public class Shop extends JFrame  implements ActionListener {

	JFrame janela = new JFrame ("Laboratorio Professor Oak");	
	ImageIcon fundoSala = new ImageIcon (getClass().getResource("Fundo.jpg"));
	ImageIcon casa      = new ImageIcon (getClass().getResource("OakLab.png"));
	ImageIcon borda     = new ImageIcon (getClass().getResource("Borda.png"));
	ImageIcon npc     = new ImageIcon (getClass().getResource("Joy.png"));
	JLabel lFundo       = new JLabel (fundoSala);
	JLabel lSala        = new JLabel (casa);
	JLabel lBorda       = new JLabel (borda);
	JLabel lNpc       = new JLabel (npc);
	JButton btnCandyFire = new JButton("Fogo");
	JButton btnCandyElectric = new JButton("Eletrica");
	JButton btnCandyWater = new JButton("Agua");
	JButton btnCandyPhysic = new JButton("Psiquica");
	JButton btnCandyGrass = new JButton("Folha");
	House teste = new House();	

	Shop(){
		editarComponentes();
		editarJanela();
		btnCandyFire.addActionListener(this);
		btnCandyGrass.addActionListener(this);
		btnCandyWater.addActionListener(this);
		btnCandyElectric.addActionListener(this);
		btnCandyPhysic.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == btnCandyFire) { //Aciona o botão explorar
			teste.vetorPokeCandy [0] ++;
		}else if( e.getSource() == btnCandyWater) { //Aciona o botão explorar
			teste.vetorPokeCandy [1] ++;
		}else if( e.getSource() == btnCandyElectric) { //Aciona o botão explorar
			teste.vetorPokeCandy [2] ++;
		}else if( e.getSource() == btnCandyPhysic) { //Aciona o botão explorar
			teste.vetorPokeCandy [3] ++;
		}else if( e.getSource() == btnCandyGrass) { //Aciona o botão explorar
			teste.vetorPokeCandy [4] ++;
		}		
	}
	
	public void editarComponentes() {
		lFundo.setBounds(0, 0, 463, 559);
		lBorda.setBounds(21, 91, 419, 363);
		lSala.setBounds(21, 91, 419, 363);	
		btnCandyFire.setBounds(31, 520, 73, 31);
		btnCandyWater.setBounds(201, 520, 73, 31);
		btnCandyElectric.setBounds(284, 520, 73, 31);
		btnCandyGrass.setBounds(114, 520, 73, 31);
		btnCandyPhysic.setBounds(367, 520, 73, 31);
		lNpc.setBounds(82, 113, 334, 341);
	}
	
	public void editarJanela() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(477, 601);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(btnCandyFire);
		getContentPane().add(btnCandyGrass);
		getContentPane().add(btnCandyWater);
		getContentPane().add(btnCandyElectric);
		getContentPane().add(btnCandyPhysic);
		getContentPane().add(lBorda);
		getContentPane().add(lNpc);
		getContentPane().add(lSala);
		getContentPane().add(lFundo);
	}
}
