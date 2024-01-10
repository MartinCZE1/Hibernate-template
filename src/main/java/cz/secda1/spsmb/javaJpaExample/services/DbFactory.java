package cz.secda1.spsmb.javaJpaExample.services;

import cz.secda1.spsmb.javaJpaExample.model.Band;
import cz.secda1.spsmb.javaJpaExample.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbFactory {
    private Session session;

    private void createSession() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        configuration.addAnnotatedClass(Band.class);

        // Create Session Factory
        SessionFactory sessionFactory
                = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();
         this.session = session;
    }

    public Session getSession() {
        if (session == null){
            createSession();
        }
        return session;
    }


}
