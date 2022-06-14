package Controller;


import Interfaces.Register;
import Interfaces.Print;
import Interfaces.Save;
import Model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateController implements Print, Register, Save {

    private final List<Candidate> candList = new ArrayList<>();

    @Override
    public void print() {
        for (Candidate candidate : candList) {
            String print = "Candidate name: " + candidate.getName() +
                           "\nCandidate party: " + candidate.getParty() + "\n";
            System.out.println(print);
        }
    }


    @Override
    public void register(String name, String party) {
        Candidate candidate = new Candidate(name, party);
        save(candidate);
    }

    @Override
    public void save(Candidate candidate) {
        candList.add(candidate);
    }


    public List<Candidate> getCandList() {
        return candList;
    }

    public void increaseVote(int num) {
        Candidate cand;
        try {
            cand = candList.get(num - 1);

        } catch (Exception e) {
            System.err.println("ERROR!\nIncorrect Candidate Number!");
            return;
        }
        cand.setVotes(1);
        candList.set(num - 1, cand);
    }

    public String getVotes() {
        String votes = "\n";
        for (Candidate candidate: candList ) {
            votes += candidate.getName();
            votes += " votes: " + candidate.getVotes() + ".\n";
        }
        return votes;
    }
}
