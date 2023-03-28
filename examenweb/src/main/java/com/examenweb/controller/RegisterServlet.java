package com.examenweb.controller;

import java.io.IOException;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CvRepository cvrepository;
       
    public RegisterServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.cvrepository = new CvService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cv cv = new Cv();
		cv.setAdresse(request.getParameter("adresse"));
		cv.setAge(Integer.parseInt(request.getParameter("age")));
		cv.setEmail(request.getParameter("email"));
		cv.setExperienceProfessionnelle(request.getParameter("experienceProfessionnelle"));
		cv.setNiveauEtude(request.getParameter("niveauEtude"));
		cv.setNom(request.getParameter("nom"));
		cv.setPrenom(request.getParameter("prenom"));
		cv.setSpecialite(request.getParameter("specialite"));
		cv.setTelephone(request.getParameter("telephone"));
		cv.setPassword(request.getParameter("password"));
		if(cvrepository.Register(cv)) {
			response.sendRedirect("login");
		}else {
			response.sendRedirect("register");
		}
	}

}
