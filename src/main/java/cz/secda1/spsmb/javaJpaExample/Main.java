package cz.secda1.spsmb.javaJpaExample;

import cz.secda1.spsmb.javaJpaExample.model.Song;
import cz.secda1.spsmb.javaJpaExample.repository.SongRepository;
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

        session.beginTransaction();
        if (mySong.isPresent()){
            Song song = mySong.get();
            song.setName(song.getName() + " UPDATED");
            session.persist(song);
        }
        session.getTransaction().commit();


    }
}
