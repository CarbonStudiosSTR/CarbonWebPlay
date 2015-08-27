package dl.logic.gameLoop;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer{

    private final GameUpdater updater;
    private final Runnable renderer;

    private long previousTime = 0;
    private float secondsElapsedSinceLastFpsUpdate = 0f;
    private int framesSinceLastFpsUpdate = 0;

    private static final float timeStep = 0.0166f;
    private float accumulatedTime = 0;
    private float maximumStep = 10;

    public GameLoop(GameUpdater updater, Runnable renderer) {
        this.updater = updater;
        this.renderer = renderer;
    }

    @Override
    public void handle(long currentTime) {
        if (previousTime == 0) {
            previousTime = currentTime;
            return;
        }

        float secondsElapsed = (currentTime - previousTime) / 1e9f;
        float secondsElapsedCapped = Math.min(secondsElapsed, getMaximumStep());
        accumulatedTime += secondsElapsedCapped;
        previousTime = currentTime;

        while (accumulatedTime >= timeStep) {
            updater.update(currentTime);
            accumulatedTime -= timeStep;
        }
        renderer.run();

        secondsElapsedSinceLastFpsUpdate += secondsElapsed;
        framesSinceLastFpsUpdate++;
        if (secondsElapsedSinceLastFpsUpdate >= 0.5f) {
            int fps = Math.round(framesSinceLastFpsUpdate / secondsElapsedSinceLastFpsUpdate);
            secondsElapsedSinceLastFpsUpdate = 0;
            framesSinceLastFpsUpdate = 0;
        }
    }

    @Override
    public void stop()
    {
        super.stop();
        previousTime = 0;
        accumulatedTime = 0;
        secondsElapsedSinceLastFpsUpdate = 0f;
        framesSinceLastFpsUpdate = 0;
    }

    public float getMaximumStep() {
        return maximumStep;
    }
}
