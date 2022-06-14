package Controller;


import Interfaces.Register;
import Interfaces.Print;
import Interfaces.Save;
import Model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateController implements Print, Register, Save {

    // List responsible to store the candidates
    private final List<Candidate> candList = new ArrayList<>();

    // Print each candidate name and party
    @Override
    public void print() {
        for (Candidate candidate : candList) {
            String print = "Candidate name: " + candidate.getName() +
                           "\nCandidate party: " + candidate.getParty() + "\n";
            System.out.println(print);
        }
    }


    // Will register the name and party of each candidate and call the 'save' method
    @Override
    public void register(String name, String party) {
        Candidate candidate = new Candidate(name, party);
        save(candidate);
    }

    // Save candidate information in candList
    @Override
    public void save(Candidate candidate) {
        candList.add(candidate);
    }


    // Return the values of the candList
    public List<Candidate> getCandList() {
        return candList;
    }

    // Increases a given candidate's votes by 1
    public void increaseVote(int num) {
        Candidate cand;
        // Try to get the candidate information
        try {
            cand = candList.get(num - 1);

        }
        // If there is no candidate in index 'num' return the error message below
        catch (Exception e) {
            System.err.println("ERROR!\nIncorrect Candidate Number!");
            return;
        }
        // Increase votes by 1
        cand.setVotes(1);
        // Updates candidate information in the list
        candList.set(num - 1, cand);
    }

    // Returns the votes of each candidate
    public String getVotes() {
        StringBuilder votes = new StringBuilder("\n");
        for (Candidate candidate: candList ) {
            votes.append(candidate.getName());
            votes.append(" votes: ").append(candidate.getVotes()).append(".\n");
        }
        return votes.toString();
    }
}
