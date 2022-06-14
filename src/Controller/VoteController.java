package Controller;

import Interfaces.Print;
import Model.Candidate;

import java.util.List;
import java.util.Scanner;

public class VoteController implements Print {
    Scanner scan = new Scanner(System.in);

    private final List<Candidate> candList;
    private final CandidateController candidate;

    public VoteController(CandidateController candidate, List<Candidate> candList) {
        this.candidate = candidate;
        this.candList = candList;
    }

    @Override
    public void print() {
        if (candList == null) {
            System.out.println("No Candidates registered.");
            return;
        }
        int num = 1;

        System.out.println("Candidates available: ");
        for (Candidate candidate : candList) {
            String print = "To vote for: " + candidate.getName() +
                    ", Party: " + candidate.getParty() + ",Press " + num + ".\n";
            System.out.println(print);
            num++;
        }
    }

    public void vote(int voters) {
        do {
            print();
            System.out.print("Enter the number of your candidate: ");
            int numCand = scan.nextInt();
            candidate.increaseVote(numCand);
            voters--;
        } while (voters > 0);
    }
}
