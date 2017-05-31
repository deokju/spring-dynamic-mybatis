package kim.deok.ju.service;

import kim.deok.ju.domain.MessageVO;
import kim.deok.ju.persistence.MessageDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MessageService {

    @Inject
    private MessageDAO messageDAO;

    public void writeMessage(MessageVO messageVO) {
        messageDAO.write(messageVO);
    }

    public List<MessageVO> getMessages(String id) {
        return messageDAO.getMessages(id);
    }
}
