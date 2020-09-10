package com.example.demo;
import java.io.Serializable;

import lombok.Data;
//ユーザー情報 リクエストデータ
@Data
public class UserRequest implements Serializable {
//名前
  public String name;
//住所
  public String address;
//電話
  public String tel;
//排除フラグ
  public String delete_flg;
}

