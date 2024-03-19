package com.jia.demo.algorithm.weight_random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *过于复杂，有比较简单的实现方式
 * @param <T>
 */
public class WeightRandom<T> {
  private final List<T> items = new ArrayList<>();
  private double[] weights;

  public WeightRandom(List<ItemWithWeight<T>> itemsWithWeight) {
    this.calWeights(itemsWithWeight);
  }

  /**
   * 计算权重，初始化或者重新定义权重时使用
   *
   */
  public void calWeights(List<ItemWithWeight<T>> itemsWithWeight) {
    items.clear();
    // 计算权重总和
    double originWeightSum = 0;
    for (ItemWithWeight<T> itemWithWeight : itemsWithWeight) {
      double weight = itemWithWeight.getWeight();
      if (weight <= 0) {
        continue;
      }
      items.add(itemWithWeight.getItem());
      if (Double.isInfinite(weight)) {
        weight = 10000.0D;
      }
      if (Double.isNaN(weight)) {
        weight = 1.0D;
      }
      originWeightSum += weight;
    }
    // 计算每个item的实际权重比例
    double[] actualWeightRatios = new double[items.size()];
    int index = 0;
    for (ItemWithWeight<T> itemWithWeight : itemsWithWeight) {
      double weight = itemWithWeight.getWeight();
      if (weight <= 0) {
        continue;
      }
      actualWeightRatios[index++] = weight / originWeightSum;
    }

    // 计算每个item的权重范围
    // 权重范围起始位置
    weights = new double[items.size()];
    double weightRangeStartPos = 0;
    for (int i = 0; i < index; i++) {
      weights[i] = weightRangeStartPos + actualWeightRatios[i];
      weightRangeStartPos += actualWeightRatios[i];
    }
  }

  /**
   * 基于权重随机算法选择
   *
   */
  public T choose() {
    double random = ThreadLocalRandom.current().nextDouble();
    int index = Arrays.binarySearch(weights, random);
    if (index < 0) {
      index = -index - 1;
    } else {
      return items.get(index);
    }

    if (index < weights.length && random < weights[index]) {
      return items.get(index);
    }
    return items.get(0);
  }

  public static class ItemWithWeight<T> {
    T item;
    double weight;

    public ItemWithWeight() {
    }

    public ItemWithWeight(T item, double weight) {
      this.item = item;
      this.weight = weight;
    }

    public T getItem() {
      return item;
    }

    public void setItem(T item) {
      this.item = item;
    }

    public double getWeight() {
      return weight;
    }

    public void setWeight(double weight) {
      this.weight = weight;
    }
  }
}
