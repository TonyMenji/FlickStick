package menji.flicksticksoccer;

import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

import menji.framework.animation.Animation;
import menji.framework.animation.Frame;

public class Assets {
    private static SoundPool soundPool;
    public static Bitmap welcome, single, singleDown, two, twoDown, tournament, tournamentDown,
            redbluefield, greenfield, sticks, ball, soccerGoal, player1, player2;
    public static int flickID, stickHitID, wallHitID, QuietFlickID;

    public static void load() {
        welcome = loadBitmap("welcome.png", false);
        redbluefield = loadBitmap("rb_play.png", false);
        greenfield = loadBitmap("g_play.png", false);
        sticks = loadBitmap("stick.png", true);
        ball = loadBitmap("soccer_ball.png", true);
        singleDown = loadBitmap("single_button_down.png", true);
        single = loadBitmap("single_button.png", true);
        twoDown = loadBitmap("double_down_button.png", true);
        two = loadBitmap("double_button.png", true);
        tournamentDown = loadBitmap("tournament_down_button.png", true);
        tournament = loadBitmap("tournament_button.png", true);
        soccerGoal = loadBitmap("soccer_goal.png", true);
        player1 = loadBitmap("player1.png", true);
        player2 = loadBitmap("player2.png", true);


        flickID = loadSound("Flick.wav");
        stickHitID = loadSound("Stick_Hit.wav");
        wallHitID = loadSound("Wall_Hit.wav");
        QuietFlickID = loadSound("Quiet_Flick.wav");
    }

    private static Bitmap loadBitmap(String filename, boolean transparency) {
        InputStream inputStream = null;
        try {
            inputStream = GameMainActivity.assets.open(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Options options = new Options();
        if (transparency) {
            options.inPreferredConfig = Config.ARGB_8888;
        } else {
            options.inPreferredConfig = Config.RGB_565;
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null,
                options);
        return bitmap;
    }

    private static int loadSound(String filename) {
        int soundID = 0;
        if (soundPool == null) {
            soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
        }
        try {
            soundID = soundPool.load(GameMainActivity.assets.openFd(filename),
                    1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return soundID;
    }

    public static void playSound(int soundID) {
        soundPool.play(soundID, 1, 1, 1, 0, 1);
    }
}