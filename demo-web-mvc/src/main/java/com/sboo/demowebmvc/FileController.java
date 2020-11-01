package com.sboo.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @GetMapping("/file")
    public String fileUploadForm(Model model) {
        return "files/index";
    }

    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file,
                             RedirectAttributes attributes) throws IOException {
        String fileName = file.getOriginalFilename();
        File newFile = new File("/Users/sboo/Desktop/Development/test2.txt");
        newFile.getParentFile().mkdir();
        file.transferTo(newFile);

        String message = file.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message", message);
        return "redirect:/file";
    }
}
