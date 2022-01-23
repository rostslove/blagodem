package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import webproject.blagodem.repo.RatingRepo;
import webproject.blagodem.repo.VolunteerRepo;


/*public class AccountController {

    @Autowired
    private RatingRepo ratingRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @RequestMapping("blagodem/{id}")
    @ResponseBody
    public Long getRating(@RequestParam(value = "id") Long id){
        return Long.valueOf((long) ratingRepo.findAllByVolunteer(id).mapToLong(x -> x.getGrade()).average().getAsDouble());
    }
}*/
