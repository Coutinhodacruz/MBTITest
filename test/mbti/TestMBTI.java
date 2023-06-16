package mbti;

import java.util.Scanner;

import java.util.Scanner;

public class TestMBTI {
//    private static final int NUM_QUESTIONS = 20;
//    private static final int NUM_TRAITS = 4;
//
//    private static final String[] questions = {
//            "Expend energy (A) or conserve energy (B), enjoy one-on-one?",
//            "Interpret literally (A) or look for meaning and possibilities (B)?",
//            "Logical, thinking, questioning (A) or empathetic, feeling, accommodating (B)?",
//            "Organized, orderly (A) or flexible, adaptable (B)?",
//            "More outgoing, think out loud (A) or more reserved, think to yourself (B)?",
//            "Practical, realistic, experiential (A) or imaginative, innovative, theoretical (B)?",
//            "Candid, straightforward, frank (A) or tactful, kind, encouraging (B)?",
//            "Plan, schedule (A) or unplanned, spontaneous (B)?",
//            "Seek many tasks, public activities, interaction with others (A) or seek private solitary activities with quiet to concentrate (B)?",
//            "Standard, usual, conventional (A) or different, novel, unique (B)?",
//            "Firm, tend to criticize, hold the line (A) or gentle, tend to appreciate, conciliate (B)?",
//            "Regulated, structured (A) or easygoing, live and let live (B)?",
//            "External, communicative, express yourself (A) or internal, reticent, keep to yourself (B)?",
//            "Focus on here and now (A) or look to the future, global perspective, big picture (B)?",
//            "Tough-minded, just (A) or tender-hearted, merciful (B)?",
//            "Preparation, plan ahead (A) or go with the flow, adapt as you go (B)?",
//            "Active, initiate (A) or reflective, deliberate (B)?",
//            "Facts, things, what is (A) or ideas, dreams, 'what could be', philosophical (B)?",
//            "Matter of fact, issue-oriented (A) or sensitive, people-oriented, compassionate (B)?",
//            "Control, govern (A) or latitude, freedom (B)?"
//    };
//
//    private static final String[] traits = {
//            "Introversion (I) - Extroversion (E)",
//            "Sensing (S) - Intuition (N)",
//            "Thinking (T) - Feeling (F)",
//            "Judging (J) - Perceiving (P)"
//    };
//
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final int[] traitScores = new int[NUM_TRAITS];
//
//    public static void main(String[] args) {
//        administerTest();
//        calculatePersonalityTrait();
//        displayResults();
//    }
//
//    private static void administerTest() {
//        System.out.print("Welcome to the MBTI Personality Test! Please enter your name: ");
//        String userName = scanner.nextLine();
//        System.out.println("\nHello, " + userName + "!\n");
//
//        for (int i = 0; i < NUM_QUESTIONS; i++) {
//            System.out.println(questions[i]);
//            char response = '\0';
//            do {
//                System.out.print("Enter your response [A/B]: ");
//                response = Character.toUpperCase(scanner.nextLine().charAt(0));
//            } while (response != 'A' && response != 'B');
//
//            // Update the trait scores based on the response
//            updateTraitScore(i, response);
//        }
//    }
//
//    private static void updateTraitScore(int questionIndex, char response) {
//        int traitIndex;
//
//        if (questionIndex >= 0 && questionIndex < 5) {
//            traitIndex = 0; // Introversion (I) - Extroversion (E)
//        } else if (questionIndex >= 5 && questionIndex < 10) {
//            traitIndex = 1; // Sensing (S) - Intuition (N)
//        } else if (questionIndex >= 10 && questionIndex < 15) {
//            traitIndex = 2; // Thinking (T) - Feeling (F)
//        } else {
//            traitIndex = 3; // Judging (J) - Perceiving (P)
//        }
//
//        if (response == 'A') {
//            traitScores[traitIndex]--;
//        } else {
//            traitScores[traitIndex]++;
//        }
//    }
//
//    private static void calculatePersonalityTrait() {
//        StringBuilder personalityTrait = new StringBuilder();
//
//        for (int i = 0; i < NUM_TRAITS; i++) {
//            if (traitScores[i] > 0) {
//                personalityTrait.append(traits[i].charAt(4));
//            } else {
//                personalityTrait.append(traits[i].charAt(0));
//            }
//        }
//
//        System.out.println("\nPersonality Trait: " + personalityTrait.toString());
//    }
//
//    private static void displayResults() {
//        int numA = 0;
//        int numB = 0;
//
//        System.out.println("\nYour selected responses:\n");
//
//        for (int i = 0; i < NUM_QUESTIONS; i++) {
//            char response = (i % 2 == 0) ? 'A' : 'B';
//
//            if (response == 'A') {
//                numA++;
//            } else {
//                numB++;
//            }
//
//            System.out.println(response + ". " + questions[i]);
//        }
//
//        System.out.println("\nNumber of A selected: " + numA);
//        System.out.println("Number of B selected: " + numB);
//    }


}



