package org.example.domain;

import jakarta.persistence.Query;
import org.example.model.BookDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernateSession {
    private  static final SessionFactory sessionFactory = HibernateSessionFactory.getHibernateSessionFactory();
    private static final Session session = sessionFactory.getCurrentSession();
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSession.class);


    // save new record in database
    public static void saveCompleteRecord(BookDTO bookDTO){
        Book book = new Book();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(bookDTO, book);
        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
    }


    // Give specific record from database
    public static Book getRecordById(long id){
        session.beginTransaction();
        Query query = session.createQuery("FROM library WHERE id = :id" , Book.class);
        query.setParameter("id", id);
        return (Book) query.getSingleResult();
    }


    // Give all records from database
    public static List<Book> getAllRecords(){
        session.beginTransaction();
        Query query = session.createQuery("From library", Book.class);
         return  query.getResultList();
    }

    // Get Record by book name
    public static Book getRecordByTitle(String title){
        session.beginTransaction();
        Query query = session.createQuery("FROM library WHERE title = :title", Book.class);
        query.setParameter("title", title);
        return (Book) query.getSingleResult();
    }

    public static void updateRowOfTable(long id, int quantity){
        session.beginTransaction();
        Query query = session.createQuery(
                "update library set totalCount=:quantity where id=:id", Book.class);
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        int result = query.executeUpdate();
        LOGGER.info("The update query executed successfully :  {}", result);
        session.getTransaction().commit();
        session.close();

    }

    public static void updateSoldRecords(long id, int quantity, int sold){
        session.beginTransaction();
        Query query = session.createQuery(
                "update library set totalCount=:quantity, sold=:sold where id=:id", Book.class);
        query.setParameter("id", id);
        query.setParameter("quantity", quantity);
        query.setParameter("sold", sold);
        int result = query.executeUpdate();
        LOGGER.info("table updated : {}", result);
        session.getTransaction().commit();
        session.close();
    }


// update records

// find list of sold

// find total counts

// sell book


    
}

