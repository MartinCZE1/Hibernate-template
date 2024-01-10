package cz.secda1.spsmb.javaJpaExample.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @Column(name = "song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "song_name")
    String name;

    LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    Band band;


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", band=" + band +
                '}';
    }
}
