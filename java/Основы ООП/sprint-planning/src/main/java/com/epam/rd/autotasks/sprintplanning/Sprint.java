package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private int currentTicketsNumber;
    private int currentTime;
    private Ticket[] tickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        currentTicketsNumber = 0;
        currentTime = 0;
        tickets = new Ticket[ticketsLimit];
        Arrays.fill(tickets, null);
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null){
            return false;
        }
        if(!checkDependencies(userStory)){
            return false;
        }

        return addTicket(userStory);
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null){
            return false;
        }
        return addTicket( bugReport);
    }

    private boolean addTicket(Ticket ticket){
        if(ticket.isCompleted()){
            return false;
        }
        if (ticket.getEstimate() + currentTime > capacity) {
            return false;
        }
        if (currentTicketsNumber == ticketsLimit) {
            return false;
        }

        tickets[currentTicketsNumber] = ticket;
        currentTicketsNumber++;
        currentTime += ticket.getEstimate();
        return true;
    }

    public Ticket[] getTickets() {
        if(currentTicketsNumber == 0){
            return null;
        }
        return Arrays.copyOf(tickets, currentTicketsNumber);
    }

    public int getTotalEstimate() {
        return currentTime;
    }

    private boolean checkDependencies(UserStory us) {
        UserStory[] dependencies = us.getDependencies();
        if (dependencies == null) {
            return true;
        }

        dependenciesFor: for(UserStory dependency: dependencies){
            if(dependency.isCompleted()){
                continue;
            }
            for(Ticket ticket: tickets){
                if(ticket instanceof UserStory && ticket.getId() == dependency.getId()){
                    continue dependenciesFor;
                }
            }
            return false;
        }
        return true;
    }

}
