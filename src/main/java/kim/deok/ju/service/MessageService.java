package kim.deok.ju.service;

import kim.deok.ju.domain.AuthVO;
import kim.deok.ju.domain.MessageVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MessageService {

    @Inject
    private MessageService messageService;

    public void writeMessage(MessageVO messageVO) {

    }
}
