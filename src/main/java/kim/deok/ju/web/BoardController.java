package kim.deok.ju.web;

import kim.deok.ju.dbrouting.DbContextHolder;
import kim.deok.ju.dbrouting.DbType;
import kim.deok.ju.domain.AuthVO;
import kim.deok.ju.service.AuthService;
import kim.deok.ju.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;


@RequestMapping("/board")
@Controller
public class BoardController {

    @Inject
    AuthService authService;

    @Inject
    MessageService messageService;

  @GetMapping("list2")
  public String getList2(Model model, HttpSession session) throws  Exception{
      AuthVO auth = (AuthVO)session.getAttribute("Auth");
      DbContextHolder.dbchanged(auth.getDbNum());

      model.addAttribute("messages", messageService.getMessages(auth.getId()));
      model.addAttribute("members",  authService.getMembers());

    return "board/list2";
  }
}
