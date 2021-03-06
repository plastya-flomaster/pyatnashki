package com.company.initialRules;


import java.util.*;

public class Algorithm<TState extends State, TRules extends Rules<TState>> {

	private TRules rules;
	private int closedStates = 0;

	public Collection<State> search(TState startState) {
		LinkedList<Integer> close = new LinkedList<>();
		LinkedList<TState> open = new LinkedList<>();
		
		open.add(startState);
		
		startState.setTour(0);
		startState.setQuality(rules.getQuality(startState));

		while (!open.isEmpty()) {
			TState x = getStateWithMinF(open);
			if (rules.isTerminate(x)) {
				closedStates = close.size();
				return completeSolution(x);
			}
			open.remove(x);
			close.add(x.hashCode());
			List<TState> neighbors = rules.getNeighbors(x);
			for (TState neighbor : neighbors) {
				if (close.contains(neighbor.hashCode())) {
					continue;
				}
				int Tour = x.getTour() + rules.getDistance(x, neighbor);
				boolean isTourLess;
				if (!open.contains(neighbor)) {
					neighbor.setQuality(rules.getQuality(neighbor));
					open.add(neighbor);
					isTourLess = true;
				} else {
					isTourLess = Tour < neighbor.getTour();
				}
				if (isTourLess) {
					neighbor.setParent(x);
					neighbor.setTour(Tour);
				}
			}
		}
		return null;
	}

	public int getClosedStatesCount() {
		return closedStates;
	}

	public Algorithm(TRules rules) {
		if (rules == null) {
			throw new IllegalArgumentException("Правила не могут быть пустыми");
		}
		this.rules = rules;
	}


	private TState getStateWithMinF(Collection<TState> open) {
		TState res = null;
		int min = Integer.MAX_VALUE;
		for (TState state : open) {
			if (state.getFunc() < min) {
				min = state.getFunc();
				res = state;
			}
		}
		return res;
	}

	private Collection<State> completeSolution(TState terminate) {
		LinkedList<State> path = new LinkedList<>();
		State c = terminate;
		while (c != null) {
			path.addFirst(c);
			c = c.getParent();
		}
		return path;
	}
}
