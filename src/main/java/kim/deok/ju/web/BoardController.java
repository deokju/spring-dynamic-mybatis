package kim.deok.ju.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/board")
@Controller
public class BoardController {


  @GetMapping("list")
  public String getList(Model model) throws  Exception{
    return "board/list";
  }
}
