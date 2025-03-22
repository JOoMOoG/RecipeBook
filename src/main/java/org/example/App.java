package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.databaseManager.DatabaseManager;
import org.example.services.DatabaseService;
import java.io.File;
import java.sql.*;


public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws SQLException {

        DatabaseService  databaseService = new DatabaseService(DatabaseManager.getConnection());
        boolean isNewDatabase = databaseService.setupDatabase();

        Button checkButton = new Button("Verificar Estado");

        checkButton.setOnAction(e -> {
            if (isNewDatabase) {
                showAlert();
                chooseFile(primaryStage);
            } else {
                System.out.println("A base de dados não está vazia.");
            }
        });

        VBox vbox = new VBox(checkButton);
        Scene scene = new Scene(vbox, 400, 400);

        primaryStage.setTitle("Exemplo JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showAlert() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText("A base de dados está vazia!");
        alert.setContentText("Deseja carregar um ficheiro para inicializar a base de dados?");
        alert.showAndWait();
    }

    private void chooseFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Ficheiros Excel", "*.xls", "*.xlsx"));

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            System.out.println("Ficheiro selecionado: " + selectedFile.getAbsolutePath());
        }
    }


    public static void main(String[] args) {
        launch();
    }
}
