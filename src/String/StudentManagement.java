package String;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student[] students=new Student[100];
        int currentIndex = 0;
        do {
            System.out.println("** MENU **");
            System.out.println("1. Nhập thông tin sinh viên.");
            System.out.println("2. Hiển thị thông tin sinh viên.");
            System.out.println("3. Thoát.");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    students[currentIndex] = new Student();
                    students[currentIndex].inputData(scanner, students, currentIndex);
                    currentIndex++;
                    break;
                case 2:
                    System.out.println("Hiển thị thông tin sinh viên:");
                    for (int i = 0; i < currentIndex; i++) {
                        students[i].displayData();
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Chọn không hợp lệ vui lòng chọn lại.");
            }
        }while (true);
    }
}
