package mbti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MBTIPersonalityTest {
    private static final int NUM_QUESTIONS = 20;
    private static final String[] QUESTIONS = {
            "I enjoy socializing at parties.",
            "I prefer to spend time alone rather than with a group of people.",
            "I often try new things just for the experience.",
            "I prefer to have a few close friends rather than many acquaintances.",
            "I like to carefully plan my activities in advance.",
            "I am more energetic and enthusiastic than calm and reserved.",
            "I often feel overwhelmed by emotions.",
            "I value logic and rational thinking over emotions and feelings.",
            "I enjoy going to social events and meeting new people.",
            "I find it draining to be around a lot of people for long periods.",
            "I am often the one to start a conversation with others.",
            "I am a private person and don't share much about myself.",
            "I like to follow a schedule and dislike unexpected changes.",
            "I am adaptable and go with the flow.",
            "I trust my instincts and feelings more than facts and evidence.",
            "I enjoy discussing various topics with different people.",
            "I need some time alone to recharge after socializing.",
            "I am detail-oriented and notice small changes.",
            "I prefer to work in a quiet and focused environment.",
            "I enjoy taking risks and trying new things."
    };

    private static final String[] TRAIT_DESCRIPTIONS = {
            "Introverted (I) - Reserved, reflective, and thoughtful.",
            "Extroverted (E) - Outgoing, energetic, and expressive.",
            "Intuitive (N) - Imaginative, open-minded, and curious.",
            "Observant (S) - Practical, realistic, and focused on details.",
            "Thinking (T) - Logical, objective, and analytical.",
            "Feeling (F) - Empathetic, compassionate, and values emotions.",
            "Judging (J) - Organized, planned, and decisive.",
            "Perceiving (P) - Flexible, spontaneous, and adaptable."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect user's name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Welcome, " + userName + ", to the MBTI Personality Test!");

        List<Character> userResponses = new ArrayList<>();

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Q" + (i + 1) + ": " + QUESTIONS[i]);
            char response = getUserResponse(scanner);
            userResponses.add(response);
        }

        scanner.close();

        // Calculate personality trait based on user responses
        String personalityTrait = calculatePersonalityTrait(userResponses);

        // Display results
        System.out.println("\nUser Responses:");
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println("Q" + (i + 1) + ": " + userResponses.get(i));
        }

        System.out.println("\nPersonality Trait: " + personalityTrait);
        System.out.println("Trait Description: " + getTraitDescription(personalityTrait));
    }

    static char getUserResponse(Scanner scanner) {
        char response;
        do {
            System.out.print("Select A or B: ");
            try {
                response = validateResponse(scanner.next().toUpperCase().charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                response = ' '; // Set response to a default value
            }
        } while (response == ' ');
        return response;
    }

    static char validateResponse(char response) {
        if (response != 'A' && response != 'B') {
            throw new IllegalArgumentException("Invalid response. Please enter either 'A' or 'B'.");
        }
        return response;
    }

    static String calculatePersonalityTrait(List<Character> responses) {
        int countA = 0;
        int countB = 0;

        for (char response : responses) {
            if (response == 'A') {
                countA++;
            } else {
                countB++;
            }
        }

        // Personality trait determination
        String trait = "";
        if (countA > countB) {
            trait += "I";
        } else {
            trait += "E";
        }

        if (responses.get(4) == 'B') {
            trait += "S";
        } else {
            trait += "N";
        }

        if (responses.get(8) == 'B') {
            trait += "T";
        } else {
            trait += "F";
        }

        if (responses.get(12) == 'B') {
            trait += "J";
        } else {
            trait += "P";
        }

        return trait;
    }

    static String getTraitDescription(String personalityTrait) {
        StringBuilder description = new StringBuilder();

        for (char trait : personalityTrait.toCharArray()) {
            switch (trait) {
                case 'I' -> description.append(TRAIT_DESCRIPTIONS[0]).append(" ");
                case 'E' -> description.append(TRAIT_DESCRIPTIONS[1]).append(" ");
                case 'N' -> description.append(TRAIT_DESCRIPTIONS[2]).append(" ");
                case 'S' -> description.append(TRAIT_DESCRIPTIONS[3]).append(" ");
                case 'T' -> description.append(TRAIT_DESCRIPTIONS[4]).append(" ");
                case 'F' -> description.append(TRAIT_DESCRIPTIONS[5]).append(" ");
                case 'J' -> description.append(TRAIT_DESCRIPTIONS[6]).append(" ");
                case 'P' -> description.append(TRAIT_DESCRIPTIONS[7]).append(" ");
            }
        }

        return description.toString().trim();
    }
}
