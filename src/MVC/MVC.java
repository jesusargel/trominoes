package MVC;

import MVC.SimulationController;
import MVC.MVC;


public class MVC
{
    // Properties
    private SimulationController myController;
    
    // Methods
    public static void main(String[] args)
    {
        new MVC();
    }
    
    public MVC()
    {
        setController(new SimulationController());
    }

	public void setController(SimulationController controller) 
	{
		myController = controller;
	}

	public SimulationController getController() {
		return myController;
	}
}