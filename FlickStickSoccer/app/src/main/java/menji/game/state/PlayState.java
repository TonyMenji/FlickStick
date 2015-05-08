package menji.game.state;


import java.util.ArrayList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.os.Handler;
import android.app.Activity;
import java.lang.Math;
import menji.framework.util.Painter;
import menji.flicksticksoccer.Assets;
import menji.game.model.Sticks;
import menji.game.model.Ball;
import menji.flicksticksoccer.GameMainActivity;

public class PlayState extends State {
    private Ball ball;
    private Sticks stick1;
    private Sticks stick2;
    private Sticks stick3;
    private Sticks stick4;
    private Sticks stick5;
    private Sticks stick6;
    private Sticks stick7;
    private Sticks stick8;
    private Sticks stick9;
    private Sticks stick10;
    private Sticks stick11;
    private Sticks stick12;
    private Sticks stick13;
    private Sticks stick14;
    private Sticks stick15;
    private Sticks stick16;
    private Sticks stick17;
    private Sticks stick18;
    private Sticks stick19;
    private Sticks stick20;
    private Sticks stick21;
    private Sticks stick22;
    private int playerScore1 = 0;
    private int playerScore2 = 0;
    int hit1 = 0;
    int hit2 = 0;
    int hit3 = 0;
    int wallhit1 = 0;
    int wallhit2 = 0;

   private Handler h;

    private float recentTouchY;
    private float recentTouchX;

    @Override
    public void init() {

        ball = new Ball (390, 215, 20, 20);
        stick1 = new Sticks (30, 215, 18, 18);
        stick2 = new Sticks (100, 165, 18, 18);
        stick3 = new Sticks (100, 265, 18, 18);
        stick4 = new Sticks (180, 115, 18, 18);
        stick5 = new Sticks (180, 215, 18, 18);
        stick6 = new Sticks (180, 315, 18, 18);
        stick7 = new Sticks (275, 65, 18, 18);
        stick8 = new Sticks (260, 165, 18, 18);
        stick9 = new Sticks (260, 265, 18, 18);
        stick10 = new Sticks (275, 365, 18, 18);
        stick11 = new Sticks (325, 215, 18, 18);

        stick12 = new Sticks (455, 215, 18, 18);
        stick13 = new Sticks (505, 365, 18, 18);
        stick14 = new Sticks (505, 65, 18, 18);
        stick15 = new Sticks (520, 265, 18, 18);
        stick16 = new Sticks (520, 165, 18, 18);
        stick17 = new Sticks (602, 115, 18, 18);
        stick18 = new Sticks (602, 215, 18, 18);
        stick19 = new Sticks (602, 315, 18, 18);
        stick20 = new Sticks (685, 165, 18, 18);
        stick21 = new Sticks (685, 265, 18, 18);
        stick22 = new Sticks (755, 215, 18, 18);
    }


    @Override
    public void update(float delta) {}
    @Override
    public void render(Painter g) {
        g.drawImage(Assets.greenfield, 0, 0);
        g.drawImage(Assets.ball, ball.getX(),ball.getY(), ball.getWidth(), ball.getHeight());
        g.drawImage(Assets.sticks, stick1.getX(),stick1.getY(), stick1.getWidth(), stick1.getHeight());
        g.drawImage(Assets.sticks, stick2.getX(),stick2.getY(), stick2.getWidth(), stick2.getHeight());
        g.drawImage(Assets.sticks, stick3.getX(),stick3.getY(), stick3.getWidth(), stick3.getHeight());
        g.drawImage(Assets.sticks, stick4.getX(),stick4.getY(), stick4.getWidth(), stick4.getHeight());
        g.drawImage(Assets.sticks, stick5.getX(),stick5.getY(), stick5.getWidth(), stick5.getHeight());
        g.drawImage(Assets.sticks, stick6.getX(),stick6.getY(), stick6.getWidth(), stick6.getHeight());
        g.drawImage(Assets.sticks, stick7.getX(),stick7.getY(), stick7.getWidth(), stick7.getHeight());
        g.drawImage(Assets.sticks, stick8.getX(),stick8.getY(), stick8.getWidth(), stick8.getHeight());
        g.drawImage(Assets.sticks, stick9.getX(),stick9.getY(), stick9.getWidth(), stick9.getHeight());
        g.drawImage(Assets.sticks, stick10.getX(),stick10.getY(), stick10.getWidth(), stick10.getHeight());
        g.drawImage(Assets.sticks, stick11.getX(),stick11.getY(), stick11.getWidth(), stick11.getHeight());
        g.drawImage(Assets.sticks, stick12.getX(),stick12.getY(), stick12.getWidth(), stick12.getHeight());
        g.drawImage(Assets.sticks, stick13.getX(),stick13.getY(), stick13.getWidth(), stick13.getHeight());
        g.drawImage(Assets.sticks, stick14.getX(),stick14.getY(), stick14.getWidth(), stick14.getHeight());
        g.drawImage(Assets.sticks, stick15.getX(),stick15.getY(), stick15.getWidth(), stick15.getHeight());
        g.drawImage(Assets.sticks, stick16.getX(),stick16.getY(), stick16.getWidth(), stick16.getHeight());
        g.drawImage(Assets.sticks, stick17.getX(),stick17.getY(), stick17.getWidth(), stick17.getHeight());
        g.drawImage(Assets.sticks, stick18.getX(),stick18.getY(), stick18.getWidth(), stick18.getHeight());
        g.drawImage(Assets.sticks, stick19.getX(),stick19.getY(), stick19.getWidth(), stick19.getHeight());
        g.drawImage(Assets.sticks, stick20.getX(),stick20.getY(), stick20.getWidth(), stick20.getHeight());
        g.drawImage(Assets.sticks, stick21.getX(),stick21.getY(), stick21.getWidth(), stick21.getHeight());
        g.drawImage(Assets.sticks, stick22.getX(),stick22.getY(), stick22.getWidth(), stick22.getHeight());
        renderScore(g, 350, playerScore1);
        renderScore(g, 440, playerScore2);
        g.drawImage(Assets.soccerGoal, 0, 186, 30, 80);
        g.drawImage(Assets.soccerGoal, 773, 186, 30, 80);

    }

