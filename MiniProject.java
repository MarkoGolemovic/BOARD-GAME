/*

 * ISTE-121 Comp.Prob.Solv.II

 * prof.Ante Poljicak

 *

 * Mini Project -> Game

 *

 * Group: Purica

 * Made by: Golemovic Marko, Kovacevic Nikica

 */

//imports
import java.awt.*;

import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;

//main class MiniProject
public class MiniProject extends JFrame implements ActionListener{

	//menu items
  	private JMenu menuGame, menuAbout, titleText, player1title, player2title;
  	private JMenuItem itemRestart, itemExit, itemHow, itemAbout;
  
  	//main panel which will contain everything 
    JPanel mainPanel = new JPanel();

    //buttons
    XOButton buttons[][] = new XOButton[8][8];
    XOButton player[][] = new XOButton[8][8];

    //player record nr.
    int recordP1[][] = new int[8][8];
    int recordP2[][] = new int[8][8];

//    ArrayList<Integer> xRowChicken = new ArrayList<>();
//    ArrayList<Integer> xColChicken = new ArrayList<>();
//    ArrayList<Integer> xRowEag = new ArrayList<>();
//    ArrayList<Integer> xColEag = new ArrayList<>();

  	//counters for players
    int puricaCounter = 0;
    int mlinacCounter = 0;

    //checking for winner
    boolean stateOfGamePurica = false;
    boolean stateOfGameMlinac = false;

    //counters for winner and global counter
    int value;
    int counterWinner = 0;
    int counter = 0;

    //main method
    public static void main(String[] args) {

        MiniProject miniProject = new MiniProject();

    }//end main method

