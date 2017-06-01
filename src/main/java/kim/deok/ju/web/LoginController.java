package kim.deok.ju.web;

import kim.deok.ju.domain.AuthVO;
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

    @GetMapping("join")
    public String joinBefore() throws  Exception{
        return "login/join";
    }

    @PostMapping("join")
    public String joinAfter(String id, String password, String userName) throws  Exception{
      AuthVO newMember = new AuthVO();
      newMember.setId(id);
      newMember.setPassword(password);
      newMember.setUserName(userName);
      newMember.setProfile("muzi.jpg");

      authService.insertMember(newMember);

        return "login/join";
    }

}
