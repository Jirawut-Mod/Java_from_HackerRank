/*
กรอกโค้ดที่กำหนดเพื่อให้แสดงพื้นที่ของสี่เหลี่ยมด้านขนานที่มีความกว้าง B และส่วนสูง H
อินพุตมาตรฐาน
ถ้า B <= 0 หรือ H <= 0 ผลลัพธ์ควรเป็น"java.lang.Exception: ความกว้างและความสูงต้องเป็นค่าบวก"โดยไม่มีเครื่องหมายอัญประกาศ
รูปแบบการป้อนข้อมูล
มีอินพุตสองบรรทัด บรรทัดแรกประกอบด้วย B:  ความกว้างของสี่เหลี่ยมด้านขนาน บรรทัดถัดไปประกอบด้วย H: ความสูงของสี่เหลี่ยมด้านขนาน
ข้อ จำกัด
-100 <= B <= 100
-100 <= H <= 100
รูปแบบเอาต์พุต
หากค่าทั้งสองมี ค่ามากกว่าศูนย์ วิธีการ หลักจะต้องแสดงพื้นที่ของสี่เหลี่ยมด้านขนาน มิฉะนั้น ให้พิมพ์"java.lang.Exception:
Breadth and height must be positive"โดยไม่ต้องใส่เครื่องหมายอัญประกาศ
ตัวอย่างอินพุต1
1
3
เอาต์พุตตัวอย่าง1
3
ตัวอย่างอินพุต2
-1
2
เอาต์พุตตัวอย่าง2
java.lang.Exception: Breadth and height must be positive
 */

import java.io.*;
import java.util.*;
public class J8_JavaStatic_Initializer_Block {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            int breadth = scanner.nextInt();
            int height = scanner.nextInt();
            scanner.close();

            if (breadth > 0 && height > 0) {
                int area = breadth * height;
                System.out.println(area);
            } else {
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
