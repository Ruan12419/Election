import Controller.CandidateController;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static CandidateController candidate = new CandidateController();
    public static void main(String[] args) {
        int numOfCand;

        if (args.length == 0) {
            System.out.print("How many candidates will you register ?\nThe Maximum Value is 15: ");
            numOfCand = scan.nextInt();
            if (!validate(numOfCand)) {
                return;
            }
        } else {
            numOfCand = Integer.parseInt(args[0]);
        }


        registerCandidate(numOfCand);

        candidate.print();
    }



    private static void registerCandidate(int numOfCand) {
        String name;
        String party;
        int i = 0;

        while( i < numOfCand) {
            scan = new Scanner(System.in);

            System.out.print("What's The Candidate Name: ");
            name = scan.nextLine();

            System.out.print("What's The Candidate Party: ");
            party =  scan.nextLine();

            candidate.register(name, party);
            i++;
        }
    }

    private static boolean validate(int numOfCand) {
        try {
            return numOfCand <= 15 && numOfCand > 0;
        } catch (Exception e) {
            System.err.println("ERROR!!!\nMake Sure You Typed A Valid Integer Value Between 1 and 15");
            return false;
        }
    }
}
