package com.health.service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "HealthService")
public class HealthService {

    @WebMethod(operationName = "displayUserInfo")
    public String displayUserInfo(
            @WebParam(name = "name") String name,
            @WebParam(name = "idNumber") String idNumber,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "weight") double weight,
            @WebParam(name = "height") double height,
            @WebParam(name = "age") int age) {

        // TODO: Return formatted user information
        return "User information module is not completed yet.";
    }

    @WebMethod(operationName = "calculateAge")
    public int calculateAge(
            @WebParam(name = "idNumber") String idNumber) {

        // TODO: Calculate age based on IC number / birthdate
        return 0;
    }

    @WebMethod(operationName = "calculateBMI")
    public double calculateBMI(
            @WebParam(name = "weight") double weight,
            @WebParam(name = "height") double height) {

        // TODO: BMI person fills this logic
        return 0.0;
    }

    @WebMethod(operationName = "getBMICategory")
    public String getBMICategory(
            @WebParam(name = "bmi") double bmi) {

        // TODO: BMI person fills category logic
        return "Not completed yet.";
    }

    @WebMethod(operationName = "calculateBodyFat")
    public double calculateBodyFat(
            @WebParam(name = "gender") String gender,
            @WebParam(name = "age") int age,
            @WebParam(name = "weight") double weight,
            @WebParam(name = "height") double height) {

        // TODO: Body Fat person fills this logic
        return 0.0;
    }

    @WebMethod(operationName = "calculateCalories")
    public double calculateCalories(
            @WebParam(name = "gender") String gender,
            @WebParam(name = "age") int age,
            @WebParam(name = "weight") double weight,
            @WebParam(name = "height") double height,
            @WebParam(name = "activityLevel") String activityLevel) {

        // TODO: Calories person fills this logic
        return 0.0;
    }

    @WebMethod(operationName = "calculateSleepQuality")
    public String calculateSleepQuality(
            @WebParam(name = "sleepHours") double sleepHours,
            @WebParam(name = "wakeUpCount") int wakeUpCount,
            @WebParam(name = "caffeineBeforeSleep") boolean caffeineBeforeSleep,
            @WebParam(name = "screenBeforeSleep") boolean screenBeforeSleep) {

        // TODO: Sleep Quality person fills this logic
        int score = 100;

        // Sleep duration
        if (sleepHours < 6) {
            score -= 25;
        } else if (sleepHours < 7) {
            score -= 10;
        }

        // Wake up interruptions
        if (wakeUpCount > 2) {
            score -= 20;
        }

        // Caffeine effect
        if (caffeineBeforeSleep) {
            score -= 15;
        }

        // Screen exposure
        if (screenBeforeSleep) {
            score -= 10;
        }

        // Category
        String category;
        if (score >= 80) {
            category = "Good Sleep";
        } else if (score >= 50) {
            category = "Moderate Sleep";
        } else {
            category = "Poor Sleep";
        }

        // Recommendation
        String recommendation;

        if (category.equals("Good Sleep")) {
            recommendation = "Keep maintaining your current sleep habits.";
        } else if (category.equals("Moderate Sleep")) {
            recommendation = "Try to improve sleep consistency and reduce screen time.";
        } else {
            recommendation = "Increase sleep duration and avoid caffeine before bedtime.";
        }

        return "Sleep Score: " + score +
               "\nCategory: " + category +
               "\nRecommendation: " + recommendation;
            }

    @WebMethod(operationName = "estimateStressLevel")
    public String estimateStressLevel(
            @WebParam(name = "sleepHours") double sleepHours,
            @WebParam(name = "activityLevel") String activityLevel,
            @WebParam(name = "caffeineBeforeSleep") boolean caffeineBeforeSleep,
            @WebParam(name = "workloadLevel") int workloadLevel,
            @WebParam(name = "moodLevel") int moodLevel,
            @WebParam(name = "exerciseFrequency") int exerciseFrequency) {

        // TODO: Stress Level person fills this logic
        return "Stress Level module is not completed yet.";
    }
}