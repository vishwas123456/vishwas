package com.niit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.model.Product;
import com.niit.service.ProductSevice;

@Controller
public class ProductController {
@Autowired
ProductSevice productservice;
@RequestMapping("/viewProduct/{pid}")
public String viewProduct(@PathVariable int pid, Model model) throws IOException
{
	
	Product product=productservice.getProductById(pid);
	model.addAttribute("product", product);
	return "viewProduct";
}


	

		
}
