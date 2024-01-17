package org.koushik.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.FourWheeler;
import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {
    public static void main(String[] args) {                

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("Yamaha");
        bike.setSteeringHandle("handle steer");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Ford");
        car.setSteeringWheel("round steer");
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.persist(vehicle);
        session.persist(bike);
        session.persist(car);
        session.getTransaction().commit();

        session.close();
    }
}