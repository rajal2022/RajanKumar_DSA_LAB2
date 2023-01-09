package com.greatlearning.driver;

import java.util.Arrays;
import java.util.Scanner;
import com.greatlearning.services.TransactionTargetAlgo;

public class Driver {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TransactionTargetAlgo transactionTargetAlgo = new TransactionTargetAlgo();
        System.out.println("Enter the size of transaction array");
        
        int totalNoOfTransactions = scanner.nextInt();
     
        int[] transactions = new int[totalNoOfTransactions];
        		
        System.out.println("Enter the values of array");
  
        for(int i=0; i<totalNoOfTransactions; i++)
        	transactions[i] = scanner.nextInt();
 
        System.out.println("Enter the total no. of targets that needs to be achieved");
        int targetCount = scanner.nextInt();
        System.out.println("Enter the value of targets");
        int target;
       
        int prefixSum[] = new int[totalNoOfTransactions];
        prefixSum[0] = transactions[0];
        for(int i=1; i<totalNoOfTransactions; i++) {
        	prefixSum[i] = prefixSum[i-1] + transactions[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        for(int i=0; i<targetCount; i++) {
        	target = scanner.nextInt();
        	transactionTargetAlgo.processTransactions(prefixSum, target);
        }
        
        scanner.close();

	}

}