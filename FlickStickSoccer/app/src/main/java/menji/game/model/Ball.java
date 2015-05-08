package menji.game.model;

import android.graphics.Rect;
import menji.flicksticksoccer.GameMainActivity;
import menji.flicksticksoccer.Assets;

public class Ball {

    public int x, y, width, height, velX, velY;
    private Rect rect;

    public Ball(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        velX = 1;
        velY = 1;
        rect = new Rect(x, y, width, height);
    }


    public void left() {
        x -= velX;
        correctYCollisions();
        correctXCollisions();
        updateRect();
        Assets.playSound(Assets.QuietFlickID);
    }

    public void right() {
        x += velX;
        correctYCollisions();
        correctXCollisions();
        updateRect();
        Assets.playSound(Assets.QuietFlickID);
    }

    public void up() {
        y -= velY;
        correctYCollisions();
        correctXCollisions();
        updateRect();
        Assets.playSound(Assets.QuietFlickID);
    }

    public void down() {
        y += velY;
        correctYCollisions();
        correctXCollisions();
        updateRect();
        Assets.playSound(Assets.QuietFlickID);
    }

    public void correctYCollisions() {
        if (y < 0) {
            y = 0;
            //y += velY;
        } else if (y + height > GameMainActivity.GAME_HEIGHT) {
            y = GameMainActivity.GAME_HEIGHT - height;
            //y -= velY;
        } else {
            return;
        }
        //Assets.playSound(Assets.wallHitID);
    }
    public void correctXCollisions() {
        if (x < 0) {
            x = 0;
            //down();
        } else if (x + width > GameMainActivity.GAME_WIDTH) {
            x = GameMainActivity.GAME_WIDTH - width;
            //up();
        } else {
            return;
        }
        //Assets.playSound(Assets.wallHitID);
    }


    private void updateRect() {
            rect.set(x, y, width, height);
    }

    public void setY(int Y) {
        y = Y;
    }

    public void setX(int X) {
        x = X;
    }

    public int getVelY(){
        return velY;
    }

    public int getVelX(){
        return velX;
    }

    public void resetVelX() {
        velX = -velX;
    }

    public void resetVelY() {
        velY = -velY;
    }

    public void reset() {
        x = 390;
        y = 215;
    }

    public void topWall( int dY) {
        for (int i = 0; i < dY; i++) {
            y += velY;
            Assets.playSound(Assets.QuietFlickID);
        }
    }

    public void bottomWall( int dY) {
        for (int i = 0; i < dY; i++) {
            y -= velY;
            Assets.playSound(Assets.QuietFlickID);
        }
    }

    public void rightWall( int dY) {
        for (int i = 0; i < dY; i++) {
            x -= velX;
            Assets.playSound(Assets.QuietFlickID);
        }
    }

    public void leftWall() {
            x += velX;
            Assets.playSound(Assets.QuietFlickID);
    }

    public void pushRight() {
        velX = -velX;
        Assets.playSound(Assets.QuietFlickID);
    }

    public void pushLeft() {
        velX = -velX;
        Assets.playSound(Assets.QuietFlickID);
    }

    public void pushUp() {
        velY = -velY;
        Assets.playSound(Assets.QuietFlickID);
    }

    public void pushDown() {
        velY = -velY;
        Assets.playSound(Assets.QuietFlickID);
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

