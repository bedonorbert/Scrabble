package hu.norbi.view;
import java.util.ArrayList;
import java.util.List;

import hu.norbi.modell.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * A játékos nevének bekérését megvalósító osztály. 
 * 
 * @author Bedő Norbert
 *
 */
public class NameController {

	@FXML
	private TextField firstPlayer;
	
	@FXML
	private TextField secondPlayer;
	
	private Stage dialogStage;
	private boolean okClicked = false;
	private List<String> name=new ArrayList<String>();
	Player first, second;
	@FXML
	private void initialize() {
		
	}
	
	/**
	 * Beállítja az ablakot.
	 * 
	 * @param dialogStage az ablak.
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
   

	
	/**
	 * Visszaadja a {@link hu.norbi.modell.Player} neveit.
	 * @return a játékos neve
	 */
	public List<String> getName() {
		return name;
	}


	@FXML
	private void Vege(){
		System.out.print("bezar");
	}
	
	@FXML
	private void Ok() {
		if(isInputValid()) {
			
			
			name.add(firstPlayer.getText().toString());
			name.add(secondPlayer.getText().toString());
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	private boolean isInputValid() {
		String errorMessage = "";
		
		if(firstPlayer.getText() == null || firstPlayer.getText().length() == 0) {
			errorMessage += "Nem adta meg az első játékos nevét!\n";
		}
		if(secondPlayer.getText() == null || secondPlayer.getText().length() == 0) {
			errorMessage += "Nem adta meg a második játékos nevét!\n";
		}
		
		
		if(errorMessage.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Hiányzó paraméterek");
			alert.setHeaderText("Kérem adja meg a játékosok nevét!");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			
			return false;
		}
	}
}
