package cz.secda1.spsmb.javaJpaExample.repository;

import cz.secda1.spsmb.javaJpaExample.model.Genre;
import cz.secda1.spsmb.javaJpaExample.model.Song;
import org.hibernate.Session;

import java.util.List;

public class GenreRepository {
    public static List<Genre> getGenresByBandName(Session session, String genreName) {
        List<Genre> filteredSongs = session.createQuery("SELECT s from Genre s where s.name = :genreName", Genre.class)
                .setParameter("genreName", genreName).getResultList();
        return filteredSongs;
    }
}
