package Controller;


import Interfaces.Register;
import Interfaces.Print;
import Interfaces.Save;
import Model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateController implements Print, Register, Save {

    private List<Candidate> candList = new ArrayList<>();

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
}
