package itis.homework.demo.Repositories;

import itis.homework.demo.Dto.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);

}