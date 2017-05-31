package kim.deok.ju.web;

import kim.deok.ju.dbrouting.DbContextHolder;
import kim.deok.ju.dbrouting.DbType;
import kim.deok.ju.domain.AuthVO;
import kim.deok.ju.domain.MessageVO;
import kim.deok.ju.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/board")
public class MessageController {

    @Inject
    MessageService messageService;

    @PostMapping("message")
    public ResponseEntity<String> register(String sender, String receiver, String title, String message, HttpServletRequest request ) {

        ResponseEntity<String> entity = null;
        try {
            HttpSession session = request.getSession();
            AuthVO auth = null;
            auth = (AuthVO)session.getAttribute("Auth");

            MessageVO messageVO = new MessageVO();
            messageVO.setMessage(message);
            messageVO.setReceiver(receiver);
            messageVO.setSender(sender);
            messageVO.setTitle(title);
            messageVO.setSummary(message.substring(0,10));

            switch (auth.getDbNum()) {
                case 1:
                    DbContextHolder.setDbType(DbType.MASTER);
                    break;
                case 2:
                    DbContextHolder.setDbType(DbType.SLAVE);
                    break;
            }

            messageService.writeMessage(messageVO);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
