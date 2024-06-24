package br.com.avaliacao.assembleia.votacao.application.controllers;

import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.SubjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/metting-management/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SubjectController {

    private final SubjectService subjectService;


    public SubjectController(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject")
    Subject create(@RequestBody final Subject subject) {
        return subjectService.create(subject);
    }

    @GetMapping("/screen/subject/{cpf}")
    ScreenResponse getScreen(@PathVariable String cpf) {
        return subjectService.getScreen(cpf);
    }
}
