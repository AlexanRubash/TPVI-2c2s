package com.rubash.lab13.test;

import com.rubash.lab13.zad3.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

    @Test
    public void testGetDescription() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        Assertions.assertEquals("Test Description", schedule.getDescription());
    }

    @Test
    public void testSetDescription() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Old Description");
        schedule.setDescription("New Description");
        Assertions.assertEquals("New Description", schedule.getDescription());
    }

    @Test
    public void testGetId() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        schedule.setId(10);
        Assertions.assertEquals(10, schedule.getId());
    }

    @Test
    public void testGetUserId() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        Assertions.assertEquals(1, schedule.getuser_id());
    }

    @Test
    public void testSetUserId() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        schedule.setuser_id(5);
        Assertions.assertEquals(5, schedule.getuser_id());
    }

    @Test
    public void testGetDayOfWeek() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        Assertions.assertEquals(2, schedule.getday_of_week());
    }

    @Test
    public void testSetDayOfWeek() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        schedule.setday_of_week(3);
        Assertions.assertEquals(3, schedule.getday_of_week());
    }

    @Test
    public void testGetStartTime() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        Assertions.assertEquals("10:00", schedule.getstart_time());
    }

    @Test
    public void testSetStartTime() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        schedule.setstart_time("11:00");
        Assertions.assertEquals("11:00", schedule.getstart_time());
    }

    @Test
    public void testGetEndTime() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        Assertions.assertEquals("12:00", schedule.getend_time());
    }

    @Test
    public void testSetEndTime() {
        Schedule schedule = new Schedule(1, 2, "10:00", "12:00", "Test Description");
        schedule.setend_time("13:00");
        Assertions.assertEquals("13:00", schedule.getend_time());
    }
}
