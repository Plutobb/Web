package com.example.mopo.Entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IsDelete {
    DELETE(1,"删除"),
    NO_DELETE(0,"未删除");

    private int value;
    private String label;
}
