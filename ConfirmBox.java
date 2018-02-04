package fi.taappana;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Voih!");
        window.setMinWidth(250);
        Label labelConfirm = new Label();
        labelConfirm.setText("Jaahas");

        // create two buttons
        Button yesButton = new Button("Kylmaar mä tahron lophettaa");
        Button noButton = new Button("No eih, en mie tohri lophettaa");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layoutConfirm = new VBox(10);
        layoutConfirm.getChildren().addAll(labelConfirm, yesButton, noButton);
        layoutConfirm.setAlignment(Pos.CENTER);
        Scene layoutScene = new Scene(layoutConfirm, 300, 150);
        window.setScene(layoutScene);
        window.showAndWait();

        return answer;
    }
}
