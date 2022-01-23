package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webproject.blagodem.entities.User;
import webproject.blagodem.repo.UserRepo;

import java.util.Map;

@Controller
@RequestMapping("/blagodem/login")
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public String showLogin(){
        return "login";
    }

    @PostMapping()
    public String postLogin(String username, String password, Map<String, Object> model){
        User user = userRepo.findByEmail(username);
        if (user == null){
            model.put("message", "Такого пользователя не существует");
            return showLogin();
        }
        String encoded = passwordEncoder.encode(password);
        if (!encoded.equals(user.getPassword())){
            model.put("message", "Неверный пароль");
            return showLogin();
        }
        return "redirect:/blagodem/main";
    }
}

