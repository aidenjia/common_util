package com.jia.demo.pattern.listener;

import java.util.EventObject;

public class PrintEvent extends EventObject {

  /**
   * Constructs a prototypical Event.
   *
   * @param source the object on which the Event initially occurred
   * @throws IllegalArgumentException if source is null
   */
  public PrintEvent(Object source) {
    super(source);
  }

  public void doEvent() {
    //getSource The object on which the Event initially occurred.
    System.out.println("通知一个事件源 source: " + this.getSource());
  }
}
