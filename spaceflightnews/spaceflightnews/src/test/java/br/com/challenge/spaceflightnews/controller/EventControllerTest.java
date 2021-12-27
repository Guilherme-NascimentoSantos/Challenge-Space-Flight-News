package br.com.challenge.spaceflightnews.controller;

import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.domain.Event;
import br.com.challenge.spaceflightnews.repository.EventRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class EventControllerTest {

    @Autowired
    EventController eventController;

    @MockBean
    EventRepository eventRepository;

    @Test
    @DisplayName("Salvar um evento, deve retornar o status 201 sem evento corpo")
    void postEvent() {

        Event event = new Event();
        Event eventMock = mock(Event.class);

        when(eventRepository.save(event)).thenReturn(eventMock);

        ResponseEntity response = eventController.postEvent(event);

        assertEquals(201, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }
}