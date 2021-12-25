package br.com.challenge.spaceflightnews.repository;

import br.com.challenge.spaceflightnews.domain.Launche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LauncheRepository extends JpaRepository<Launche, String> {
}
