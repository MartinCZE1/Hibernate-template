package cz.secda1.spsmb.javaJpaExample;

import cz.secda1.spsmb.javaJpaExample.model.Genre;
import cz.secda1.spsmb.javaJpaExample.model.Song;
import cz.secda1.spsmb.javaJpaExample.model.User;
import cz.secda1.spsmb.javaJpaExample.repository.GenreRepository;
import cz.secda1.spsmb.javaJpaExample.repository.SongRepository;
import cz.secda1.spsmb.javaJpaExample.repository.UserRepository;
import cz.secda1.spsmb.javaJpaExample.services.DBInit;
import cz.secda1.spsmb.javaJpaExample.services.DbFactory;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        DbFactory dbFactory = new DbFactory();
        Session session = dbFactory.getSession();

        DBInit.initDB(session);

        Optional<Song> mySong = SongRepository.getSongById(session, 1l);
        System.out.println(mySong);
        List<Song> filteredSongs = SongRepository.getSongsByBandName(session, "AC/DC");
        System.out.println(filteredSongs);

         List <Genre> genre1= GenreRepository.getGenresByBandName(session, "Pop");
        System.out.println(genre1);

        List <User> user1= UserRepository.getUsersByName(session, "Ouyi");
        System.out.println(user1.get(0).getSongs());

        double avgRating = SongRepository.getSongAvgRatings(session, 1);
        System.out.println(avgRating);

        session.beginTransaction();
        if (mySong.isPresent()){
            Song song = mySong.get();
            song.setName(song.getName() + " UPDATED");
            session.persist(song);
        }
        session.getTransaction().commit();

    }
}
