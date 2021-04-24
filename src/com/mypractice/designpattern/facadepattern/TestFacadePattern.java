package com.mypractice.designpattern.facadepattern;

import com.mypractice.designpattern.facadepattern.facade.ScheduleServerFacade;
import com.mypractice.designpattern.facadepattern.scheduler.ScheduleServer;

public class TestFacadePattern {
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade scheduleServerFacade = new ScheduleServerFacade(scheduleServer);
        scheduleServerFacade.startServer();
        scheduleServer.shutDown();
    }
}
