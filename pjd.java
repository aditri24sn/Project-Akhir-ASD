package TugasAkhir;

import java.util.Scanner;

public class pjd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan angka yang ingin disorting (pisahkan dengan koma): ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(",");
        int[] numbers = new int[inputArray.length];
        
        try {
            for (int i = 0; i < inputArray.length; i++) {
                numbers[i] = Integer.parseInt(inputArray[i].trim());
            }

            boolean running = true;
            while (running) {
                System.out.println("\nPilih metode sorting:");
                System.out.println("1. Selection Sort");
                System.out.println("2. Insertion Sort");
                System.out.println("3. Keluar");
                int choice = scanner.nextInt();

                int[] sortedNumbers = numbers.clone();

                if (choice == 1) {
                    selectionSort(sortedNumbers);
                    System.out.println("Hasil setelah Selection Sort:");
                } else if (choice == 2) {
                    insertionSort(sortedNumbers);
                    System.out.println("Hasil setelah Insertion Sort:");
                } else if (choice == 3) {
                    System.out.println("Terima kasih! Program selesai.");
                    running = false;
                    continue;
                } else {
                    System.out.println("Pilihan tidak valid.");
                    continue;
                }

                for (int number : sortedNumbers) {
                    System.out.print(number + " ");
                }
                System.out.println(); 
                System.out.println("\nApakah Anda ingin mencoba metode lain?");
                System.out.println("1. Ya");
                System.out.println("2. Tidak");
                int continueChoice = scanner.nextInt();
                if (continueChoice != 1) {
                    System.out.println("Terima kasih! Program selesai.");
                    running = false;
                }
            }

        } catch (NumberFormatException ex) {
            System.out.println("Input tidak valid. Pastikan hanya memasukkan angka.");
        } finally {
            scanner.close();
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
