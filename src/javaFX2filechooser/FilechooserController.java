package javaFX2filechooser;

import java.io.File;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FilechooserController {

	@FXML
	private Button btn01;

	@FXML
	private Button btn02;

	@FXML
	private TextArea txa;

	Stage stage;

	@FXML
	void initialize() {
		assert btn01 != null : "fx:id=\"btn01\" was not injected: check your FXML file 'FileChooser.fxml'.";
		assert btn02 != null : "fx:id=\"btn02\" was not injected: check your FXML file 'FileChooser.fxml'.";
		assert txa != null : "fx:id=\"txa\" was not injected: check your FXML file 'FileChooser.fxml'.";

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				stage = (Stage) btn01.getScene().getWindow();
			}
		});
	}

	@FXML
	void btn01OnAction(ActionEvent event) {
		FileChooser fch = new FileChooser();
		fch.setTitle("Select File !!");
		fch.setInitialDirectory(new File(System.getProperty("user.home")));
		File file = fch.showOpenDialog(this.stage);
		if (file != null) {
			this.txa.clear();
			this.txa.setText(file.getPath());
		}
	}

	@FXML
	void btn02OnAction(ActionEvent event) {
		FileChooser fch = new FileChooser();
		fch.setTitle("Select File !!");
		fch.setInitialDirectory(new File(System.getProperty("user.home")));
		List<File> files = fch.showOpenMultipleDialog(this.stage);
		this.txa.clear();
		if (files != null) {
			for (File file : files) {
				this.txa.appendText(file.getPath() + "\n");
			}
		}
	}
}
