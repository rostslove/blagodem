package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webproject.blagodem.entities.Disabled;
import webproject.blagodem.entities.User;
import webproject.blagodem.entities.Volunteer;
import webproject.blagodem.repo.DisabledRepo;
import webproject.blagodem.repo.UserRepo;
import webproject.blagodem.repo.VolunteerRepo;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class RegController {
    @Autowired
    private DisabledRepo disabledRepo;

    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/blagodem/registration-disabled")
    public String showRegFormDisabled() {
        return "registration-disabled";
    }

    @GetMapping("/blagodem/registration-volunteer")
    public String showRegFormVolunteer() {
        return "registration-volunteer";
    }

    @PostMapping("/blagodem/registration-volunteer")
    public String postRegVolunteer(String firstname,
                                   String lastname,
                                   String birthdate,
                                   char sex,
                                   String city,
                                   String phone,
                                   String email,
                                   String password,
                                   String repeat,
                                   Map<String, Object> model) {
        if (!password.equals(repeat)){
            model.put("message", "Пароли не совпадают");
            return "registration-volunteer";
        }

        final User userWithSameName = userRepo.findByUsername(email);
        if (userWithSameName != null) {
            model.put("message", "Такой пользователь уже существует");
            return "registration-volunteer";
        }
        String date[] = birthdate.split("-");
        String encoded = passwordEncoder.encode(password);
        User user = new User(email, encoded);
        user.setRole("VOLUNTEER");
        Volunteer volunteer = new Volunteer(firstname, lastname, LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]), Integer.parseInt(date[2])), sex, city, phone, email, encoded);
        if (email.equals("mardyshkinrr@mail.ru")){
            user.setRole("ADMIN");
            volunteer.setRole("ADMIN");
        }
        userRepo.save(user);
        volunteerRepo.save(volunteer);
        return "redirect:/blagodem/login";
    }

    @PostMapping("/blagodem/registration-disabled")
    public String postRegDisabled(String firstname,
                                  String lastname,
                                  String birthdate,
                                  char sex,
                                  String city,
                                  String disease,
                                  int dis_group,
                                  String phone,
                                  String email,
                                  String password,
                                  String repeat,
                                  Map<String, Object> model) {
        if (!password.equals(repeat)) {
            model.put("message", "Пароли не совпадают");
            return "registration-disabled";
        }

        final User userWithSameName = userRepo.findByUsername(email);
        if (userWithSameName != null) {
            model.put("message", "Такой пользователь уже существует");
            return "registration-disabled";
        }
        String date[] = birthdate.split("-");
        String encoded = passwordEncoder.encode(password);
        User user = new User(email, encoded);
        user.setRole("DISABLED");
        userRepo.save(user);
        disabledRepo.save(new Disabled(firstname,lastname, LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]), Integer.parseInt(date[2])), sex, city, disease, dis_group, phone, email, encoded));
        return "redirect:/blagodem/main";
    }
}
