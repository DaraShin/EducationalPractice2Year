package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.*;

public class Main {
    public static void main(String[] args){
        int nextId = 1;

        Sprint sprint = new Sprint(20, 3);

        UserStory userStory = new UserStory(nextId++, "Registration Form", 16);
        userStory.complete();
        boolean result = sprint.addBug(Bug.createBug(nextId++, "Add password repeat", 8, userStory));
        System.out.println(result);
        System.out.println(sprint.addBug(Bug.createBug(nextId++, "Apply validation", 10, userStory)));
        System.out.println(sprint.addBug(Bug.createBug(nextId++, "Add hide/show button for password", 8, userStory)));


        Ticket[] tickets = sprint.getTickets();
        System.out.println(2 == tickets.length);
        System.out.println(tickets[0].toString().equals(new String("[Bug 2] Registration Form: Add password repeat")));
        System.out.println(tickets[1].toString().equals(new String("[Bug 3] Registration Form: Apply validation")));

        System.out.println(18 == sprint.getTotalEstimate());
    }
}
