/*
ข้อสอบที่ 2 Product Data Management
System analyst ของบริษัทซีพีเอฟไอทีที่ต้องการสร้างระบบค้นหาสินค้าสำหรับเว็บไซต์อีคอมเมิร์ช ซึ่งต้องการให้ค้นหาได้ด้วยข้อมูล ชื่อ(product name), ราคา(price),
และปีที่ผลิต(manufacturing year)
เขาออกแบบให้สร้างระบบที่สามารถรับข้อมูลของสินค้าเป็น array 2 มิติและ query ที่ใช้ในการค้นหาสินค้าเป็น array 2 มิติที่จะเก็บประเภทของการค้นหาและข้อมูลที่ใช้ค้นหา
ซึ่งประเภทของการค้นหาจะมี
- Type1: ค้นหาสินค้าที่ผลิตในปีที่ระบุ
- Type2: ค้นหาสินค้าที่ราคาต่ำกว่าที่ระบุ โดยคงลำดับเดิมของสินค้าไว้
- Type3: ค้นหาสินค้าที่ราคาสูงกว่าที่ระบุ โดยคงลำดับเดิมของสินค้าไว้
และระบบจะต้อง return ข้อมูลผลการค้นหาเป็น array 2 มิติ ของซื้อสินค้าที่หาเจอโดยอ้างอิงตาม query
Note: ข้อมูลที่ใช้เป็น String ทั้งหมด
ตัวอย่าง
n = 5
products =
[
 ["key", "50", "2013"],
 ["fan", "100", "2012"],
 ["lock", "150", "2013"],
 ["table", "200", "2011"],
 ["toy", "500", "2011"]
]
q = 4
queries =
[
 ["Type1", "2013"],
 ["Type2", "500"],
 ["Type3", "500"],
 ["Type4", "2011"]
]

ระบบจะทำการค้นหาข้อมูลสินค้าดังนี้
    Query          Explanation             Answer
Type1 2013     สินค้าที่ถูกผลิตในปี 2013      ["key", "lock"]
Type2 500      สินค้าที่ราคาต่ำกว่า 500       ["key", "fan", "table", "lock"]
Type3 500      สินค้าที่ราคาสูงกว่า 500       []
Type1 2011     สินค้าที่ถูกผลิตในปี 2011      ["table", "toy"]

และรีเทิร์น
[
 ["key", "lock"],
 ["key", "fan", "table", "lock"],
 [],
 ["table", "toy"]
]
รายละเอียดของฟังก์ชั่น
ฟังก์ชั่น getMatchingProducts จะรับพารามิเตอร์ดังนี้
1.string products[n] - array 2 มิติของสินค้า
2.string queries[q] - array 2 มิติของ query ที่ใช้ในการค้นหา
ฟังก์ชั่น getMatchingProducts จะรีเทิร์นข้อมูลดังนี้
1.string[q][] - array 2 มิติของชื่อสินค้าที่หาเจอ

ข้อจำกัด
1 <= n <= 600
1 <= q <= 700
สินค้นราคาไม่เกิน 10,000
สินค้าถูกผลิตไม่เกินปี 2100
ชื่อสินค้าจะเป็นภาษาอังกฤษตัวเล็ก (a-z) และตัวเลข (0-9) เท่านั้น

Sample Input For Custom Testing
STDIN                               FUNCTION
--------                            ------------
3                       ->          product[] size n = 3
3                       ->          product[][] size const = 3
item2 510 1947          ->          product = [["item2", "510", "1947"], ["item3", "2089", "2097"], ["item1", "4139", "1970"]]
item3   2080    2097
item1   4139    1970
6                       ->          query[] size q = 6
2                       ->          query[][] size const = 2
Type3   2089            ->          query = [["Type3", "2089"], ["Type2", "4139"], ["Type2", "510"], ["Type1", "1947"], ["Type1", "1970"], ["Type1", "2097"]]
Type2   4139
Type2   510
Type1   1947
Type1   1970
Type1   2097

Sample Output
item1
item2   item3

item2
item1
item3

 */

