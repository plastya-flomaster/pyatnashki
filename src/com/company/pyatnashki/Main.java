package com.company.pyatnashki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import com.company.initialRules.State;
import com.company.initialRules.Algorithm;

public class Main {

  private static boolean isShowStatistic = true; //подробный вывод
  private static int sideSize = 3;

  public static void main(String[] args) {

    // получим общее кол-во клеток
    int size = sideSize * sideSize;

    // зададим стартовое и конечное состояния пятнашки
    byte[] startField = new byte[] {2, 1, 6, 4, 0, 8, 7, 5, 3};
    byte[] finalField = new byte[] {1, 2, 3, 8, 0, 4, 7, 6, 5};

    FifteenRules rules = new FifteenRules(sideSize, finalField);
    FifteenState startState = new FifteenState(null, sideSize);

    startState.setField(startField);

    Algorithm<FifteenState, FifteenRules> algorithm = new Algorithm<>(rules);

    long time = System.currentTimeMillis();
    Collection<State> res = algorithm.search(startState);
    time = System.currentTimeMillis() - time;

    if (res == null) {
      System.out.println("Ошибка или решение не было найдено");
      return;
    } else {
      for (State s : res) {
        System.out.println(s.toString());
      }
    }
    if (isShowStatistic) {
      System.out.println("Время: " + time + "мс");
      System.out.println("Кратчайший путь: " + (res.size()));
      System.out.println("Всего просмотрено матриц: " + algorithm.getClosedStatesCount());
    }
  }
}
