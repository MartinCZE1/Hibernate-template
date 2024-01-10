package cz.secda1.spsmb.javaJpaExample;

import cz.secda1.spsmb.javaJpaExample.services.DbFactory;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        DbFactory dbFactory = new DbFactory();
        Session session = dbFactory.getSession();

    }
}