    //constructor
    public MiniProject() {

    	//setting title 
		super("Mini Project");

		//switch value
		value = 0;

		//menu and menu items 
		JMenuBar menuBar = new JMenuBar();

		//add menu to the frame
		add(menuBar);

		//Menu game + shortcuts,mnemonics -> left of the title
		menuGame = new JMenu("Game");
		menuGame.setMnemonic('g');

		//restart menu item
		itemRestart = new JMenuItem("Restart game");
		itemRestart.setMnemonic('r');

		//exit menu item
		itemExit = new JMenuItem("Exit");
		itemExit.setMnemonic('e');

		//add items to the JMenu game
		menuGame.add(itemRestart);
		menuGame.add(itemExit);

		//Menu about -> right of the title
		menuAbout = new JMenu("About");
		menuAbout.setMnemonic('a');

		//menu items for about
		itemAbout = new JMenuItem("About this app");
		itemAbout.setMnemonic('a');

		//how to play item in about
		itemHow = new JMenuItem("How to play?");
		itemHow.setMnemonic('h');

		//adding items to about menu
		menuAbout.add(itemHow);
		menuAbout.add(itemAbout);

		//title with GIF's which are the players player
		titleText = new JMenu("<html>  <font color=#0000;font size='20';><b>PURICA </b>"

				+ "<font color=#0000;font size='20';><b>Z'</b> "

				+ "<font color=#0000;font size='20';><b>MLINCIMA</b></html>");

		player1title = new JMenu();

		player2title = new JMenu();	

		//GIF's for player (chicken and dumplings-mlinci)
		player1title.setIcon(new ImageIcon("purica.gif"));
		player2title.setIcon(new ImageIcon("mlinac.gif"));

		//add menu to the MenuBar
		menuBar.add(player1title);
		menuBar.add(menuGame);
		menuBar.add(titleText);
		menuBar.add(menuAbout);
		menuBar.add(player2title);

		//frame configuration
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanel.setLayout(new GridLayout(8, 8));

        //loop for 64 buttons
        //i being x and j being y in a graph
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	
                recordP1[i][j] = 0;
                recordP2[i][j] = 0;
                buttons[i][j] = new XOButton(i, j);
                mainPanel.add(buttons[i][j]);  
                //setting the size because of the flow layout which 
                //would make buttons smaller than they should be upon first click
                (buttons[i][j]).setPreferredSize(new Dimension(70, 70));
                
            }
        }//end for
                
        //more frame adjustments and adding the main panel to it
		setLayout(new FlowLayout());
		add(mainPanel);
		setVisible(true);

		//adding actionListener to the menu items
		itemRestart.addActionListener(this);
		itemHow.addActionListener(this);
		itemAbout.addActionListener(this);
		itemExit.addActionListener(this);

    }//end main constructor

	 //action performed for menu items
	 public void actionPerformed(ActionEvent ae){
		 //choice object for menu items
		 Object choice = ae.getSource();
		 
		//restart the application if item restart is pressed
		 if(choice==itemRestart){
			 	dispose();
		        MiniProject game = new MiniProject();
		        game.setVisible(true);
		        
	      // terminate the program and ask a option dialogue before exiting
	      }else if(choice==itemExit){

	    	int exit =  JOptionPane.showOptionDialog(null, 

	    	            "Are you sure you want to exit purica ?", 

	    	            "Was it enough allready?", 

	    	            JOptionPane.OK_CANCEL_OPTION, 

	    	            JOptionPane.INFORMATION_MESSAGE, 

	    	            null, 

	    	            new String[]{"Yes it's boring..", "Cancel, it's awesome!"},

	    	            "");

	    	//ok to exit the program and cancel to do go back
	    	 if(exit == JOptionPane.OK_OPTION) {
	    	 System.exit(0);}

	      //option pane for item How to show how to play the game information
	      }else if(choice==itemHow){

	    	  JOptionPane.showMessageDialog(null, 

	    			  " First you need a friend. Or pretend you have one since it's a 2 player game. \n"

	    			  + "..then you will need some chickens, and some mlinci And finally you will play! \n"
	    			  
	    			  + "\n"

	    			  + "This is a connection game (connecting buttons), in which one \n"

	    			  + "of the players will win if he is faster than the other player\n"

	    			  + "in connecting 4 images/buttons in a row or 4 images close together\n"
	    			  
	    			  + "horizontal, vertical and diagonal connections are allowed, so all directions!\n"
	    			  
	    			  + "\n"
	    			  
	    			  + "---> The first player is Purica and by clicking first on a button will show a gif A\n"
	    			  
	    			  + "---> The second player is Mlinac and by clicking second on a button will show a gif B\n"
	    			  
	    			  + " \n"
	    			  
	    			  + "The game board consits of 64 pieces and the game is played by turns where \n"
	    			  
	    			  + "each player has one turn to decide where he will put his chichken/mlinac by \n "
	    			  
	    			  + "clicking on a button from any of the 64 pieces except those allready taken!\n"
	    			
	    			  + "\n"

	    			  + "<><><><><><><><> Let the games begin! <><><><><><><><> ");
	      //option pane for item about to show more information about the app
	      }else if(choice==itemAbout){

	    	  //showing option pane about the authors
	    	  JOptionPane.showMessageDialog(null, "Made by: Marko Golemovic & Nikica Kovacevic \n"

	    	  		+ "Group name: PURICA \n"

	    	  		+ "ISTE-121 Comp.Prob.Solv.II \n"

	    	  		+ "prof. Ante Poljicak \n"

	    	  		+ "Assignment: MiniProject - Game");

	      }//end of if/else
	 }//end actionPerformed

    //inner class
    class XOButton extends JButton implements ActionListener {
    	//x,y
        int row, col;
        //images
        ImageIcon purica, mlinci;

        //inner constructor with row, col param
        public XOButton(int row, int col) {

            this.row = row;
            this.col = col;
            
            //setting the image
            purica = new ImageIcon(this.getClass().getResource("purica.gif"));
			mlinci = new ImageIcon(this.getClass().getResource("mlinac.gif"));

            //add listener to the buttons
            this.addActionListener(this);

        }//end inner constructor

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        //action performed
        public void actionPerformed(ActionEvent ae) {
        	
            //increment value upon click
            value++;

//            System.out.println("row: " + getRow() + "\ncol: " + getCol());
//            System.out.println("STATE P1: " + recordP1[row][col]);
//            System.out.println("STATE P2: " + recordP2[row][col]);

            //bringing it back to zero after reaching
            switch (value % 2) {
            
            //zero(first) case with setting the icon to mlinac
                case 0:
                	
                    setIcon(mlinci);

                    //xRowChicken.add(row);
                    //xColChicken.add(col);

                    removeActionListener(this);

                    recordP2[row][col] = -1;

                    //System.out.println("STATE P2A: " + recordP2[row][col]);

                    chheckWinnerDownP2();

                    endingGameJaje(stateOfGameMlinac);

                    //System.out.println(chheckWinnerDownP2());

                    break;

                //second case set it to purica
                case 1:

                    setIcon(purica);

                    removeActionListener(this);

                    recordP1[row][col] = 1;

                    //System.out.println("STATE P1A: " + recordP1[row][col]);

                    chheckWinnerDownP1();

                    endingGamePurica(stateOfGamePurica);

                    //System.out.println(chheckWinnerDownP1());
                    
                    //xRowEag.add(row);
                    //xRowEag.add(col);
                    
                    break;

                //third to disable
                case 2:

                    setDisabledIcon(purica);

                    setEnabled(false);

                    break;

            }
            //prtinting and checking
            System.out.println("purica" + puricaCounter);
            System.out.println("mlinac" + mlinacCounter);
            System.out.println(stateOfGamePurica);

            //chheckWinnerDown();

        }//end actionPerformed
        
        /**
         * Purica Check
         * 
         * Idea   is to create 2 d array of recordP1[i][j]=1;
         * i represent row
         * j represent column
         * 
         * IDEA VAS TO ITERATE by using  double nested for loop
         * FIRST  --> BY ROW
         * SECOND --> BY COLLUM
         * THIRD  --> BY LEFT TO RIGHT DIAGONAL
         * FOURT  --> BY RIGHT TO LEFT DIAGONAL
         *
         * The problem is that algorithm is not setup properly
         * 
         * Problem:
         * 1. We do not know how, but local variable in side of method did not
         * 2. understanding right to left diagonal
         * 3. winner search
         *
         * @return stateOfGamePurica
         */
        public boolean chheckWinnerDownP1() {

            //puricaCounter++;
            for (int i = 0; i < recordP1.length - 1; i++) {

                for (int j = 0; j < recordP1.length - 1; j++) {

                    if (recordP1[i][j] == 1 && recordP1[i][j + 1] == 1) {

                        puricaCounter++;

                        //System.out.println("purica"+puricaCounter);

                        if (puricaCounter >= 4) {

                            stateOfGamePurica = true;

                        }//else  if (puricaCounter)
                    }//checking condition
                }
            }

            for (int i = 0; i < recordP1.length - 1; i++) {

                for (int j = 0; j < recordP1.length - 1; j++) {

                    if (recordP1[i][j] == 1 && recordP1[i+1][j] == 1) {

                        puricaCounter++;

                        //System.out.println("purica"+puricaCounter);

                        if (puricaCounter >= 4) {

                            stateOfGamePurica = true;

                        }//else  if (puricaCounter)

                    }//checking condition
                }
            }

            for (int i = 0; i < recordP1.length - 1; i++) {

                for (int j = 0; j < recordP1.length - 1; j++) {

                    if (recordP1[i][j] == 1 && recordP1[i+1][j+1] == 1) {

                        puricaCounter++;

                        //System.out.println("purica"+puricaCounter);

                        if (puricaCounter >= 4) {

                            stateOfGamePurica = true;

                        }//else  if (puricaCounter)
                    }//checking condition
                }
            }
            return stateOfGamePurica;

        }


        /**
         * Mlinac Check
         * 
         * Idea   is to create 2 d array of recordP1[i][j]=-1;
         * i represent row
         * j represent column
         * 
         * IDEA VAS TO ITERATE by using  double nested for loop
         * FIRST  --> BY ROW
         * SECOND --> BY COLLUM
         * THIRD  --> BY LEFT TO RIGHT DIAGONAL
         * FOURT  --> BY RIGHT TO LEFT DIAGONAL
         * 
         * The problem is that algorithm is not setup properly
         * 
         * Problem:
         * 1. We do not know how, but local variable in side of method did not
         * 2. understanding right to left diagonal
         * 3. winner search
         *
         * @return stateOfGameMlinac
         */

        public boolean chheckWinnerDownP2() {

            //boolean stateOffGame = false;
        
            for (int i = 0; i < recordP2.length - 1; i++) {

                for (int j = 0; j < recordP2.length - 1; j++) {

                    if (recordP2[i][j] == -1 && recordP2[i][j + 1] == -1) {

                        mlinacCounter++;

                        //System.out.println("jaje"+mlinacCounter);

                        if (mlinacCounter >= 4) {

                            stateOfGameMlinac = true;

                        }
                    }
                }
            }

            for (int i = 0; i < recordP2.length - 1; i++) {

                for (int j = 0; j < recordP2.length - 1; j++) {

                    if (recordP2[i][j] == -1 && recordP2[i+1][j] == -1) {

                        mlinacCounter++;

                        //System.out.println("jaje"+mlinacCounter);

                        if (mlinacCounter >= 4) {

                            stateOfGameMlinac = true;

                        }
                    }
                }
            }


            for (int i = 0; i < recordP2.length - 1; i++) {

                for (int j = 0; j < recordP2.length - 1; j++) {

                    if (recordP2[i][j] == -1 && recordP2[i+1][j+1] == -1) {


                        mlinacCounter++;

                        //System.out.println("jaje"+mlinacCounter);

                        if (mlinacCounter >= 4) {

                            stateOfGameMlinac = true;

                        }
                    }
                }
            }    
            return stateOfGameMlinac;

        }



        public void endingGamePurica(boolean stateOfGamePurica) {

            if (stateOfGamePurica == true) {
            	
                //option pane to show the winner and ask a dialog
                //if you want to play another game or go back to the screen
                //if you chose to go back, then you can restart via Menu
            	
                int exit =  JOptionPane.showOptionDialog(null, 

		    	            "The winner is Purica! \n Play another game?",
		    	            "WINNER ANNOUNCMENT", 
		    	            JOptionPane.OK_CANCEL_OPTION, 
		    	            JOptionPane.INFORMATION_MESSAGE, 
		    	            null, 
		    	            new String[]{"LET'S PLAY", "Cancel"},
		    	            "");

		    	//ok to restart the program and cancel to do go back
		    	 if(exit == JOptionPane.OK_OPTION) {

		    	 	dispose();
			        MiniProject game = new MiniProject();
			        game.setVisible(true);}

            }

        }


        public void endingGameJaje(boolean stateOfGameMlinac) {

            if (stateOfGameMlinac == true) {

                //option pane to show the winner and ask a dialog
                //if you want to play another game or go back to the screen
                //if you chose to go back, then you can restart via Menu

                int exit =  JOptionPane.showOptionDialog(null, 

		    	            "The winner is Mlinac! \n Play another game?", 
		    	            "WINNER ANNOUNCMENT", 
		    	            JOptionPane.OK_CANCEL_OPTION, 
		    	            JOptionPane.INFORMATION_MESSAGE, 
		    	            null, 
		    	            new String[]{"LET'S PLAY", "Cancel"},

		    	            "");

		    	//ok to restart the program and cancel to do go back

		    	 if(exit == JOptionPane.OK_OPTION) {

		    	 	dispose();
			        MiniProject game = new MiniProject();
			        game.setVisible(true);}

            }

        }

    }//enc class XOButtons

}//end class MiniProject