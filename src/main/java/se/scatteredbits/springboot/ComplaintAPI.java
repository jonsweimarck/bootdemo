package se.scatteredbits.springboot;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Created by jons on 2017-02-20.
 */
@RequestMapping("/complaints")
@RestController
public class ComplaintAPI {

    private ComplaintQueryObjectRepository repo;
    private CommandGateway commandGateway;


    public ComplaintAPI(ComplaintQueryObjectRepository repo, CommandGateway commandGateway) {
        this.repo = repo;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<String> fileComplaint(@RequestBody Map<String, String> request) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(new FileComplaintCommand(id, request.get("company"), request.get("description")));
    }

    @GetMapping
    public List<ComplaintQueryObject> findAll() {
        List<ComplaintQueryObject> result =  repo.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public ComplaintQueryObject get(@PathVariable("id") String id) {
        return repo.getOne(id);
    }

}
