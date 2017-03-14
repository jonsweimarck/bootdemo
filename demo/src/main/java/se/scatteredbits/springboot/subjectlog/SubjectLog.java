package se.scatteredbits.springboot.subjectlog;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Id;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@Entity
public class SubjectLog {

    @Id
    private String id;


    @CommandHandler
    public SubjectLog(EnrollSubjectCommand cmd) {
        apply(new SubjectEnrolledEvent(cmd.getId()));
    }

    @SuppressWarnings("unused")
    private SubjectLog() {
    }

    @EventSourcingHandler
    public void on(SubjectEnrolledEvent event){
        this.id = event.getId();
    }
}
