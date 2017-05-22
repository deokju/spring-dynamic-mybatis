package kim.deok.ju.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/")
@Controller
public class LoginController {


  @RequestMapping("intro")
  public String loginBefore(Model model) throws  Exception{

    return "login/login";
  }

  @PostMapping("login")
  public String loginAfter(@RequestParam String userName, @RequestParam String userPass) {

      return "redirect:main";
  }

}
