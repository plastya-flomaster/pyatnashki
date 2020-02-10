package com.company.initialRules;

import java.util.List;

public interface Rules<TState extends State> {

	//определяет количество вариаций хода, на вход -- текущее состояние
	List<TState> getNeighbors(TState currentState);

	//возвращает расстояние между двумя состояниями
	int getDistance(TState a, TState b);

	//получаем оценку, в данном случае, количество фишек не на своем месте
	int getQuality(TState state);

	//проверяем является ли состояние конечным
	boolean isTerminate(TState state);
}
