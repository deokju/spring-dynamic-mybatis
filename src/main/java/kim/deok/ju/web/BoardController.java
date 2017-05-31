package kim.deok.ju.web;

import kim.deok.ju.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;


@RequestMapping("/board")
@Controller
public class BoardController {

  @Inject
  AuthService authService;

  @GetMapping("list2")
  public String getList2(Model model) throws  Exception{

      model.addAttribute("members", authService.getMembers());

    return "board/list2";
  }
}
