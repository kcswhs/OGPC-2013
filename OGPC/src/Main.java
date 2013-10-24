import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main
{
	static Main ex;
	JFrame frame = new JFrame();
	DisplayPanel canvas;
	
	public Main() 
	{
        initUI();
    }

    private void initUI() 
    {
    	frame.setUndecorated(true);
    	frame.setVisible(true);
        frame.setTitle("Dehk");
        
        canvas = new DisplayPanel(frame);
        frame.add(canvas);
        //setFocusable(true);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
    }
    
    public void HIT_THE_BUTTON()
    {
    	frame.dispose();
    }
    
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() 
		{
            public void run()
            {
            	ex = new Main();
            }
        });
	}
}
