package application;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 * @author Gilles Russo und Alex Schaub
 * @version 14.04.2021
 */
public class Main extends Application {
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
				int zaehler = 0;
				double power = 0.0;
				double tension = 0.0;
				double current = 0.0;
				double resistence = 0.0;
				boolean [] isEingetragen = new boolean [4];
				if(txLeistung.getText().isEmpty()==false) {
					power = Double.parseDouble(txLeistung.getText());
					zaehler++;
					isEingetragen[0] = true;
				}
				if(txSpannung.getText().isEmpty()==false) {
					tension = Double.parseDouble(txSpannung.getText());
				zaehler++;
					isEingetragen[1] = true;
				}
				if(txStrom.getText().isEmpty()==false) {
					current = Double.parseDouble(txStrom.getText());
					zaehler++;
					isEingetragen[2] = true;
				}
				if(txWiderstand.getText().isEmpty()==false) {
					resistence = Double.parseDouble(txWiderstand.getText());
					zaehler++;
					isEingetragen[3] = true;
				}
				Calculator myCalculator = new Calculator(
						power, tension, current, resistence);

			if(zaehler == 2) {
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
					txSpannung.setText(Double.toString(myCalculator.getLeistung()));
					txSpannung.setStyle("-fx-text-fill: red;");
				}
				if (isEingetragen[2]) {
					txStrom.setText(Double.toString(myCalculator.getStrom()));
					txStrom.setStyle("-fx-text-fill: black;");
				} else {
					txStrom.setText(Double.toString(myCalculator.getLeistung()));
					txStrom.setStyle("-fx-text-fill: red;");
				}
				if (isEingetragen[3]) {
					txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
					txWiderstand.setStyle("-fx-text-fill: black;");
				} else {
					txWiderstand.setText(Double.toString(myCalculator.getLeistung()));
					txWiderstand.setStyle("-fx-text-fill: red;");
				}
			}
			else{
				System.out.println("Es müssen genau 2 Werte eingetragen werden");
				txLeistung.setText("Es müssen genau 2 Werte eingetragen werden");
				txSpannung.setText("");
				txStrom.setText("");
				txWiderstand.setText("");
			}
			});


			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
