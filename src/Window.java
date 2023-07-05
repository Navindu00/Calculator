import controller.WindowInterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Window extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/WindowInterface.fxml"));
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/images/icon.png")));
        stage.setResizable(false);
        ((WindowInterfaceController)loader.getController()).init(stage);
        //WindowInterfaceController controller = (WindowInterfaceController)loader.getController();
        //controller.init(stage);
        
        stage.show();
    }

    public void run(){
        launch();
    }
    
}
