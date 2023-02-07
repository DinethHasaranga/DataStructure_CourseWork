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

public class HighPriorityCustomer {
    Queue HighPriorityCustomerQueue = new Queue();
    ArrayList<String> arrayProcess1 = new ArrayList<>();
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
    TextArea text1;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("InnerCircleCustomer.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddToQueue() {

        arrayProcess1.add(TRP1.getText());
        HighPriorityCustomerQueue.enqueue(Integer.parseInt(TRP1.getText()), TRP2.getText(), Integer.parseInt(TRP3.getText()), TRP4.getText(), TRP5.getText(), TRP6.getText());

    }

    public void ShowApplications() throws IOException {
        //System.out.println("Queue Front : " + HighPriorityCustomerQueue.front.applicationNumber);
        //System.out.println("Queue Rear  : " + HighPriorityCustomerQueue.rear.applicationNumber);
        text1.setText("Queue Front : " + " " + "Application Number: " + String.valueOf(HighPriorityCustomerQueue.front.applicationNumber) + " " + "NIC: " + HighPriorityCustomerQueue.front.NIC + " " + "Account No: " + HighPriorityCustomerQueue.front.accountNumber + " " + "Collateral Description: " + HighPriorityCustomerQueue.front.collateralDescription + " " + "Loan Type: "  + HighPriorityCustomerQueue.front.loanType + " " + "Reason of Loan: " + HighPriorityCustomerQueue.front.reasonOfLoan + "\n");
        text1.appendText("Queue Rear  : " + " " + "Application Number: " + String.valueOf(HighPriorityCustomerQueue.rear.applicationNumber) + " " + "NIC: " + HighPriorityCustomerQueue.rear.NIC + " " + "Account No: " + HighPriorityCustomerQueue.rear.accountNumber + " " + "Collateral Description: " + HighPriorityCustomerQueue.rear.collateralDescription + " " + "Loan Type: "  + HighPriorityCustomerQueue.rear.loanType + " " + "Reason of Loan: " + HighPriorityCustomerQueue.rear.reasonOfLoan + "\n");
        System.out.println(arrayProcess1);


        FileWriter writer = new FileWriter("HighPriorityCustomerAppNos.txt");
        for(String str: arrayProcess1) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

    }
}