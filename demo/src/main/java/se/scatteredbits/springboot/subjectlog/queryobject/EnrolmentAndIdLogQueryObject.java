package se.scatteredbits.springboot.subjectlog.queryobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "EnrolmentAndIdLogQueryObject")
@Table(name = "EnrolmentAndIdLogQueryObject")
public class EnrolmentAndIdLogQueryObject {

    @Id
    private String id;

    protected EnrolmentAndIdLogQueryObject(){}

    public EnrolmentAndIdLogQueryObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
