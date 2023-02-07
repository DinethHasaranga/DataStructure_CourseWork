package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NormalCusEmployee {

    @FXML
    TextArea Display;
    @FXML
    TextArea Display1;
    @FXML
    TextArea Display2;
    @FXML
    TextField TRP1;
    @FXML
    TextField TRP2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HighPriorityCusEmployee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ShowApplicationNumbers() {
        List<String> normalCustomerApplicationNumbers = Collections.emptyList();

        try {
            normalCustomerApplicationNumbers = Files.readAllLines(Paths.get("C:\\Users\\HP\\Data Structure CW\\NormalCustomerAppNos.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Required file is not found");
        }

        Display.clear();

        for (int i = 0; i < normalCustomerApplicationNumbers.size(); i++) {
            Display.appendText(normalCustomerApplicationNumbers.get(i) + "\n");
        }
    }

    public void ApproveProcess() {
        ArrayList<String> arrayApprove1 = new ArrayList<>();

        arrayApprove1.add(TRP1.getText());

        for (int i = 0; i < arrayApprove1.size(); i++) {
            Display1.appendText(arrayApprove1.get(i) + "\n");
        }
    }

    public void DispproveProcess() {
        ArrayList<String> arrayDisapprove = new ArrayList<>();

        arrayDisapprove.add(TRP2.getText());

        for (int i = 0; i < arrayDisapprove.size(); i++) {
            Display2.appendText(arrayDisapprove.get(i) + "\n");
        }
    }
}









