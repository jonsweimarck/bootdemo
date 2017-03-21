
package se.scatteredbits.springboot.api;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.scatteredbits.springboot.subjectlog.EnrollSubjectCommand;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.UUID;

@Component
@Path("/enrollment")
public class EnrollmentApi {

    private CommandBus commandBus;

    @Autowired
    public EnrollmentApi(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    @GET
    @Path("ping")
    public String ping() {
        return "pong";
    }

    @POST
    @Path("enroll")
    public void enroll() {
        String id = UUID.randomUUID().toString();
        CommandMessage<EnrollSubjectCommand> cmdMess
                = GenericCommandMessage.asCommandMessage(new EnrollSubjectCommand(id));

        commandBus.dispatch(cmdMess);
    }

}