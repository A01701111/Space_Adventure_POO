import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.Timer;

public class Misil extends ObjetoMovil implements ActionListener{
    private int speedY;
    private int height, width;
    private Timer clock;
    private boolean activa;
    private Color color;

    public Misil(int posX, int posY) {
        super(posX,posY);
        setColor(Color.BLACK);
        speedY=10;
        height=10;
        width=10;
        setClock(new Timer(10, this));
        activa = false;
    }

    public void paint(Graphics g) {
        if(activa) {

            g.setColor(Color.BLACK);
            g.fillOval(posX, posY, height, width);
        }


    }

    public boolean colision(ArrayList<Enemy> coleccion) {

        ListIterator<Enemy> itr = coleccion.listIterator();
        

        while(itr.hasNext()) {
            Enemy aux = itr.next();
            if(posY == (aux.getPosY() + aux.getWidth()) && (posX == (aux.getPosX()+aux.getHeight())) ){
                return true;
            }
        }
        return false;
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        // TODO Auto-generated method stub

        if(evento.getSource() == clock) {
            if(activa) {
                move();
            }
        }
    }



    public boolean isActiva() {
        return activa;
    }



    public void setActiva(boolean activa) {
        this.activa = activa;
    }



    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
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

    public Timer getClock() {
        return clock;
    }



    public void setClock(Timer clock) {
        this.clock = clock;
    }

    public void move() {
        posY -= speedY;
    }

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}





}