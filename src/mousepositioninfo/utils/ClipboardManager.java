
package mousepositioninfo.utils;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>TWTribalWars</h1>
 * <h3>Class Clipboard</h3> 
 * <p>Created: 12 Ιουν 2015, 12:57:17 μμ</p>
 *
 * <p>Copyright © 2015 | RiflemanSD | All right reserved</p>
 *
 * @author RiflemanSD
 */
public class ClipboardManager
{
    public static void copy(String text)
    {
        Clipboard clipboard = getSystemClipboard();

        clipboard.setContents(new StringSelection(text), null);
    }

    public static void paste() throws AWTException
    {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }

    public static String get() 
    {
        try {
            Clipboard systemClipboard = getSystemClipboard();
            
            //System.out.println(Arrays.toString(systemClipboard.getAvailableDataFlavors()));
            Object text = systemClipboard.getData(DataFlavor.stringFlavor);
            
            return (String) text;
        } catch (UnsupportedFlavorException ex) {
            Logger.getLogger(ClipboardManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClipboardManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClipboardManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    private static Clipboard getSystemClipboard()
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

        return systemClipboard;
    }
}
