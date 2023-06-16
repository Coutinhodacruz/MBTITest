package mbti;

import static mbti.TestMBTI.*;

public class MBTITestMain {
    public static void main(String[] args) {

        administerTest();
        calculatePersonalityTrait();
        displayResults();
        scanner.close();

    }

//        List<String> answers = new ArrayList<>();
//
//        System.out.println("Personality Test");
//        System.out.println("----------------");
//
//        for (String question : questions) {
//            System.out.println(question);
//            System.out.print("Your answer (A/B): ");
//            String answer = scanner.nextLine().trim().toUpperCase();
//            answers.add(answer);
//        }
//
//        // Process the answers using switch case
//        for (int i = 0; i < answers.size(); i++) {
//            String answer = answers.get(i);
//            switch (answer) {
//                case "A":
//                    System.out.println("Question " + (i + 1) + ": You chose A");
//                    break;
//                case "B":
//                    System.out.println("Question " + (i + 1) + ": You chose B");
//                    break;
//                default:
//                    System.out.println("Question " + (i + 1) + ": Invalid answer");
//                    break;
//            }
//        }




}
