package com.aritra.grabhouse.interview.design;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aritra
 */
@RequiredArgsConstructor
public class Robot {

    @Getter
    private final Position position;

    private final Plateau plateau;

}
