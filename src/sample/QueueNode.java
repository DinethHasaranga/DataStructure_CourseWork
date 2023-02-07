package sample;

class QueueNode {
    int applicationNumber;
    String NIC;
    long accountNumber;
    String loanType;
    String reasonOfLoan;
    String collateralDescription;
    QueueNode next;

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getReasonOfLoan() {
        return reasonOfLoan;
    }

    public void setReasonOfLoan(String reasonOfLoan) {
        this.reasonOfLoan = reasonOfLoan;
    }

    public String getCollateralDescription() {
        return collateralDescription;
    }

    public void setCollateralDescription(String collateralDescription) {
        this.collateralDescription = collateralDescription;
    }


    public QueueNode(int applicationNumber, String NIC, int accountNumber, String loanType, String reasonOfLoan, String collateralDescription) {
        this.applicationNumber = applicationNumber;
        this.NIC = NIC;
        this.accountNumber = accountNumber;
        this.loanType = loanType;
        this.reasonOfLoan = reasonOfLoan;
        this.collateralDescription = collateralDescription;
        next = null;
    }
}

class Queue {
    QueueNode front, rear;

    public Queue(){
        this.front = this.rear = null;
    }

    void enqueue(int applicationNumber,String NIC, int accountNumber, String loanType, String reasonOfLoan,String collateralDescription) {
        QueueNode map = new QueueNode(applicationNumber,NIC,accountNumber,loanType,reasonOfLoan,collateralDescription);

        if (this.rear == null) {
            this.front = this.rear = map;
            return;
        }
        this.rear.next = map;
        this.rear = map;
    }

    void dequeue() {
        if (this.front == null)
            return;

        QueueNode map = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
        return;
    }

}
