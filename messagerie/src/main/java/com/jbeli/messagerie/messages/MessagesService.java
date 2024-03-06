package com.jbeli.messagerie.messages;

import com.jbeli.messagerie.PageResponse.PageResponse;

public interface MessagesService {

    Messages findById(Integer id);
    PageResponse<Messages> findAll(int page, int size);
    void deleteById(Integer id);
    Messages CreateUser(Messages u);
}
