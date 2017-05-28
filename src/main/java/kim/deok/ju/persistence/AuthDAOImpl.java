package kim.deok.ju.persistence;

import kim.deok.ju.domain.AuthVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class AuthDAOImpl implements AuthDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace ="AuthMapper";

    public AuthVO getUser(String id) {
        return session.selectOne(namespace+".getUser", id);
    }
}


