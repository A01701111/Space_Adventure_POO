import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class MyCanvas extends Canvas implements ActionListener, KeyListener {

	private Enemies enemies;
    private Nave nave;
    private Timer updateT, timer;
    private BufferedImage imagen;
    private int counter = 0, lineNum = 3, speed;
    private int y;

    public MyCanvas() {
        super();
        this.setBackground(Color.BLACK);
        imagen = new BufferedImage(1800, 980, BufferedImage.TYPE_INT_RGB);
        enemies = new Enemies();
        speed = 20;
        nave = new Nave(600, 750, new Misil(600, 750));
        generateLevel(1);
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    public void generateLevel(int level) {
        switch (level) {
            case 1:
                timer = new Timer(130000, this);
                updateT = new Timer(speed, this);
                updateT.start();
                timer.start();
                timer.restart();
                y = 0;
                counter = 0;
                lineNum = 3;
                speed -= 5;
                while (counter < lineNum) {

                    enemies.addEnemy(1800, y);
                    counter++;
                    y -= 160;
                    System.out.println(counter);
                }
                break;
            case 2:
                timer = new Timer(4000, this);
                updateT = new Timer(speed, this);
                updateT.start();
                timer.restart();
                y = 0;
                counter = 0;
                lineNum = 4;
                speed = 15;
                while (counter < lineNum) {

                    enemies.addEnemy(1800, y);
                    counter++;
                    y -= 160;
                    System.out.println(counter);
                }
                break;
            case 3:
                timer = new Timer(4000, this);
                updateT = new Timer(speed, this);
                updateT.start();
                timer.restart();
                y = 0;
                counter = 0;
                lineNum = 5;
                speed = 22;
                while (counter < lineNum) {

                    enemies.addEnemy(1800, y);
                    counter++;
                    y -= 160;
                    System.out.println(counter);
                }
        }
    }

    public void paint(Graphics graphics) {
        Graphics gra = imagen.createGraphics();
        gra.setColor(Color.black);
        gra.fillRect(0, 0, 1800, 980);
        enemies.paint(gra);
        nave.paint(gra);
        graphics.drawImage(imagen, 0, 0, null);
        
    }

    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enemies.moveEnemies();
        nave.getMisil().move();

        if(enemies != null) {
            enemies.collision(nave.getMisil());
        }
        if (enemies.end()){
            timer.stop();
        }
        repaint();
        System.out.println(enemies.score+'w');
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent tecla) {
        int oprimida;
        oprimida=tecla.getKeyCode();
        System.out.println(oprimida);

        if(oprimida!=32) {

            nave.move(oprimida, 1800);

        }

        //Disparar bala con tecla espacio
        if(oprimida==32) {
            nave.getMisil().setPosX(nave.getPosX() + nave.getHeight()/2);
            nave.getMisil().setPosY(nave.getPosY() + nave.getHeight()/2);

            //activa la bala
            nave.getMisil().setActiva(true);

            //eventos del timer
        }
        this.repaint();

    }

    public int returnScore(){
        System.out.println(enemies.score+"pene");
        return enemies.getScore();
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}