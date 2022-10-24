package com.teamproject.mvc20221004teamproject.service;

import com.teamproject.mvc20221004teamproject.dto.JoinDto;

public interface AccountService {

    public void duplicataEmail(JoinDto joinDto) throws Exception; //
    public void join(JoinDto joinDto) throws Exception; //추상메소드
}
