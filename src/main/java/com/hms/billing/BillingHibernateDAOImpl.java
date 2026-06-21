package com.hms.billing;

import com.hms.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class BillingHibernateDAOImpl implements BillingDAO {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public void generateBill(Bill b) {
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(b);
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("Bill Generation Failed" + e.getMessage());
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Bill> getAllBills() {
        Session session = null;
        try{
            session = factory.openSession();
            return new ArrayList<Bill>(session.createQuery("from Bill", Bill.class).list());
        }
        catch (Exception e){
            System.out.println("The Action Failed" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Bill getBillById(int id) {
        Session session = null;
        try{
            session = factory.openSession();
            Bill b = session.find(Bill.class, id);
            return b;
        }
        catch (Exception e){
            System.out.println("The Action Failed" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void markBillAsPaid(int id){
        Session session = null;
        Transaction tx = null;
        try{
            session = factory.openSession();
            tx = session.beginTransaction();
            Bill b = session.find(Bill.class, id);
            if(b != null){
                b.setPaymentStatus(Bill.PaymentStatus.PAID);
                session.merge(b);
                System.out.println("Bill Marked as Paid");
            }
            else{
                System.out.println("Bill Not Found");
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            System.out.println("The Action Failed" + e.getMessage());
        }
        finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void printDetails(Bill b) {

    }
}
