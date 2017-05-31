package kim.deok.ju.persistence;

import javax.inject.Inject;

import kim.deok.ju.domain.MessageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace ="MessageMapper";


    public void write(MessageVO messageVO){
        session.insert(namespace+".writeMessage", messageVO);
    }
}


