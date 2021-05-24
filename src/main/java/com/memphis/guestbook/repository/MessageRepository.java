package com.memphis.guestbook.repository;

import com.memphis.guestbook.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message,Integer>{
    List<Message> findAll();
}
