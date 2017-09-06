package com.assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add login and password to an existing login.txt file
		createDirectory();
		addLoginEntry(request.getParameter("username"), request.getParameter("password"));
		System.out.println("Entry successfully put in file.\nLogin name is" + request.getParameter("username"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("You have successfully created your account");
		request.getRequestDispatcher("login.jsp").include(request, response);
	}

	public void createDirectory() {
		String directoryName = "./Database/";
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdir();
			File file = new File("./Database/Login.txt");
			FileWriter writer = null;
			try {
				writer= new FileWriter(file,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BufferedWriter bw = new BufferedWriter(writer);
			try {
				bw.write("aaa,123");
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.write("bbb,123");
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.write("ccc,123");
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		} else
			System.out.println("Directory already exists");
	}

	public void addLoginEntry(String username, String password) {
		String s = String.join(",", username, password);
		FileUtility.createOrAppendContent(GlobalConstants.directoryPrefix+"Login.txt", s);

	}

}
