package cz.secda1.spsmb.javaJpaExample.repository;

import cz.secda1.spsmb.javaJpaExample.model.User;
import org.hibernate.Session;

import java.util.List;

public class UserRepository {

    public static List<User> getUsersByName(Session session, String user) {
        List<User> filteredSongs = session.createQuery("SELECT u from User u where u.name = :user", User.class)
                .setParameter("user", user).getResultList();
        return filteredSongs;
    }
}
