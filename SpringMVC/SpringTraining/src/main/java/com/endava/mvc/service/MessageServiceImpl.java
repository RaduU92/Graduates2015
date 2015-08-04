package com.endava.mvc.service;

import com.endava.mvc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cudrescu on 8/4/2015.
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRespository;

    @Override
    public String getMessageContent() {
        return messageRespository.getMessageContent();
    }


}