import java.io.*; // ไลบรารีที่ใช้ในการทำงานกับการป้อนเข้าและการส่งออกข้อมูล เช่นการอ่านและเขียนไฟล์
import java.math.*; // ไลบรารีที่ใช้ในการดำเนินการทางคณิตศาสตร์ที่ข้างมาก เช่น การทำงานกับจำนวนทศนิยมแบบใหญ่
import java.security.*; // ไลบรารีที่ใช้ในการจัดการความปลอดภัย เช่น เข้ารหัสและถอดรหัสข้อมูล
import java.text.*; // ไลบรารีที่ใช้ในการจัดการการจัดรูปแบบข้อความ เช่นการจัดรูปแบบวันที่และเวลา
import java.util.*; // ไลบรารีที่ใช้ในการจัดการโครงสร้างข้อมูลที่เกี่ยวข้องกับคอลเลกชันของข้อมูล เช่น ลิสต์ (List), เซต (Set), และแมพ (Map)
import java.util.concurrent.*; /* ไลบรารีที่ใช้ในการจัดการกระบวนการที่มีการทำงานพร้อมกัน (concurrent programming) เช่น การจัดการเธรด (Thread)
                                  และการจัดการกลไกการเข้าถึงข้อมูลในลำดับการดำเนินงานสำหรับการใช้งานแบบพร้อมกัน (concurrent data structures)*/
import java.util.function.*; // ไลบรารีที่ใช้ในการประกาศและใช้งานออบเจ็กต์ฟังก์ชัน เพื่อการเขียนโค้ดแบบฟังก์ชัน
import java.util.regex.*; // ไลบรารีที่ใช้ในการจัดการกับรูปแบบของข้อความที่เข้ากับแบบแผน (pattern) ที่กำหนดไว้ เช่น การตรวจสอบและการแทนที่ข้อความที่ตรงกับแบบแผนที่กำหนด
import java.util.stream.*; // ไลบรารีที่ใช้ในการทำงานกับกระแสข้อมูลแบบต่อเนื่อง (stream) โดยใช้แนวคิดของการดำเนินการแบบฟังก์ชันสำหรับการประมวลผลข้อมูลทั้งหมดในกระแสนั้น
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*
ส่วนของคำสั่ง import static java.util.stream.Collectors.joining; และ import static java.util.stream.Collectors.toList;
หมายถึงการนำเข้าฟังก์ชัน joining และ toList จากคลาส Collectors ในไลบรารี java.util.stream โดยใช้คีย์เวิร์ด static เพื่อเรียกใช้งานฟังก์ชันโดยตรงโดยไม่ต้องระบุชื่อคลาสของฟังก์ชัน*/


class test2 {

    /*
     * Complete the 'getMatchingProducts' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY queries
     */

    public static List<List<String>> getMatchingProducts(List<List<String>> products, List<List<String>> queries) {
        /*
        getMatchingProducts: เป็นเมธอดสำหรับค้นหาและคืนค่าผลลัพธ์ของสินค้าที่ตรงกับเงื่อนไขจากลิสต์สินค้า (products) และลิสต์คำถาม (queries) โดยมีฟอร์แมตดังนี้:
        รับพารามิเตอร์ products และ queries ซึ่งเป็นลิสต์สองมิติของสตริง (2D_STRING_ARRAY)
        */

        List<List<String>> matchingProducts = new ArrayList<>();  // สร้างตัวแปร matchingProducts เพื่อเก็บลิสต์สินค้าที่ตรงกับเงื่อนไข

        for (List<String> query : queries) {  // วนลูปผ่านลิสต์คำถาม (queries) โดยใช้ตัวแปร query ในแต่ละรอบ
            String type = query.get(0);    // รับค่าประเภท (type) และค่า (value) จากลิสต์คำถาม
            String value = query.get(1);

            List<String> matching = new ArrayList<>();  // สร้างตัวแปร matching เพื่อเก็บสินค้าที่ตรงกับเงื่อนไขในแต่ละรอบ
            for (List<String> product : products) {  // วนลูปผ่านลิสต์สินค้า (products) โดยใช้ตัวแปร product ในแต่ละรอบ
                String productId = product.get(0);  // รับค่ารหัสสินค้า (productId) และประเภทสินค้า (productType) จากลิสต์สินค้า
                String productType = product.get(1);

                if (productType.equals(type) && productId.contains(value)) { // ถ้าประเภทสินค้าเท่ากับประเภทที่ระบุในคำถามและรหัสสินค้า
                    matching.add(productId);   // มีค่าเป็นส่วนหนึ่งของคำที่ระบุในคำถาม ให้เพิ่มรหัสสินค้าในลิสต์ matching
                }
            }

            matchingProducts.add(matching);   // เพิ่มลิสต์ matching เข้าไปในลิสต์ matchingProducts
        }

        return matchingProducts;   // คืนค่า matchingProducts
    }

