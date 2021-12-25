package br.com.challenge.spaceflightnews.controller;

import br.com.challenge.spaceflightnews.domain.Event;
import br.com.challenge.spaceflightnews.domain.Launche;
import br.com.challenge.spaceflightnews.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/event")
    public ResponseEntity postEvent(@RequestBody Event event) {

        eventRepository.save(event);
        return ResponseEntity.status(201).build();
    }
}
