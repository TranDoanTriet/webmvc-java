package Finalproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmailSenderController extends BaseController{

	@RequestMapping(value = {"/user/contact"}, method = RequestMethod.GET)
	public String showEmailForm() {
        
        return "user/sendingMail";
    }
//	@RequestMapping(value = {"/user/sendingMail"}, method = RequestMethod.POST)
//	public String sendEmail(@ModelAttribute EmailModel emailModel, Module model) {
//		return "user/sendingMail";
//	}
    
}
