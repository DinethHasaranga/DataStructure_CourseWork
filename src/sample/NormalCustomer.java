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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NormalCustomer {
    Queue NormalCustomerQueue = new Queue();
    ArrayList<String> arrayProcess = new ArrayList<>();
    String appNo;

    @FXML
    TextField TRP1;
    @FXML
    TextField TRP2;
    @FXML
    TextField TRP3;
    @FXML
    TextField TRP4;
    @FXML
    TextField TRP5;
    @FXML
    TextField TRP6;
    @FXML
    TextArea text3;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HighPriorityCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddToQueue() {

        arrayProcess.add(TRP1.getText());
        NormalCustomerQueue.enqueue(Integer.parseInt(TRP1.getText()), TRP2.getText(), Integer.parseInt(TRP3.getText()), TRP4.getText(), TRP5.getText(), TRP6.getText());

    }

    public void ShowApplications() throws IOException {
        //System.out.println("Queue Front : " + NormalCustomerQueue.front.applicationNumber);
        //System.out.println("Queue Rear  : " + NormalCustomerQueue.rear.applicationNumber);
        text3.setText("Queue Front : " + " " + "Application Number: " + String.valueOf(NormalCustomerQueue.front.applicationNumber) + " " + "NIC: " + NormalCustomerQueue.front.NIC + " " + "Account No: " + NormalCustomerQueue.front.accountNumber + " " + "Collateral Description: " + NormalCustomerQueue.front.collateralDescription + " " + "Loan Type: "  + NormalCustomerQueue.front.loanType + " " + "Reason of Loan: " + NormalCustomerQueue.front.reasonOfLoan + "\n");
        text3.appendText("Queue Rear  : " + " " + "Application Number: " + String.valueOf(NormalCustomerQueue.rear.applicationNumber) + " " + "NIC: " + NormalCustomerQueue.rear.NIC + " " + "Account No: " + NormalCustomerQueue.rear.accountNumber + " " + "Collateral Description: " + NormalCustomerQueue.rear.collateralDescription + " " + "Loan Type: "  + NormalCustomerQueue.rear.loanType + " " + "Reason of Loan: " + NormalCustomerQueue.rear.reasonOfLoan + "\n");
        System.out.println(arrayProcess);


        FileWriter writer = new FileWriter("NormalCustomerAppNos.txt");
        for(String str: arrayProcess) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

    }
}