package com.fundaments;


import java.util.Scanner;

import com.hash.CustomHash;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
        CustomHash seen = new CustomHash(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.getPosic(complement), i };
            }
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os números do array separados por espaço: ");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.print("Digite o valor alvo (target): ");
        int target = scanner.nextInt();

        try {
            int[] result = twoSum(nums, target);
            System.out.println("Resultado: [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("Nenhuma combinação encontrada que some " + target);
        }

        scanner.close();
    }
}