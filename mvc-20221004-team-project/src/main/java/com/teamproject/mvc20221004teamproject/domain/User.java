package com.teamproject.mvc20221004teamproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
//    user_mst 테이블과 동일
    private String id;
    private String username;
    private String password;
    private String passwordchk;
    private String name;
    private String email;
    private String phonenum;
    private String number;
    private String address;
    private String provider;
    private int role_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

    private Role role; //join을 위해 객체 생성
}
