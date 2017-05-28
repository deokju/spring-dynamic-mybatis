package kim.deok.ju.web;

import kim.deok.ju.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RequestMapping("/")
@Controller
public class LoginController {

    @Inject
    private AuthService authService;


  @GetMapping("login")
  public String loginBefore() throws  Exception{
    return "login/login";
  }

  @PostMapping("login")
  public String loginAfter(@RequestParam String userName, @RequestParam String userPass, HttpServletRequest request) {

      if(authService.isUserCheck(userName, userPass)) {
            HttpSession session = request.getSession();
            session.setAttribute("Auth", authService.getAuth(userName));
      }
      return "redirect:/board/list2";
  }

}
