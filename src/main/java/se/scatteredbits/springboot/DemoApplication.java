package se.scatteredbits.springboot;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@RestController
	public static class ComplaintAPI{

        private final ComplaintQueryObjectRepository repo;
        private final CommandGateway commandGateway;


        public ComplaintAPI(ComplaintQueryObjectRepository repo, CommandGateway commandGateway) {
            this.repo = repo;
            this.commandGateway = commandGateway;
        }

        @PostMapping
        public CompletableFuture<String> fileComplaint(@RequestBody Map<String, String> request){
            String id = UUID.randomUUID().toString();
            return commandGateway.send(new FileComplaintCommand(id, request.get("company"), request.get("description")));
        }

        @GetMapping
		public List<ComplaintQueryObject> findAll(){
            return repo.findAll();
		}

        @GetMapping("/{id}")
        public ComplaintQueryObject findAll(@PathVariable("id") String id){
            return repo.getOne(id);
        }

	}


}
