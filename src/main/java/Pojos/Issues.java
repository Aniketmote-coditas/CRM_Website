package Pojos;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issue_id;

    private String issue_Name;

    private String description;

    private String status;
    private LocalDate today;

    private LocalDate deadline;
    @ManyToOne
    private Customer customer;

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_Name() {
        return issue_Name;
    }

    public void setIssue_Name(String issue_Name) {
        this.issue_Name = issue_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Issues() {
        this.status="Pending";
    }

    @Override
    public String toString() {
        return "Issues{" +
                "issue_id=" + issue_id +
                ", issue_Name='" + issue_Name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", today=" + today +
                ", deadline=" + deadline +
                ", customer=" + customer +
                '}';
    }
}