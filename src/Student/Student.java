package Student;

import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        /*
        Bài 1: Quản lý điểm sinh viên

Tạo một chương trình Java để quản lý điểm sinh viên trong một lớp học.
Sử dụng một mảng để lưu trữ điểm của các sinh viên. Mỗi phần tử trong mảng sẽ là một điểm của một sinh viên cụ thể (từ 0 đến 100).
Cho phép người dùng nhập số lượng sinh viên trong lớp học và điểm của từng sinh viên.
Yêu cầu:
Hiển thị điểm của tất cả sinh viên cùng với thông tin số thứ tự (index) của từng sinh viên trong mảng.
Tính và hiển thị điểm trung bình của cả lớp học.
Tìm và hiển thị sinh viên có điểm cao nhất và điểm thấp nhất trong lớp học.
Gợi ý:
Sử dụng vòng lặp để nhập điểm và lưu trữ vào mảng.
Sử dụng vòng lặp để tính tổng điểm và sau đó tính điểm trung bình.
Trong quá trình tính điểm trung bình, có thể sử dụng biến tạm thời để tính tổng các điểm.
Sử dụng vòng lặp để tìm sinh viên có điểm cao nhất và điểm thấp nhất trong mảng.
         */
        Scanner scanner = new Scanner(System.in);
        // Nhập số lượng sinh viên rong lớp học
        System.out.println("Hãy nhập số lượng sinh viên: ");
        int soLuongSinhVien = Integer.parseInt(scanner.nextLine());

        //khai báo mãng để lưu điểm của sinh viên
        int[] diemSinhVien = new int[100];
        int index = 0;// số lượng sinh viên hiện tại

        // nhập điểm của từng sinh viên lưu vào mãng
        for (int i = 0; i < soLuongSinhVien; i++) {
            System.out.println("Nhập điểm của sinh viên thứ " + (i + 1) + ":");
            diemSinhVien[i] = Integer.parseInt(scanner.nextLine());
        }

        do {
            System.out.println("*******************MENNU*******************");
            System.out.println("1. Hiển thị điểm của tất cả sinh viên cùng với thông tin số thứ tự (index) của từng sinh viên trong mảng.");
            System.out.println("2. Tính và hiển thị điểm trung bình của cả lớp học.");
            System.out.println("3. Tìm và hiển thị sinh viên có điểm cao nhất và điểm thấp nhất trong lớp học.");
            System.out.println("4. Thoát");
            System.out.println("Hãy chọn lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    //1. Hiển thị điểm của tất cả sinh viên cùng với thông tin số thứ tự (index) của từng sinh viên trong mảng.");
                    System.out.println("Danh sách điểm của sinh viên: ");
                    for (int i = 0; i < soLuongSinhVien; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ":" + diemSinhVien[i]);
                    }
                    System.out.println();
                    break;
                case 2:
                    //"2. Tính và hiển thị điểm trung bình của cả lớp học.");
                    int diemSum = 0;
                    for (int i = 0; i < soLuongSinhVien; i++) {
                        diemSum += diemSinhVien[i];
                    }
                    double diemTrungBinh = (double) diemSum / soLuongSinhVien;
                    System.out.println("Điểm trung bình của cả lớp học là: " + diemTrungBinh);
                    break;
                case 3:
                    //("3. Tìm và hiển thị sinh viên có điểm cao nhất và điểm thấp nhất trong lớp học.");
                    int diemMax = diemSinhVien[0];
                    int diemMin = diemSinhVien[0];

                    for (int i = 0; i < soLuongSinhVien; i++) {
                        if (diemSinhVien[i] > diemMax) {
                            diemMax = diemSinhVien[i];
                        }
                        if (diemSinhVien[i] < diemMin) {
                            diemMin = diemSinhVien[i];
                        }
                    }
                    System.out.println("Sinh viên có điểm cao nhất là: "+diemMax);
                    System.out.println("Sinh viên có điểm thấp nhất là: "+diemMin);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("vui lòng chọn từ 1 đến 4");
            }
        } while (true);
    }
}
