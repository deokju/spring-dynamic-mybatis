package kim.deok.ju.interceptor;


import kim.deok.ju.domain.AuthVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AuthVO auth = null;
        try{
            auth = (AuthVO)session.getAttribute("Auth");

            if(auth == null) {
                throw new Exception("사용자 정보가 없습니다.");
            }
        }catch(Exception e) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
