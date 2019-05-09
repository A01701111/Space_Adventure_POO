import javax.swing.*;
import java.awt.*;


public class MyWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyCanvas canvas;

    public MyWindow() {
        super("Bloques bajando");
        setSize(1800,980);
        setLocationRelativeTo(null);
        canvas = new MyCanvas();
        this.add(canvas);

    }


}