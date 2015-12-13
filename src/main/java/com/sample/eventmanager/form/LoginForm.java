/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.form;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ログイン用フォームクラス
 * @author Shindo
 */
@XmlRootElement
public class LoginForm {
    
    /** エラーメッセージ */
    @XmlElement
    private List<String> message;
    
    /** ユーザID */
    @NotNull
    @FormParam("userId")
    @XmlElement
    private String userId;
    
    /** パスワード */
    @NotNull
    @FormParam("password")
    @XmlElement
    private String password;

    public LoginForm() {
    }

    public LoginForm(List<String> message, String userId, String password) {
        this.message = message;
        this.userId = userId;
        this.password = password;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
