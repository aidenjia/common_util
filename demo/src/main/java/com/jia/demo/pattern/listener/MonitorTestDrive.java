package com.jia.demo.pattern.listener;

public class MonitorTestDrive {

  public static void main(String[] args) {
    EventSource eventSource = new EventSource();
    eventSource.addListener(event -> {
      event.doEvent();
      if(event.getSource().equals("openWindows")) {
        System.out.println("doOpen");
      }
      if(event.getSource().equals("closeWindows")){
        System.out.println("doClose");
      }
    });
    eventSource.notifyListenerEvents(new PrintEvent("openWindows"));
  }
}
