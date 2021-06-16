package com.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CostAndSAles {
    double cost;
    int sales;

    CostAndSAles() {

    }

    CostAndSAles(double cost, int sales) {
        this.cost = cost;
        this.sales = sales;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}

class ProductNumWeekCombo {
    String productNum;
    int week;

    ProductNumWeekCombo(String productNum, int week) {
        this.week = week;
        this.productNum = productNum;
    }


    @Override
    public int hashCode() {
        int result = productNum != null ? productNum.hashCode() : 0;
        result = 31 * result + week;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductNumWeekCombo that = (ProductNumWeekCombo) o;

        if (week != that.week) return false;
        return productNum.equals(that.productNum);
    }
}

public class NineLeaps {
    List<Map<String, CostAndSAles>> convert(Response response) {

        List<Product> list = response.getResults();

        Map<String, CostAndSAles> resultMap = new HashMap<>();
        List<Map<String, CostAndSAles>> listResult = new ArrayList<>();


        CostAndSAles costAndSAles = new CostAndSAles();
       /* list.stream().map(product -> {
            StringBuilder sb = new StringBuilder();
            sb.append(product.getProductNumber()).append("-").append(product.getWeek());
            costAndSAles = new CostAndSAles(product.getCost(),product.getSales());
            return sb.toString();
        }).map*/


       /* list.stream().forEach(product -> {
           String key =  getMapKey(product);

        });*/


        list.forEach(product -> {
            String sb = getMapKey(product);
            resultMap.put(sb, new CostAndSAles(product.getCost(), product.getSales()));
            listResult.add(resultMap);

        });

        return listResult;
    }


    String getMapKey(Product product) {
        String productNumber = product.getProductNumber();
        int week = product.getWeek();
        StringBuilder sb = new StringBuilder();
        sb.append(productNumber);
        sb.append('-');
        sb.append(week);
        return sb.toString();
    }
}

class ResultMapList {
    String key;
    CostAndSAles costAndSAles;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CostAndSAles getCostAndSAles() {
        return costAndSAles;
    }

    public void setCostAndSAles(CostAndSAles costAndSAles) {
        this.costAndSAles = costAndSAles;
    }
}

class Response {
    List<Product> results;

    public List<Product> getResults() {
        return results;
    }
}

class Product {
    String productNumber;
    int week;
    double cost;
    int sales;

    public String getProductNumber() {
        return productNumber;
    }

    public int getWeek() {
        return week;
    }

    public double getCost() {
        return cost;
    }

    public int getSales() {
        return sales;
    }
}
