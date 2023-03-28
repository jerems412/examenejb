package com.examenweb.controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.entities.Cv;
import com.examen.repository.CvRepository;
import com.examen.service.CvService;

@WebServlet("/cv")
public class CvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CvRepository cvrepository;
       
    public CvServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.cvrepository = new CvService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("action").equals("edit")) {
			request.setAttribute("cv", cvrepository.findById(Integer.parseInt(request.getParameter("id")), new Cv()));
        	request.getRequestDispatcher("WEB-INF/views/cv/edit.jsp").forward(request, response);
		} else if (request.getParameter("action").equals("delete")) {
			cvrepository.deleteById(Integer.parseInt(request.getParameter("id")),new Cv());
        	List<Cv> cv = cvrepository.findAll(new Cv());
			request.setAttribute("cvs", cv);
			request.getRequestDispatcher("WEB-INF/views/cv/list.jsp").forward(request, response);
		} else if (request.getParameter("action").equals("edition")) {
        	Cv cv = cvrepository.findById(Integer.parseInt(request.getParameter("id")), new Cv());
			request.setAttribute("cvs", cv);
			request.getRequestDispatcher("WEB-INF/views/cv/edition.jsp").forward(request, response);
		} else if (request.getParameter("action").equals("imprimer")) {
			cvrepository.print(cvrepository.findById(Integer.parseInt(request.getParameter("id")),new Cv()));
        	List<Cv> cv = cvrepository.findAll(new Cv());
			request.setAttribute("cvs", cv);
			request.getRequestDispatcher("WEB-INF/views/cv/list.jsp").forward(request, response);
		} else {
			List<Cv> cv = cvrepository.findAll(new Cv());
			request.setAttribute("cvs", cv);
			request.getRequestDispatcher("WEB-INF/views/cv/list.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action").equals("edit")) {
			Cv cv = cvrepository.findById(Integer.parseInt(request.getParameter("id")), new Cv());
			cv.setAdresse(request.getParameter("adresse"));
			cv.setAge(Integer.parseInt(request.getParameter("age")));
			cv.setEmail(cv.getEmail());
			cv.setExperienceProfessionnelle(request.getParameter("experienceProfessionnelle"));
			cv.setNiveauEtude(request.getParameter("niveauEtude"));
			cv.setNom(request.getParameter("nom"));
			cv.setPrenom(request.getParameter("prenom"));
			cv.setSpecialite(request.getParameter("specialite"));
			cv.setTelephone(request.getParameter("telephone"));
			cv.setPassword(cv.getPassword());
			cvrepository.update(cv);
			List<Cv> cvs = cvrepository.findAll(new Cv());
			request.setAttribute("cvs", cvs);
			request.getRequestDispatcher("WEB-INF/views/cv/list.jsp").forward(request, response);
		}
	}

}
