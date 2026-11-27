package com.mypractice.designpattern.facadepattern;

import com.mypractice.designpattern.facadepattern.facade.ScheduleServerFacade;
import com.mypractice.designpattern.facadepattern.scheduler.ScheduleServer;

/**
 * We used when we want to provide a simple interface for complex subsytem. A facade can provide simple default view of
 * the subsystem that's good enough for most users.
 */
public class TestFacadePattern {
    public static void main(String[] args) {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade scheduleServerFacade = new ScheduleServerFacade(scheduleServer);
        scheduleServerFacade.startServer();
        scheduleServer.shutDown();
    }
}
