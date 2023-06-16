package mbti;
import java.util.Scanner;

public class TestMBTI {




    private static final int NUM_QUESTIONS = 20;
    private static final int NUM_TRAITS = 4;



        private static final String[] traits = {
                "Introversion (I) - Extroversion (E)",
                "Sensing (S) - Intuition (N)",
                "Thinking (T) - Feeling (F)",
                "Judging (J) - Perceiving (P)"
        };

        private static final int[] traitScores = new int[NUM_TRAITS];

        public static  Scanner scanner = new Scanner(System.in);



    public static void administerTest() {
        System.out.println("Welcome to the MBTI Personality Test! \n");
        System.out.println("Please enter your name:");
        String userName = scanner.nextLine();
        System.out.println("\nHello, " + userName + "!\n");

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            System.out.println(questions[i]);
            char response;
            do {
                System.out.print("Enter your response [A/B]: ");
                response = Character.toUpperCase(scanner.nextLine().charAt(0));
            } while (response != 'A' && response != 'B');

            updateTraitScore(i, response);
        }
    }


    private static void updateTraitScore(int questionIndex, char response) {

            if (response == 'A') {

                traitScores[0] += (questionIndex % 2 == 0) ? 1 : -1;
                traitScores[2] += (questionIndex % 2 == 0) ? 1 : -1;
            } else {

                traitScores[1] += (questionIndex % 2 == 1) ? 1 : -1;
                traitScores[3] += (questionIndex % 2 == 1) ? 1 : -1;
            }
        }



    public static void calculatePersonalityTrait() {
        int numA = 0;
        int numB = 0;

        for (int i = 0; i < NUM_QUESTIONS; i++) {
            char response = (i % 2 == 0) ? 'A' : 'B';

            if (response == 'A') {
                numA++;
            } else {
                numB++;
            }

            System.out.println(response + ". " + questions[i]);
        }
        StringBuilder personalityTrait = new StringBuilder();

        for (int i = 0; i < NUM_TRAITS; i++) {
            if (traitScores[i] > 0) {
                personalityTrait.append(traits[i].charAt(4));
            } else {
                personalityTrait.append(traits[i].charAt(0));
            }
        }

        System.out.println("\nPersonality Trait: " + personalityTrait);
        displayPersonalityMeaning(personalityTrait.toString());

        System.out.println("\nNumber of A selected: " + numA);
        System.out.println("Number of B selected: " + numB);
    }

    private static void displayPersonalityMeaning(String personalityTrait) {
        String meaning = switch (personalityTrait) {
            case "ISTJ" -> "ISTJ (Introverted, Sensing, Thinking, Judging) - The Inspector";
            case "ISFJ" -> "ISFJ (Introverted, Sensing, Feeling, Judging) - The Protector";
            case "INFJ" -> "INFJ (Introverted, Intuitive, Feeling, Judging) - The Counselor";
            case "INTJ" -> "INTJ (Introverted, Intuitive, Thinking, Judging) - The Mastermind";
            case "ISTP" -> "ISTP (Introverted, Sensing, Thinking, Perceiving) - The Craftsman";
            case "ISFP" -> "ISFP (Introverted, Sensing, Feeling, Perceiving) - The Composer";
            case "INFP" -> "INFP (Introverted, Intuitive, Feeling, Perceiving) - The Healer";
            default -> "";
        };

        System.out.println("Personality Meaning: " + meaning);
    }

    public static void displayResults() {
        StringBuilder personalityTrait = new StringBuilder();

        for (int i = 0; i < NUM_TRAITS; i++) {
            if (traitScores[i] > 0) {
                personalityTrait.append(traits[i].charAt(0));
            } else {
                personalityTrait.append(traits[i].charAt(4));
            }
        }

        System.out.println("\nPersonality Trait: " + personalityTrait);
    }

    private static final String[] questions = {
            "1 \nExpend energy (A) \t (B) conserve energy enjoy one-on-one? \n",
            "2 \nInterpret literally (A) \t look for meaning and possibilities (B)? \n",
            "3 \nLogical, thinking, questioning (A) \t empathetic, feeling, accommodating (B)? \n",
            "4 \nOrganized, orderly (A) \t flexible, adaptable (B)?\n ",
            "5 \nMore outgoing, think out loud (A) \t more reserved, think to yourself (B)?\n",
            "6 \nPractical, realistic, experiential (A) \t imaginative, innovative, theoretical (B)? \n",
            "7 \nCandid, straightforward, frank (A) \t tactful, kind, encouraging (B)? \n",
            "8 \nPlan, schedule (A) \t unplanned, spontaneous (B)? \n",
            "9 \nSeek many tasks, public activities, interaction with others (A) \t seek private solitary activities with quiet to concentrate (B)? \n",
            "10 \nStandard, usual, conventional (A) \t different, novel, unique (B)? \n",
            "11 \nFirm, tend to criticize, hold the line (A) \t gentle, tend to appreciate, conciliate (B)? \n",
            "12 \nRegulated, structured (A) \t easygoing, live and let live (B)?",
            "13 \nExternal, communicative, express yourself (A) \t internal, reticent, keep to yourself (B)? \n",
            "14 \nFocus on here and now (A) \t look to the future, global perspective, big picture (B)? \n",
            "15 \nTough-minded, just (A) \t tender-hearted, merciful (B)? \n",
            "16 \nPreparation, plan ahead (A) \t go with the flow, adapt as you go (B)? \n",
            "17 \nActive, initiate (A) \t reflective, deliberate (B)? \n",
            "18 \nFacts, things, what is (A) \t ideas, dreams, 'what could be', philosophical (B)? \n",
            "19 \nMatter of fact, issue-oriented (A) \t sensitive, people-oriented, compassionate (B)? \n",
            "20 \nControl, govern (A) \t latitude, freedom (B)? \n"
    };


}

