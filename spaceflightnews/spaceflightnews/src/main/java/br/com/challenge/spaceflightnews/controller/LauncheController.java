package br.com.challenge.spaceflightnews.controller;

import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.domain.Launche;
import br.com.challenge.spaceflightnews.repository.LauncheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LauncheController {

    @Autowired
    LauncheRepository launcheRepository;

    @PostMapping("/launche")
    public ResponseEntity postLaunche(@RequestBody Launche launche) {

        if (!launcheRepository.existsById(launche.getId())) {
            launcheRepository.save(launche);
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(400).build();

    }
}
