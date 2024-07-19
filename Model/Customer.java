import java.util.ArrayList;

public class Customer extends User {
    //instance data members
    private String custName;
    private String custSurname;
    private ArrayList<String> commentsGivenByCustomer;

    //constructor
    public Customer(String custName, String custSurname, String password, String email, String username, Address address) {
        super(password, email, username, address);
        setCustName(custName);
        setCustSurname(custSurname);
        commentsGivenByCustomer = new ArrayList<String>();
    }

    //getters
    public String getCustName() {
        return custName;
    }

    public String getCustSurname() {
        return custSurname;
    }

    public ArrayList<String> getCommentsGivenByCustomer() {
        return commentsGivenByCustomer;
    }

    //setters
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustSurname(String custSurname) {
        this.custSurname = custSurname;
    }

    public void setCommentsGivenByCustomer(ArrayList<String> commentsGivenByCustomer) {
        this.commentsGivenByCustomer = commentsGivenByCustomer;
    }

    //add the comment made by the customer to the list of comments given by this customer
    public void addCommentToCustCommentList(String comment) {
        commentsGivenByCustomer.add(comment);
    }

    @Override
    public String toString() {
        return "Name: " + custName + "\nSurname: " + custSurname + "\n" + super.toString();
    }
}
