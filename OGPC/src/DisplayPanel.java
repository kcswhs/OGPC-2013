import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DisplayPanel extends JPanel implements MouseListener, KeyListener
{
	private Image Wall;
    private Image Block;
    private Player p1;
    private boolean drawing;
    //GeneralPath path;
    ArrayList<Point> points;
    ArrayList<Point> pointsTest;
    Timer t = new Timer();
	
	public DisplayPanel()
	{
		points = new ArrayList<Point>();
		pointsTest = new ArrayList<Point>();
		p1 = new Player();
		drawing = false;
		//path = null;
		loadImage();
        setSurfaceSize();
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        t.schedule(new TimerTask() 
        {
            public void run() 
            {
            	if (drawing)
            		updatePointsTest();
                repaint();
            }
        }, 10, 10);
	}
	
	public void loadImage()
	{
		Block = new ImageIcon("data/Block.png").getImage();
        Wall = new ImageIcon("data/Wall.png").getImage();
	}
	
	public void setSurfaceSize()
	{
		Dimension d = new Dimension();
        d.width = 600;
        d.height = 400;
        setPreferredSize(d); 
	}
	
	public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        p1.drawPlayer(g);
        
        if (drawing)
        	g.drawLine(pointsTest.get(0).x, pointsTest.get(0).y, pointsTest.get(1).x, pointsTest.get(1).y);
        
        for (int i = 1; i < points.size(); i  = i + 2)
        {
        	g.drawLine(points.get(i-1).x, points.get(i-1).y, points.get(i).x, points.get(i).y);
        }
        
        /*Graphics2D g2d = (Graphics2D) g;
          if (path != null) 
          {
            g2d.draw(path);
          }*/
        
    }
	
	public void updatePointsTest()
	{
		if (pointsTest.size() == 2)
			pointsTest.remove(pointsTest.size() - 1);
		
		PointerInfo p = MouseInfo.getPointerInfo();
        Point point = new Point(p.getLocation());
        SwingUtilities.convertPointFromScreen(point, this);
        pointsTest.add(point);
        
	}

	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
		{
			points.remove(points.size() - 1);
			points.remove(points.size() - 1);
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			p1.movePlayer(0, -p1.moveDistance);
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			p1.movePlayer(0, p1.moveDistance);
		}
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			p1.movePlayer(-p1.moveDistance, 0);
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			p1.movePlayer(p1.moveDistance, 0);
		}
	}

	public void keyReleased(KeyEvent e)
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}

	public void mouseClicked(MouseEvent e) 
	{
		/*PointerInfo p = MouseInfo.getPointerInfo();
        Point point = new Point(p.getLocation());
        SwingUtilities.convertPointFromScreen(point, this);
        points.add(p1.updatePoint());
        points.add(point);
        /*if (p1.onPlayer(point) && !drawing)
        {
        	points.add(point);
        	drawing = true;
        }
        else if (drawing)
        	points.add(point);*/
        /*for (int i = 0; i < points.size(); i++)
        {
        	System.out.println(points.get(i));
        	System.out.println(points.size());
        }*/
		
		/*PointerInfo p = MouseInfo.getPointerInfo();
        Point point = new Point(p.getLocation());
        SwingUtilities.convertPointFromScreen(point, this);
        if (!drawing && point.x > 40 && point.x < 80 && point.y > 320 && point.y < 360) 
        {
            path = new GeneralPath();
            path.moveTo(point.x, point.y);
            drawing = true;
        } 
        else if (drawing && drawPower <= 0)
        {
            path.lineTo(point.x, point.y);
        }*/
	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		PointerInfo p = MouseInfo.getPointerInfo();
        Point point = new Point(p.getLocation());
        SwingUtilities.convertPointFromScreen(point, this);
        if (p1.onPlayer(point))
        {
	        pointsTest.add(point);
	        drawing = true;
	        points.add(point);
        }
	}

	public void mouseReleased(MouseEvent e) 
	{
		if (drawing)
		{
			PointerInfo p = MouseInfo.getPointerInfo();
	        Point point = new Point(p.getLocation());
	        SwingUtilities.convertPointFromScreen(point, this);
	        points.add(point);
	        drawing = false;
	        pointsTest.clear();
		}
	}
}
