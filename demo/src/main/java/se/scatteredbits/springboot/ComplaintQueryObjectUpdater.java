package se.scatteredbits.springboot;


import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.stereotype.Component;

@Component
public class ComplaintQueryObjectUpdater {

    private final ComplaintQueryObjectRepository repo;

    public ComplaintQueryObjectUpdater(ComplaintQueryObjectRepository repo) {
        this.repo = repo;
    }


    @EventSourcingHandler
    public void on(ComplaintFiledEvent event){
        repo.save(new ComplaintQueryObject(event.getId(), event.getCompany(), event.getDescription()));
    }
}
