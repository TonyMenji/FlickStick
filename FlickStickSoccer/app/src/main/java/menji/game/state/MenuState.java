package menji.game.state;

import android.view.MotionEvent;

import menji.framework.util.Painter;
import menji.flicksticksoccer.Assets;
import menji.framework.util.UIButton;

public class MenuState extends State {
    private UIButton singleButton, doubleButton, tournamentButton;

    @Override
    public void init() {
        singleButton = new UIButton(275, 220, 525, 279, Assets.single,
                Assets.singleDown);
        doubleButton = new UIButton(275, 290, 525, 349, Assets.two,
                Assets.twoDown);
        tournamentButton = new UIButton(275, 361, 525, 420, Assets.tournament,
                Assets.tournamentDown);
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.welcome, 0, 0);
        singleButton.render(g);
        doubleButton.render(g);
        tournamentButton.render(g);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            singleButton.onTouchDown(scaledX, scaledY);
            doubleButton.onTouchDown(scaledX, scaledY);
            tournamentButton.onTouchDown(scaledX, scaledY);
        }
        if (e.getAction() == MotionEvent.ACTION_UP) {
            if (singleButton.isPressed(scaledX, scaledY)) {
                singleButton.cancel();
                //setCurrentState(new DoublePlayState());
            } else if (doubleButton.isPressed(scaledX, scaledY)) {
                doubleButton.cancel();
                setCurrentState(new PlayState());
            } else if (tournamentButton.isPressed(scaledX, scaledY)) {
                tournamentButton.cancel();
            } else {
                singleButton.cancel();
                doubleButton.cancel();
                tournamentButton.cancel();
            }
        }
        return true;
    }
}