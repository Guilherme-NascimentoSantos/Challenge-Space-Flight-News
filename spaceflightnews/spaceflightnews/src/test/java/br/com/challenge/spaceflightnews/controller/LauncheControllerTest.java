package br.com.challenge.spaceflightnews.controller;

import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.domain.Launche;
import br.com.challenge.spaceflightnews.repository.LauncheRepository;
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
class LauncheControllerTest {

    @Autowired
    LauncheController launcheController;

    @MockBean
    LauncheRepository launcheRepository;

    @Test
    @DisplayName("Salvar um lançamento, deve retornar o status 201 sem lançamento no corpo")
    public void postLaunche_status200() {

        Launche launche = new Launche();
        Launche launcheMock = mock(Launche.class);

        when(launcheRepository.save(launche)).thenReturn(launcheMock);

        ResponseEntity response = launcheController.postLaunche(launche);

        assertEquals(201, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

}