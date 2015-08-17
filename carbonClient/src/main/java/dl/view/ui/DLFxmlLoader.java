package dl.view.ui;

import javafx.fxml.FXMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component("fxmlLoader")
public class DLFxmlLoader extends FXMLLoader implements ApplicationContextAware {

   private static final Logger LOG = LoggerFactory.getLogger(DLFxmlLoader.class);

   public DLFxmlLoader() throws MalformedURLException {

      super(DLFxmlLoader.class.getResource("/ui/RootPane.fxml"));
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

      LOG.debug("setting application context: {}", applicationContext);
      setControllerFactory(applicationContext::getBean);
   }
}
