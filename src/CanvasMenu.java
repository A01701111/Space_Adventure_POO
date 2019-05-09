import java.awt.*;

public class CanvasMenu extends Canvas{
    private String text;


    public CanvasMenu(String text) {
        super();
        this.text = text;
    }


    public void paint(Graphics g) {
        Font fuente = new Font("SANS_SERIF", Font.BOLD, 72);
        g.setFont(fuente);
        g.setColor(Color.BLACK);
        this.setBackground(Color.BLACK);
        FontMetrics metrics = g.getFontMetrics(fuente);
        int x = (1600 - metrics.stringWidth(text)) / 2;
        int y = (((950 - metrics.getHeight()) / 2) + metrics.getAscent()) - 60;
        System.out.println(x + "\n" + y);
        System.out.println("width " + metrics.stringWidth(text));
        System.out.println("height " + metrics.getHeight());
        g.setColor(Color.BLUE);
        g.drawString(text, x, y);

    }
}