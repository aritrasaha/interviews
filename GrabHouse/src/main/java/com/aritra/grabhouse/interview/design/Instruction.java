package com.aritra.grabhouse.interview.design;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aritra
 */
@RequiredArgsConstructor
public enum Instruction {
    L("Left"), R("Right"), M("Move");

    @Getter
    private final String description;

}
