import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Task 1");

        int[] arr = {1, 2, 3, 4, 1, 0};
        int k = sc.nextInt();

        int minSum = 0;

        for(int i = 0; i < k; i++)
        {
            minSum += arr[i];
        }

        int sum = minSum;

        for(int i = k-1; i < arr.length - 1; i++)
        {
            sum = sum + arr[i+1] - arr[i-k+1];
            if(sum < minSum)
            {
                minSum = sum;
            }
        }

        System.out.println("MinSum: " + minSum);


        System.out.println();
        System.out.println("Task 2");
        int[] coins = {1, 5, 10, 15, 20};
        int value = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println(minCoins(coins, value, map));

        System.out.println();
        System.out.println("Task 3");
        int[] coins2 = {20, 10, 15, 5, 1};
        int value2 = sc.nextInt();
        System.out.println(minCoinsGreedy(coins2, value2));

        System.out.println();
        System.out.println("Task 4");
        Map<Integer, Boolean> map2 = new HashMap<>();
        System.out.println(isZero(10, map2));

        System.out.println();
        System.out.println("Task 5");
        int[] items = {100, 2, 10, 20};
        int[] costs = {10, 40, 30, 5};
        System.out.println(backpack(items, costs, 50));
    }

    public static int minCoins(int[] coins, int value, Map<Integer, Integer> map)
    {
        if(value == 0)
            return 0;

        if(value < 0)
            return -1;

        if(map.containsKey(value))
            return map.get(value);

        int minCoins = -1;

        for(int i = coins.length - 1; i >= 0; i--)
        {
            int res = minCoins(coins, value - coins[i], map);
            if(res > -1)
            {
                minCoins = res+1;
                break;
            }
        }

        map.put(value, minCoins);
        return minCoins;
    }

    public static int minCoinsGreedy(int[] coins, int value)
    {
        for(int i = 0; i < coins.length-1; i++)
        {
            for(int j = 0; j < coins.length-1-i; j++)
            {
                if(coins[j] > coins[j+1])
                {
                    int buff = coins[j];
                    coins[j] = coins[j+1];
                    coins[j+1] = buff;
                }
            }
        }

        System.out.println(Arrays.toString(coins));

        int minCoins = 0;

        for(int i = coins.length-1; i >= 0; i--)
        {
            while(value >= coins[i])
            {
                value -= coins[i];
                minCoins += 1;
            }
        }

        return minCoins;
    }

    public static boolean isZero(int value, Map<Integer, Boolean> map)
    {
        if(value == 0)
            return true;
        if(value < 0)
            return false;

        if(map.containsKey(value))
            return map.get(value);

        boolean isZero = isZero(value-3, map) || isZero(value-5, map);
        map.put(value, isZero);

        return isZero;
    }

    public static int backpack(int[] items, int[] costs, int weight)
    {
        for(int i = 0; i < costs.length-1; i++)
        {
            for (int j = 0; j < costs.length-1-i; j++)
            {
                if(costs[j] > costs[j+1])
                {
                    int buffC = costs[j];
                    costs[j] = costs[j+1];
                    costs[j+1] = buffC;

                    int buffI = items[j];
                    items[j] = items[j+1];
                    items[j+1] = buffI;
                }
            }
        }

        System.out.println(Arrays.toString(items));
        System.out.println(Arrays.toString(costs));

        int maxPrice = 0;
        for(int i = costs.length-1; i >= 0; i--)
        {
            if(weight >= items[i])
            {
                weight -= items[i];
                maxPrice = items[i] * costs[i];
            }
            else {
                maxPrice = weight * costs[i];
                break;
            }
        }

        return maxPrice;
    }



}
