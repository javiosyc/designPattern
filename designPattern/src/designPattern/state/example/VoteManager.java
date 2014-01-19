package designPattern.state.example;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {

	private VoteState state = null;
	private Map<String, String> mapVote = new HashMap<String, String>();

	private Map<String, Integer> mapVoteCount = new HashMap<String, Integer>();

	public Map<String, String> getMapVote() {
		return mapVote;
	}

	public void setMapVote(Map<String, String> mapVote) {
		this.mapVote = mapVote;
	}

	public Map<String, Integer> getMapVoteCount() {
		return mapVoteCount;
	}

	public void setMapVoteCount(Map<String, Integer> mapVoteCount) {
		this.mapVoteCount = mapVoteCount;
	}

	public void vote(String user, String voteItem) {

		Integer oldVoteCount = mapVoteCount.get(user);
		if (oldVoteCount == null) {
			oldVoteCount = 0;
		}

		oldVoteCount++;
		mapVoteCount.put(user, oldVoteCount);

		if (oldVoteCount == 1) {
			state = new NormalVoteState();
		} else if (oldVoteCount > 1 && oldVoteCount < 5) {
			state = new RepeatVoteState();
		} else if (oldVoteCount >= 5 && oldVoteCount < 8) {
			state = new SpiteVoteState();
		} else if (oldVoteCount > 8) {
			state = new BlackVoteState();
		}
		
		state.vote(user, voteItem, this);
	}
}
