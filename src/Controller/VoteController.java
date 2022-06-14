package Controller;

import Interfaces.Print;
import Model.Candidate;

import java.util.List;
import java.util.Scanner;

public class VoteController implements Print {
    Scanner scan = new Scanner(System.in);

    private final List<Candidate> candList;
    private final CandidateController candidate;

    // Get values from 'Candidate' class and 'candList'
    public VoteController(CandidateController candidate, List<Candidate> candList) {
        this.candidate = candidate;
        this.candList = candList;
    }

    @Override
    public void print() {
        // If candList is empty print the message below and return
        if (candList == null) {
            System.out.println("No Candidates registered.");
            return;
        }
        int num = 1;

        // Print the  name and party of the candidate and the number to vote for him
        System.out.println("Candidates available: ");
        for (Candidate candidate : candList) {
            String print = "To vote for: " + candidate.getName() +
                    ", Party: " + candidate.getParty() + ",Press " + num + ".\n";
            System.out.println(print);
            num++;
        }
    }

    public void vote(int voters) {
        // Do-whille loop to put the number of the candidate that each voter will vote for
        do {
            print();
            System.out.print("Enter the number of your candidate: ");
            int numCand = scan.nextInt();
            // Calls increaseVote method of the CandidateController class
            candidate.increaseVote(numCand);
            voters--;
        } while (voters > 0);
    }
}
