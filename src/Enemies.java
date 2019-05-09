import java.awt.*;
import java.util.ArrayList;

public class Enemies {
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

    public boolean collision(Misil misil) {
        enemies.forEach((Enemy enemy) -> {
            if () {
            }
            flag = true;


        });
        return flag;
    }
}
