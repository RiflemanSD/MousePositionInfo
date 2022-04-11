
package mousepositioninfo;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>TWTribalWars</h1>
 * <h3>Class ScheduledTask</h3> 
 * <p>Created: 21 Μαϊ 2015, 10:29:28 μμ</p>
 *
 * <p>Copyright © 2015 | RiflemanSD | All right reserved</p>
 *
 * @author RiflemanSD
 */
public class ScheduledTask extends TimerTask {
    private MousePositionInfo mpi;
    
    public ScheduledTask(MousePositionInfo mpi) {
        this.mpi = mpi;
    }
	
    // Add your task here
    public void run() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        
        int x = (int) b.getX();
        int y = (int) b.getY();
        
        mpi.fillXY(x, y);
        
        if (mpi.color) {
            x = mpi.getXY()[0];
            y = mpi.getXY()[1];
        }
        //System.out.println(x + ", " + y);
        
        Robot r;
        try {
            r = new Robot();
            
            Color c = r.getPixelColor(x, y);
            //System.out.println(c);
            //System.out.println(r.getPixelColor(500, 500));
            
            int blue = c.getBlue();
            int green = c.getGreen();
            int red = c.getRed();
            
            mpi.fillColor(red, green, blue);
            
        } catch (AWTException ex) {
            Logger.getLogger(ScheduledTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}