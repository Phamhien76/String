package String;

import java.util.Scanner;

public class Student {
    /*

    Tạo lớp Student trong package ra.entity có
    + Các thuộc tính:
    studentId - String: Có 5 ký tự, bắt đầu là ký tự P, không trùng lặp
    studentName - String: có độ dài từ 10-50 ký tự
    age - int: có giá trị lớn hơn 0
    email - String: có định dạng email
    phone - String: có định dạng số điện thoại di động ở VN với các đầu 091, 092, 098, 035, 090
    sex - boolean: chỉ nhận giá trị true|false
    javascore - float: điểm javascore giá trị trong khoảng 0-10
    + Các constructor, getter/setter
    + inputData(Scanner scanner, Student[] arrStudent, int currentIndex): cho phép nhập thông tin
    sinh viên có bắt validate dữ liệu đầu vào theo yêu cầu
    + displayData(): hiển thị thông tin sinh viên
    Tạo lớp StudentManagement trong package ra.run khởi tạo mảng sinh viên gồm 100 phần tử, hiển
    thị menu và thực hiện các chức năng theo menu:
    **MENU**
    Nhập thông tin n sinh viên
    Hiển thị thông tin n sinh viên
    Thoát
    */
    // thuộc tính
    private String studentId;
    private String studentName;
    private int age;
    private String email;
    private String phone;
    private boolean sex;
    private float javacore;

    //Các constructor


    public Student() {
    }

    public Student(String studentId, String studentName, int age, String email, String phone, boolean sex, float javacore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.javacore = javacore;
    }

    // getter/setter

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getJavacore() {
        return javacore;
    }

    public void setJavacore(float javacore) {
        this.javacore = javacore;
    }

    //+ inputData(Scanner scanner, Student[] arrStudent, int currentIndex): cho phép nhập thông tin
    //    sinh viên có bắt validate dữ liệu đầu vào theo yêu cầu

    public void inputData(Scanner scanner, Student[] arrStudent, int currentIndex) {
//        System.out.println("hãy nhập mã sinh viên: ");
//        String studentId=scanner.nextLine();
//        System.out.println("hãy nhập tên sinh viên: ");
//        String studentName=scanner.nextLine();
//        System.out.println("Hãy nhập tuổi: ");
//        int age= Integer.parseInt(scanner.nextLine());
//        System.out.println("Hãy nhập email: ");
//        String email=scanner.nextLine();
//        System.out.println("Hãy nhập phone: ");
//        String phone=scanner.nextLine();
//        System.out.println("Hãy nhập giới tính: ");
//        boolean sex=Boolean.getBoolean(scanner.nextLine());
//        System.out.println("Hãy nhập điểm Javascore: ");
//        float javascore=scanner.nextFloat();
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Nhập mã sinh viên (5 ký tự, bắt đầu bằng P, không trùng lặp): ");
            String newStudentId = scanner.next();

            // Kiểm tra mã sinh viên có hợp lệ
            if (newStudentId.length() == 5 && newStudentId.startsWith("P")) {
                boolean isDuplicate = false;
                for (int i = 0; i < currentIndex; i++) {
                    if (arrStudent[i] != null && arrStudent[i].getStudentId().equals(newStudentId)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập lại.");
                } else {
                    this.studentId = newStudentId;
                    validInput = true;
                }
            } else {
                System.out.println("Mã sinh viên không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // Nhập các thông tin khác
        System.out.print("Nhập tên sinh viên (10-50 ký tự): ");
        scanner.nextLine();
        String newStudentName = scanner.nextLine();

        while (newStudentName.length() < 10 || newStudentName.length() > 50) {
            System.out.println("Tên sinh viên không hợp lệ. Vui lòng nhập lại (10-50 ký tự): ");
            newStudentName = scanner.nextLine();
        }
        this.studentName = newStudentName;

        System.out.print("Nhập tuổi (lớn hơn 0): ");
        int newAge = scanner.nextInt();

        while (newAge <= 0) {
            System.out.println("Tuổi không hợp lệ. Vui lòng nhập lại (lớn hơn 0): ");
            newAge = scanner.nextInt();
        }
        this.age = newAge;

        // Kiểm tra và nhập email
        System.out.print("Nhập email: ");
        String newEmail = scanner.next();

        while (!isValidEmail(newEmail)) {
            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            newEmail = scanner.next();
        }
        this.email = newEmail;

        // Kiểm tra và nhập số điện thoại
        System.out.print("Nhập số điện thoại (định dạng 091, 092, 098, 035, 090): ");
        String newPhone = scanner.next();

        while (!isValidPhone(newPhone)) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            newPhone = scanner.next();
        }
        this.phone = newPhone;

        // Kiểm tra và nhập giới tính
        System.out.print("Nhập giới tính (true/false): ");
        boolean newSex = scanner.nextBoolean();
        this.sex = newSex;

        // Kiểm tra và nhập điểm javascore
        System.out.print("Nhập điểm javascore (0-10): ");
        float newJavascore = scanner.nextFloat();

        while (newJavascore < 0 || newJavascore > 10) {
            System.out.println("Điểm javascore không hợp lệ. Vui lòng nhập lại (0-10): ");
            newJavascore = scanner.nextFloat();
        }
        this.javacore = newJavascore;
    }

    // Hàm kiểm tra định dạng email
    private boolean isValidEmail(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@";
        return true;
    }

    // Hàm kiểm tra định dạng số điện thoại
    private boolean isValidPhone(String phone) {
        String phonePattern = "\\d{3}-\\d{2}-\\d{7}";
        return true;
    }
    public void displayData() {
        System.out.println("Thông tin sinh viên");
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Tên sinh viên: " + studentName);
        System.out.println("Tuổi: " + age);
        System.out.println("email: " + email);
        System.out.println("phone: " + phone);
        System.out.println("Giới tính: " + sex);
        System.out.println("Điểm Javascode: " + javacore);

    }
}
