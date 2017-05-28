package kim.deok.ju.web;

import kim.deok.ju.domain.MessageVO;
import kim.deok.ju.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/board")
public class MessageController {

    @Inject
    MessageService messageService;

    @PostMapping("message")
    public ResponseEntity<String> register(@RequestBody MessageVO vo) {

        ResponseEntity<String> entity = null;
        try {
            messageService.writeMessage(vo);
            entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
