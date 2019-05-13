import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private int width,height, speed, posX,posY;
    private boolean alive;
    private Color color;
    private BufferedImage img;

    public Enemy(int posX, int posY) {
        String srcName= "C:\\Tec\\Java\\A01701111_JAVA\\bloques_bajando\\malo1.png";
        File srcFile = new File (srcName);
        try {
            img = ImageIO.read(srcFile);
        }catch(IOException e) {
            e.printStackTrace();
        }
        this.alive= true;
        this.posX = posX;
        this.posY = posY;
        this.width = 80;
        this.height = 80;
        this.speed = 10;
        this.color = new Color(22, 183, 46);
    }

    public Enemy() {
        this.width = 80;
        this.height = 80;
        this.speed = 10;
        this.color = new Color(22, 183, 46);
    }
    public void paint(Graphics graphics){
        graphics.setColor(color);
        if (alive){
        graphics.drawImage(img, posX, posY, width,height, null);}

        //graphics.fillRect(posX,posY,width,height);
    }

    public void death(int flag){
        if(flag==1){
            alive = false;
        }
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}