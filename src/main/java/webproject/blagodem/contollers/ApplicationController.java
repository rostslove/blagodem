package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import webproject.blagodem.entities.Application;
import webproject.blagodem.entities.File;
import webproject.blagodem.entities.User;
import webproject.blagodem.repo.UserRepo;
import webproject.blagodem.utils.Statuses;
import webproject.blagodem.repo.ApplicationRepo;
import webproject.blagodem.repo.FileRepo;

import java.io.IOException;
import java.security.Principal;

@Controller
public class ApplicationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApplicationRepo applicationRepo;

    @Autowired
    private FileRepo fileRepo;

    @GetMapping("/blagodem/application")
    public String showApplication(Principal principal) {;
        User user = userRepo.findByUsername(principal.getName());
        if(user != null) {
            return "application";
        }
        return "main";
    }

    @PostMapping("/blagodem/application/add")
    public String applicationAdd(Principal principal, MultipartFile file, String text, String address) throws IOException {
        Application application = new Application();

        User user = userRepo.findByUsername(principal.getName());

        File newFile = new File();
        newFile.setFileData(file.getBytes());
        newFile.setFileType(file.getContentType());
        newFile.setFileName(file.getName());
        fileRepo.save(newFile);

        application.setUser(user);
        application.setStatus(Statuses.NOT_SUBMITTED.name());
        application.setAddress(address);
        application.setText(text);
        application.setFile(newFile);
        applicationRepo.save(application);
        return "redirect:/blagodem/main";
    }

    @PostMapping("/blagodem/application/{appId}/changeStatus")
    public String applicationChangeStatus(@PathVariable Long appId, String status_a) {
        for (Statuses st : Statuses.values()) {
            if (st.getName().equals(status_a)) {
                status_a = st.name();
            }
        }
        Application application = applicationRepo.findById(appId).orElseThrow();
        application.setStatus(status_a);
        applicationRepo.save(application);
        return "redirect:/blagodem/main";
    }
}
