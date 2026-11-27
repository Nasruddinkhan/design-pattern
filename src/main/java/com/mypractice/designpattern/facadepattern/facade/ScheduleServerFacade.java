package com.mypractice.designpattern.facadepattern.facade;

import com.mypractice.designpattern.facadepattern.scheduler.ScheduleServer;

public class ScheduleServerFacade {
    private final ScheduleServer scheduleServer;
    public ScheduleServerFacade(ScheduleServer scheduleServer) {
        this.scheduleServer = scheduleServer;
    }
    public void startServer(){
        scheduleServer.startBooting();
        scheduleServer.readySystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }
    public void stopServer(){
        scheduleServer.realeaseProcess();
        scheduleServer.destroy();
        scheduleServer.destroySubSystem();
        scheduleServer.destroyContext();
        scheduleServer.shutDown();
    }
}