    private void renderScore(Painter g, int xLocation, int playerScore) {
        g.setFont(Typeface.SANS_SERIF, 25);
        g.setColor(Color.GRAY);
        g.drawString("" + playerScore, xLocation, 30);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        int random = (int) (Math.random()* 401);
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            recentTouchY = scaledY;
            recentTouchX = scaledX;
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            if (scaledY - recentTouchY < -50 && scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.up();
                    ball.right();
                    ball.correctYCollisions();
                    ball.correctXCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i = random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushDown();
                        ball.pushLeft();
                        hit3++;
                    }

                    if (ball.getY() == 0) {
                        ball.pushDown();
                        wallhit2++;
                    }

                    if (ball.getX() == GameMainActivity.GAME_WIDTH - ball.width) {
                        ball.pushLeft();
                        wallhit1++;
                    }
                }
            } else if (scaledY - recentTouchY > 50 && scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.down();
                    ball.right();
                    ball.correctYCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushUp();
                        ball.pushLeft();
                        hit3++;
                    }

                    if (ball.getY() == GameMainActivity.GAME_HEIGHT - ball.height) {
                        ball.pushUp();
                        wallhit2++;
                    }

                    if (ball.getX() == GameMainActivity.GAME_WIDTH - ball.width) {
                        ball.pushLeft();
                        wallhit1++;
                    }
                }
            } else if (scaledY - recentTouchY < -50 && scaledX - recentTouchX < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.up();
                    ball.left();
                    ball.correctYCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushDown();
                        ball.pushRight();
                        hit3++;
                    }

                    if (ball.getY() == 0) {
                        ball.pushDown();
                        wallhit2++;
                    }

                    if (ball.getX() == 0) {
                        ball.pushRight();
                        wallhit1++;
                    }
                }
            } else if (scaledY - recentTouchY > 50 && scaledX - recentTouchX <- 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.down();
                    ball.left();
                    ball.correctYCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushUp();
                        ball.pushRight();
                        hit3++;
                    }

                    if (ball.getY() == GameMainActivity.GAME_HEIGHT - ball.height) {
                        ball.pushUp();
                        wallhit2++;
                    }

                    if (ball.getX() == 0) {
                        ball.pushRight();
                        wallhit1++;
                    }
                }
            } else if (scaledY - recentTouchY < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.up();
                    ball.correctYCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushDown();
                        hit2++;                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushDown();
                        hit2++;
                    }

                    if (ball.getY() == 0) {
                        ball.pushDown();
                        wallhit2++;
                    }

                    if (ball.getX() <= 30 && ball.getY() == 260) {
                        ball.pushDown();
                        wallhit2++;
                    }

                    if (ball.getX() >= 765 && ball.getY() == 260) {
                        ball.pushDown();
                        wallhit2++;
                    }
                }
            } else if (scaledY - recentTouchY > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.down();
                    ball.correctYCollisions();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i = random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i = random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushUp();
                        hit2++;
                    }

                    if (ball.getY() == GameMainActivity.GAME_HEIGHT - ball.height) {
                        ball.pushUp();
                        wallhit2++;
                    }

                    if (ball.getX() <= 30 && ball.getY() == 170) {
                        ball.pushUp();
                        wallhit2++;
                    }

                    if (ball.getX() >= 765 && ball.getY() == 170) {
                        ball.pushUp();
                        wallhit2++;
                    }
                }
            } else if (scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.right();

                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushLeft();
                        hit1++;
                    }

                    if (ball.getX() == GameMainActivity.GAME_WIDTH - ball.width) {
                        ball.pushRight();
                        wallhit1++;
                    }

                }
            } else if (scaledX - recentTouchX < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < random; i ++) {
                    ball.left();
                    if (ball.getX() < 20 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore2 += 1;
                        ball.reset();
                        i= random;
                    }

                    if (ball.getX() > 765 && ball.getY() < 260 && ball.getY() > 170) {
                        playerScore1 += 1;
                        ball.reset();
                        i= random;
                    }

                    if ((ball.getX() > stick1.getX() - 16 && ball.getX() < stick1.getX() + 16) && (ball.getY() > stick1.getY() - 16 && ball.getY() < stick1.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick2.getX() - 16 && ball.getX() < stick2.getX() + 16) && (ball.getY() > stick2.getY() - 16 && ball.getY() < stick2.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick3.getX() - 16 && ball.getX() < stick3.getX() + 16) && (ball.getY() > stick3.getY() - 16 && ball.getY() < stick3.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick4.getX() - 16 && ball.getX() < stick4.getX() + 16) && (ball.getY() > stick4.getY() - 16 && ball.getY() < stick4.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick5.getX() - 16 && ball.getX() < stick5.getX() + 16) && (ball.getY() > stick5.getY() - 16 && ball.getY() < stick5.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick6.getX() - 16 && ball.getX() < stick6.getX() + 16) && (ball.getY() > stick6.getY() - 16 && ball.getY() < stick6.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick7.getX() - 16 && ball.getX() < stick7.getX() + 16) && (ball.getY() > stick7.getY() - 16 && ball.getY() < stick7.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick8.getX() - 16 && ball.getX() < stick8.getX() + 16) && (ball.getY() > stick8.getY() - 16 && ball.getY() < stick8.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick9.getX() - 16 && ball.getX() < stick9.getX() + 16) && (ball.getY() > stick9.getY() - 16 && ball.getY() < stick9.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick10.getX() - 16 && ball.getX() < stick10.getX() + 16) && (ball.getY() > stick10.getY() - 16 && ball.getY() < stick10.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick11.getX() - 16 && ball.getX() < stick11.getX() + 16) && (ball.getY() > stick11.getY() - 16 && ball.getY() < stick11.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick12.getX() - 16 && ball.getX() < stick12.getX() + 16) && (ball.getY() > stick12.getY() - 16 && ball.getY() < stick12.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick13.getX() - 16 && ball.getX() < stick13.getX() + 16) && (ball.getY() > stick13.getY() - 16 && ball.getY() < stick13.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick14.getX() - 16 && ball.getX() < stick14.getX() + 16) && (ball.getY() > stick14.getY() - 16 && ball.getY() < stick14.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick15.getX() - 16 && ball.getX() < stick15.getX() + 16) && (ball.getY() > stick15.getY() - 16 && ball.getY() < stick15.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick16.getX() - 16 && ball.getX() < stick16.getX() + 16) && (ball.getY() > stick16.getY() - 16 && ball.getY() < stick16.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick17.getX() - 16 && ball.getX() < stick17.getX() + 16) && (ball.getY() > stick17.getY() - 16 && ball.getY() < stick17.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick18.getX() - 16 && ball.getX() < stick18.getX() + 16) && (ball.getY() > stick18.getY() - 16 && ball.getY() < stick18.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick19.getX() - 16 && ball.getX() < stick19.getX() + 16) && (ball.getY() > stick19.getY() - 16 && ball.getY() < stick19.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick20.getX() - 16 && ball.getX() < stick20.getX() + 16) && (ball.getY() > stick20.getY() - 16 && ball.getY() < stick20.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick21.getX() - 16 && ball.getX() < stick21.getX() + 16) && (ball.getY() > stick21.getY() - 16 && ball.getY() < stick21.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if ((ball.getX() > stick22.getX() - 16 && ball.getX() < stick22.getX() + 16) && (ball.getY() > stick22.getY() - 16 && ball.getY() < stick22.getY() + 16)) {
                        ball.pushRight();
                        hit1++;
                    }

                    if (ball.getX() == 0) {
                        ball.pushLeft();
                        wallhit1++;
                    }
                }
            }

            if (!(hit1 % 2 == 0)) {
                ball.resetVelX();
                hit1 = 0;
            } else {
                hit1 = 0;
            }

            if (!(hit2 % 2 == 0)) {
                ball.resetVelY();
                hit2 = 0;
            } else {
                hit2 = 0;
            }

            if (!(hit3 % 2 == 0)) {
                ball.resetVelX();
                ball.resetVelY();
                hit3 = 0;
            } else {
                hit3 = 0;
            }

            if (!(wallhit1 % 2 == 0)){
                ball.resetVelX();
                wallhit1 = 0;
            } else {
                wallhit1 = 0;
            }

            if (!(wallhit2 % 2 == 0)){
                ball.resetVelY();
                wallhit2 = 0;
            } else {
                wallhit2 = 0;
            }
        }

        if (playerScore1 == 5) {
            setCurrentState(new Player1WinState());
        } else if (playerScore2 == 5) {
            setCurrentState(new Player2WinState());
        }

        return true;
    }
}