package com.renu.onlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.renu.onlineShopping.util.FileUploadUtility;
import com.renu.onlineShopping.validator.ProductValidator;
import com.renu.shoppingBackend.dao.CategoryDAO;
import com.renu.shoppingBackend.dao.ProductDAO;
import com.renu.shoppingBackend.dto.Category;
import com.renu.shoppingBackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {


	@Autowired
	private CategoryDAO categoryDAO;		
	@Autowired
	private ProductDAO productDAO;
	

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Manage Products");		
		mv.addObject("userClickManageProducts",true);
		
        Product nProduct = new Product();
		
		// assuming that the user is ADMIN
		// later we will fixed it based on user is SUPPLIER or ADMIN
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);
		if (operation!=null) {
			if (operation.equals("product")) {
				mv.addObject("message","Product submitted successfully");
			}else {
				mv.addObject("message"," Category submitted successfully");
			}
		}
		return mv;
		
	}
	
	
	

	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView manageProductEdit(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProducts",true);
		
		//fetch the product to edit		
		Product nProduct= productDAO.get(id);
         mv.addObject("product",nProduct);
			
		return mv;
		
	}
	
	


	@RequestMapping(value = "/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult result,Model model,HttpServletRequest request) {

		// mandatory file upload check
			if(mProduct.getId() == 0) {
					new ProductValidator().validate(mProduct, result);
				}
				else {
					// edit check only when the file has been selected
					if(!mProduct.getFile().getOriginalFilename().equals("")) {
						new ProductValidator().validate(mProduct, result);
					}			
				}
		
		//error check
		if(result.hasErrors()) {
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation failed for product Submission");
			return "page";
		}
		
		
		
		
		if(mProduct.getId() == 0 ) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
		}
		
		 //upload the file
		 if(!mProduct.getFile().getOriginalFilename().equals("") ){
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode()); 
		 }
		return "redirect:/manage/products?operation=product";
	}

	
	

	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);		
		return (isActive)? "You have successfully deactivated the product id "+product.getId()
		:"You have successfully activated the product id "+product.getId();
	}
	
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {					
		categoryDAO.add(mCategory);		
		return "redirect:/manage/products?operation=mCategory";
	}
		
	
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}
	
	
	
}

	
