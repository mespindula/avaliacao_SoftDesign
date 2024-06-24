package br.com.avaliacao.assembleia.votacao.application.controllers;

import br.com.avaliacao.assembleia.votacao.application.model.VotingRequest;
import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.VotingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/metting-management/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class VotingController {

    private VotingService votingService;

    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @GetMapping("/screen/voting/{uuid}")
    ScreenResponse getScreen(@PathVariable String uuid) {
        return votingService.getScreen(uuid);
    }

    @PostMapping("/screen/voting/{uuid}")
    void setVoting(@PathVariable String uuid,
                             @RequestBody VotingRequest votingRequest) {
        votingService.setVoting(uuid, votingRequest);
    }
}
