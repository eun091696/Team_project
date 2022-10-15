package com.teamproject.mvc20221004teamproject.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

//유효성검사 순서.
@GroupSequence({ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeGroup.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})
public interface ValidationSequence {}
