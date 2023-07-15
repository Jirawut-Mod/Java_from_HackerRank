/*
ในความท้าทายนี้ คุณต้องอ่านจำนวนเต็ม จำนวนคู่ และสตริงจาก stdin จากนั้นพิมพ์ค่าตามคำแนะนำในส่วนรูปแบบผลลัพธ์ด้านล่าง
เพื่อทำให้ปัญหาง่ายขึ้นเล็กน้อย โค้ดส่วนหนึ่งมีให้ในตัวแก้ไข
หมายเหตุ: เราขอแนะนำให้กรอก Java Stdin และ Stdout I ก่อนดำเนินการนี้
รูปแบบการป้อนข้อมูล
อินพุตมีสามบรรทัด:
1. บรรทัดแรกประกอบด้วยจำนวนเต็ม
2. บรรทัดที่สองประกอบด้วยคู่
3. บรรทัดที่สามประกอบด้วยสตริง
รูปแบบเอาต์พุต
เอาต์พุตมีสามบรรทัด:
1. ในบรรทัดแรก พิมพ์ String: ตามด้วย String ที่ไม่เปลี่ยนแปลงที่อ่านจาก stdin
2. ในบรรทัดที่สอง พิมพ์ Double: ตามด้วยการอ่านซ้ำสองครั้งที่ไม่เปลี่ยนแปลงจาก stdin
3. ในบรรทัดที่สาม พิมพ์ Int: ตามด้วยจำนวนเต็มที่ไม่เปลี่ยนแปลงที่อ่านจาก stdin เพื่อทำให้ปัญหาง่ายขึ้น โค้ดส่วนหนึ่งมีอยู่ในตัวแก้ไขแล้ว
หมายเหตุ: หากคุณใช้เมธอด nextLine() ต่อจากเมธอด nextInt() ในทันที โปรดจำไว้ว่า nextint() อ่านโทเค็นจำนวนเต็ม ด้วยเหตุนี้
อักขระขึ้นบรรทัดใหม่สุดท้ายสำหรับบรรทัดของอินพุตจำนวนเต็มนั้นยังคงอยู่ในคิวในบัฟเฟอร์อินพุตและ ถัดไป nextLine() จะอ่านส่วนที่เหลือของบรรทัดจำนวนเต็ม (ซึ่งว่างเปล่า)
 */

/*
Input ที่พิมพ์เข้ามา
42
3.1415
Welcome to HackerRank's Java tutorials!

Output ที่แสดงผล
String: Welcome to HackerRank's Java tutorials!
Double: 3.1415
Int: 42
*/


import java.util.Scanner;
public class J2_JavaStdinAndStdoutII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        Double d = scan.nextDouble();
        scan.nextLine();  // อ่านเอาชนิดข้อมูลที่เหลือหลังจาก nextDouble() ซึ่งเป็นเอนเทอร์รัดบรรทัดใหม่
        String s = scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
