package fi.taappana;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Huvitoimikunta extends Application {

    Stage window;
    Scene sceneOne, sceneTwo;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Huvitoimikunta");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Button buttonClose = new Button("Sulje ohojelma!");
        buttonClose.setOnAction(e -> closeProgram());

        Label labelOne = new Label("Huvitoimikunta tiedottaa");
        labelOne.setFont(new Font("Cambria", 30));
        Button buttonOne = new Button("Tästä tiedotukseen!");
        buttonOne.setOnAction(e -> window.setScene(sceneTwo));

        // Layout One
        VBox layoutOne = new VBox(50);
        layoutOne.getChildren().addAll(labelOne ,buttonOne, buttonClose);
        layoutOne.setAlignment(Pos.CENTER);
        sceneOne = new Scene(layoutOne, 500, 300);

        Button buttonTwo = new Button("Tästä tekee kummia");
        buttonTwo.setOnAction(e -> window.setScene(sceneOne));
        buttonTwo.setRotate(2);
        buttonTwo.setTranslateX(20);
        Label labelTwo = new Label("Sehän on #wonderMonday");
        labelTwo.setFont(new Font("Cambria", 30));
        labelTwo.setRotate(-5);

        // Layout Two
        VBox layoutTwo = new VBox(50);
        layoutTwo.getChildren().addAll(labelTwo ,buttonTwo);
        layoutTwo.setAlignment(Pos.CENTER);
        sceneTwo = new Scene(layoutTwo, 500, 300);

        // Set up default scene
        window.setScene(sceneOne);
        window.setTitle("Huvitoimikunta");
        // Display window
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Voih eih!", "Hei älä mee, tai viet multa kaiken!");
        if(answer)
            window.close();
    }
}
