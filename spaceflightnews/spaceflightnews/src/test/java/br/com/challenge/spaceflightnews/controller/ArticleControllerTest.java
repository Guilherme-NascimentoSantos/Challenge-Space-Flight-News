package br.com.challenge.spaceflightnews.controller;

import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ArticleControllerTest {

    @MockBean
    ArticleRepository articleRepository;

    @Autowired
    ArticleController articleController;

    @Test
    @DisplayName("Deve retornar uma mensagem de boas vindas com corpo")
    public void getWelcomeMessage_status200_comCorpo() {

        ResponseEntity response = articleController.getWelcomeMessage();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
    }

    @Test
    @DisplayName("Deve retornar o status 200 com todos os artigos salvos")
    public void getAllArticles_status200() {

        Pageable pageable = Pageable.unpaged();
        Page<Article> articlesPageMock = mock(Page.class);

        when(articleRepository.findAll(pageable)).thenReturn(articlesPageMock);

        ResponseEntity response = articleController.getAllArticles();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
        assertEquals(articlesPageMock, response.getBody());

    }

    @Test
    @DisplayName("Buscar só um artigo, deve retornar o status 200 com um artigo no corpo")
    public void getOnlyOneArticle_status200() {

        Integer idTeste = 1;

        Article articleMock = mock(Article.class);

        when(articleRepository.existsById(idTeste)).thenReturn(true);
        when(articleRepository.findById(idTeste)).thenReturn(Optional.of(articleMock));

        ResponseEntity response = articleController.getOnlyOneArticle(idTeste);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
    }

    @Test
    @DisplayName("Buscar só um artigo, deve retornar o status 404 sem artigo no corpo")
    public void getOnlyOneArticle_status404() {

        Integer idTeste = 1;

        when(articleRepository.existsById(idTeste)).thenReturn(false);

        ResponseEntity response = articleController.getOnlyOneArticle(idTeste);

        assertEquals(404, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    @DisplayName("Salvar um artigo, deve retornar o status 201 sem artigo no corpo")
    public void postArticle() {

        Article article = new Article();
        Article articleMock = mock(Article.class);

        when(articleRepository.save(article)).thenReturn(articleMock);

        ResponseEntity response = articleController.postArticle(article);

        assertEquals(201, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    @DisplayName("Alterar os dados de um artigo, deve retornar o status 200 sem artigo no corpo")
    public void putOnlyOneArticle_status200() {

        Article article = new Article();
        Article articleMock = mock(Article.class);
        Integer idTeste = 1;

        when(articleRepository.existsById(idTeste)).thenReturn(true);
        when(articleRepository.save(article)).thenReturn(articleMock);

        ResponseEntity response = articleController.putOnlyOneArticle(idTeste, article);

        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    @DisplayName("Alterar os dados de um artigo, deve retornar o status 404 sem artigo no corpo")
    public void putOnlyOneArticle_status404() {

        Article article = new Article();
        Integer idTeste = 1;

        when(articleRepository.existsById(idTeste)).thenReturn(false);

        ResponseEntity response = articleController.putOnlyOneArticle(idTeste, article);

        assertEquals(404, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    @DisplayName("Deletar um artigo, deve retornar o status 200 sem artigo no corpo")
    public void deleteOnlyOneArticle_status200() {

        Integer idTeste = 1;

        when(articleRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity response = articleController.deleteOnlyOneArticle(idTeste);

        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    @DisplayName("Deletar um artigo inexistente, deve retornar o status 404 sem artigo no corpo")
    public void deleteOnlyOneArticle_status404() {

        Integer idTeste = 1;

        when(articleRepository.existsById(idTeste)).thenReturn(false);

        ResponseEntity response = articleController.deleteOnlyOneArticle(idTeste);

        assertEquals(404, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

}