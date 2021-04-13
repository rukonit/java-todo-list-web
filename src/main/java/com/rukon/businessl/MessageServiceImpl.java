package com.rukon.businessl;


import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


    @Override
    public String getHelloMessage(String name) {
        return "Hello " + name;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this application. My man!";
    }
}
