import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    private MyCanvas canvas;
    private JLabel scoreLabel;

    public MyWindow() {
        super("Space Adventure");
        setLayout(new BorderLayout());
        setSize(1800, 980);
        setLocationRelativeTo(null);
        canvas = new MyCanvas();
        this.add(canvas);
        scoreLabel = new JLabel();
        scoreLabel.setForeground(Color.red);
        scoreLabel.setText(canvas.returnScore() +   " Hola");
        this.add(scoreLabel, BorderLayout.SOUTH);


    }

    public MyCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }
}