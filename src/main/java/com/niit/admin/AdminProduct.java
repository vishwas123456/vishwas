package com.niit.admin;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Product;
import com.niit.service.ProductSevice;
@Controller
@RequestMapping("/admin")
public class AdminProduct {

	@Autowired
	private ProductSevice productService;
	private Path path;
	
	
	@RequestMapping("product/addProduct")
	public String addProduct(Model model) {
		
		Product product=new Product();
		model.addAttribute("product", product);
		return "addProduct";
		
	}
	@RequestMapping(value="product/addProduct/submit" , method=RequestMethod.POST)
	public String addProductData(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request ) {
		
		if(result.hasErrors()){
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getImages();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getPid() + ".png");

        if(productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex){
                ex.printStackTrace();
                throw new RuntimeException("Product image saving failed", ex);
            }
        }

        return "redirect:/admin/productInventory";
    }

	@RequestMapping("product/editProduct/{pid}")
	public String editProduct(@PathVariable int pid, Model model) throws IOException{
		
		Product product=productService.getProductById(pid);
		model.addAttribute("product", product);
		return "editProduct";
	}
	@RequestMapping(value="products/editProduct/submit" , method=RequestMethod.POST)
	public String editProductData(@ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {
		
		 if(result.hasErrors()){
	            return "editProduct";
	        }


	        MultipartFile productImage = product.getImages();
	        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getPid() + ".png");

	        if(productImage != null && !productImage.isEmpty()){
	            try {
	                productImage.transferTo(new File(path.toString()));
	            } catch (Exception ex){
	                ex.printStackTrace();
	                throw new RuntimeException("Product image saving failed", ex);
	            }
	        }

	        productService.editProduct(product);

	        return "redirect:/admin/productInventory";
	    }
	
	@RequestMapping("/product/deleteProduct/{pid}")
	public String deleteProduct(@PathVariable int pid, Model model, HttpServletRequest request) {
		
		Product product=productService.getProductById(pid);
	boolean flag=	productService.deleteProduct(product);
		if(flag==true)
			return "redirect:/admin/productInventory";
		return "index";
	}
}
