package com.olacabs.atc.models;

/**
 * @author aritra
 */

public class Airline {

  private String callSign;

  private String flightNUmber;

  public Parking getParking() {
    return null;
  }

  public void boardingComplete() {
    getParking().boardingComplete();
  }

}
