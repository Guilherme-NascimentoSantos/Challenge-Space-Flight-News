package br.com.challenge.spaceflightnews.repository;

import br.com.challenge.spaceflightnews.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
