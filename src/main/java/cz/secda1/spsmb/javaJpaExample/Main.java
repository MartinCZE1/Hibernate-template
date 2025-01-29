package cz.secda1.spsmb.javaJpaExample;


import cz.secda1.spsmb.javaJpaExample.model.User;
import cz.secda1.spsmb.javaJpaExample.repository.UserRepository;
import cz.secda1.spsmb.javaJpaExample.services.DbFactory;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = new DbFactory().getSession();

        User user1 = new User();
        user1.setName("Jan");
        user1.setSurname("Holan");
        user1.setAddress("Na Praze1");
        user1.setEmail("Email@gmail.com");
        user1.setPassword("Some pass");

        session.persist(user1);

        User user2 = new User();
        user1.setName("Tom");
        user1.setSurname("Holan");
        user1.setAddress("Na Praze 2");
        user1.setEmail("Email2@gmail.com");
        user1.setPassword("Some another pass");

        session.getTransaction().commit();

        List<User> allUsers = UserRepository.getUsersAllUsers(session);
        User foundUser = UserRepository.getUsersById(session, 1L);

        System.out.println(allUsers);
        System.out.println(foundUser);
    }
}
