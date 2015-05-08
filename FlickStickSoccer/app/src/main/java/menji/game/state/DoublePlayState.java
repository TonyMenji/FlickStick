package menji.game.state;


import java.util.ArrayList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.os.Handler;
import menji.framework.util.Painter;
import menji.flicksticksoccer.Assets;
import menji.game.model.Sticks;
import menji.game.model.Ball;
import menji.flicksticksoccer.GameMainActivity;

public class DoublePlayState extends State {
    private Ball ball;
    private ArrayList<Sticks> sticks;
    private int playerScore1 = 0;
    private int playerScore2 = 0;
    private static final int BLOCK_HEIGHT = 18;
    private static final int BLOCK_WIDTH = 18;
    private int blockSpeed = -200;
    private static final int PLAYER_WIDTH = 66;
    private static final int PLAYER_HEIGHT = 92;

    private Handler h;

    private float recentTouchY;
    private float recentTouchX;

    @Override
    public void init() {
        ball = new Ball (390, 215, 20, 20);
    }


    @Override
    public void update(float delta) {}
    @Override
    public void render(Painter g) {
        g.drawImage(Assets.redbluefield, 0, 0);
        g.drawImage(Assets.ball, ball.getX(),ball.getY(), ball.getWidth(), ball.getHeight());
        renderScore(g, 350, playerScore1);
        renderScore(g, 425, playerScore2);
        g.fillRect(0, 191, 30, 63);
        g.fillRect(773, 192, 30, 63);
        renderSticks(g);
        g.drawImage(Assets.soccerGoal, 0, 191, 30, 63);
        g.drawImage(Assets.soccerGoal, 773, 192, 30, 63);

    }

    private void renderScore(Painter g, int xLocation, int playerScore) {
        g.setFont(Typeface.SANS_SERIF, 25);
        g.setColor(Color.GRAY);
        g.drawString("" + playerScore, xLocation, 30);
    }

    private void renderSticks(Painter g) {
        g.fillOval(25, 215, BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval( 100, 165, BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(100, 265,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(180, 115,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(180, 215,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(180, 315,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(275, 65,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(260, 165,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(260, 265,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(275, 365,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(325, 215,
                BLOCK_WIDTH, BLOCK_HEIGHT);



        g.fillOval(460, 215,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(510, 365,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(510, 65,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(525, 265,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(525, 165,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(605, 115,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(605, 215,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(605, 315,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(685, 165,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(685, 265,
                BLOCK_WIDTH, BLOCK_HEIGHT);

        g.fillOval(765, 215,
                BLOCK_WIDTH, BLOCK_HEIGHT);

    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            recentTouchY = scaledY;
            recentTouchX = scaledX;
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            if (scaledY - recentTouchY < -50 && scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.up();
                    ball.right();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i = 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledY - recentTouchY > 50 && scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.down();
                    ball.right();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledY - recentTouchY < -50 && scaledX - recentTouchX < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.up();
                    ball.left();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledY - recentTouchY > 50 && scaledX - recentTouchX <- 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.down();
                    ball.left();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledY - recentTouchY < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.up();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledY - recentTouchY > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.down();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledX - recentTouchX > 50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.right();

                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            } else if (scaledX - recentTouchX < -50) {
                Assets.playSound(Assets.flickID);
                for (int i = 0; i < 50; i ++) {
                    ball.left();
                    if (ball.getX() < 20 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore2 += 1;
                        ball.reset();
                        i= 50;
                    }

                    if (ball.getX() > 765 && ball.getY() < 240 && ball.getY() > 190) {
                        playerScore1 += 1;
                        ball.reset();
                        i= 50;
                    }
                }
            }

        }

        return true;
    }
}