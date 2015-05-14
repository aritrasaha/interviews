package com.aritra.grabhouse.interview.design;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author aritra
 */
@RequiredArgsConstructor
public enum Heading {
    N("North"), E("East"), S("South"), W("West");

    @Getter
    private final String description;

}
