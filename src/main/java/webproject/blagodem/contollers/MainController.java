package webproject.blagodem.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webproject.blagodem.entities.Application;
import webproject.blagodem.entities.Disabled;
import webproject.blagodem.entities.Volunteer;
import webproject.blagodem.repo.ApplicationRepo;
import webproject.blagodem.repo.DisabledRepo;
import webproject.blagodem.repo.RequestRepo;
import webproject.blagodem.repo.VolunteerRepo;

import java.security.Principal;

@Controller
@RequestMapping("/blagodem/main")
public class MainController {

    @Autowired
    private DisabledRepo disabledRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private RequestRepo requestRepo;

    @GetMapping
    public String showMainPage(Model model, Principal principal){
        String email = principal.getName();
        Disabled disabled = disabledRepo.findByEmail(email);
        Volunteer volunteer = volunteerRepo.findByEmail(email);
        if(disabled != null) {
            model.addAttribute("user", disabled);
        }
        if(volunteer != null) {
            model.addAttribute("user", volunteer);
        }
        return "main";
    }
}
