package com.examenweb.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examen.entities.Cv;
import com.examen.repository.CvRepository;
import com.examen.service.CvService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CvRepository cvrepository;
       
    public LoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		this.cvrepository = new CvService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cv cv = cvrepository.logon(request.getParameter("email"),request.getParameter("password"));
		if(cv != null) {
			HttpSession session1 = request.getSession();
			session1.setAttribute("userConnect", cv);
			response.sendRedirect("cv?action=list");
		}else {
			request.setAttribute("msg_error", "email or password incorrect");
			response.sendRedirect("login");
		}
	}

}
