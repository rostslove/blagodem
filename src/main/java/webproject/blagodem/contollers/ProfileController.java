package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import webproject.blagodem.entities.Disabled;
import webproject.blagodem.entities.Rating;
import webproject.blagodem.entities.Volunteer;
import webproject.blagodem.repo.*;
import webproject.blagodem.utils.ImageUtil;
import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private DisabledRepo disabledRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/blagodem/profile")
    public String getProfile(Model model, Principal principal) {
        String email = principal.getName();
        Disabled disabled = disabledRepo.findByEmail(email);
        Volunteer volunteer = volunteerRepo.findByEmail(email);
        if(disabled != null) {
            model.addAttribute("imgUtil", new ImageUtil());
            model.addAttribute("applications", applicationRepo.findAllByUser(userRepo.findByUsername(email)));
            model.addAttribute("requests", requestRepo.findAllByDisabled(disabled));
            model.addAttribute("user", userRepo.findByUsername(principal.getName()));
            model.addAttribute("disabled", disabled);
            return "disableProfile";
        }
        if (volunteer != null) {
            Long rating = Long.valueOf(0);
            List<Rating> ratingList = ratingRepo.findAllByVolunteer(volunteer);
            if (!ratingList.isEmpty()){
                rating = (long) ratingRepo.findAllByVolunteer(volunteer).stream().mapToLong(Rating::getGrade).average().getAsDouble();}
            model.addAttribute("rating", rating);
            model.addAttribute("imgUtil", new ImageUtil());
            model.addAttribute("applications", applicationRepo.findAllByUser(userRepo.findByUsername(email)));
            model.addAttribute("requests", requestRepo.findAllByVolunteer(volunteer));
            model.addAttribute("user", userRepo.findByUsername(principal.getName()));
            model.addAttribute("volunteer", volunteer);
            return "volunteerProfile";
        }
        return "main";
    }

}
