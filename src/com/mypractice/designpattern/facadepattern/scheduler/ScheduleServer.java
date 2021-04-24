package com.mypractice.designpattern.facadepattern.scheduler;

public class ScheduleServer {
    public void startBooting() {
        System.out.println("ScheduleServer.startBooting");
    }

    public void readySystemConfigFile() {
        System.out.println("ScheduleServer.readySystemConfigFile");
    }

    public void init() {
        System.out.println("ScheduleServer.init");
    }

    public void initializeContext() {
        System.out.println("ScheduleServer.initializeContext");
    }

    public void initializeListeners() {
        System.out.println("ScheduleServer.initializeListeners");
    }

    public void createSystemObjects() {
        System.out.println("ScheduleServer.createSystemObjects");
    }

    public void realeaseProcess() {
        System.out.println("ScheduleServer.realeaseProcess");
    }

    public void destroy() {
        System.out.println("ScheduleServer.destroy");
    }

    public void destroySubSystem() {
        System.out.println("ScheduleServer.destroySubSystem");
    }

    public void destroyContext() {
        System.out.println("ScheduleServer.destroyContext");
    }

    public void shutDown() {
        System.out.println("ScheduleServer.shutDown");
    }
}
