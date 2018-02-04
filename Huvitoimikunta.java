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

import java.time.DayOfWeek;
import java.time.LocalDate;

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

//      Getting current dayname and passing text to labelTwo accordingly /////////
        LocalDate localDate = LocalDate.now();
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        String textForDay = "";
        if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            textForDay = "#krapulaSunnuntai";
        } else if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
            textForDay = "#wonderMonday";
        } else if (dayOfWeek.equals(DayOfWeek.TUESDAY)) {
            textForDay = "#terribleTuesday";
        } else if (dayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
            textForDay = "#ketteraKeskiviikko";
        } else if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            textForDay = "#terrificThursday";
        } else if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            textForDay = "#tanssiPerjantai";
        } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            textForDay = "#saunaLauantai";
        } else {
            textForDay = "Noh, mitäs ihmettä?";
        }

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
        Label labelTwo = new Label();
        labelTwo.setText("Sehän on " + textForDay);
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
