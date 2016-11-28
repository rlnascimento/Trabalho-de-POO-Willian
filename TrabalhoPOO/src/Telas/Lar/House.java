package Telas.Lar;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.net.URL;
import java.awt.Color;
import java.awt.event.ActionListener;
import Mente.PokeChoice;;

public class House extends JFrame implements MouseListener , ActionListener {
	
	public House() {
	}
	
	JFrame janela = new JFrame ("Pokemon Pet");		
	ImageIcon fundoSala = new ImageIcon (getClass().getResource("TelaPrincipal.png"));
	ImageIcon casa      = new ImageIcon (getClass().getResource("House.jpg"));
	ImageIcon borda     = new ImageIcon (getClass().getResource("Borda.png"));
	static int vetorPokeParty [][] = new int [6][3];
	static int vetorPokedex [] = new int [6];
	static int vetorPokeCandy [] = new int [5];
	static int projeta = 0;
	String escolha = PokeChoice.pokeIni("");
	URL estatico = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+".gif");
	URL animadoA = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"A.gif");
	URL animadoB = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"B.gif");
	ImageIcon pokeParado      = new ImageIcon (estatico);
	ImageIcon pokeAnimadoA     = new ImageIcon (animadoA);
	ImageIcon pokeAnimadoB     = new ImageIcon (animadoB);
	
	JProgressBar progressFome        = new JProgressBar ();
	JProgressBar progressSono        = new JProgressBar ();
	JProgressBar progressHigiene     = new JProgressBar ();	
	JProgressBar progressExperiencia = new JProgressBar ();
	
	public int pointFome        = 100;
	public int pointSono        = 100;
	public int pointHigiene     = 100;
	public int pointExperiencia = 0;
	int level = 0;
	int cash = 90000;
	
	JLabel lFundo          = new JLabel (fundoSala);
	JLabel lSala           = new JLabel (casa);
	JLabel textFome        = new JLabel ("Fome");
	JLabel textSono        = new JLabel ("Sono");
	JLabel textHigiene     = new JLabel("Higiene");
	JLabel textExperiencia = new JLabel("Experiencia");
	JLabel lMini           = new JLabel(pokeParado);
	JLabel textNivel	   = new JLabel("Nivel");
	JLabel textCash		   = new JLabel("Cash");
	JLabel lNivel          = new JLabel(""+level);
	JLabel lCash           = new JLabel(""+cash);
	JLabel textShop		   = new JLabel("Shop");
	JLabel textDormir	   = new JLabel("Dormir");
	JLabel textBanho	   = new JLabel("Banho");
	JLabel textLabCarvalho = new JLabel("Laboratorio");
	JLabel lPokeOne     = new JLabel ("Poke");
	JLabel lPokeTwo     = new JLabel ("Poke");
	JLabel lPokeThree   = new JLabel ("Poke");
	
	URL imagemBanho = ClassLoader.getSystemResource("Telas/Lar/Botões/banho.png");
	URL imagemSono = ClassLoader.getSystemResource("Telas/Lar/Botões/sono.png");
	URL imagemExplore = ClassLoader.getSystemResource("Telas/Lar/Botões/explore.png");
	URL imagemShop = ClassLoader.getSystemResource("Telas/Lar/Botões/shop.png");
	URL imagemNula = ClassLoader.getSystemResource("Telas/Lar/Candy/6.png");
	URL imagemFire = ClassLoader.getSystemResource("Telas/Lar/Candy/1.png");
	URL imagemElectric = ClassLoader.getSystemResource("Telas/Lar/Candy/electric.png");
	URL imagemWater = ClassLoader.getSystemResource("Telas/Lar/Candy/water.png");
	URL imagemGrass = ClassLoader.getSystemResource("Telas/Lar/Candy/grass.png");
	URL imagemPhysic = ClassLoader.getSystemResource("Telas/Lar/Candy/physic.png");
	
	ImageIcon imgBtnBanho = new ImageIcon (imagemBanho);
	ImageIcon imgBtnSono = new ImageIcon (imagemSono);
	ImageIcon imgBtnExplore = new ImageIcon (imagemExplore);
	ImageIcon imgBtnShop = new ImageIcon (imagemShop);
	ImageIcon imgFire = new ImageIcon(imagemFire);
	ImageIcon imgNulo = new ImageIcon(imagemNula);
	ImageIcon imgElectric = new ImageIcon(imagemElectric);
	ImageIcon imgWater = new ImageIcon(imagemWater);
	ImageIcon imgGrass = new ImageIcon(imagemGrass);
	ImageIcon imgPhysic = new ImageIcon(imagemPhysic);
	
	JButton btnComer    = new JButton("Comer");
	JButton fireCandy   = new JButton(imgNulo);
	JButton grassCandy   = new JButton(imgNulo);
	JButton waterCandy   = new JButton(imgNulo);
	JButton electricCandy   = new JButton(imgNulo);
	JButton physicCandy   = new JButton(imgNulo);	
	JButton btnBanho    = new JButton(imgBtnBanho);
	JButton btnDormir   = new JButton(imgBtnSono);
	JButton btnBrincar  = new JButton("Brincar");
	JButton btnExplorar = new JButton(imgBtnExplore);
	JButton btnShop     = new JButton(imgBtnShop);
	JButton btnTrocaOne    = new JButton("Trocar");
	JButton btnTrocaTwo    = new JButton("Trocar");
	JButton btnTrocaThree  = new JButton("Trocar");
	JButton btnCaptura = new JButton("Captura");
	
	public void HouseConstruir(){
			
			for(int counterX = 0;counterX < 6;counterX++){
				for(int counterY =0;counterY < 3;counterY++){
					vetorPokeParty [counterX][counterY] = 100;
				}
			}
			
			editarComponentes();
			editarJanela();
			bFome.start();
			bSono.start();
			bHigiene.start();
			lMini.addMouseListener(this);
			btnExplorar.addActionListener(this);
			btnShop.addActionListener(this);
			btnBrincar.addActionListener(this);
			btnBanho.addActionListener(this);
			btnDormir.addActionListener(this);
			btnCaptura.addActionListener(this);
			btnTrocaOne.addActionListener(this);
			btnTrocaTwo.addActionListener(this);
			btnTrocaThree.addActionListener(this);
			btnComer.addActionListener(this);
			fireCandy.addActionListener(this);
			grassCandy.addActionListener(this);
			waterCandy.addActionListener(this);
			physicCandy.addActionListener(this);
			electricCandy.addActionListener(this);
			projeta++;
		
	}
	
	Thread bFome = new Thread (){
		public void run(){	
			while(vetorPokeParty[Integer.parseInt(escolha)][1] > -2){
				try {
					if(vetorPokeParty[Integer.parseInt(escolha)][1] > 100){
						vetorPokeParty[Integer.parseInt(escolha)][1] = 100;
		            }else if(vetorPokeParty[Integer.parseInt(escolha)][1] < 0){
		            	vetorPokeParty[Integer.parseInt(escolha)][1] = 0;
		            }else{
		            	Thread.sleep(500);
		            	vetorPokeParty[Integer.parseInt(escolha)][1]--;
						progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);	
		            }
					
					if(vetorPokeParty[Integer.parseInt(escolha)][1] == 10){
						JOptionPane.showMessageDialog(null, "Seu pokemon está com muita fome.\nAlimente-o antes que passe mal.");
					}
					
					if(vetorPokeCandy[0] == 0){
						fireCandy.setIcon(imgNulo);
					}else{
						fireCandy.setIcon(imgFire);
					}
					
					if(vetorPokeCandy[2] == 0){
						electricCandy.setIcon(imgNulo);
					}else{
						electricCandy.setIcon(imgElectric);
					}
					
					if(vetorPokeCandy[1] == 0){
						waterCandy.setIcon(imgNulo);
					}else{
						waterCandy.setIcon(imgWater);
					}
					
					if(vetorPokeCandy[4] == 0){
						grassCandy.setIcon(imgNulo);
					}else{
						grassCandy.setIcon(imgGrass);
					}
					
					if(vetorPokeCandy[3] == 0){
						physicCandy.setIcon(imgNulo);
					}else{
						physicCandy.setIcon(imgPhysic);
					}
					
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	};
	
	Thread bSono = new Thread (){
		public void run(){	
			while(vetorPokeParty[Integer.parseInt(escolha)][2] > -2){
				try {
					if(vetorPokeParty[Integer.parseInt(escolha)][2] > 100){
						vetorPokeParty[Integer.parseInt(escolha)][2] = 100;
		            }else if(vetorPokeParty[Integer.parseInt(escolha)][2] < 0){
		            	vetorPokeParty[Integer.parseInt(escolha)][2] = 0;
		            }else{
		            	Thread.sleep(500);
		            	vetorPokeParty[Integer.parseInt(escolha)][2]--;
						progressSono.setValue(vetorPokeParty[Integer.parseInt(escolha)][2]);	
		            }
					if(vetorPokeParty[Integer.parseInt(escolha)][2] == 10){
						JOptionPane.showMessageDialog(null, "Seu pokemon está com muito sono.\nColoque-o para dormir.");
					}
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	};
	
	Thread bHigiene = new Thread (){ 
		public void run(){	
			while(vetorPokeParty[Integer.parseInt(escolha)][0] > -2){
				try {
		            if(vetorPokeParty[Integer.parseInt(escolha)][0] > 100){
		            	vetorPokeParty[Integer.parseInt(escolha)][0] = 100;
		            }else if(vetorPokeParty[Integer.parseInt(escolha)][0] < 0){
		            	vetorPokeParty[Integer.parseInt(escolha)][0] = 0;
		            }else{
		            	Thread.sleep(500);
		            	vetorPokeParty[Integer.parseInt(escolha)][0]--;
						progressHigiene.setValue(vetorPokeParty[Integer.parseInt(escolha)][0]);	
		            }
		            if(vetorPokeParty[Integer.parseInt(escolha)][0] == 10){
						JOptionPane.showMessageDialog(null, "Seu pokemon está cheirando mal.\nHora do banho.");
					}
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		}
	};
	
	public void mouseClicked(MouseEvent arg0) {
		lMini.setIcon(pokeAnimadoA);
	}// evento q sera executado caso o mouse click no label
	public void mouseEntered(MouseEvent arg0) {
		lMini.setIcon(pokeParado);
	}// evento q sera executado caso o mouse entre no label
	public void mouseExited(MouseEvent arg0) {
		lMini.setIcon(pokeParado);
	}// evento q sera executado caso o mouse saia do label
	public void mousePressed(MouseEvent arg0) {
		lMini.setIcon(pokeAnimadoB);
	}// evento q sera executado caso o mouse seja pressionado no label
	public void mouseReleased(MouseEvent arg0) {
		lMini.setIcon(pokeParado);
	}// evento q sera executado caso o mouse seja largado no label

	public void actionPerformed(ActionEvent e) {
        if( e.getSource() == btnExplorar) { //Aciona o botão explorar
                  new LabCarvalho();
        }else if( e.getSource() == btnShop) { //Aciona o botão explorar
            new Shop();
        }else if (e.getSource() == btnBrincar) { //Aciona o botão Brincar
        		  if(pointExperiencia == 100){
        			  pointExperiencia = 0;
        			  progressExperiencia.setValue(pointExperiencia); 
        			  level++;
        			  lNivel.setText(""+level);
        		  }else{
        			  pointExperiencia += 10;
            		  progressExperiencia.setValue(pointExperiencia); 
        		  }        		  	
        }else if (e.getSource()== btnBanho){ //Aciona o botão Banho
        		  vetorPokeParty[Integer.parseInt(escolha)][0] += 10;
        		  progressHigiene.setValue(vetorPokeParty[Integer.parseInt(escolha)][0]);
        }else if (e.getSource() == btnDormir){ //Aciona o botão Dormir
        		  vetorPokeParty[Integer.parseInt(escolha)][2] += 10;
        		  progressSono.setValue(vetorPokeParty[Integer.parseInt(escolha)][2]);
        }else if (e.getSource() == btnComer){
        		  vetorPokeCandy [0] ++;
        }else if (e.getSource() == fireCandy){
        	if(vetorPokeCandy[0] > 0){
        		vetorPokeParty[Integer.parseInt(escolha)][1] += 20;
        		vetorPokeCandy [0] --;
        		progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não possui Fire Candy."
        											+ "\nPor Favor compre no Shop");
        	}
        }else if (e.getSource() == waterCandy){
        	if(vetorPokeCandy[1] > 0){
        		vetorPokeParty[Integer.parseInt(escolha)][1] += 20;
        		vetorPokeCandy [1] --;
        		progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não possui Water Candy."
        											+ "\nPor Favor compre no Shop");
        	}
        }else if (e.getSource() == electricCandy){
        	if(vetorPokeCandy[2] > 0){
        		vetorPokeParty[Integer.parseInt(escolha)][1] += 20;
        		vetorPokeCandy [2] --;
        		progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não possui Electric Candy."
        											+ "\nPor Favor compre no Shop");
        	}
        }else if (e.getSource() == physicCandy){
        	if(vetorPokeCandy[3] > 0){
        		vetorPokeParty[Integer.parseInt(escolha)][1] += 20;
        		vetorPokeCandy [3] --;
        		progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não possui Physic Candy."
        											+ "\nPor Favor compre no Shop");
        	}
        }else if (e.getSource() == grassCandy){
        	if(vetorPokeCandy[4] > 0){
        		vetorPokeParty[Integer.parseInt(escolha)][1] += 20;
        		vetorPokeCandy [4] --;
        		progressFome.setValue(vetorPokeParty[Integer.parseInt(escolha)][1]);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não possui Grass Candy."
        											+ "\nPor Favor compre no Shop");
        	}
        }else if (e.getSource() == btnCaptura){
        	vetorPokedex[0]++;
        }else if(e.getSource() == btnTrocaOne){
        	if(vetorPokedex[0] > 0){
        		escolha = "1";
            	estatico = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+".gif");
            	animadoA = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"A.gif");
            	animadoB = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"B.gif");
            	pokeParado       = new ImageIcon (estatico);
            	pokeAnimadoA     = new ImageIcon (animadoA);
            	pokeAnimadoB     = new ImageIcon (animadoB);
            	lMini.setIcon(pokeParado);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não capturou este pokemon!");
        	}        	
        }else if(e.getSource() == btnTrocaTwo){
        	if(vetorPokedex[1] > 0){
        		escolha = "2";
            	estatico = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+".gif");
            	animadoA = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"A.gif");
            	animadoB = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"B.gif");
            	pokeParado       = new ImageIcon (estatico);
            	pokeAnimadoA     = new ImageIcon (animadoA);
            	pokeAnimadoB     = new ImageIcon (animadoB);
            	lMini.setIcon(pokeParado);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não capturou este pokemon!");
        	} 
        }else if(e.getSource() == btnTrocaThree){
        	if(vetorPokedex[3] > 0){
        		escolha = "3";
            	estatico = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+".gif");
            	animadoA = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"A.gif");
            	animadoB = ClassLoader.getSystemResource("Telas/Lar/pokeSprites/"+escolha+"B.gif");
            	pokeParado       = new ImageIcon (estatico);
            	pokeAnimadoA     = new ImageIcon (animadoA);
            	pokeAnimadoB     = new ImageIcon (animadoB);
            	lMini.setIcon(pokeParado);
        	}else{
        		JOptionPane.showMessageDialog(null,"Você não capturou este pokemon!");
        	} 
        }
   }
	
	public void editarComponentes() {

		lFundo.setBounds(0, -5, 800, 630);
		progressFome.setForeground(Color.ORANGE);
		progressFome.setValue(100);
		progressFome.setBounds(41, 516, 101, 30);
		progressSono.setForeground(Color.ORANGE);
		progressSono.setValue(100);
		progressSono.setBounds(41, 461, 101, 30);
		progressHigiene.setForeground(Color.ORANGE);
		progressHigiene.setStringPainted(true);
		progressHigiene.setValue(100);
		progressHigiene.setBounds(41, 573, 101, 30);
		progressExperiencia.setValue(1);
		progressExperiencia.setBounds(447, 333, 89, 30);
		lSala.setBounds(16, 30, 320, 383);
		lPokeOne.setBounds(361, 46, 126, 89);
		lPokeTwo.setBounds(648, 46, 126, 89);
		lPokeThree.setBounds(508, 46, 126, 89);
		textSono.setFont(new Font("Dosis", Font.PLAIN, 18));
		textSono.setBounds(51, 487, 37, 30);
		lNivel.setFont(new Font("Dosis", Font.PLAIN, 18));
		lNivel.setBounds(411, 366, 37, 30);
		textHigiene.setFont(new Font("Dosis", Font.PLAIN, 18));
		textHigiene.setBounds(51, 595, 69, 30);
		textFome.setFont(new Font("Dosis", Font.PLAIN, 18));
		textFome.setBounds(51, 548, 69, 24);
		textNivel.setFont(new Font("Dosis", Font.PLAIN, 18));
		textNivel.setBounds(357, 369, 37, 24);
		textCash.setFont(new Font("Dosis", Font.PLAIN, 18));
		textCash.setBounds(457, 369, 37, 24);
		textExperiencia.setFont(new Font("Dosis", Font.PLAIN, 18));
		textExperiencia.setBounds(362, 334, 89, 24);
		btnBanho.setBounds(173, 458, 69, 54);
		btnComer.setBounds(533, 374, 50, 43);
		btnCaptura.setBounds(695, 369, 89, 30);
		btnTrocaThree.setBounds(672, 142, 89, 30);
		btnTrocaTwo.setBounds(528, 142, 89, 30);
		btnTrocaOne.setBounds(382, 142, 89, 30);
		grassCandy.setBounds(567, 560, 50, 43);
		fireCandy.setBounds(635, 375, 50, 43);
		waterCandy.setBounds(732, 455, 50, 43);
		electricCandy.setBounds(533, 455, 50, 43);
		physicCandy.setBounds(697, 560, 50, 43);
		btnDormir.setBounds(173, 541, 69, 54);
		btnBrincar.setBounds(420, 573, 89, 23);
		btnExplorar.setBounds(257, 542, 69, 54);
		lMini.setBounds(167, 215, 180, 157);
		btnShop.setBounds(257, 458, 69, 54);
		textBanho.setBounds(183, 507, 69, 24);
		textDormir.setBounds(185, 588, 62, 24);
		textLabCarvalho.setBounds(257, 588, 79, 24);
		textShop.setBounds(277, 507, 37, 24);
		
	}

	public void editarJanela() {				
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setSize(819, 670);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.getContentPane().setLayout(null);
		janela.getContentPane().add(progressFome);
		progressFome.setStringPainted(true);
		progressSono.setStringPainted(true);		
		janela.getContentPane().add(progressExperiencia);
		progressExperiencia.setStringPainted(true);
		janela.getContentPane().add(progressSono);			
		janela.getContentPane().add(progressHigiene);	
		janela.getContentPane().add(lNivel);
		janela.getContentPane().add(textFome);
		janela.getContentPane().add(textNivel);
		janela.getContentPane().add(textCash);
		janela.getContentPane().add(textLabCarvalho);
		janela.getContentPane().add(textShop);
		janela.getContentPane().add(textDormir);
		janela.getContentPane().add(textBanho);
		janela.getContentPane().add(textHigiene);
		janela.getContentPane().add(textSono);
		janela.getContentPane().add(textExperiencia);
		janela.getContentPane().add(lMini);
		janela.getContentPane().add(lSala);		
		janela.getContentPane().add(btnComer);
		janela.getContentPane().add(lPokeTwo);
		janela.getContentPane().add(lPokeThree);
		janela.getContentPane().add(lPokeOne);
		janela.getContentPane().add(btnCaptura);
		janela.getContentPane().add(btnTrocaThree);
		janela.getContentPane().add(btnTrocaTwo);
		janela.getContentPane().add(btnTrocaOne);
		janela.getContentPane().add(btnBanho);		
		janela.getContentPane().add(btnDormir);		
		janela.getContentPane().add(btnBrincar);		
		janela.getContentPane().add(btnExplorar);		
		janela.getContentPane().add(btnShop);
		janela.getContentPane().add(grassCandy);
		janela.getContentPane().add(fireCandy);
		janela.getContentPane().add(waterCandy);
		janela.getContentPane().add(electricCandy);
		janela.getContentPane().add(physicCandy);
		janela.getContentPane().add(lFundo);
		
	}
}
