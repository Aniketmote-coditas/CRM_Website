package Pojos;

import Pojos.Customer;
import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;
    private String crmName;
    private String feebackdesc;

    @ManyToOne
    private Customer customer;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getCrmName() {
        return crmName;
    }

    public void setCrmName(String crmName) {
        this.crmName = crmName;
    }

    public String getFeebackdesc() {
        return feebackdesc;
    }

    public void setFeebackdesc(String feebackdesc) {
        this.feebackdesc = feebackdesc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fid=" + fid +
                ", crmName='" + crmName + '\'' +
                ", feebackdesc='" + feebackdesc + '\'' +
                ", customer=" + customer +
                '}';
    }
}
