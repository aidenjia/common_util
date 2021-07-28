package com.jia.demo.completabelfuture.demofindbestprice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MainDemo1 {

    public static void main(String[] args) throws InterruptedException {
        List<Shop> shops = new ArrayList<>();
        shops.add(new Shop("BestPrice"));
        shops.add(new Shop("LetsSaveBig"));
        shops.add(new Shop("MyFavoriteShop"));
        shops.add(new Shop("BuyItAll"));

//        long start = System.nanoTime();
//        System.out.println(findPricesParallel("myPhone27S",shops));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");
//
//        long start1 = System.nanoTime();
//        System.out.println(findPricesParallel("myPhone27S",shops));
//        long duration1 = (System.nanoTime() - start1) / 1_000_000;
//        System.out.println("Done in " + duration1 + " msecs");

//        long start = System.nanoTime();
//        System.out.println(findPricesCompletable("myPhone27S",shops));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");
//
//        long start = System.nanoTime();
//        System.out.println(findPricesDisCount("myPhone27S",shops));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

//        long start = System.nanoTime();
//        System.out.println(findPricesDiscount2("myPhone27S",shops));
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

//        long start = System.nanoTime();
//        CompletableFuture[] futures=findPricesStream("myPhone",shops).map(f -> f.thenAccept(System.out::println))
//                .toArray(size->new CompletableFuture[size]);
//        CompletableFuture.allOf(futures).join();
//        long duration = (System.nanoTime() - start) / 1_000_000;
//        System.out.println("Done in " + duration + " msecs");

        long start = System.nanoTime();
        CompletableFuture[] futures = findPricesStream("myPhone27S",shops)
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " +
                                ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.anyOf(futures).join();
        System.out.println("All shops have now responded in "
                + ((System.nanoTime() - start) / 1_000_000) + " msecs");

    }

    /**
     * 你希望达到的效果是，一旦拿到商店的价格数据，立刻将它们展示给你的用户（这是汽车保险和机票比价
     * 网站常用的做法），而不是像你目前的代码那样，要等到获取了所有数据后才开始展示数据。
     * CompletableFuture 自身执行完毕之前，调用它的 get 或者 join 方法，执行都会被阻塞。
     * 如何通过响应 CompletableFuture 的 completion 事件达到及时展示数据
     * 这一目标，不再受制于 get 或者 join 方法
     * @param product
     * @param shops
     * @return
     */
    public static Stream<CompletableFuture<String>> findPricesStream(String product,List<Shop> shops) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote))));
    }

    /**
     * Java 8 的 CompletableFutureAPI 提供了名为 thenCompose 的方法，它就是专门为这一
     * 目的而设计的，thenCompose 方法允许你对两个异步操作进行流水线，第一个操作完成时，将
     * 其结果作为参数传递给第二个操作
     * @param product
     * @param shops
     * @return
     */

    public static List<String> findPricesDiscount2(String product,List<Shop> shops){
        List<CompletableFuture<String>> priceFutures=
           shops.stream().map(shop -> CompletableFuture.supplyAsync(()->shop.getPrice(product)))
                .map(future->future.thenApply(Quote::parse))
                .map(future->future.thenCompose(quote -> CompletableFuture.supplyAsync(()->Discount.applyDiscount(quote))))
                   .collect(toList());
        System.out.println("do something else");
        return priceFutures.stream().map(CompletableFuture::join).collect(toList());
    }


    public static List<String> findPricesDisCount(String product,List<Shop> shops){
        return shops.stream().map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(toList());
    }


    public static List<String> findPrices(String product,List<Shop> shops) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getShopName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPricesParallel(String product,List<Shop> shops) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getShopName(), shop.getPrice(product)))
                .collect(toList());
    }

    public static List<String> findPricesCompletable(String product,List<Shop> shops){
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> String.format("%s price is %.2f",
                                        shop.getShopName(), shop.getPrice(product))))
                        .collect(toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }
}
