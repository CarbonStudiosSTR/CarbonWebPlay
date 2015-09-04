package dl.logic.gameLoop;

import javafx.animation.AnimationTimer;
import util.CarbonProperties;

public abstract class GameLoop extends AnimationTimer {

    private long previousTime = 0;
    private static final float timeStep = CarbonProperties.TIME_FRAME_IN_NANOS;
    private float accumulatedTime = 0;
    private GameUpdater gameUpdater;

    public GameLoop() {
        gameUpdater = new GameUpdater();
    }

    @Override
    public void handle(long currentTime) {
        if (previousTime == 0) {
            previousTime = currentTime;
            return;
        }
        float nanosElapsed = currentTime - previousTime;
        accumulatedTime += nanosElapsed;
        previousTime = currentTime;
        while (accumulatedTime >= timeStep) {
            gameUpdater.update(currentTime);
            render();
            accumulatedTime -= timeStep;
        }

    }

    protected abstract void render();

    @Override
    public void stop() {
        super.stop();
        previousTime = 0;
        accumulatedTime = 0;
    }

}


