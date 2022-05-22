package com.search.bitonic;

public class StockPurchaseSell {

	public static void main(String[] args) {
		int[] arr = { 10, 150, 6, 67, 61, 16, 86, 6, 67, 78, 150, 3, 28, 143 };

		StockPurchaseSell sps = new StockPurchaseSell();
		sps.maxProfit(arr);
		sps.maxBrute(arr);
	}

	private void maxBrute(int[] arr) {

		int maxprofit = 0;
		int buyday = 0;
		int sellday = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int currProfit = arr[j] - arr[i];
				if (currProfit > maxprofit) {
					maxprofit = currProfit;
					buyday = i;
					sellday = j;
				}
			}
		}
		System.out.println("max profit :" + maxprofit);
		System.out.println("sell day:" + sellday + ", buy day:" + buyday);

	}

	private void maxProfit(int[] arr) {
		int min = 0;
		int currProfit = 0;
		int maxProfit = 0;
		int buy = 0;
		int sell = 0; 
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[min]) {
				min = i;
			}
			currProfit = arr[i] - arr[min];
			if (maxProfit < currProfit) {
				maxProfit = currProfit;
				sell = min;
				buy = i;
			}

		}

		System.out.println("max profit :" + maxProfit);
		System.out.println("sell day:" + sell + ", buy day:" + buy);

	}

}
