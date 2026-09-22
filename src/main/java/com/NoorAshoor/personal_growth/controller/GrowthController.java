package com.NoorAshoor.personal_growth.controller;

import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class GrowthController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Noor's Personal Growth API ";
    }

    static class Profile {
        private String name;
        private String introduction;
        private String theme;
        private List<String> interestingFacts;
        private String favoriteGoal;
        private String currentlyInterestedIn;

        public Profile(String name, String introduction, String theme, List<String> interestingFacts, String favoriteGoal, String currentlyInterestedIn) {
            this.name = name;
            this.introduction = introduction;
            this.theme = theme;
            this.interestingFacts = interestingFacts;
            this.favoriteGoal = favoriteGoal;
            this.currentlyInterestedIn = currentlyInterestedIn;
        }

        public String getName() {return name;}
        public String getIntroduction() {return introduction;}
        public String getTheme() {return theme;}
        public List<String> getInterestingFacts() {return interestingFacts;}
        public String getFavoriteGoal() {return favoriteGoal;}
        public String getCurrentlyInterestedIn() {return currentlyInterestedIn;}
    }

    private final Profile profile = new Profile(
            "Noor",
            "I enjoy learning, building healthy habits, and becoming a better version of myself.",
            "Personal Growth",
            List.of(
                    "I enjoy reading books.",
                    "I am working on building a healthier lifestyle.",
                    "I value spending time with my family."
            ),
            "Building a balanced lifestyle",
            "Personal growth and building better habits"
    );

    @GetMapping("/profile")
    public Profile getProfile() {
        return profile;
    }

    static class Goal {
        private int id;
        private String name;
        private String Category;
        public Goal(int id, String name, String Category) {this.id = id;this.name = name; this.Category = Category;}
        public int getId() {return id;}
        public String getName() {return name;}
        public String getCategory() {return Category;}
    }
    private final List<Goal> goals = new ArrayList<>(List.of(
            new Goal(1, "Learn a New Language", "Learning"),
            new Goal(2, "Stay Active & Exercise", "Fitness"),
            new Goal(3, "Build Healthy Eating Habits", "Health"),
            new Goal(4, "Read More Books", "Learning"),
            new Goal(5, "Strengthen My Faith", "Spiritual"),
            new Goal(6, "Strengthen Family Relationships", "Family")
    ));
    @GetMapping("/goals")
    public List<Goal> getGoals() {
        return goals;
    }

    @GetMapping("/goals/{id}")
    public Goal byId(@PathVariable int id) {
        for (Goal goal : goals) {
            if (goal.getId() == id) {
                return goal;
            }
        }
        return null;
    }

    @GetMapping("/goals/search")
    public List<Goal> searchGoals(@RequestParam String name) {
        return goals.stream().filter(goal -> goal.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    @GetMapping("/goals/filter")
    public List<Goal> filterGoals(@RequestParam String category) {
        return goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase(category)).toList();
    }

    @PostMapping("/goals")
    public Goal addGoal(@RequestBody Goal goal) {
        goals.add(goal);
        return goal;
    }

    @PutMapping("/goals/{id}")
    public Goal updateGoal(@PathVariable int id, @RequestBody Goal updatedGoal) {

        for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i).getId() == id) {
                goals.set(i, updatedGoal);
                return updatedGoal;
            }
        }
        return null;
    }

    @DeleteMapping("/goals/{id}")
    public String deleteGoal(@PathVariable int id) {
        for (Goal goal : goals) {
            if (goal.getId() == id) {
                goals.remove(goal);
                return "Goal deleted successfully";
            }
        }
        return "Goal not found";
    }

    @GetMapping("/statistics")
    public String getStatistics() {
        long totalGoals = goals.size();
        long learningGoals = goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase("Learning")).count();
        long fitnessGoals = goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase("Fitness")).count();
        long healthGoals = goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase("Health")).count();
        long spiritualGoals = goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase("Spiritual")).count();
        long familyGoals = goals.stream().filter(goal -> goal.getCategory().equalsIgnoreCase("Family")).count();
        return "Total Goals: " + totalGoals + ", Learning: " + learningGoals + ", Fitness: " + fitnessGoals + ", Health: " + healthGoals + ", Spiritual: " + spiritualGoals + ", Family: " + familyGoals;
    }

    @GetMapping("/goals/today")
    public Goal dailyGrowthGoal() {
        Random random = new Random();
        int randomIndex = random.nextInt(goals.size());
        return goals.get(randomIndex);
    }
}