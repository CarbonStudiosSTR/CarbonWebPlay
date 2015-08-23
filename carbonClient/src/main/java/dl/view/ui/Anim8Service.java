package dl.view.ui;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static javafx.animation.FadeTransitionBuilder.create;
import static javafx.animation.Interpolator.EASE_IN;
import static javafx.animation.Interpolator.EASE_OUT;

@Component
public class Anim8Service {

   private Duration fadeDuration;

   @NotNull
   public Transition fadeOut(@NotNull final Node node) {

      return fadeOut(node, false);
   }

   @NotNull
   public Transition fadeOut(@NotNull final Node node, final boolean nodeVisibleAfterFade) {

      Transition fadeTransition = new FadeTransition(fadeDuration, node);
      fadeTransition.setInterpolator(EASE_OUT);
      fadeTransition.getInterpolator().interpolate(node.getOpacity(), 0.0, 1.0);

      fadeTransition.setOnFinished(actionEvent -> node.setVisible(nodeVisibleAfterFade));

      return fadeTransition;
   }

   @NotNull
   public Transition fadeIn(@NotNull Node node) {

      return fadeIn(node, 1.0);
   }

   @NotNull
   public Transition fadeIn(@NotNull Node node, @NotNull Double nodeOpacityAfterFade) {

      Transition fadeTransition = create()
              .duration(fadeDuration)
              .interpolator(EASE_IN)
              .fromValue(node.getOpacity())
              .toValue(nodeOpacityAfterFade)
              .node(node)
              .build();

      if (!node.isVisible())
         node.setVisible(true);

      return fadeTransition;
   }


   @NotNull
   public Transition fadeChainSwap(@NotNull Node nodeToHide, @NotNull Node nodeToReveal) {

      Transition fadeOut = fadeOut(nodeToHide);
      Transition fadeIn = fadeIn(nodeToReveal);

      return chain(fadeOut, fadeIn);
   }

   @NotNull
   public Transition chain(@NotNull Transition... transitions) {

      return new SequentialTransition(transitions);
   }

   @PostConstruct
   private void init() {

      fadeDuration = new Duration(500.0);
   }
}
