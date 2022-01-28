package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import webproject.blagodem.entities.*;
import webproject.blagodem.repo.DisabledRepo;
import webproject.blagodem.repo.RatingRepo;
import webproject.blagodem.repo.RequestRepo;
import webproject.blagodem.repo.VolunteerRepo;
import webproject.blagodem.utils.Statuses;

import java.security.Principal;

@Controller
public class RequestController {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private DisabledRepo disabledRepo;

    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping("/blagodem/request")
    public String showBlog(Model model, Principal principal) {
        String email = principal.getName();
        Disabled disabled = disabledRepo.findByEmail(email);
        Volunteer volunteer = volunteerRepo.findByEmail(email);
        if (disabled != null) {
            return "request";
        }
        if (volunteer != null) {
            model.addAttribute("requests", requestRepo.findAllByStatus(Statuses.NOT_SUBMITTED.name()));
            return "showRequests";
        }
        return "redirect:/blagodem/profile";
    }

    @PostMapping("/blagodem/request")
    public String createBlog(Principal principal) {
        Disabled disabled = disabledRepo.findByEmail(principal.getName());
        if (disabled != null) {
            Request request = new Request();
            request.setDisabled(disabled);
            request.setStatus(Statuses.NOT_SUBMITTED.name());
            requestRepo.save(request);
        }
        return "redirect:/blagodem/profile";
    }

    @PostMapping("/blagodem/request/{requestId}/assign")
    public String assignRequest(@PathVariable Long requestId, Principal principal) {
        Request request = requestRepo.findById(requestId).orElseThrow();
        Volunteer volunteer = volunteerRepo.findByEmail(principal.getName());
        request.setVolunteer(volunteer);
        request.setStatus(Statuses.IN_PROGRESS.name());
        requestRepo.save(request);
        return "showRequests";
    }

    @PostMapping("/blagodem/request/{requestId}/grade")
    public String gradeRequest(@PathVariable Long requestId, Principal principal, String ratingGrade) {
        Request request = requestRepo.findById(requestId).orElseThrow();
        Disabled disabled = disabledRepo.findByEmail(principal.getName());
        Long grade = Long.valueOf(0);
        if(!ratingGrade.equals("")) {
            grade = Long.parseLong(ratingGrade);
        }
        Rating rating = new Rating();
        rating.setGrade(grade);
        rating.setDisabled(disabled);
        rating.setVolunteer(request.getVolunteer());
        ratingRepo.save(rating);
        request.setRating(rating);
        requestRepo.save(request);
        return "redirect:/blagodem/profile";
    }

    @PostMapping("/blagodem/request/{requestId}/changeStatus")
    public String changeStatus(@PathVariable Long requestId, String status) {
        for (Statuses st : Statuses.values()) {
            if (st.getName().equals(status)) {
                status = st.name();
            }
        }
        Request request = requestRepo.findById(requestId).orElseThrow();
        request.setStatus(status);
        requestRepo.save(request);
        return "redirect:/blagodem/main";
    }

}
