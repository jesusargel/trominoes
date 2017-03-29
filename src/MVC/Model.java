package MVC;
import java.util.*;

public class Model {
	
	private int myX_board;
	private int myY_board;
	private int myX_missing;
	private int myY_missing;
	private int myBoard_size;
	
	public Model(int x_board, int y_board, int x_missing, int y_missing, int board_size)
	{
		myX_board = x_board;
		myY_board = y_board;
		myX_missing = x_missing;
		myY_missing = y_missing;
		myBoard_size = board_size;
	}

}
