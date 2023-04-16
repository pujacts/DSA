package com.graph;

import java.util.*;

class City implements Comparable<City> {
    int city;
    int maxRoadLength;

    public City(int city, int maxRoadLength) {
        this.city = city;
        this.maxRoadLength = maxRoadLength;
    }

    @Override
    public int compareTo(City other) {
        return Integer.compare(this.maxRoadLength, other.maxRoadLength);
    }
}

public class MinimumBatteryCapacity {

    public static int minimumBatteryCapacity(int N, int M, int[][] Roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : Roads) {
            int city1 = road[0];
            int city2 = road[1];
            int roadLength = road[2];
            graph.putIfAbsent(city1, new ArrayList<>());
            graph.putIfAbsent(city2, new ArrayList<>());
            graph.get(city1).add(new int[]{city2, roadLength});
            graph.get(city2).add(new int[]{city1, roadLength});
        }

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(1, 0));

        Map<Integer, Integer> maxRoadLengths = new HashMap<>();
        maxRoadLengths.put(1, 0);

        while (!pq.isEmpty()) {
            City currCity = pq.poll();
            int city = currCity.city;
            int maxRoadLength = currCity.maxRoadLength;

            if (city == N) {
                return maxRoadLength;
            }

            for (int[] neighbor : graph.getOrDefault(city, new ArrayList<>())) {
                int nextCity = neighbor[0];
                int roadLength = neighbor[1];
                int newMaxRoadLength = Math.max(maxRoadLength, roadLength);

                if (!maxRoadLengths.containsKey(nextCity) || newMaxRoadLength < maxRoadLengths.get(nextCity)) {
                    maxRoadLengths.put(nextCity, newMaxRoadLength);
                    pq.offer(new City(nextCity, newMaxRoadLength));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 3;
        int M = 3;
        int[][] Roads = {
                            {1, 2, 5},
                            {2, 3, 5},
                            {1, 3, 9}
        };
     //   int[][] Roads = {{1, 2, 1},{2, 3, 6},{3, 6, 1}, {1, 4, 2}, {4, 5, 2},{5, 6, 4}};

        int minBatteryCapacity = minimumBatteryCapacity(N, M, Roads);
        System.out.println("Minimum battery capacity needed: " + minBatteryCapacity);
    }
}
