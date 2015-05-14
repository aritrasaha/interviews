package com.aritra.grabhouse.interview.design;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aritra
 */
@AllArgsConstructor
public class Position {

    @Getter
    @Setter
    private int X;

    @Getter
    @Setter
    private int Y;

    @Getter
    @Setter
    private Heading heading;

}
