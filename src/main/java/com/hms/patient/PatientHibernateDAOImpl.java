package com.hms.patient;

import com.hms.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class PatientHibernateDAOImpl implements PatientDAO{

    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    @Override
    public void addPatient(Patient p) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(p);
            tx.commit();
            System.out.println("Successfully added a patient");
            System.out.println("Patient ID : " + p.getPatientId());
        }
        catch (Exception e){
            if(tx!=null) tx.rollback();
            System.out.println("Error adding a patient" + e.getMessage());
        }
        finally{
            if(session!=null) session.close();
        }
    }

    @Override
    public ArrayList<Patient> getAllPatients() {
        Session session = null;
        try{
            session = factory.openSession();
            return new ArrayList<>( session.createQuery("from Patient", Patient.class).list());
        }
        catch (Exception e){
            System.out.println("Error retrieving all patients");
        }
        finally{
            if(session!=null) session.close();
        }
        return new ArrayList<>();
    }

    @Override
    public Patient getPatientById(int id) {
        Session session = null;
        try{
            session = factory.openSession();
            return session.find(Patient.class, id);
        }
        catch (Exception e){
            System.out.println("Error getting a patient by id" + e.getMessage());
        }
        finally{
            if(session!=null) session.close();
        }
        return null;
    }

    @Override
    public void updatePatient(Patient P){
        updatePatientDetails(P);
    }

    @Override
    public void deletePatient(int id) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            Patient p = session.find(Patient.class, id);
            if(p != null){
                session.remove(p);
                System.out.println("Successfully removed a patient");
            }
            else{
                System.out.println("Patient with id " + id + " not found");
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null) tx.rollback();
            System.out.println("Error updating a patient by id" + e.getMessage());
        }
        finally{
            if(session!=null) session.close();
        }
    }

    @Override
    public void printDetails(Patient p) {

    }
    @Override
    public void updatePatientField(int patientId, int choice, String newValue){

    }

    @Override
    public void updatePatientDetails(Patient p) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx =  session.beginTransaction();
            session.merge(p);
            tx.commit();
            System.out.println("Successfully updated a patient");
        }
        catch (Exception e){
            if(tx!=null) tx.rollback();
            System.out.println("Error updating a patient details by id" + e.getMessage());
        }
        finally{
            if(session!=null) session.close();
        }
    }

}
