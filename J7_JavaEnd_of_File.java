/*
"ในการคำนวณEnd Of File (ย่อโดยทั่วไปคือEOF ) เป็นเงื่อนไขในระบบปฏิบัติการคอมพิวเตอร์ที่ไม่สามารถอ่านข้อมูลจากแหล่งข้อมูลได้อีก"
— ( วิกิพีเดีย: จุดสิ้นสุดของไฟล์ )ความท้าทายที่นี่คือการอ่าน n บรรทัดอินพุตจนกว่าคุณจะถึงEOFจากนั้นป้อนหมายเลขและพิมพ์ทั้งหมด n บรรทัดของเนื้อหา
คำแนะนำ: วิธีการ Scanner.hasNext()ของ Java มีประโยชน์สำหรับปัญหานี้
รูปแบบการป้อนข้อมูล
อ่านบางอย่างที่ไม่รู้จัก n บรรทัดอินพุตจากstdin (System.in)จนกว่าจะถึงEOF ; แต่ละบรรทัดของอินพุตมีสตริง ที่ไม่ว่าง เปล่า
รูปแบบเอาต์พุต
สำหรับแต่ละบรรทัด ให้พิมพ์หมายเลขบรรทัด ตามด้วยเว้นวรรคหนึ่งช่อง แล้วตามด้วยเนื้อหาบรรทัดที่ได้รับเป็นอินพุต
อินพุตตัวอย่าง
Hello world
I am a file
Read me until end-of-file.
เอาต์พุตตัวอย่าง
1 Hello world
2 I am a file
3 Read me until end-of-file.
 */

import java.io.*;
import java.util.*;
//import java.util.Scanner;
public class J7_JavaEnd_of_File {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int lineCount = 1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(lineCount + " " + line);
            lineCount++;
        }
        scanner.close();

    }
}

/*
ในโค้ดด้านบน เราใช้ Scanner เพื่ออ่านข้อมูลจาก System.in ในลูป while โดยใช้ scanner.hasNext() เพื่อตรวจสอบว่ายังมีข้อมูลให้อ่านหรือไม่
ถ้ายังมีข้อมูล จะอ่านบรรทัดถัดไปด้วย scanner.nextLine() และพิมพ์เลขบรรทัดและเนื้อหาของบรรทัดนั้น
สุดท้าย เราปิด Scanner ด้วย scanner.close()
สรุปแล้ว โค้ดนี้จะอ่านข้อมูลจาก System.in จนกระทั่งเจอสิ้นสุดของไฟล์ (EOF) และพิมพ์เลขบรรทัดตามด้วยชุดข้อมูลที่ได้อ่าน
 */
