package br.com.challenge.spaceflightnews.domain;

import javax.persistence.*;

@Entity
public class Launche {


    @Id
    private String id;
    private String provider;

    public Launche(String id, String provider) {
        this.id = id;
        this.provider = provider;
    }

    public Launche() {
    }

    @Override
    public String toString() {
        return "Launche{" +
                "id='" + id + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
