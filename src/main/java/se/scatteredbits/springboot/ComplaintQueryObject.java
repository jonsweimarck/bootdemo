package se.scatteredbits.springboot;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplaintQueryObject {

    @Id
    String complaintId;
    String company;
    String complaint;

    public ComplaintQueryObject() {
    }

    public ComplaintQueryObject(String complaintId, String company, String complaint) {
        this.complaintId = complaintId;
        this.company = company;
        this.complaint = complaint;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getCompany() {
        return company;
    }

    public String getComplaint() {
        return complaint;
    }
}
