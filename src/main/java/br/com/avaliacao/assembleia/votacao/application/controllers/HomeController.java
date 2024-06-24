package br.com.avaliacao.assembleia.votacao.application.controllers;

import br.com.avaliacao.assembleia.votacao.application.model.screen.MeetingHomeScreenResponse;
import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.AssociateService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/metting-management/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class HomeController {

    @GetMapping("/screen/home")
    ScreenResponse getHomeScreen() {
        return new MeetingHomeScreenResponse().getScreen();
    }

}
