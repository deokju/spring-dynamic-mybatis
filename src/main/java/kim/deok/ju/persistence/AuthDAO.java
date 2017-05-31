package kim.deok.ju.persistence;

import kim.deok.ju.domain.AuthVO;

import java.util.List;

public interface AuthDAO {
  public AuthVO getUserById(String id);
  public List<AuthVO> getMembers();
}
