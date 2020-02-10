package com.company;

import java.util.*;



/**
 * Реализует алгоритм поиска решения А*.
 */
public class Algorithm<TState extends State, TRules extends Rules<TState>> {

	private TRules rules;
	private int closedStates = 0;


	/**
	 * Применяет алгоритм А* для поиска кратчайшего пути до терминального
	 * состоянияот указанного.
	 *
	 * @param startState - начальное состояние.
	 * @return последовательность состояний от заданного до терминального.
	 */
	public Collection<State> search(TState startState) {
		LinkedList<Integer> close = new LinkedList<Integer>();
		LinkedList<TState> open = new LinkedList<TState>();
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
				int g = x.getTour() + rules.getDistance(x, neighbor);
				boolean isGBetter;
				if (!open.contains(neighbor)) {
					neighbor.setQuality(rules.getQuality(neighbor));
					open.add(neighbor);
					isGBetter = true;
				} else {
					isGBetter = g < neighbor.getTour();
				}
				if (isGBetter) {
					neighbor.setParent(x);
					neighbor.setTour(g);
				}
			}
		}
		return null;
	}

	public int getClosedStatesCount() {
		return closedStates;
	}

	/**
	 * Создает объект для поиска терминального состояния по указанным правилам.
	 *
	 * @param rules правила, в соответствии с которыми будет производиться поиск
	 *              терминального состояния.
	 */
	public createRules(TRules rules) {
		if (rules == null) {
			throw new IllegalArgumentException("Правила не могут быть пустыми");
		}
		this.rules = rules;
	}

	/**
	 * Находит вершину в списке open с наименьшим значением веса.
	 *
	 * @param open список открытых вершин.
	 * @return вершину с наименьшим весом.
	 */
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

	/**
	 * Составляет последовательность состояний пройденных от начального
	 * состояния до конечного.
	 *
	 * @param terminate найденное конечное состояние.
	 * @return последовательность состояний пройденных от начального
	 * состояния до конечного.
	 */
	private Collection<State> completeSolution(TState terminate) {
		LinkedList<State> path = new LinkedList<State>();
		State c = terminate;
		while (c != null) {
			path.addFirst(c);
			c = c.getParent();
		}
		return path;
	}
}
