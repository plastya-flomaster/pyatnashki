package com.company.initialRules;

public abstract class State {

	private int tour; //номер тура
	private int quality; //количество фишек не на своих местах

	private State parent; //ссылка на номер вершины

	//возвращаем "вес" состояния как сумму тура и качества пятнашки. можно изменить
	//и задать другие правила. поиграться со знаками
	public int getFunc() {
		return (int)Math.round(0.7* tour + 0.3* quality);
	}


	public int getTour() {
		return tour;
	}


	//вовзращает предыдущее состояние (из какой вершины вышла)
	public State getParent() {
		return parent;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}
	public State(State parent) {
		this.parent = parent;
	}
}
