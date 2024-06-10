package Finalproject.Controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Finalproject.Entity.UserEntity;
import Finalproject.Service.User.UserService;

@Controller
public class PasswordController extends BaseController{
	@Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender mailSender;
    
    @RequestMapping(value = "/reset-password", method = RequestMethod.GET)
    public ModelAndView displayResetPasswordPage(@RequestParam("token") String token) {
        ModelAndView modelAndView = new ModelAndView("authen/reset-password");
        modelAndView.addObject("token", token);
        return modelAndView;
    }
    
    @RequestMapping(value = "/reset-password", method = RequestMethod.POST)
    public String handleResetPassword(@RequestParam("token") String token, 
                                      @RequestParam("password") String password) {
        UserEntity user = userService.validatePasswordResetToken(token);
        if (user == null) {
            return "redirect:/reset-password?error";
        }

        userService.updatePassword(user, password);
        return "redirect:/authen/login?resetSuccess";
    }
	    
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
    public String processForgotPassword(HttpServletRequest request, @RequestParam("email") String userEmail) {
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(userEmail, token);
        
        String appUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/final_project";
        String resetUrl = appUrl + "/reset-password?token=" + token;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(userEmail);
        email.setSubject("Đặt lại mật khẩu");
        email.setText("Nhấp vào liên kết sau để đặt lại mật khẩu của bạn: \n" + resetUrl);
        mailSender.send(email);

        return "redirect:/forgot-password?success";
    }
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public String viewForgotPassword() {
        
        return "authen/forgot-password";
    }
}
