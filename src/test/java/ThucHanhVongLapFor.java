import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ThucHanhVongLapFor {

    @Test
    public void TestForCoBan_Sum() {
        int[] numbers = {1, 3, 5, 7, 9};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Tổng giá trị các phần tử trong mảng: " + sum);
    }

    @Test
    public void TestForCaiTien_InSoChan() {
        int[] numbers = {2, 7, 8, 10, 15, 20};

        //Tạo ArrayList để in số chẵn
        ArrayList<Integer> soChan = new ArrayList<>();
        //Duyệt mảng và thêm số chẵn vào ArrayList
        for (int i : numbers) {
            if (i % 2 == 0) {
                soChan.add(i); //Thêm số chẵn vào ArrayList
            }
        }
        //In các số chẵn sau vòng lặp
        if (soChan.size() > 0) {
            System.out.println("Các số chẵn là: " + soChan);
        } else {
            System.out.println("Không có số chẵn nào.");
        }
    }

    @Test
    public void TestForCoBan_SoLe() {

        int[] numbers = {1, 2, 5, 7, 9, 10, 11};
        //Tạo ArrayList để in số lẻ
        ArrayList<Integer> soLe = new ArrayList<>();
        //Duyệt mảng và thêm số lẻ vào ArrayList
        for (int i : numbers) {
            if (i % 2 != 0) {
                soLe.add(i);//Add số lẻ vào ArrayList
            }
        }
        //In số lẻ trong ArrayList ra
        if (soLe.size() > 0) {
            System.out.println("Danh sách số lẻ là: " + soLe);
        } else {
            System.out.println("Không có số lẻ nào.");
        }
    }


    @Test
    public void TestForCoBan_DaoNguocMang() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Mảng đảo ngược là: ");
        for (int i = numbers.length - 1; i >= 0; i--) { //Duyệt phần tử từ cuối về đầu
            System.out.println(numbers[i] + " "); //In ra giá trị phần tử thay vì in ra chỉ mục
        }
    }

    @Test
    public void TestForCaiTien_TimSoLonNhat() {
        int[] numbers = {12, 45, 2, 67, 34, 89, 23};
        // Bước 1: Khởi tạo giá trị lớn nhất là phần tử đầu tiên
        int max = numbers[0];
        // Bước 2: Duyệt mảng để tìm giá trị lớn nhất
        for (int num : numbers) {
            if (num > max) {
                max = num; // Cập nhật số lớn nhất
            }
        }
        // Bước 3: In kết quả
        System.out.println("Phần tử lớn nhất trong mảng: " + max);
    }

    @Test
    public void TestForcoban_Demsolanxuathienso() {

        int[] numbers = {1, 2, 3, 2, 4, 2, 5, 2};
        int soCanNhap = 2;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            {
                if (soCanNhap == numbers[i]) {
                    count++;
                }
            }
        }
        System.out.println("Số lần xuất hiện của " + soCanNhap + " trong mảng: " + count);
    }

    @Test
    public void TestForCaitien_Demsolanxuathienchuoi() {
        String[] words = {"banana", "apple", " strawberry", "blueberry", "banana", "mango"};
        String chuoiCanNhap = "banana";
        int count = 0;

        for (String word : words) {
            if (word.equals(chuoiCanNhap)) { //Dùng hàm equals để so sánh chuỗi
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của " + chuoiCanNhap + " trong mảng: " + count);

    }

    @Test
    //Dùng hashMap lưu lại số lần xuất hiện của từng phần tử trong mảng
    public void TestForCoBan_Demsolanxhcuatatca() {
        int[] numbers = {1, 2, 3, 2, 4, 2, 5, 6, 3, 3, 3};
        HashMap<Integer, Integer> map = new HashMap<>();

        //Đếm số lần xuất hiện
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // In kết quả
        System.out.println("Số lần xuất hiện của từng phần tử:");
        for (int key : map.keySet()) {
            System.out.println(key + " xuất hiện " + map.get(key) + " lần");
        }
    }

    @Test
    public void TestForCaiTien_soNguyenTo() {
        int[] numbers = {2, 4, 7, 10, 13, 17, 22};

        // Biến để lưu các số nguyên tố
        StringBuilder primeNumbers = new StringBuilder(); //Để lưu các số nguyên tố vào một chuỗi, chúng ta sử dụng StringBuilder. Mỗi khi tìm thấy một số nguyên tố, chúng ta thêm nó vào primeNumbers cùng với dấu cách

        // Duyệt mảng bằng vòng lặp for-each
        for (int num : numbers) {
            if (isPrime(num)) {  // Kiểm tra nếu là số nguyên tố
                primeNumbers.append(num).append(" ");  // Thêm số nguyên tố vào StringBuilder (append là phương thức của lớp StringBuilder trong Java dùng để thêm một chuỗi (hoặc bất kỳ kiểu dữ liệu nào) vào cuối StringBuilder hiện tại mà không tạo ra một đối tượng mới.)
            }
        }

        // In ra các số nguyên tố trong mảng
        System.out.println("Các số nguyên tố trong mảng: " + primeNumbers.toString().trim()); //.toString() chuyển StringBuilder thành chuỗi và in ra. Hàm trim() sẽ loại bỏ khoảng trắng thừa ở cuối chuỗi.
    }

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;  // Số nhỏ hơn hoặc bằng 1 không phải là số nguyên tố
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {  // Duyệt từ 2 đến căn bậc 2 của num
            if (num % i == 0) {  // Nếu chia hết cho bất kỳ số nào, không phải là số nguyên tố
                return false;
            }
        }

        return true;  // Nếu không chia hết cho số nào thì là số nguyên tố
    }

    @Test
    public void TestForCaiTien_NhapVaInDSSV() {
        ArrayList<String> DSSV = new ArrayList<>();
        DSSV.add("Vũ Nguyễn Bảo Ngọc");
        DSSV.add("Nguyễn Trần Mint");
        DSSV.add("Trần Bảo Sam");
        DSSV.add("Vũ Lê Hà Vy");
        int i = 1;
        System.out.println("Danh sách sinh viên: ");

        for (String DanhSach : DSSV) {
            System.out.println(i + ". " + DanhSach);
            i++;
        }

    }

    //Dùng thử Scanner của chatGPT và phải chạy bằng Main, nhập data từ bàn phím => ấn Enter
//    public static void main(String[] args) {
//
//        //Khởi tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
//        Scanner scanner = new Scanner(System.in);
//        //Nhập số lượng sinh viên
//        System.out.println("Nhập số lượng sinh viên: ");
//        int n = scanner.nextInt();
//        scanner.nextLine(); // Đọc bỏ ký tự xuống dòng
//
//        //Khởi tạo ArrayList để lưu danh sách sinh viên
//        ArrayList<String> studentList = new ArrayList<>();
//
//        //Nhập danh sách sinh viên từ bàn phím
//        for (int i = 0; i < n; i++) {
//            System.out.println("Nhập sinh viên thứ: " + (i + 1) + ": ");
//            String name = scanner.nextLine();
//            studentList.add(name);
//        }
//
//        //In danh sách sinh viên ra màn hình
//        System.out.println("\nDanh sách sinh viên: ");
//        int index = 1;
//        for (String student : studentList) {
//            System.out.println(index + ". " + student);
//            index++;
//        }
//        scanner.close();
//    }

    @Test
    public void TestForCơBan_Cong2MangcungKT() {
        int[] number1 = {1, 2, 3};
        int[] number2 = {4, 5, 6};
        int result[] = new int[number1.length]; //Tạo mảng để lưu kết quả cộng từ 2 mảng có cùng kích thước

        for (int i = 0; i < number1.length; i++) { // Duyệt từng phần tử
            result[i] = number1[i] + number2[i]; // Cộng từng phần tử tương ứng
        }
        //In kết quả theo định dạng mong muốn
        System.out.println("Mảng kết quả sau khi cộng: ");
        for (int num : result) {
            System.out.println(num + " "); // để in kết quả trên cùng 1 dòng
        }
    }

    @Test
    public void TestForCơBan_Cong2MangcungKT2() {
        int[] number1 = {1, 2, 3};
        int[] number2 = {4, 5, 6};
        int result1[] = new int[number1.length]; //Tạo mảng để lưu kết quả cộng từ 2 mảng có cùng kích thước
        int result2[] = new int[number1.length]; //Tạo mảng để lưu kết quả cộng từ 2 mảng có cùng kích thước
        int result3[] = new int[number1.length]; //Tạo mảng để lưu kết quả cộng từ 2 mảng có cùng kích thước

        for (int i = 0; i < number1.length; i++) { // Duyệt từng phần tử
            result1[i] = number1[0] + number2[i]; // Cộng từng phần tử số 1 mảng 1 với tất cả các phần tử mảng 2
            result2[i] = number1[1] + number2[i]; // Cộng từng phần tử số 2 mảng 1 với tất cả các phần tử mảng 2
            result3[i] = number1[2] + number2[i]; // Cộng từng phần tử số 3 mảng 1 với tất cả các phần tử mảng 2
        }
        //In kết quả theo định dạng mong muốn
        System.out.println("Mảng kết quả sau khi cộng: ");
        System.out.println("Mảng 1: ");
        for (int num : result1) {
            System.out.println(num + " "); // để in kết quả trên cùng 1 dòng
        }
        System.out.println("Mảng 2: ");
        for (int num : result2) {
            System.out.println(num + " "); // để in kết quả trên cùng 1 dòng
        }
        System.out.println("Mảng 3: ");
        for (int num : result3) {
            System.out.println(num + " "); // để in kết quả trên cùng 1 dòng
        }
    }
}

