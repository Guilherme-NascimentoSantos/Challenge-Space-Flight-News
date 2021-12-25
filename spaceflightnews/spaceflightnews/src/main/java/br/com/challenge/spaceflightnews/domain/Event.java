package br.com.challenge.spaceflightnews.domain;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    private String id;
    private String provider;


    public Event(String id, String provider) {
        this.id = id;
        this.provider = provider;
    }

    public Event() {
    }
}
