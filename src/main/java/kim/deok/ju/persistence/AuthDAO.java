package kim.deok.ju.persistence;

import kim.deok.ju.domain.AuthVO;
public interface AuthDAO {
  public AuthVO getUser(String id);
}
