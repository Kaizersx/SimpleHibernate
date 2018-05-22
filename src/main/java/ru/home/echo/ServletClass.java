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

        ControlClass controlClass= new ControlClass();
        RequestDispatcher rd = null;

        if (req.getParameter("action" )!=null) {

            if (req.getParameter("action").equals("delete")) {

                int id = Integer.parseInt(req.getParameter("id"));
                Books books = new Books();
                books.setId(id);

                controlClass.deleteBook(books);

                List<Books> book = controlClass.getAllData();
                req.setAttribute("Books", book);
                rd = req.getRequestDispatcher("BookStore.jsp");
            }

            else if (req.getParameter("action").equals("update")){

                int id = Integer.parseInt(req.getParameter("id").toString());


                Books book = controlClass.getBooksById(id);
                req.setAttribute("booking", book);
                req.setAttribute("action", "update");

                List<Books> books = controlClass.getAllData();
                req.setAttribute("Books", books);

                rd = req.getRequestDispatcher("BookStore.jsp");

            }
        }
        else {

            List<Books> books = controlClass.getAllData();
            req.setAttribute("Books", books);
            rd = req.getRequestDispatcher("BookStore.jsp");
        }

        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action").toString();

        RequestDispatcher rd=null;
        if(action.equals("new")) {
            Books books = new Books();
            ControlClass controlClass = new ControlClass();

            req.setAttribute("booking", books);

            books.setName(req.getParameter("bookname").toString());
            books.setAuthor(req.getParameter("bookauthor").toString());
            books.setYear(Integer.parseInt(req.getParameter("bookyear")));

            controlClass.saveBook(books);


            List<Books> booksList = controlClass.getAllData();
            req.setAttribute("Books", booksList);
            rd = req.getRequestDispatcher("BookStore.jsp");
        }

        else if(action.equals("update")){

            Books book= new Books();
            book.setName(req.getParameter("bookname").toString());
            book.setAuthor(req.getParameter("bookauthor").toString());
            book.setYear(Integer.parseInt(req.getParameter("bookyear")));

            book.setId(Integer.parseInt(req.getParameter("bookingid").toString()));

            ControlClass controlClass= new ControlClass();
            controlClass.updateBook(book);

            List<Books>booksList= controlClass.getAllData();
            req.setAttribute("Books",booksList);
            rd=req.getRequestDispatcher("BookStore.jsp");

        }



        rd.forward(req,resp);

    }
}
