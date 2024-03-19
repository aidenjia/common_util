package com.jia.demo.algorithm.weight_random;

import com.jia.demo.algorithm.weight_random.WeightRandom.ItemWithWeight;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MainClass {

  public static void main(String[] args) {
    int sampleCount = 100;

    ItemWithWeight<String> server1 = new ItemWithWeight<>("server1", 1.0);
    ItemWithWeight<String> server2 = new ItemWithWeight<>("server2", 3.0);
    ItemWithWeight<String> server3 = new ItemWithWeight<>("server3", 2.0);

    WeightRandom<String> weightRandom = new WeightRandom<>(
        Arrays.asList(server1, server2, server3));

    // 统计 (这里用 AtomicInteger 仅仅是因为写起来比较方便，这是一个单线程测试)
    Map<String, AtomicInteger> statistics = new HashMap<>();

    for (int i = 0; i < sampleCount; i++) {
      statistics
          .computeIfAbsent(weightRandom.choose(), (k) -> new AtomicInteger())
          .incrementAndGet();
    }

    statistics.forEach((k, v) -> {
      double hit = (double) v.get() / sampleCount;
      System.out.println(k + ", hit:" + hit);
    });
  }

}
