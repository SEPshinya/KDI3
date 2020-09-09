package com.example.demo;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 100, message = "名前は100桁以内で入力してください")
  public String name;
  /**
   * 住所
   */
  @Size(max = 255, message = "住所は255桁以内で入力してください")
  public String address;
  /**
   * 電話番号
   */
  @Pattern(regexp = "/\\A0[5789]0[-(]?\\d{4}[-)]?\\d{4}\\z/", message = "電話番号の形式で入力してください")
  public String tel;

  public String delete_flg="0";



}

