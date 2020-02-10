package com.company;

public interface Rules<TState extends State> {
	List<TState> getNeighbours(TState currentState);
	int getDistance(TState a, TState b);
	int getQuality(TState state);
	boolean isTerminate(TState state);
}
