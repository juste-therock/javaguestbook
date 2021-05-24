package com.memphis.guestbook.controller;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import com.memphis.guestbook.entity.Message;
import com.memphis.guestbook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class MessageController implements WebMvcConfigurer {
    @Autowired
    private MessageService messageService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Message message) {
        return "form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<Message> hello = messageService.findAll();
        model.addAttribute("messages",hello);
        return "list.html";
    }

    @PostMapping("/")
    public String checkMessageInfo(@Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
            messageService.save(message);
            return "redirect:/results";}
    }



  @GetMapping("/createJson")
  public ResponseEntity<byte[]> createJson() {
        List<Message> messageList = messageService.findAll();
        String messageToJson = messageService.export(messageList);
        byte[] messageToJsonBytes = messageToJson.getBytes();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=messages.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(messageToJsonBytes.length)
                .body(messageToJsonBytes);
  }


    @GetMapping("/createCsv")
    public void createCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String fileName = "messages" + currentDateTime + ".csv";
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);
        List<Message> messageList = messageService.findAll();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID", "First Name", "Last Name", "Email", "Subject", "Age",
                "Content", "Gender", "Rating", "Sent time"};
        String[] nameMapping = {"id", "firstName", "lastName", "email", "subject", "age",
                "content", "gender", "rating", "sentTime"};
        csvWriter.writeHeader(csvHeader);
       try { for (Message message : messageList) {
            csvWriter.write(message, nameMapping);
        }
       }
       finally {
           csvWriter.close();
       }



    }






}
