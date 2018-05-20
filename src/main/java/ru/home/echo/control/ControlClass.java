package ru.home.echo.control;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.home.echo.DAO.GetSession;
import ru.home.echo.entity.Books;

import java.util.ArrayList;
import java.util.List;

public class ControlClass {
    public List<Books> getAllData(){

        GetSession getSession= new GetSession();
        Session session= getSession.getSessionFactory().openSession();
        List<Books>book=new ArrayList<>();
        Query query=session.createQuery("from Books book");
        book= query.list();

        return  book;

    }

    public void saveBook(Books book) {
        GetSession getSession= new GetSession();
        Session session = getSession.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        session.save(book);
        t.commit();
        System.out.println("inserted.......");

    }


}
