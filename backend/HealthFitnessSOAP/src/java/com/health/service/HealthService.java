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
        return "Sleep Quality module is not completed yet.";
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
        // ===== VALIDATION =====
if (sleepHours < 0 || sleepHours > 24) {
    return "Error: Sleep hours must be between 0 and 24.";
}

if (activityLevel == null || activityLevel.trim().isEmpty()) {
    return "Error: Activity level cannot be empty.";
}

if (workloadLevel < 1 || workloadLevel > 5) {
    return "Error: Workload level must be between 1 and 5.";
}

if (moodLevel < 1 || moodLevel > 5) {
    return "Error: Mood level must be between 1 and 5.";
}

if (exerciseFrequency < 0 || exerciseFrequency > 7) {
    return "Error: Exercise frequency must be between 0 and 7 days.";
}

// ===== CALCULATION =====
int stressScore = 0;

// Sleep factor
if (sleepHours < 5) {
    stressScore += 30;
} else if (sleepHours < 7) {
    stressScore += 15;
} else {
    stressScore += 5;
}

// Activity level factor
if (activityLevel.equalsIgnoreCase("low")) {
    stressScore += 20;
} else if (activityLevel.equalsIgnoreCase("moderate")) {
    stressScore += 10;
} else if (activityLevel.equalsIgnoreCase("high")) {
    stressScore += 5;
} else {
    return "Error: Activity level must be Low, Moderate, or High.";
}

// Caffeine factor
if (caffeineBeforeSleep) {
    stressScore += 10;
}

// Workload factor
stressScore += workloadLevel * 8;

// Mood factor (reverse effect)
stressScore += (6 - moodLevel) * 6;

// Exercise factor
if (exerciseFrequency <= 1) {
    stressScore += 15;
} else if (exerciseFrequency <= 3) {
    stressScore += 8;
} else {
    stressScore += 3;
}

// Limit score
if (stressScore > 100) {
    stressScore = 100;
}

// ===== RESULT =====
String category;
String interpretation;

if (stressScore < 25) {
    category = "Low Stress";
    interpretation = "Your stress level is low. Maintain your healthy routine.";
} else if (stressScore < 50) {
    category = "Mild Stress";
    interpretation = "You show mild stress. Improve rest and manage workload.";
} else if (stressScore < 75) {
    category = "Moderate Stress";
    interpretation = "Your stress level is moderate. Improve sleep and time management.";
} else {
    category = "High Stress";
    interpretation = "Your stress level is high. Take breaks and reduce workload.";
}

return "===== STRESS LEVEL RESULT ====="
        + "\nSleep Hours           : " + sleepHours
        + "\nActivity Level        : " + activityLevel
        + "\nCaffeine Before Sleep : " + caffeineBeforeSleep
        + "\nWorkload Level        : " + workloadLevel + "/5"
        + "\nMood Level            : " + moodLevel + "/5"
        + "\nExercise Frequency    : " + exerciseFrequency + " days/week"
        + "\nStress Score          : " + stressScore + "/100"
        + "\nCategory              : " + category
        + "\nInterpretation        : " + interpretation
        + "\n===============================";
    }
}