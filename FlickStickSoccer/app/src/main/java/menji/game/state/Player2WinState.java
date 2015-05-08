package menji.game.state;

import android.view.MotionEvent;
import menji.framework.util.Painter;
import menji.flicksticksoccer.Assets;

public class Player2WinState extends State {

    @Override
    public void init() {

    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void render(Painter g) {
        g.drawImage(Assets.player2, 0, 0);
    }

    @Override
    public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
        if( e.getAction() == MotionEvent.ACTION_DOWN) {
            setCurrentState(new MenuState());
        }
        return true;
    }

}
