/**
 * Write a description of class Click here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.pumaj.PjShape;
import com.pumaj.PjRectangle;
import com.pumaj.PjUtils;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
public class Click extends PjShape
{
    public boolean click = false;
    public Click()
    {
        super();
    }
    public void mousePressed(MouseEvent e) 
    {
        this.setBackground(Color.green);
        click = true;
    }
    public void mouseReleased(MouseEvent e)
    {
        click = false;
    }
    public boolean getClick()
    {
        return this.click;
    }
    public void setClick(boolean click)
    {
        this.click = click;
    }
    
 }     
