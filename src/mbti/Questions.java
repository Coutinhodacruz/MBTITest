package mbti;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questions {
    private static final Scanner scanner = new Scanner(System.in);
    static int[] counts = new int[5];

    public static void main(String[] args) {
        Questions questions = new Questions();
        questions.personalityTest();
    }

    public void personalityTest() {
        System.out.println("What is your full name");
        String name = scanner.nextLine().toUpperCase();
        System.out.println("Hi " + name + ", this is your personality check questionnaire");
        System.out.println();

//        int[] counts = new int[5]; // Adjusted array size to match the number of questions

        String value1 = introvertedAndExtroverted(name, counts);
        String value2 = sensingAndIntuitive(name, counts);
        String value3 = thinkingAndFeeling(name, counts);
        String value4 = judgingAndPerceptive(name, counts);

        String traits = value1 + value2 + value3 + value4;
        System.out.println("Your personality type is: " + traits);
        System.out.println();

        System.out.print("You show traits of an/a: ");
        String personalityType = getPersonalityType(traits);
        if (!personalityType.isEmpty()) {
            System.out.println(personalityType);
        } else {
            System.out.println("Unknown");
        }
    }

    private static String introvertedAndExtroverted(String name, int[] counts) {
        String[] questions = {"1", "2", "3", "4", "5"};
        String[][] answerOptions = {
                {"a. expend energy, enjoy groups", "b. conserve energy, enjoy one-on-one"},
                {"a. more outgoing, think out loud", "b. more reserved, think to yourself"},
                {"a. seek many tasks, public activities, interaction with others", "b. seek private solitary activities with quiet to concentrate"},
                {"a. external, communicative, express yourself", "b. internal, reticent, keep to yourself"},
                {"a. active, initiate", "b. reflective, deliberate"}
        };

        return getTrait(questions, answerOptions, name, counts, "E", "I");
    }

    private static String sensingAndIntuitive(String name, int[] counts) {
        String[] questions = {"6", "7", "8", "9", "10"};
        String[][] answerOptions = {
                {"a. interpret literally", "b. look for meaning and possibilities"},
                {"a. practical, realistic, experiential", "b. imaginative, innovative, theoretical"},
                {"a. standard, usual, conventional", "b. different, novel, unique"},
                {"a. focus on here and now", "b. look to the future, global perspective, big picture"},
                {"a. facts, things, what is", "b. ideas, dreams, what could be, philosophical"}
        };

        return getTrait(questions, answerOptions, name, counts, "S", "N");
    }

    private static String thinkingAndFeeling(String name, int[] counts) {
        String[] questions = {"11", "12", "13", "14", "15"};
        String[][] answerOptions = {
                {"a. logical, thinking, questioning", "b. empathetic, feeling, accommodating"},
                {"a. candid, straightforward, frank", "b. tactful, kind, encouraging"},
                {"a. firm, tend to criticize, hold the line", "b. gentle, tend to appreciate, conciliate"},
                {"a. tough-minded, just", "b. tender-hearted, merciful"},
                {"a. matter of fact, issue-oriented", "b. sensitive, people-oriented, compassionate"}
        };

        return getTrait(questions, answerOptions, name, counts, "T", "F");
    }

    private static String judgingAndPerceptive(String name, int[] counts) {
        String[] questions = {"16", "17", "18", "19", "20"};
        String[][] answerOptions = {
                {"a. organized, orderly", "b. flexible, adaptable"},
                {"a. plan, schedule", "b. unplanned, spontaneous"},
                {"a. regulated, structured", "b. easygoing, live and let live"},
                {"a. preparation, plan ahead", "b. go with the flow, adapt as you go"},
                {"a. control, govern", "b. latitude, freedom"}
        };

        return getTrait(questions, answerOptions, name, counts, "J", "P");
    }

    private static String getTrait(String[] questions, String[][] answerOptions, String name, int[] counts, String traitA, String traitB) {
        List<String> userAnswers = getUsersAnswers(questions, answerOptions, name);

        for (String answer : userAnswers) {
            if (answer.equals("a")) {
                counts[0]++;
            } else if (answer.equals("b")) {
                counts[1]++;
            }
        }

        return (counts[0] > counts[1]) ? traitA : traitB;
    }

    private static List<String> getUsersAnswers(String[] questions, String[][] answerOptions, String name) {
        List<String> userAnswers = new ArrayList<>();

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + questions[i]);
            System.out.println("Choose either a or b: ");
            for (String choice : answerOptions[i]) {
                System.out.println(choice);
            }
            String userAnswer = scanner.nextLine().toLowerCase();

            while (!userAnswer.equals("a") && !userAnswer.equals("b")) {
                System.out.println("Expected a or b as a response");
                System.out.println("I know this is an error, please retry again");
                userAnswer = scanner.nextLine().toLowerCase();
            }
            userAnswers.add(userAnswer);
            System.out.println();
        }

        System.out.println();
        System.out.println("Hello " + name + ", you selected:");
        for (String letter : userAnswers) {
            System.out.println(letter);
        }
        System.out.println("Number of A's selected: " + counts[0]);
        System.out.println("Number of B's selected: " + counts[1]);
        System.out.println();
        System.out.println();

        return userAnswers;
    }

    private static String getPersonalityType(String traits) {
        switch (traits) {
            case "INTJ":
                return "Architect";
            case "INTP":
                return "Logician";
            case "ENTJ":
                return "Commander";
            case "ENTP":
                return "Debater";
            case "INFJ":
                return "Advocate";
            case "INFP":
                return "Mediator";
            case "ENFJ":
                return "Protagonist";
            case "ENJP":
                return "Campaigner";
            case "ISTJ":
                return "Logistician";
            case "ISFJ":
                return "Defender";
            case "ESTJ":
                return "Executive";
            case "ESFJ":
                return "Consul";
            case "ISTP":
                return "Virtuoso";
            case "ISFP":
                return "Adventurer";
            case "ESTP":
                return "Entrepreneur";
            case "ESFP":
                return "Entertainer";
            default:
                return "";
        }
    }
}

