package br.com.challenge.spaceflightnews.controller;


import br.com.challenge.spaceflightnews.domain.Article;
import br.com.challenge.spaceflightnews.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;


    @GetMapping
    public ResponseEntity getWelcomeMessage() {
        return ResponseEntity.status(200).body("Back-end Challenge 2021 🏅 - Space Flight News");
    }

    @GetMapping("/articles")
    public ResponseEntity getAllArticles() {
        Pageable pageable = Pageable.unpaged();
        return ResponseEntity.of(Optional.of(articleRepository.findAll(pageable.first())));
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity getOnlyOneArticle(@PathVariable Integer id) {

        if (articleRepository.existsById(id)) {
            return ResponseEntity.status(200).body(articleRepository.findById(id));
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping("/articles")
    public ResponseEntity postArticle(@RequestBody Article article) {

        articleRepository.save(article);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity putOnlyOneArticle(@PathVariable Integer id,
                                            @RequestBody Article article) {

        if (articleRepository.existsById(id)) {
            article.setId(id);
            articleRepository.save(article);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity deleteOnlyOneArticle(@PathVariable Integer id) {

        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

}
