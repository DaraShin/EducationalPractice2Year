package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);

        if(dependsOn.length == 0){
            dependencies = null;
        }
        else {
            dependencies = dependsOn;
        }
    }

    @Override
    public void complete() {
        if(isCompleted){
            return;
        }

        if(dependencies == null || dependencies.length == 0){
            isCompleted = true;
            return;
        }
        for(UserStory us: dependencies){
            if(us == null){
                return;
            }
            if(!us.isCompleted()){
                return;
            }
        }
        isCompleted = true;
    }

    public UserStory[] getDependencies() {
        if(dependencies == null || dependencies.length == 0){
            return null;
        }

        UserStory[] dependsOn = Arrays.copyOf(dependencies, dependencies.length);
        return  dependsOn;
    }

    @Override
    public String toString() {
        return "[US " + id + "] " + name;
    }
}
