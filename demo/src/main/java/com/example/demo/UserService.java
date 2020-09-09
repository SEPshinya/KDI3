package com.example.demo;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * ユーザー情報 Service
 */
@SuppressWarnings("unused")
@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private UserRepository userRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<User> searchAll() {
    return userRepository.findAll();
  }
  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(UserRequest UserRequest) {
    User user = new User();
    user.setName(UserRequest.getName());
    user.setAddress(UserRequest.getAddress());
    user.setTel(UserRequest.getTel());
    userRepository.save(user);
  }
  /**
   * ユーザー情報 主キー検索
   * @return 検索結果
   */
  public User findById(Long id) {
    return userRepository.findById(id).get();
  }
}
