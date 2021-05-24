package com.memphis.guestbook.service;
import com.google.gson.Gson;
import com.memphis.guestbook.entity.Message;
import com.memphis.guestbook.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    public Message save(Message message) {
        message = new Message();
        return messageRepository.save(message);
    }


    public String export(List<Message> messageList) {
        Gson gson = new Gson();
        String messageListInJson = gson.toJson(messageList);
        return messageListInJson;
    }
}
