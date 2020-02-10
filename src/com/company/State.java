package com.company;

public abstract class State {

	int tour; //номер тура
	int quality; //количество фишек не на своих местах

	State parent; //ссылка на номер вершины

	public int getFunc() {
		return tour + quality;
	}
	public int getTour() {
		return tour;
	}

	public int getQuality() {
		return quality;
	}

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

	@Override
	public boolean equals(State obj) {
		return super.equals(obj);
	}
}
