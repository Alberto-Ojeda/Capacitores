package capacitores;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Diagrama extends Canvas implements MouseListener, MouseMotionListener{
private ArrayList rectangles = new ArrayList();
private ArrayList circles = new ArrayList();
private ArrayList shapes = new ArrayList();
public Color color;
public int whidth;
private Path2D shape;
public boolean m_alzada=true,rectangle=false,circle=false;
private int uX,uY,X,Y;

Diagrama(){
    this.color=color.BLACK;
    this.setBackground(color.WHITE);
    this.shape= new Path2D.Float();
    this.shape.moveTo(0, 0);
    this.whidth=5;
    
}
public void paint(Graphics g)
{
    super.paint(g);
    Graphics2D draw=(Graphics2D) g;
/*    for (int i = 0; i < this.rectangles.size(); i++) {
        
    }*/

    draw.setColor(Color.white);
    draw.fillRect(0, 0, this.getWidth(), this.getHeight());
    draw.setStroke(new BasicStroke(this.whidth));
    draw.setColor(this.color);
    draw.draw(this.shape);        }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
if(this.m_alzada) this.shape.moveTo(e.getX(), e.getY());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
this.X=e.getX();
this.Y=e.getY();
if(this.m_alzada) this.shape.lineTo(this.X, this.Y);
repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
