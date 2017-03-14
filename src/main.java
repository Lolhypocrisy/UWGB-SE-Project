
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application {

	private Stage primaryStage;
	protected static BorderPane rootLayout;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Sorting Algorithm Tool");
		
		initRootLayout();
		
		showMainScreen();
	}

	public void initRootLayout() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
	
	public void showMainScreen(){
        try {
            // Load main menu overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(main.class.getResource("MainScreen.fxml"));
            AnchorPane mainScreen = (AnchorPane) loader.load();

            // Set main menu into the center of root layout.
            rootLayout.setCenter(mainScreen);
           
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
