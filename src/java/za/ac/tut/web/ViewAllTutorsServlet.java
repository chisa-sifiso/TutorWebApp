package za.ac.tut.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.TutorFacadeLocal;
import za.ac.tut.models.Tutor;

/**
 *
 * @author sifis
 */
public class ViewAllTutorsServlet extends HttpServlet {
    @EJB TutorFacadeLocal tfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Tutor> tutors =tfl.findAll();
        request.setAttribute("tutors", tutors);
        
        request.getRequestDispatcher("view_all_tutors_outcome.jsp").forward(request, response);
    
    }



}
