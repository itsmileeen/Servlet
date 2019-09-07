package com.senati.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saludo
 */
public class Saludo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Saludo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Creamos la variable usuario y le asignamos el valor del campo del formulario
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("password");
		System.out.println(usuario);
		System.out.println(clave);
		
		if(usuario.equals("admin") && clave.equals("123@")) {
			System.out.println("Welcome...!! Java Webs");
			request.setAttribute("usuarioLogueado", usuario);
			//Para que se dirija a la pagina jsp
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
		}
		else {
			System.out.println("Error en las credenciales.");
			//Programar el else para que se dirija al index.html
			response.sendRedirect("index.html");
		}
	}

}
