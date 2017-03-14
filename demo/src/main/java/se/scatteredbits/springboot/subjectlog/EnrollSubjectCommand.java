package se.scatteredbits.springboot.subjectlog;


public class EnrollSubjectCommand {
    private final String id;

    public EnrollSubjectCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
