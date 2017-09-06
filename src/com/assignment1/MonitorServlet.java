package com.assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonitorServlet
 */
@WebServlet("/MonitorServlet")
public class MonitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonitorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		String action="";
        PrintWriter out=response.getWriter(); 
		
		if(GlobalConstants.state==States.LOGGEDIN) {
		GlobalConstants.actionInstance= Actions.getActionInstance();
		System.out.println("Users action is "+request.getParameter("action"));
		switch(request.getParameter("action")) {
		case "Comment":
			Actions.addAction("You commented");
			action="You commented";
			break;
		case "Search":
			Actions.addAction("You tried searching for something");
			action="You tried searching for something";
			break;
		case "Post":
			Actions.addAction("You posted a question");
			action="You posted a question";
			break;
		case "Scroll":
			Actions.addAction("You are viewing the post");
			action="You are viewing the post";
			return;
		case "Favourite":
			Actions.addAction("You favourited a question");
			action="You favourited a question";
			break;
		case "Upvote":
			Actions.addAction("You upvoted a question");
			action="You upvoted a question";
			break;
		case "Downvote":
			Actions.addAction("You downvoted a question");
			action="You downvoted a question";
			break;
			
			
		}
		
		String name= GlobalConstants.userName;
		String timeStamp = new SimpleDateFormat("dd-MM-YYYY   HH:mm:ss").format(new Date());
		FileUtility.createOrAppendContent(GlobalConstants.directoryPrefix+name+"Actions.txt", "".join(",",action,timeStamp));
		
		}
		
		
		}
	

}
