package com.memphis.guestbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends CrudRepository<Message,Integer>{
}
