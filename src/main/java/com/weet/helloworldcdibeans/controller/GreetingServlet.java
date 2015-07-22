package com.weet.helloworldcdibeans.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weet.helloworldcdibeans.entity.GreetingType;
import com.weet.helloworldcdibeans.entity.Greetings;
import com.weet.helloworldcdibeans.service.GreetingCard;

@WebServlet(name = "greetingServlet", urlPatterns = {"/sayHello"})
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 2280890757609124481L;
	
	@Inject
	@Greetings(GreetingType.HELLO)
	private GreetingCard greetingCard;

	@Inject
	@Greetings(GreetingType.HI)
	private GreetingCard anotherGreetingCard;

	  public void init() throws ServletException {
	  }

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + greetingCard.sayHello() + "</h1>");
	      out.println("<h1>" + anotherGreetingCard.sayHello() + "</h1>");
	  }
	  
	  public void destroy(){
	  }

}

