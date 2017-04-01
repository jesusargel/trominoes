package MVC;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Scanner;

import javax.swing.JOptionPane;

import MVC.ButtonListener;
import MVC.SimulationController;
import MVC.AWindowListener;
import MVC.Can;

@SuppressWarnings("serial")
public class SimulationView extends Frame 
{
	private Can[][] myCanvas;
	private Panel myGameBoardPanel;
	private Label myTitle;
	private ButtonListener mySolvePuzzleListener;
	private Button myButtonSolvePuzzle;
	private ButtonListener myWipePuzzleListener;
	private Button myWipePuzzle;
	private ButtonListener myResetListener;
	private Button myResetPuzzle;
	private Image myBlankImage;
	private Image myMainImage;
	private Image my1Image;
	private Image my2Image;
	private Image my3Image;
	private Image my4Image;
	private Image my5Image;
	private Image my6Image;
	private Image my7Image;
	private Image my8Image;
	private Image my9Image;
	private Image my10Image;
	private Image my11Image;
	private Image my12Image;
	private Image my13Image;
	private Image my14Image;
	private Image my15Image;
	private int mySize;
	private int myXcor;
	private int myYcor;
	
	private SimulationController myController;
	
	public SimulationView(SimulationController controller)
	{
		myController = controller;
		this.setSize(800,700);
		this.setLayout(null);
		this.setResizable(false);
		this.setBackground(Color.pink);
		
		this.associateListeners(controller);
		
		getInfo();
		
		myBlankImage = Toolkit.getDefaultToolkit().getImage("images/blank.png");
		myMainImage = Toolkit.getDefaultToolkit().getImage("images/black.png");
		my1Image = Toolkit.getDefaultToolkit().getImage("images/blue.png");
		my2Image = Toolkit.getDefaultToolkit().getImage("images/red.png");
		my3Image = Toolkit.getDefaultToolkit().getImage("images/yellow.jpg");
		my4Image = Toolkit.getDefaultToolkit().getImage("images/orange.png");
		my5Image = Toolkit.getDefaultToolkit().getImage("images/purple.jpg");
		my6Image = Toolkit.getDefaultToolkit().getImage("images/green.jpg");
		my7Image = Toolkit.getDefaultToolkit().getImage("images/brown.png");
		my8Image = Toolkit.getDefaultToolkit().getImage("images/cyan.png");
		my9Image = Toolkit.getDefaultToolkit().getImage("images/magenta.jpg");
		my10Image = Toolkit.getDefaultToolkit().getImage("images/violet.png");
		my11Image = Toolkit.getDefaultToolkit().getImage("images/azul.jpg");
		my12Image = Toolkit.getDefaultToolkit().getImage("images/salmon.jpg");
		my13Image = Toolkit.getDefaultToolkit().getImage("images/lavender.png");
		my14Image = Toolkit.getDefaultToolkit().getImage("images/violet.png");
		my15Image = Toolkit.getDefaultToolkit().getImage("images/beige.jpg");
		
		
		myTitle = new Label("TROMI");
		myTitle.setFont(new Font("Courier New", Font.ITALIC, 48));
		myTitle.setSize(300, 70);
		myTitle.setLocation(330,10);
		
		
		myWipePuzzle = new Button("Wipe");
		myWipePuzzle.setSize(100,50);
		myWipePuzzle.setLocation(75, 650);
		myWipePuzzle.addMouseListener(myWipePuzzleListener);
		
		myButtonSolvePuzzle = new Button("Solve");
		myButtonSolvePuzzle.setSize(100,50);
		myButtonSolvePuzzle.setLocation(350,650); 
		myButtonSolvePuzzle.addMouseListener(mySolvePuzzleListener);
		
		myResetPuzzle = new Button("Reset");
		myResetPuzzle.setSize(100,50);
		myResetPuzzle.setLocation(600, 650);
		myResetPuzzle.addMouseListener(myResetListener);
		
		myCanvas = new Can[mySize][mySize];
		myGameBoardPanel = new Panel(new GridLayout(mySize,mySize));
		
		myGameBoardPanel.setSize(560,500);
		myGameBoardPanel.setLocation(100,100);
		for(int i = 0; i < mySize; i++)
		{
			for(int j = 0; j <mySize; j++)
			{
				if(i == myXcor && j == myYcor){
					myCanvas[i][j] = new Can(myMainImage);
				}
				else
				{
					myCanvas[i][j] = new Can(myBlankImage);
				}
				myGameBoardPanel.add(myCanvas[i][j]);
			}
		}	
		
		
		this.add(myTitle);
		this.add(myGameBoardPanel);
		this.add(myButtonSolvePuzzle);
		this.add(myWipePuzzle);
		this.add(myResetPuzzle);
		this.setVisible(true);
		this.addWindowListener(new AWindowListener());
		
	}
	
	public void associateListeners(SimulationController controller)
    {
		Class<? extends SimulationController> controllerClass;
        Method solveMethod,  wipeMethod, resetMethod;
        
        solveMethod = null;
        wipeMethod = null;
        resetMethod = null;
        
        controllerClass = controller.getClass();
        
        try
        {
           solveMethod = controllerClass.getMethod("solve",(Class<?>[])null); 
           wipeMethod = controllerClass.getMethod("wipe",(Class<?>[])null);
           resetMethod = controllerClass.getMethod("reset",(Class<?>[])null);
        }
        catch(NoSuchMethodException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        catch(SecurityException exception)
        {
           String error;

           error = exception.toString();
           System.out.println(error);
        }
        
        mySolvePuzzleListener = new ButtonListener(controller, solveMethod, null);
        myWipePuzzleListener = new ButtonListener(controller, wipeMethod, null);
        myResetListener = new ButtonListener(controller, resetMethod, null);
    }
	
	
	public int getMySize() {
		return mySize;
	}

	public int getMyXcor() {
		return myXcor;
	}

	public int getMyYcor() {
		return myYcor;
	}

	public void getInfo() {
		mySize = Integer.parseInt(JOptionPane.showInputDialog("Select dimensions for your board: 2, 4, 8, 16..."));
		myXcor = Integer.parseInt(JOptionPane.showInputDialog("X-cordinate for initial square: "));
		myYcor = Integer.parseInt(JOptionPane.showInputDialog("Y-cordintate for intial square: "));
	}
	
	public void changeImage(int x, int y) {
		if (myController.getGrid()[x][y] > 0) {
			if(myController.getGrid()[x][y] % 15 == 1)
			{
				myCanvas[x][y].setImage(my1Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 2){
				myCanvas[x][y].setImage(my2Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 3){
				myCanvas[x][y].setImage(my3Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 4){
				myCanvas[x][y].setImage(my4Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 5){
				myCanvas[x][y].setImage(my5Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 6){
				myCanvas[x][y].setImage(my6Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 7){
				myCanvas[x][y].setImage(my7Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 8){
				myCanvas[x][y].setImage(my8Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 9){
				myCanvas[x][y].setImage(my9Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 10){
				myCanvas[x][y].setImage(my10Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 11){
				myCanvas[x][y].setImage(my11Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 12){
				myCanvas[x][y].setImage(my12Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 13){
				myCanvas[x][y].setImage(my13Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 14){
				myCanvas[x][y].setImage(my14Image);
			}
			else if(myController.getGrid()[x][y] % 15 == 0){
				myCanvas[x][y].setImage(my15Image);
			}
		}
	}
	
	public void wipeImage(int x, int y){	
		myCanvas[x][y].setImage(myBlankImage);
	}
}
