package com.teamproject.mvc20221004teamproject.dto;

import com.teamproject.mvc20221004teamproject.domain.User;
import com.teamproject.mvc20221004teamproject.dto.validation.ValidationGroups;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class JoinDto {
    @NotBlank(message = "아이디는 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 4, max = 20, message = "최소 4글자 이상, 20글자 미만 입력 가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^*[a-zA-Z\\d]*$", message = "영어,숫자만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String userName;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 8, max = 16, message = "비밀번호는 8자 부터 16자 까지 입력하여야 합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]*$", message = "비밀번호는 특수기호, 영문, 숫자를 모두 포함해야합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String password;

    @NotBlank(message = "비밀번호는 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    private String passwordChk;

    @NotBlank(message = "이름은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 1, max = 4, message = "이름은 4자 까지만 입력가능합니다", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^*[가-힣]*$", message = "한글만 입력 가능합니다", groups = ValidationGroups.PatternCheckGroup.class)
    private String name;

    @NotBlank(message = "이메일은 비워둘 수 없습니다", groups = ValidationGroups.NotBlankGroup.class)
    @Email
    private String email;

    @NotBlank(message = "휴대폰번호는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    @Size(min = 10, max = 11, message = "휴대폰 번호는 10~11자 입니다.", groups = ValidationGroups.SizeGroup.class)
    @Pattern(regexp = "^01(0|1|[6-9])(\\d{3}|\\d{4})(\\d{4})$", groups = ValidationGroups.PatternCheckGroup.class)
    private String phoneNum;

    @NotBlank(message = "전화번호는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String number;

    @NotBlank(message = "주소는 비워둘 수 없습니다.", groups = ValidationGroups.NotBlankGroup.class)
    private String address;

    public User toEntity() {
        return User.builder()
                .username(userName)
                .password(new BCryptPasswordEncoder().encode(password))
                .passwordchk(new BCryptPasswordEncoder().encode(passwordChk))
                .name(name)
                .email(email)
                .phonenum(phoneNum)
                .number(number)
                .address(address)
                .role_id(1)
                .build();
    }
}
