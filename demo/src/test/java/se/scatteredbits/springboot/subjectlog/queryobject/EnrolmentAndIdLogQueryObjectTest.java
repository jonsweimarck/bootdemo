package se.scatteredbits.springboot.subjectlog.queryobject;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.scatteredbits.springboot.subjectlog.EnrollSubjectCommand;

import java.util.UUID;

import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EnrolmentAndIdLogQueryObjectTest {

    @Autowired private CommandBus commandBus;
    @Autowired private EnrolmentAndIdLogQueryObjectRepository repo;

    @Test
    public void enrolledSubjectCanBeFetchedAsQueryObject(){
        String id = UUID.randomUUID().toString();
        CommandMessage<EnrollSubjectCommand> cmdMess
                = GenericCommandMessage.asCommandMessage(new EnrollSubjectCommand(id));

        commandBus.dispatch(cmdMess);

        assertNotNull(repo.getOne(id));
    }

}
