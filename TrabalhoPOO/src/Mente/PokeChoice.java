package Mente;

import javax.swing.JOptionPane;

public class PokeChoice {
	 
	public static String pokeIni(String codigo){
		codigo = JOptionPane.showInputDialog("Escolha um Pokemon:\n1 - Squirtle\n2 - Charmander\n3 - Bulbasaur");
		return codigo;
	}
	
}
