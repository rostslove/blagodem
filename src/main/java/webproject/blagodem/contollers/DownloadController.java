package webproject.blagodem.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import webproject.blagodem.entities.File;
import webproject.blagodem.repo.FileRepo;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DownloadController {

    @Autowired
    private FileRepo fileRepo;

    @GetMapping("/blagodem/download/{fileId}")
    public String downloadFile(@PathVariable Long fileId, HttpServletResponse response) throws IOException {
        File file = fileRepo.findById(fileId).orElseThrow();
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = "+file.getFileName();
        response.setHeader(headerKey, headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(file.getFileData());
        outputStream.close();
        return "redirect:/blagodem/main";
    }
}
