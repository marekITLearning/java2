package sk.itlearning.java2.j.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GuiJavafx extends Application{

	/*
	 ** Stiahneme a nainstalujeme SceneBuilder (program na jednoduche skladanie view pre JavaFX aplikacie)
	 * najdeme ho tu: http://gluonhq.com/products/scene-builder/#download
	 *
	 *
	 ** Nase zadanie je vytvorit program ktory po stalceni tlacidla nacita vstup zmeni ho na uppercase
	 * a presunie ho na vystup kde ho nasledne odriadkuje
	 *
	 ** Vytvorime Java project
	 * Vytvorime zdrojovy subor Main.java ktora bude extend-ovat triedu jafx.application.Application (hlavna trieda)
	 *
	 * main metoda musi volat metodu launch(args) - metoda smie byt zavolana iba raz
	 *
	 *
	 ** Vytvorime zdrojovy subor s nazvom Controller.java
	 * Premenne ktore chceme aby boli prepojene s nasim view je nutne anotovat anotaciou @FXML
	 * ta nam zaruci ze komponenty sa previazu s komponentami definovanymi v Obraz.fxml subore
	 *
	 * Vytvorime premenne ktore bude nas program potrebovat
	 * @FXML
	 * TextField txtField; //komponent z ktoreho budeme nacitavat vstup
	 * @FXML
	 * Button btnPresun //komponent na ktorom bude zaveseny event handler
	 * @FXML
	 * TextArea txtArea //komponent do ktoreho zapiseme vysledok nasej operacie
	 *
	 * dalej vytvorime metodu ktora bude spracuvat vstup a vypise ho zmeneny a odriadkovany na vystup
	 * @FXML
     *	public void presunPopisDoTextArea() {
     *		txtArea.appendText(txtField.getText().toUpperCase()+"\n");
     *	}
	 *
	 ** Vytvorime subor Okno.fxml
	 * Subor Okno.fxml otvorime kliknutim praveho tlacidla na Otvor.fxml -> Open with -> Other -> External program -> SceneBuilder
	 * Ako root container pouzijeme AnchorPane (mozeme si ukotvit komponenty kdekolvek chceme)
	 * Vytvorime view podla zelania (vlozime TextField, TextArea, Button, (Label))
	 * v pravome menu mame v pravo dole zalozku code, klikneme na nu a vyplnime field fx:id podla toho,
	 * ako sme si pomenovali premenne v triede Controller
	 * napriklad textField ma fx:id txtField
	 *
	 * pre komponent Button takisto v pravom menu v zalozke code vyplnime field "On Mouse Clicked" menom metody "presunPopisDoTextArea"
	 *
	 * V SceneBuilder vidime v lavom menu uplne v lavo dole zalozku Controller, ktoru otvorime
	 * vyplnime field "Container class" v nasom pripade sk.itlearning.java2.z.Controller
	 *
	 *
	 *
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {

//		nacitanie korenoveho componentu (hlavne okno)
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Okno.fxml"));

//		nastavenie hlavnej sceny root componentom
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Konvertor na UPPERCASE");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
