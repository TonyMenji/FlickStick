package menji.game.model;

import android.graphics.Rect;
import menji.game.model.Ball;

public class Sticks {
    public int x, y, width, height;
    private Rect rect;

    public Sticks(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rect( x, y, width, height);
    }

    public void updateRect() {
        rect.set((int) x, (int) y, (int) x + width, (int) y + height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rect getRect() {
        return rect;
    }
}
