/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SearchTutorServlet extends HttpServlet {

   @EJB TutorFacadeLocal tfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Long id =Long.parseLong(request.getParameter("id"));
       String loction="tutor_not_found.html";
       Tutor tutor =tfl.find(id);
       if(tutor!=null){
           request.setAttribute("tutor", tutor);
           loction="search_tutor_outcome.jsp";
       }
       
       request.getRequestDispatcher(loction).forward(request, response);
    }

   

}
