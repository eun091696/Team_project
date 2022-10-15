package com.teamproject.mvc20221004teamproject.dto;

import com.teamproject.mvc20221004teamproject.dto.validation.ValidationGroups;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterDto {
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

}
