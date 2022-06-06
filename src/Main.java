import Controller.CandidateController;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    private static CandidateController candidate = new CandidateController();

    // Number of candidates can be passed as an argument to args
    public static void main(String[] args) {
        // Variable to save the number of candidates
        int numOfCand;

        // If you have not passed an argument to args, the system will prompt you for the number of candidates
        if (args.length == 0) {
            // If you do not pass a correct value between 1 and 15, an error message will be displayed and the program will terminate
            try {
                System.out.print("How many candidates will you register ?\nThe Maximum Value is 15: ");
                numOfCand = scan.nextInt();
                if (!(numOfCand <= 15 && numOfCand > 0)) {
                    System.err.println("ERROR!!!\nBe Sure To Enter An Integer Value Between 1 and 15");
                    return;
                }
            } catch(Exception e) {
                System.err.println("ERROR!!!\nBe Sure To Enter An Integer Value Between 1 and 15");
                return;
            }

        } else {
            numOfCand = Integer.parseInt(args[0]);
        }


        registerCandidate(numOfCand);

        candidate.print();
    }


    // Will prompt you for the candidate's name and party and will save it to an List
    private static void registerCandidate(int numOfCand) {
        String name;
        String party;
        int i = 0;

        // Uses a 'do-while' to iterate through the number of candidates
        do {
            scan = new Scanner(System.in);

            System.out.print("What's The Candidate Name: ");
            name = scan.nextLine();

            System.out.print("What's The Candidate Party: ");
            party =  scan.nextLine();

            candidate.register(name, party);
            i++;
        } while( i < numOfCand);
        System.out.println();
    }

}
