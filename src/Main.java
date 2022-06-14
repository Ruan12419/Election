import Controller.CandidateController;
import Controller.VoteController;

import java.util.Scanner;

public class Main {
    // Number of voters (you can set as final and sign a fixed amount (and remove the 'setVoters' method))
    static int VOTERS;
    private static Scanner scan = new Scanner(System.in);

    private static final CandidateController candidate = new CandidateController();
    private static final VoteController vote = new VoteController(candidate, candidate.getCandList());

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

        setVoters();
        vote.vote(VOTERS);

        System.out.println("Number of Votes: " + candidate.getVotes());
    }


    // Will prompt you for the candidate's name and party and will save it to a List
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

    // Sign the number of voters in the 'VOTERS' field
    private static void setVoters() {
        System.out.print("How many voters will this system have: ");
        VOTERS = scan.nextInt();
    }
}
