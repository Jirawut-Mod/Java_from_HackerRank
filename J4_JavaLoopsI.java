/*
วัตถุประสงค์
ในการท้าทายนี้ เราจะใช้การวนซ้ำเพื่อช่วยเราคำนวณเลขง่ายๆ
งาน
กำหนดจำนวนเต็ม N พิมพ์ 10 ทวีคูณแรก. แต่ละรายการ N*i (โดยที่ 1<= i <= 10 ) ควรพิมพ์บนบรรทัดใหม่ในรูปแบบ: N x i = ผลลัพธ์

รูปแบบการป้อนข้อมูล
จำนวนเต็มเดียว N.

ข้อ จำกัด
2 <= N <= 20

รูปแบบเอาต์พุต
พิมพ์เอาต์พุต 10 บรรทัด; แต่ละบรรทัด i (โดยที่ 1 <= i <= 10) มีผลลัพธ์ของ N*i ในรูปแบบ:
N x i = ผลลัพธ์
อินพุตตัวอย่าง
2
เอาต์พุตตัวอย่าง
==============================
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20
===============================
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class J4_JavaLoopsI {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();
        for (int i = 1; i <= 10; i++){
            int result = N * i ;
            System.out.printf("%d x %d = %d%n", N, i, result);
        }
    }
}

/*
ในโค้ดด้านบน เราใช้ BufferedReader เพื่ออ่านข้อมูลจากผู้ใช้ผ่าน System.in และรับค่า N ด้วย Integer.parseInt(bufferedReader.readLine().trim()) เช่นเดียวกับเดิม
จากนั้น เราปิดการใช้งาน bufferedReader ด้วย bufferedReader.close()
ในลูป for เราจะทำการคำนวณและพิมพ์สูตรคูณของ N ด้วยตัวเลข 1 ถึง 10 โดยใช้ System.out.printf() เพื่อจัดรูปแบบข้อความที่จะแสดงผล โดยในที่นี้จะใช้ %d x %d = %d%n
ซึ่งรับพารามิเตอร์ตามลำดับเพื่อกำหนดค่าที่จะแสดงผล
สุดท้ายเราจะพิมพ์เครื่องหมายบรรทัดใหม่ (%n) หลังจากลูป for เพื่อคั้นแต่ละบรรทัด
สรุปแล้ว โค้ดนี้จะรับจำนวนเต็ม N จากผู้ใช้และพิมพ์สูตรคูณของ N ด้วยตัวเลข 1 ถึง 10 ตามรูปแบบที่กำหนดในโจทย์
 */