package se.scatteredbits.springboot;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import static org.axonframework.commandhandling.model.AggregateLifecycle.*;

@Aggregate
public  class Complaint {

    @AggregateIdentifier
    private String complaintId;

    @CommandHandler
    public Complaint(FileComplaintCommand cmd) {
        Assert.hasLength(cmd.getCompany());
        apply(new ComplaintFiledEvent(cmd.getId(), cmd.getCompany(), cmd.getDescription()));
    }
}
