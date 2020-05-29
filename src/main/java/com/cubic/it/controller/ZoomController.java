package com.cubic.it.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cubic.it.dao.CubicDao;
import com.cubic.it.dao.CubicDaoImpl;
import com.cubic.it.dao.entity.UserEntity;

//Here you cannot use any other annotation like @Service , @Resposity and Component
@Controller
public class ZoomController {
	
	
	@GetMapping("/dasha")
	public String dashboardPage() {
		 return "dashboard"; //WEB-INF/pages/dashboard.jsp
	}

	
	@GetMapping({"/ola","/auth","/"})
	public String auth() {
		 return "login";
		 ///WEB-INF/pages/login.jsp
	}
	
	//	<form name="loginform" action="auth" method="post">
	@PostMapping("/auth")
	public String authUser(HttpServletRequest req) {
		 String username=req.getParameter("username");
         String password=req.getParameter("password");
         CubicDao cubicDao=new CubicDaoImpl();
         UserEntity userEntity=cubicDao.authUser(username, password);
         if(userEntity!=null)  {
       	  HttpSession session=req.getSession();
			   session.setMaxInactiveInterval(30*2*5);
			   //Adding data into session scope instead of request scope
			   session.setAttribute("pdata", userEntity);
			  return "review";  
	 }else {
		  return "fail";
	 }
	}
}
