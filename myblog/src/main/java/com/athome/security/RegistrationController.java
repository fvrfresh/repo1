package com.athome.security;
import com.athome.domain.Admin;
import com.athome.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  
  private AdminService userRepo;
  private PasswordEncoder passwordEncoder;

  public RegistrationController(
      AdminService userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }
  
  @GetMapping
  public String processRegistration(@RequestParam("username") String username, @RequestParam("password") String password) {
    userRepo.save(toUser(username,password));
    return "redirect:/admin";
  }

  private Admin toUser(String username, String password){
      return new Admin(
            username, passwordEncoder.encode(password));
  }

}
