package se.scatteredbits.springboot.subjectlog.queryobject;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.scatteredbits.springboot.subjectlog.SubjectEnrolledEvent;

@Service
public class EnrolmentAndIdLogQueryService {

    @Autowired
    private EnrolmentAndIdLogQueryObjectRepository repo;

    @EventSourcingHandler
    public void create(SubjectEnrolledEvent ev){
        repo.save(new EnrolmentAndIdLogQueryObject(ev.getId()));
    }
}
