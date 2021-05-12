package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Formelrad Application
 *
 * @author Gilles Russo und Alex Schaub
 * @version 12.05.2021
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = new Pane();

            // Creating an image
            Image image = new Image(getClass().getResourceAsStream("formelradelektronik.gif"));
            ImageView imageView = new ImageView(image);
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitHeight(300);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            root.getChildren().add(imageView);

            Label lbleistung = new Label("Leistung:");
            lbleistung.relocate(10, 285);
            lbleistung.setFont(Font.font(15));
            root.getChildren().add(lbleistung);

            TextField txLeistung = new TextField();
            txLeistung.relocate(100, 285);
            txLeistung.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txLeistung);

            Label lblSpannung = new Label("Spannung:");
            lblSpannung.relocate(10, 325);
            lblSpannung.setFont(Font.font(15));
            root.getChildren().add(lblSpannung);

            TextField txSpannung = new TextField();
            txSpannung.relocate(100, 325);
            txSpannung.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txSpannung);

            Label lblStrom = new Label("Strom:");
            lblStrom.relocate(10, 365);
            lblStrom.setFont(Font.font(15));
            root.getChildren().add(lblStrom);

            TextField txStrom = new TextField();
            txStrom.relocate(100, 365);
            txStrom.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txStrom);

            Label lblWiderstand = new Label("Widerstand:");
            lblWiderstand.relocate(10, 405);
            lblWiderstand.setFont(Font.font(15));
            root.getChildren().add(lblWiderstand);

            TextField txWiderstand = new TextField();
            txWiderstand.relocate(100, 405);
            txWiderstand.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txWiderstand);

            Button btnBerechnen = new Button();
            btnBerechnen.relocate(100, 445);
            btnBerechnen.setText("Berechnen");
            root.getChildren().add(btnBerechnen);

            btnBerechnen.setOnAction(e -> {
                int counter = 0;
                int zaehler = 0;
                double power = 0.0;
                double tension = 0.0;
                double current = 0.0;
                double resistence = 0.0;
                boolean[] isEingetragen = new boolean[4];
                if(txLeistung.getText().isEmpty()==true && txStrom.getText().isEmpty()==true && txSpannung.getText().isEmpty()==true && txWiderstand.getText().isEmpty()==true){
                    txLeistung.setText("Tragen Sie bitte zwei Werte ein");
                }
                if (txLeistung.getText().isEmpty() == false) {
                    try {
                        power = Double.parseDouble(txLeistung.getText());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Achtung! Es duerfen nur Zahlen bei der Eingabe verwendet werden.");
                        txLeistung.setText("Es dürfen nur Zahlen eingegeben werden");
                        txSpannung.setText("");
                        txStrom.setText("");
                        txWiderstand.setText("");
                        return;
                    }
                    zaehler++;
                    isEingetragen[0] = true;
                }
                if (txSpannung.getText().isEmpty() == false) {
                    try {
                        tension = Double.parseDouble(txSpannung.getText());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Achtung! Es duerfen nur Zahlen bei der Eingabe verwendet werden.");
                        txLeistung.setText("Es dürfen nur Zahlen eingegeben werden");
                        txSpannung.setText("");
                        txStrom.setText("");
                        txWiderstand.setText("");
                        return;
                    }
                    zaehler++;
                    isEingetragen[1] = true;
                }
                if (txStrom.getText().isEmpty() == false) {
                    try {
                        current = Double.parseDouble(txStrom.getText());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Achtung! Es duerfen nur Zahlen bei der Eingabe verwendet werden.");
                        txLeistung.setText("Es dürfen nur Zahlen eingegeben werden");
                        txSpannung.setText("");
                        txStrom.setText("");
                        txWiderstand.setText("");
                        return;
                    }
                    zaehler++;
                    isEingetragen[2] = true;
                }
                if (txWiderstand.getText().isEmpty() == false) {
                    try {
                        resistence = Double.parseDouble(txWiderstand.getText());
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println("Achtung! Es duerfen nur Zahlen bei der Eingabe verwendet werden.");
                        txLeistung.setText("Es dürfen nur Zahlen eingegeben werden");
                        txSpannung.setText("");
                        txStrom.setText("");
                        txWiderstand.setText("");
                        return;
                    }
                    zaehler++;
                    isEingetragen[3] = true;
                }

                if (zaehler == 2) {
                    counter++;
                    Calculator myCalculator = new Calculator(
                            power, tension, current, resistence);

                    if (isEingetragen[0]) {
                        txLeistung.setText(Double.toString(myCalculator.getLeistung()));
                        txLeistung.setStyle("-fx-text-fill: black;");
                    } else {
                        txLeistung.setText(Double.toString(myCalculator.getLeistung()));
                        txLeistung.setStyle("-fx-text-fill: red;");
                    }
                    if (isEingetragen[1]) {
                        txSpannung.setText(Double.toString(myCalculator.getSpannung()));
                        txSpannung.setStyle("-fx-text-fill: black;");
                    } else {
                        txSpannung.setText(Double.toString(myCalculator.getSpannung()));
                        txSpannung.setStyle("-fx-text-fill: red;");
                    }
                    if (isEingetragen[2]) {
                        txStrom.setText(Double.toString(myCalculator.getStrom()));
                        txStrom.setStyle("-fx-text-fill: black;");
                    } else {
                        txStrom.setText(Double.toString(myCalculator.getStrom()));
                        txStrom.setStyle("-fx-text-fill: red;");
                    }
                    if (isEingetragen[3]) {
                        txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
                        txWiderstand.setStyle("-fx-text-fill: black;");
                    } else {
                        txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
                        txWiderstand.setStyle("-fx-text-fill: red;");
                    }
                } else {
                    System.out.println("Es müssen genau 2 Werte eingetragen werden");
                    txLeistung.setText("Es müssen genau 2 Werte eingetragen werden");
                    txSpannung.setText("");
                    txStrom.setText("");
                    txWiderstand.setText("");
                    if(counter%2 == 0){
                        txLeistung.setText("");
                        txLeistung.setStyle("-fx-text-fill: black;");
                        txSpannung.setText("");
                        txSpannung.setStyle("-fx-text-fill: black;");
                        txWiderstand.setText("");
                        txWiderstand.setStyle("-fx-text-fill: black;");
                        txStrom.setText("");
                        txStrom.setStyle("-fx-text-fill: black;");
                    }
                }
            });

            Scene scene = new Scene(root, 330, 490);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Formelrad");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            // Wir wollen hier ein Mergekonflikt provozieren.
        }
    }
}
