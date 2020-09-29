package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    public static void main(String[] args) {
        new EvaluateDivision().calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
    }

    //[["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values); // build the graph

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), g);

        return result;

    }


    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String source = equations.get(i).get(0); // get source.
            String destination = equations.get(i).get(1);
            map.putIfAbsent(source, new ArrayList<>());
            map.putIfAbsent(destination, new ArrayList<>());
            map.get(source).add(new Node(destination, values[i]));
            map.get(destination).add(new Node(source, 1 / values[i]));

        }

        return map;
    }


    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        if (!(g.containsKey(s) && g.containsKey(d)))
            return -1.0;
        if (s.equals(d)) return 1.0;

        visited.add(s);

        for (Node node : g.get(s)) {
            if (!visited.contains(node.key)) {

                double ans = dfs(node.key, d, visited, g);
                if (ans != -1.0) {
                    return ans * node.value;
                }

            }
        }

        return -1.0;
    }

    class Node {
        String key;
        double value;


        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }
}
