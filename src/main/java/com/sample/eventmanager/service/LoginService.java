/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.eventmanager.service;

import com.sample.eventmanager.dto.LoginDto;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Shindo
 */
@Dependent
public interface LoginService {
    
    /**
     * ログイン認証を行います。ログインに成功した場合のみtrueを返します。
     * @param userId
     * @param password
     * @return 
     */
    boolean authorize(String userId, String password);
    
    /**
     * ユーザIDをもとにユーザ情報を返します。
     * @param userId
     * @return 
     */
    LoginDto getUserInfo(String userId);
    
    
    
}
