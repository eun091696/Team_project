package com.teamproject.mvc20221004teamproject.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/*
 *유효성 검사 순서
 * 1. NotBlankGroup
 * 2. SizeGroup
 * 3. PatternCheckGroup
 * 4. Default
 */
@GroupSequence({ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeGroup.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})
public interface ValidationSequence {}