    public static void main(String[] args) { // main: เป็นเมธอดหลักที่ใช้สำหรับอ่านข้อมูลเข้าและเรียกใช้เมธอด getMatchingProducts และพิมพ์ผลลัพธ์ที่ได้ทางหน้าจอ
        Scanner scanner = new Scanner(System.in);   // สร้างอ็อบเจ็กต์ Scanner เพื่ออ่านข้อมูลจากแหล่งนำเข้าระบบ

        int productSize = scanner.nextInt();  // อ่านขนาดของลิสต์สินค้าจากอินพุตและเก็บไว้ในตัวแปร productSize
        List<List<String>> products = new ArrayList<>();  // สร้างลิสต์สองมิติ products เพื่อเก็บข้อมูลสินค้า
        for (int i = 0; i < productSize; i++) {   // วนลูป productSize รอบ เพื่ออ่านข้อมูลสินค้าแต่ละรายการจากอินพุตและเพิ่มลงในลิสต์ products
            List<String> product = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                product.add(scanner.next());   // อ่านขนาดของลิสต์คำถามจากอินพุตและเก็บไว้ในตัวแปร querySize
            }
            products.add(product);
        }

        int querySize = scanner.nextInt();
        List<List<String>> queries = new ArrayList<>();  // สร้างลิสต์สองมิติ queries เพื่อเก็บข้อมูลคำถาม
        for (int i = 0; i < querySize; i++) {   // วนลูป querySize รอบ เพื่ออ่านข้อมูลคำถามแต่ละรายการจากอินพุตและเพิ่มลงในลิสต์ queries
            List<String> query = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                query.add(scanner.next());
            }
            queries.add(query);
        }

        scanner.close();    // ปิดอ็อบเจ็กต์ Scanner

        List<List<String>> matchingProducts = getMatchingProducts(products, queries);  // เรียกใช้เมธอด getMatchingProducts และเก็บผลลัพธ์ในตัวแปร matchingProducts

        for (List<String> matching : matchingProducts) {  // วนลูปผ่านลิสต์ matchingProducts เพื่อพิมพ์ผลลัพธ์ทางหน้าจอ
            for (String product : matching) {
                System.out.print(product + " ");
            }
            System.out.println();
        }
    }


}

/*
โค้ดด้านบนใช้ Scanner เพื่ออ่านข้อมูลจาก STDIN โดยตอนที่ใช้อ่านขนาดของสินค้า (productSize) และสินค้า (products)
จากนั้นอ่านขนาดของคิวรี (querySize) และคิวรี (queries) และปิด Scanner ด้วย scanner.close()

ในฟังก์ชัน getMatchingProducts เราจะวนลูปในคิวรีทั้งหมดและตรวจสอบว่าสินค้าตรงกับคิวรีหรือไม่ โดยใช้ค่าประเภทสินค้า (type)
และค่าคำค้น (value) เราจะเก็บรหัสสินค้าที่ตรงกันในลิสต์ matching และเพิ่ม matching ลงในลิสต์ matchingProducts

สุดท้าย เราจะพิมพ์ผลลัพธ์ออกทาง STDOUT โดยวนลูปในลิสต์ matchingProducts และพิมพ์สินค้าที่ตรงกันในแต่ละคิวรี

โค้ดนี้ควรทำงานได้ตามคาดหวังและแสดงผลลัพธ์ตามที่โจทย์ต้องการ
 */