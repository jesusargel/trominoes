package MVC;

import MVC.SimulationView;

public class SimulationController {

	private SimulationView myView;
	private Model myModel;
	
	public SimulationController(){
		myView = new SimulationView(this);
		myModel = new Model(myView.getMySize(), myView.getMyXcor(), myView.getMyYcor());
	}	
	
	public void wipe(){
		setModel();
		for(int i = 0; i < myView.getMySize(); i++){
			for(int j = 0; j < myView.getMySize(); j++){
				if(myModel.getGrid()[i][j] == 0){
					myView.wipeImage(i, j);
				}
			}
		}
	}
	
	public void solve(){
		setModel();
		myModel.tile();
		for(int i = 0; i < myView.getMySize(); i++){
			for(int j = 0; j < myView.getMySize(); j++){
				if(myModel.getGrid()[i][j] > 0){
					myView.changeImage(i, j);
				}
			}
		}
	}
	
	public void reset(){
		myView = new SimulationView(this);
		myModel = new Model(myView.getMySize(), myView.getMyXcor(), myView.getMyYcor());
	}
	
	public Model getMyModel(){
		return myModel;
	}
	
	public void setModel() {
		myModel = new Model(myView.getMySize(), myView.getMyXcor(), myView.getMyYcor());
	}
	
	public int[][] getGrid() {
		return myModel.getGrid();
	}
}
