package proj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JButton;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; //++
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class DatePickerTest extends Application {

	private Stage stage;
	private DatePicker checkInDatePicker;
	private final String pattern = "yyyy-MM-dd";

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		stage.setTitle("Date");

		initUI();
		stage.show();
	}

	private void initUI() {

		VBox vbox = new VBox(20);
		vbox.setStyle("-fx-padding: 10;");
		Scene scene = new Scene(vbox, 400, 400);
		stage.setScene(scene);

		checkInDatePicker = new DatePicker();
		StringConverter converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};
		EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		      System.out.println("ALIO");
		    }
		};
		
		checkInDatePicker.setConverter(converter);
		checkInDatePicker.setPromptText(pattern.toLowerCase());
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		Label checkInlabel = new Label("Check-In Date:");
		gridPane.add(checkInlabel, 0, 0);
		GridPane.setHalignment(checkInlabel, HPos.LEFT);
		gridPane.add(checkInDatePicker, 0, 1);
		vbox.getChildren().add(gridPane);
		checkInDatePicker.requestFocus();
		
		Button button = new Button("New button");
		vbox.getChildren().add(button);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				LocalDate date = checkInDatePicker.getValue();
				System.out.println(date);
			}
		});

	}
}