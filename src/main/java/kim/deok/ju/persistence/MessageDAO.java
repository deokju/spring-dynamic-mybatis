package kim.deok.ju.persistence;


import kim.deok.ju.domain.MessageVO;

import java.util.List;

public interface MessageDAO {

  public void write(MessageVO messageVO);

  public List<MessageVO> getMessages(String id);
}
