package kim.deok.ju.service;

import kim.deok.ju.domain.AuthVO;
import kim.deok.ju.persistence.AuthDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class AuthService {

    @Inject
    AuthDAO authDAO;



    public boolean isUserCheck(String userId, String password) {

        AuthVO authVO = authDAO.getUser(userId);

        if(authVO == null) {
            return false;
        }

        if(!authVO.getPassword().equalsIgnoreCase(password)) {
            return false;
        }
        return true;
    }

    public AuthVO getAuth(String userName) {
        AuthVO user = inMemoryUsers.get(userName);
        System.out.println(user.toString());
        return user;
    }
}
