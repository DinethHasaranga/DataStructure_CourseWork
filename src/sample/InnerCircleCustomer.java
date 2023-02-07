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

public class InnerCircleCustomer {
    Queue InnerCircleCustomerQueue = new Queue();
    ArrayList<String> arrayProcess2 = new ArrayList<>();
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
    TextArea text2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("NormalCusEmployee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddToQueue() {

        arrayProcess2.add(TRP1.getText());
        InnerCircleCustomerQueue.enqueue(Integer.parseInt(TRP1.getText()), TRP2.getText(), Integer.parseInt(TRP3.getText()), TRP4.getText(), TRP5.getText(), TRP6.getText());

    }

    public void ShowApplications() throws IOException {
        //System.out.println("Queue Front : " + InnerCircleCustomerQueue.front.applicationNumber);
        //System.out.println("Queue Rear  : " + InnerCircleCustomerQueue.rear.applicationNumber);
        text2.setText(String.valueOf("Queue Front : " + " " + "Application Number: " + InnerCircleCustomerQueue.front.applicationNumber) + " " + "NIC: " + InnerCircleCustomerQueue.front.NIC + " " + "Account No: " + InnerCircleCustomerQueue.front.accountNumber + " " + "Collateral Description: " + InnerCircleCustomerQueue.front.collateralDescription + " " + "Loan Type: "  + InnerCircleCustomerQueue.front.loanType + " " + "Reason of Loan: " + InnerCircleCustomerQueue.front.reasonOfLoan + "\n");
        text2.appendText(String.valueOf("Queue Rear  : " + " " + "Application Number: " + InnerCircleCustomerQueue.rear.applicationNumber) + " " + "NIC: " + InnerCircleCustomerQueue.rear.NIC + " " + "Account No: " + InnerCircleCustomerQueue.rear.accountNumber + " " + "Collateral Description: " + InnerCircleCustomerQueue.rear.collateralDescription + " " + "Loan Type: "  + InnerCircleCustomerQueue.rear.loanType + " " + "Reason of Loan: " + InnerCircleCustomerQueue.rear.reasonOfLoan + "\n");
        System.out.println(arrayProcess2);

        FileWriter writer = new FileWriter("InnerCircleCustomerAppNos.txt");
        for(String str: arrayProcess2) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

    }
}