package kim.deok.ju.persistence;

import javax.inject.Inject;

import kim.deok.ju.domain.MessageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAOImpl implements MessageDAO {

    private static String namespace ="MessageMapper";

	@Inject private SqlSession session;

    public void write(MessageVO messageVO){
        session.insert(namespace+".writeMessage", messageVO);
    }

    public List<MessageVO> getMessages(String id) {
        return session.selectList(namespace+".getMessages", id);
    }
}


