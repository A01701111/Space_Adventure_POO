import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nave extends ObjetoMovil {
    private int lives, speed, height, width;
    private Misil misil;
    private BufferedImage img;

    public Nave(int posX, int posY, Misil misil2) {
        super(posX, posY);
        lives = 3;
        height = 100;
        width = 100;
        speed = 10;
        misil = new Misil(posX, posY);

        String srcName = "src\\nave.png";
        File srcFile = new File(srcName);
        try {
            setImg(ImageIO.read(srcFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void move(int tecla, int lD) {

        if (tecla == 37) {//left

            if ((posX - speed > 0)) {
                posX -= speed;
            }
        }

        if (tecla == 39) {//right

            if (((posX + speed + width) < lD)) {
                posX += speed;
            }
        }
    }


    public void paint(Graphics graphics) {
        
        graphics.drawImage(img, posX, posY, height, width, null);

        if (misil.isActiva()) {
            misil.paint(graphics);
        }

    }


    public Misil getMisil() {
        return misil;
    }

    public void setMisil(Misil misil) {
        this.misil = misil;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

}