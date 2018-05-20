package ru.home.echo;


import ru.home.echo.control.ControlClass;
import ru.home.echo.entity.Books;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServletClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher rd=null;
        ControlClass controlClass= new ControlClass();
        List<Books>books=controlClass.getAllData();

        req.setAttribute("Books",books);
        rd=req.getRequestDispatcher("BookStore.jsp");
        rd.forward(req,resp);



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher rd=null;

        Books books= new Books();
        ControlClass controlClass= new ControlClass();
        List<Books>booki=controlClass.getAllData();
        req.setAttribute("Books",booki);

        //controlClass.saveBook(books);
//        req.setAttribute("booking",books);

//        books.setName(req.getParameter("name").toString());
//        books.setAuthor(req.getParameter("author").toString());
//        books.setYear(Integer.parseInt(req.getParameter("year")));

//        List<Books>booksList= new ArrayList<>();
//        req.setAttribute("Books",booksList);
        rd=req.getRequestDispatcher("/books");
        rd.forward(req,resp);

    }
}
