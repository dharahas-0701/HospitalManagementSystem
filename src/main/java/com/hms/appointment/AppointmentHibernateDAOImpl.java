package com.hms.appointment;

import com.hms.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AppointmentHibernateDAOImpl implements AppointmentDAO{

    SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public void bookAppointment(Appointment a) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(a);
            tx.commit();
            System.out.println("Appointment booked successfully");
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Error in Booking Appointment" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Appointment> getAppointments(){
        Session session = null;
        try{
            session = factory.openSession();
            return new ArrayList<>(session.createQuery("from Appointment", Appointment.class).list());
        }
        catch (Exception e){
            System.out.println("Error in retrieving Appointment from DB" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Appointment getAppointmentById(int id) {
        Session session = null;
        try{
            session = factory.openSession();
            return session.find(Appointment.class, id);
        }
        catch (Exception e){
            System.out.println("Error in retrieving Appointment from DB" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void updateAppointmentStatus(int appointmentId, Appointment.Status status) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            Appointment a = session.find(Appointment.class, appointmentId);
            if(a != null){
                a.setStatus(status);
                session.merge(a);
                System.out.println("Appointment updated successfully");
            }
            else{
                System.out.println("Appointment not found with id " + appointmentId);
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Error in updating Appointment status from DB" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void cancelAppointment(int appointmentId) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            Appointment a = session.find(Appointment.class, appointmentId);
            if(a != null){
                a.setStatus(Appointment.Status.CANCELLED);
                session.merge(a);
            }
            else{
                System.out.println("Appointment not found with id " + appointmentId);
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Error in retrieving Appointment from DB" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void printDetails(Appointment a) {

    }
    @Override
    public void updateAppointmentDetails(Appointment a) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.merge(a);
            tx.commit();
            System.out.println("Appointment updated successfully");
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Error in updating Appointment details from DB" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }
}

