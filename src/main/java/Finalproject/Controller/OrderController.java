package Finalproject.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Entity.Bill;
import Finalproject.Entity.BillDetail;
import Finalproject.Entity.UserEntity;
import Finalproject.Service.User.OrderServiceImpl;

@Controller
public class OrderController extends BaseController{
	
	@Autowired
	private OrderServiceImpl orderService = new OrderServiceImpl();
	
	@RequestMapping(value = {"/user/order"})
    public ModelAndView orderShow(HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("LoginInfo");
		
		List<Bill> listBill = orderService.getAllBillByIdUser(user.getIdUser());
		List<Integer> idBillList = new ArrayList<>();
		List<BillDetail> billDetails = new ArrayList<>();
		
		for (Bill bill : listBill) {
		    idBillList.add(bill.getIdbill());
		}
		// Lặp qua danh sách idBillList
	    for (Integer idBill : idBillList) {
	        // Lấy dữ liệu từ bảng billdetail dựa vào idBill
	        List<BillDetail> billDetailsForIdBill = orderService.getBillDetailByIdBill(idBill);
	        billDetails.addAll(billDetailsForIdBill);
	    }

		_mvSharePage.addObject("billDataByUser",listBill);
		_mvSharePage.addObject("billDetailDataByUser",billDetails);
    	_mvSharePage.setViewName("user/order");
        return _mvSharePage;
    }
	
	
	@RequestMapping(value = {"/admin/order"})
    public ModelAndView orderAdminShow(HttpSession session) {
		
		List<Bill> listBill = orderService.getAllBill();
		List<BillDetail> billDetails = orderService.getAllBillDetail();
		
		_mvSharePage.addObject("billDataByUser",listBill);
		_mvSharePage.addObject("billDetailDataByUser",billDetails);
    	_mvSharePage.setViewName("admin/order");
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/user/order/{id}"})
    public ModelAndView orderCancel(HttpSession session, @PathVariable int id) {
		
		orderService.cancelOrderById(id);
		_mvSharePage.setViewName("redirect:/user/order");
		
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/admin/order/{id}"})
    public ModelAndView orderAdminCancel(HttpSession session, @PathVariable int id) {
		
		orderService.cancelOrderById(id);
		_mvSharePage.setViewName("redirect:/admin/order");
		
        return _mvSharePage;
    }
	
	
	@RequestMapping(value = {"/user/received/{id}"})
    public ModelAndView orderReceived(HttpSession session, @PathVariable int id) {
		
		orderService.receivedOrderById(id);
		_mvSharePage.setViewName("redirect:/user/order");
		
        return _mvSharePage;
    }
	
	@RequestMapping(value = {"/admin/received/{id}"})
    public ModelAndView orderAdminReceived(HttpSession session, @PathVariable int id) {
		
		orderService.receivedOrderById(id);
		_mvSharePage.setViewName("redirect:/admin/order");
		
        return _mvSharePage;
    }
}
