package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * ユーザー情報 Controller
 */
@SuppressWarnings("unused")
@Controller
public class UserController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  UserService userService;
  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/list")
  public String displayList(Model model) {
    List<User> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "/list";
  }
  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "/add",method = RequestMethod.GET)
  public String Add(Model model) {
    model.addAttribute("userRequest", new UserRequest());
    return "/add";
  }
  @RequestMapping(value = "/addcheck",method = RequestMethod.POST)
  public String addcheck(@ModelAttribute("UserRequest")UserRequest form) {
    return "/addcheck";
  }
  /**
   * ユーザー新規登録

   * @param model Model
   * @param UserRequest
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value = "create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model, UserRequest UserRequest) {
    // ユーザー情報の登録
    userService.create(userRequest);
    return "redirect:/list";
  }
  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("{id}")
  public String displayView(@PathVariable Long id, Model model) {
    User user = userService.findById(id);
    model.addAttribute("userRequest", user);
    return "/edit";
  }
  @RequestMapping(value = "/{id}/editcheck",method = RequestMethod.POST)
  public String editcheck(@ModelAttribute("UserRequest")UserRequest form) {
    return "/{id}/editcheck";
  }
}