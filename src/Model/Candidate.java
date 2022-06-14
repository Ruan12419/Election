package Model;

public class Candidate {
    private final String name;
    private final String party;
    private long votes;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public String getName() {
        return name;
    }


    public String getParty() {
        return party;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes += votes;
    }
}
