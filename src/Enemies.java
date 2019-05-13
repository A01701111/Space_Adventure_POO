import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Enemies {
    public int score=0;
    protected ArrayList<Enemy> enemies;
    private boolean flag = false;

    public Enemies() {
        enemies = new ArrayList<>(30);
    }

    public void addEnemy(int widthScreen, int y) {

        Enemy enemy;
        for (int i = 60; i < widthScreen - 40; i += 160) {
            enemy = new Enemy(i, y);
            enemies.add(enemy);
            System.out.println(i);
        }

    }

    public void moveEnemies() {
        enemies.forEach((Enemy enemy) -> enemy.setPosY(enemy.getPosY() + 1));
    }

    public void paint(Graphics graphics) {
        enemies.forEach((Enemy enemy) -> enemy.paint(graphics));
    }

    public void collision(Misil misil) {
        int flag = 0;

        ListIterator<Enemy> itr = enemies.listIterator();

        while (itr.hasNext()) {
            Enemy aux = itr.next();
            if (misil.collision(aux)) {
                flag = 1;
                score+=10;
            }
            if (flag == 1) {
                aux.death(flag);


            }
            System.out.println("Score: "+score);

        }


    }

    public boolean end() {
        boolean flag = false;

        ListIterator<Enemy> itr = enemies.listIterator();

        while (itr.hasNext()) {
            Enemy aux = itr.next();
            if (aux.getPosY() >= 750) {
                flag = true;
            }


        }
        return flag;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}