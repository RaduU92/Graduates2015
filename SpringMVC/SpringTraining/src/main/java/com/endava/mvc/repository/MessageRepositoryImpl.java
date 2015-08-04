package com.endava.mvc.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by cudrescu on 8/4/2015.
 */

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Override
    public String getMessageContent() {
        return "Salut !";
    }
}
