package se.scatteredbits.springboot.subjectlog;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubjectLogTest {

    private FixtureConfiguration<SubjectLog> testFixture;

    @Before
    public void setUp() throws Exception {
        testFixture = new AggregateTestFixture<>(SubjectLog.class);

//        testFixture.registerAnnotatedCommandHandler(
//                new BankAccountCommandHandler(testFixture.getRepository(), testFixture.getEventBus()));
//        testFixture.registerCommandDispatchInterceptor(new BeanValidationInterceptor<>());
    }

    @Test
    public void enroll(){
        String id = UUID.randomUUID().toString();

        testFixture.givenNoPriorActivity()
                .when(new EnrollSubjectCommand(id))
                .expectEvents(new SubjectEnrolledEvent(id));

    }

}
