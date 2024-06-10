package Finalproject.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;  
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import Finalproject.Dto.ProductDto;
import Finalproject.Entity.Product;
import Finalproject.Service.Admin.MangeProductServiceImpl;
import Finalproject.Service.User.ViewProductServiceImpl;

@Controller
public class AdminManageProductController extends BaseController{
	 private static final String ABSOLUTE_PATH ="C:/Users/DELL/eclipse-workspace/final project/src/main/webapp/images/layout-key";  
	 
	@Autowired
	private MangeProductServiceImpl mangeProductService = new MangeProductServiceImpl();
	@Autowired
	private ViewProductServiceImpl _viewProductService;
	
	@RequestMapping(value = {"/deleteProduct/{id}"})
	public ModelAndView deleteProduct(@PathVariable int id, HttpSession session) {
		session.removeAttribute("cart");
		
		boolean check = mangeProductService.checkProductExistInBillDetail(id);
		if(check) {
			_mvSharePage.addObject("deleteMessage","Can not delete this product, User buying");
		}else {
			mangeProductService.deleteOneProduct(id);
			_mvSharePage.addObject("deleteMessage","Delete success");
		}
		_mvSharePage.setViewName("admin/homeAdmin");
		
		return _mvSharePage;
	}
	
	@RequestMapping(value = {"/updateProduct/{id}"}, method = RequestMethod.GET)
	public ModelAndView updateProductView(@PathVariable int id, HttpSession session) {
		session.removeAttribute("cart");
		_mvSharePage.setViewName("admin/updateProduct");
		_mvSharePage.addObject("viewProduct", _viewProductService.getViewProductData(id));
		return _mvSharePage;
	}
	
	@RequestMapping(value = {"/updateProduct/{id}"}, method = RequestMethod.POST)
	public ModelAndView updateProduct(@PathVariable int id, HttpSession session,HttpServletRequest request,
			@RequestParam("updateProductName") String updateProductName,
			@RequestParam("updateProductPrice") double updateProductPrice,
			@RequestParam("updateProductTitle") String updateProductTitle) 
	{
		session.removeAttribute("cart");
		Product product = new Product();
		product.setIdP(id);
		product.setPrice(updateProductPrice);
		product.setName(updateProductName);
		product.setTitle(updateProductTitle);
		Date currentDate = new Date();
		product.setUpdatedAt(currentDate);
		mangeProductService.updateProductById(product);
		
		_mvSharePage.setViewName("redirect:/admin/home");
		
		return _mvSharePage;
	}
	
	@RequestMapping(value = {"/admin/add-product"}, method = RequestMethod.GET)
	public ModelAndView addProduct() {
		_mvSharePage.setViewName("admin/addProduct");
		return _mvSharePage;
	}
	@RequestMapping(value = {"/admin/show"}, method = RequestMethod.GET)
	public ModelAndView showProduct() {
		_mvSharePage.setViewName("admin/show");
		return _mvSharePage;
	}
	
	@RequestMapping(value={"/admin/add-product"},method=RequestMethod.POST)  
    public ModelAndView saveimage( @RequestParam CommonsMultipartFile file, 
    		@RequestParam("productName") String productName,
    		@RequestParam("productPrice") double productPrice,
    		@RequestParam("idTag") int idTag,
    		@RequestParam("productProducer") String productProducer,
    		@RequestParam("productTitle") String productTitle,
    		@RequestParam("productDescription") String productDescription,
    		@RequestParam("productQuantity") int productQuantity,
           HttpSession session, HttpServletRequest request ) throws Exception{  
		
        String path = ABSOLUTE_PATH;
        String filename = file.getOriginalFilename();
        System.out.println("Upload Path: " + path + ", File Name: " + filename);
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path + File.separator + filename)));
        stream.write(bytes);
        stream.flush();
        stream.close();
        
        ProductDto product = new ProductDto();
        product.setProductName(productName);
        product.setPrice(productPrice);
        product.setIdTag(idTag);
        product.setProducer(productProducer);
        product.setTitle(productTitle);
        product.setDescription(productDescription);
        product.setQuantity(productQuantity);
        product.setSale(0);
        product.setBestSelling(false);
        product.setGaming(false);
        // Lấy thời gian hiện tại
        Date currentDate = new Date();
        product.setCreatedAt(currentDate);
        product.setUpdatedAt(currentDate);
        product.setImg(filename);
        mangeProductService.saveNewProduct(product);
	    _mvSharePage.setViewName("redirect:/admin/home");
	         
	    return _mvSharePage;  
    }  
}
