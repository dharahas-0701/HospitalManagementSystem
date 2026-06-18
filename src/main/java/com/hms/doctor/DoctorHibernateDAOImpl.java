package com.hms.doctor;

import com.hms.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DoctorHibernateDAOImpl implements DoctorDAO{

    SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public void addDoctor(Doctor doctor) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(doctor);
            tx.commit();
            System.out.println("Doctor has been added successfully");
            System.out.println("Doctor ID : " + doctor.getDoctorId());
        }
        catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Addition Of Doctor Failed" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Doctor> getAllDoctors() {
        Session session = null;
        try{
            session = factory.openSession();
            return new  ArrayList<>(session.createQuery("from Doctor", Doctor.class).list());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        Session session = null;
        try{
            session = factory.openSession();
            Doctor d = session.find(Doctor.class, doctorId);
            return d;
        }
        catch (Exception e){
            System.out.println("Doctor ID Not Found" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        updateDoctorDetails(doctor);
    }

    @Override
    public void updateDoctorField(int id, int choice, String newValue){

    }

    @Override
    public void deleteDoctor(int doctorId) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            Doctor d = session.find(Doctor.class, doctorId);
            if(d != null){
                session.remove(d);
                System.out.println("Doctor has been deleted successfully");
            }
            else{
                System.out.println("Doctor ID : " + doctorId + " not found");
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Deletion of Doctor Failed" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void printDetails(Doctor d) {
    }

    @Override
    public ArrayList<Doctor> getAvailableDoctorsBySpecialization(Doctor.Specialization specialization) {
        Session session = null;
        try {
            session = factory.openSession();
            return new ArrayList<>(session.createQuery("from Doctor where specialization = :spec and availability = :avai",Doctor.class)
                    .setParameter("spec", specialization).setParameter("avai", Doctor.Availability.AVAILABLE).list());
        }
        catch (Exception e) {
            System.out.println("Error retrieving Doctors" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public void updateDoctorDetails(Doctor doctor) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.merge(doctor);
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Doctor Updation Failed" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }
}
