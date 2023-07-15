

import java.util.*;
import java.io.*;
public class J5_JavaLoopsII {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int result = a;
            for (int j = 0; j < n; j++) {
                result += Math.pow(2, j) * b;
                System.out.print(result + " ");
            }
            System.out.println();
        }
        in.close();
    }
}

/*
ในส่วนที่เพิ่มเข้าไป เรากำหนดตัวแปร result เพื่อเก็บผลลัพธ์ของสูตรที่คำนวณ และใช้ลูป for เพื่อคำนวณและพิมพ์ผลลัพธ์ตามที่โจทย์กำหนด โดยในแต่ละรอบของลูป
เราใช้สูตร result += Math.pow(2, j) * b; เพื่อคำนวณผลลัพธ์ตามข้อกำหนด และพิมพ์ผลลัพธ์ในแต่ละรอบ โดยใช้ System.out.print(result + " ");
สุดท้ายเราใช้ System.out.println(); เพื่อพิมพ์เครื่องหมายขึ้นบรรทัดใหม่หลังจากแต่ละเซตของผลลัพธ์
สรุปแล้ว โค้ดนี้จะรับจำนวนเต็ม t จากผู้ใช้และคำนวณและพิมพ์ผลลัพธ์สูตรคำนวณตามที่โจทย์กำหนด
 */
