package com.company;

import java.util.*;

public class Algorithm<TState extends State, TRules extends Rules<TState>> {

	/**
	 * Функция поиска правильной пятнашки.
	 *
	 * @param startState = начальное состояние пятнашки
	 * @return возвращает правильный маршрут до пятнашки
	 */
	public Collection<State> search(TState startState) {
		LinkedList<TState> close = new LinkedList<TState>();
		LinkedList<TState> open = new LinkedList<TState>();

		startState.setTour(0); //начнем с нулевого тура
		startState.setQuality(rules.getQuality(startState));
		open.add(startState);

		//пока лист не пустой
		while(!open.isEmpty()){
			TState x = getStateWithMinFunc(open);
		}
		return;
	},
	public algorithm(TRules rules){
		if(rules == null) {
			throw new IllegalArgumentException("Нельзя играть без правил");
		}
		this.rules = rules;
	}
private TState getStateWithMinFunc(Collection<TState> open){
		TState res = null;
		int min = Integer.MAX_VALUE;
		for (TState state : open) {
			if(state.getFunc() < min){

			}
		}
},
	public static void main(String[] args) {
		// write your code here
		//исходная версия пятнашек
		int[][] initialState = {
			{2, 1, 3},
			{4, 5, 6},
			{7, 8, 0}
		};
		//правильная версия пятнашек
		int[][] finalState = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 0}
		};
	}
}
