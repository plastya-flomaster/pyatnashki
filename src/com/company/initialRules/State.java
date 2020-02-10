package com.company.initialRules;

public abstract class State {

	int tour; //номер тура
	int quality; //количество фишек не на своих местах

	State parent; //ссылка на номер вершины

	//возвращаем "вес" состояния как сумму тура и качества пятнашки. можно изменить
	//и задать другие правила. поиграться со знаками
	public int getFunc() {
		return tour + quality;
	}


	public int getTour() {
		return tour;
	}

	public int getQuality() {
		return quality;
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
}
