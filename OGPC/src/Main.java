import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame
{
	DisplayPanel canvas = new DisplayPanel();
	
	public Main() 
	{
        initUI();
    }

    private void initUI() 
    {
        setTitle("Dehk");

        add(canvas);
        //setFocusable(true);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
    }
    
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
            public void run()
            {
            	Main ex = new Main();
            	ex.setVisible(true);
            }
        });
	}
}
