package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;


@Controller
public class MainController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Product>products = productDao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}

	// show add product form
	@RequestMapping("/addproduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "addproduct";
	}

	// handle the product form
	@RequestMapping(path = "/handleproduct", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		this.productDao.saveProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");// if getContextPath not used it will redict to base page
															// i.e.localhost:8080
		// and show error so we have to use getContextPath along with url in "";

		return redirectView;

	}
	
	//delete
	@RequestMapping("/delete/{pid}")// after delete we pass uri template like which id to delete this uri template variable then, get by 
	//@pathVariable("uri template") datatype variable;
	public RedirectView delete(@PathVariable("pid") int id,HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		
		 this.productDao.deleteProduct(id);
		
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
	//update
	@RequestMapping("/update/{pid}")
	public String updateForm(@PathVariable("pid") int id,Model m) {
		
		
		Product product = this.productDao.getProduct(id);
		
		m.addAttribute("product", product);
		return "updateform";
	}
	
	//get updated products
	@RequestMapping(path = "/updateproduct",method = RequestMethod.POST)
	public RedirectView updatedProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		this.productDao.updateProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		
		return redirectView;
	}

}
