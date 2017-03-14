package se.scatteredbits.springboot.subjectlog.queryobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectLogQueryObject {

    @Id
    private String id;

    protected SubjectLogQueryObject(){}

    public SubjectLogQueryObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
