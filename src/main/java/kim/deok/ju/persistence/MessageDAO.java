package kim.deok.ju.persistence;


import kim.deok.ju.domain.MessageVO;

public interface MessageDAO {

  public void write(MessageVO messageVO);
}
