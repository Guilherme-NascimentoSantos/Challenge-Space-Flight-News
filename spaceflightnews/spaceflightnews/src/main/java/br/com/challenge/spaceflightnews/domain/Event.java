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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Event() {
    }
}
