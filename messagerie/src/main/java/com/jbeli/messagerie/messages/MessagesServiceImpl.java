package com.jbeli.messagerie.messages;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService{

    private final MessagesRepository messagesRepository;
    private final MessagesMapper mapper;
    @Override
    public MessagesResponse findById(Integer id) {
        return this.messagesRepository.findById(id)
                .map(mapper::toMessagesDto)
                .orElse(new MessagesResponse());

    }

    @Override
    public List<MessagesResponse> findAll() {
        return this.messagesRepository.findAll()
                .stream()
                .map(mapper::toMessagesDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        this.messagesRepository.deleteById(id);

    }

    @Override
    public Integer save(MessagesRequest m) {
        Messages messages = mapper.toMessages(m);
        return this.messagesRepository.save(messages).getId();
    }

    @Override
    public boolean MessageExisteParDate(Date date) {
        return messagesRepository.findByDate(date);
    }

    @Override
    public boolean MessageExisteParEtat(EtatEnum etat) {

        return messagesRepository.findByEtat(etat);
    }
    }

