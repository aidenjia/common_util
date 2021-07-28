package com.jia.demo.stream.map;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cityListOne = new ArrayList<>();
        cityListOne.add("郑州");
        cityListOne.add("濮阳");
        List<String> cityListTwo = new ArrayList<>();
        cityListTwo.add("廊坊");
        cityListTwo.add("邢台");
        List<String> cityListThree = new ArrayList<>();
        cityListThree.add("大同");
        cityListThree.add("太原");
        List<String> cityListFour = new ArrayList<>();
        cityListFour.add("南昌");
        cityListFour.add("九江");

        Address addressOne = new Address();
        addressOne.setProvince("河南");
        addressOne.setCityList(cityListOne);

        Address addressTwo = new Address();
        addressTwo.setProvince("河北");
        addressTwo.setCityList(cityListTwo);

        Address addressThree = new Address();
        addressThree.setProvince("山西");
        addressThree.setCityList(cityListThree);

        Address addressFour = new Address();
        addressFour.setProvince("江西");
        addressFour.setCityList(cityListFour);

        List<Address> addresseList = new ArrayList<>();
        addresseList.add(addressOne);
        addresseList.add(addressTwo);
        addresseList.add(addressThree);
        addresseList.add(addressFour);

        //使用map输出所有的城市名称
        addresseList.stream()
                .map(a -> a.getCityList())
                .forEach(cityList->{ cityList.forEach(city -> System.out.print(city));
                });
        System.out.println("");
        //使用flatMap输出所有城市名称
        addresseList.stream()
                .flatMap(a -> a.getCityList().stream())
                .forEach(city -> System.out.print(city));

    }
}
