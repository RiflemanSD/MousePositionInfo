
package mousepositioninfo;

import java.util.TimerTask;

/**
 * <h1>MousePositionInfo</h1>
 * <h3>Class TimeTask</h3> 
 * <p>Created: 8 Ιουν 2015, 4:47:06 μμ</p>
 *
 * <p>Copyright © 2015 | RiflemanSD | All right reserved</p>
 *
 * @author RiflemanSD
 */
public class TimeTask extends java.util.TimerTask {
    private MousePositionInfo mpi;
    
    public TimeTask(MousePositionInfo mpi) {
        this.mpi = mpi;
    }
    
    @Override
    public void run() {
        mpi.updateTime();
    }

}
