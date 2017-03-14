package se.scatteredbits.springboot.subjectlog;


public class SubjectEnrolledEvent {
    private final String id;


    public SubjectEnrolledEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
