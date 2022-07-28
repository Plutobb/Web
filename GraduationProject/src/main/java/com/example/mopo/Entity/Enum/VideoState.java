package com.example.mopo.Entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VideoState {
    RELEASE(1,"已发布"),
    AUDITING(0,"审核中"),
    FAIL(2,"审核失败");

    private int value;
    private String label;
}
