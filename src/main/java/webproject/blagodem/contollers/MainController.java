package webproject.blagodem.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webproject.blagodem.entities.*;
import webproject.blagodem.repo.*;
import webproject.blagodem.utils.ImageUtil;
import webproject.blagodem.utils.Statuses;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blagodem/main")
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private RequestRepo requestRepo;

    @GetMapping
    public String showMainPage(Model model, Principal principal){
        User user = userRepo.findByUsername(principal.getName());
        if(user!= null) {
            model.addAttribute("user", user);
        }
        if (user.getRole().equals("ADMIN")) {
            model.addAttribute("user", user);
            return showAdminPanel(model);
        }
        return "main";
    }

    private String showAdminPanel(Model model) {
        List<Request> requests = new ArrayList<>();
        for (Request request : requestRepo.findAll()) {
            requests.add(request);
        }
        List<Application> applications = new ArrayList<>();
        for (Application application : applicationRepo.findAll()) {
            applications.add(application);
        }
        model.addAttribute("requests", requests);
        model.addAttribute("applications", applications);
        model.addAttribute("statuses",Arrays.stream(Statuses.values()).map(Statuses::getName).collect(Collectors.toList())) ;
        model.addAttribute("imgUtil", new ImageUtil());
        return "main";
    }
}
