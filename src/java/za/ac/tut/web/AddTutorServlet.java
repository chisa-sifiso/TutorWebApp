/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import za.ac.tut.bl.TutorFacadeLocal;
import za.ac.tut.models.Tutor;

/**
 *
 * @author sifis
 */
@MultipartConfig
public class AddTutorServlet extends HttpServlet {
@EJB TutorFacadeLocal tfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part part = request.getPart("photo");
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        Long id = Long.parseLong(request.getParameter("id"));
        String[] subjects = request.getParameterValues("subjects");
        String date = request.getParameter("date");
        
        byte[] image_byte=null;
          if(part.getSize()>0&&part!=null)
          {
            InputStream input = part.getInputStream();
            image_byte =  new byte[(int)part.getSize()];
            input.read(image_byte);
        }
        
        List<String> subList = new ArrayList<>();
        
        for (int i = 0; i < subjects.length; i++) {
            
            subList.add(subjects[i]);
        }
        
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        Date updatedDate = null;
        
        try {
           updatedDate= formate.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(AddTutorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        Tutor tutor = new  Tutor();
        tutor.setPhoto(image_byte);tutor.setName(name);tutor.setAge(age);
        tutor.setGender(gender);tutor.setId(id);tutor.setSubs(subList);
        tutor.setDate(updatedDate);
        request.setAttribute("tutor", tutor);
        
        tfl.create(tutor);
        request.getRequestDispatcher("add_tutor_outcome.jsp").forward(request, response);
        
        
    
    }



}
