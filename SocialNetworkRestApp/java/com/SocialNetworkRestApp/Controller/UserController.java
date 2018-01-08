package com.SocialNetworkRestApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
		
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("register")User register)
	{
			System.out.println("Register");	
			ModelAndView model=new ModelAndView("register");
			return model;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView Success(User reg, Model m)
	{
			boolean h=userDao.saveUser(reg);
			ModelAndView model=new ModelAndView("sam","Register", new User());
			return model;
	}
	
	

}
