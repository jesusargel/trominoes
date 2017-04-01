package MVC;
/**
 * Window events
 *
 * @author Jesus Argel
 * @version 1.0 (29 October 2016)
 */
import java.awt.event.*;

public class AWindowListener extends WindowAdapter
{

    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
    