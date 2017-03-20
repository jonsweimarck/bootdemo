package se.scatteredbits.springboot.subjectlog;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@Entity
@Table(name = "EnrolmentAndIdLog")
public class EnrolmentAndIdLog {

    @Id
    private String id;


    @CommandHandler
    public EnrolmentAndIdLog(EnrollSubjectCommand cmd) {
        apply(new SubjectEnrolledEvent(cmd.getId()));
    }

    @SuppressWarnings("unused")
    private EnrolmentAndIdLog() {
    }

    @EventSourcingHandler
    public void on(SubjectEnrolledEvent event){
        this.id = event.getId();
    }
}
