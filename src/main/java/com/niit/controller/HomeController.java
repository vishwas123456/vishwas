package com.niit.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Product;
import com.niit.service.ProductSevice;


@Controller()
public class HomeController {

	@Autowired
	ProductSevice productService;
	
	@RequestMapping(value= {"/","/index"})
	public String home() 
	{
		return "index" ;
		
	}
/*	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
		
	}*/
	@RequestMapping("/allproducts")
	public String getAllproducts(Model m) {
		List<Product> allproduct=productService.getAllProduct();
		m.addAttribute("products", allproduct );
		return "allProducts";
		
	}
	
}
/*	
	@RequestMapping("/allproducts")
	public ModelAndView getAllProduct() {
		List<Product> allProducts= productService.getAllProduct();
				return new ModelAndView("AllProducts", "products",allProducts);
		
	

}
*/
