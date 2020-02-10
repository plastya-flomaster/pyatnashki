package com.company;

import java.util.List;

public interface Rules<TState extends State> {
	List<TState> getNeighbors(TState currentState);

	int getDistance(TState a, TState b);

	int getQuality(TState state);

	boolean isTerminate(TState state);
}
