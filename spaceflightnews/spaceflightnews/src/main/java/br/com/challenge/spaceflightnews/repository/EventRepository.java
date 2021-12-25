package br.com.challenge.spaceflightnews.repository;

import br.com.challenge.spaceflightnews.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
