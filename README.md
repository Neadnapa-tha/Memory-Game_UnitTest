# 🧠 Memory Game

เกมนี้เป็นเกมที่เรียบง่าย เหมาะสำหรับเด็กเล็กอายุ 4 ปีขึ้นไป เล่นสนุก ไม่มีโฆษณา ไม่ซับซ้อน และใช้งานง่าย พร้อมทั้งเปิดให้ทุกคนสามารถนำไปพัฒนาต่อได้ (Open Source) 🎉


## 🎮 คุณสมบัติ

- **ธีมให้เลือก 3 แบบ: ** 🐈 สัตว์ 🐙 มอนสเตอร์ เเละ 😄 อีโมจิ
- **ระดับความยาก 6 ระดับ** 🌟
- **เสียงเอฟเฟกต์เมื่อชนะเกม** 🎵


## 📲 ดาวน์โหลด

🔗 **ดาวน์โหลดใน Android บน Google Play**  



## 📄 License

- โค้ดอยู่ภายใต้: [Apache License 2.0](LICENSE)
- ทรัพยากร UI มีลิขสิทธิ์ตามลิงก์ต่อไปนี้:
  - [Animals Collection (Farm & Domestic)](http://graphicriver.net/item/animals-collection-farm-and-domestic-set/7177721)
  - [Monster Creation Kit](http://graphicriver.net/item/monster-creation-kit-and-large-pack/8851390)
  - [10 Fresh Game Backgrounds](http://graphicriver.net/item/10-fresh-game-backgrounds/9137937)
  - [Cartoon Game GUI Pack #11](http://graphicriver.net/item/cartoon-games-gui-pack-11-/6056785)

---
# Unit Test
## T1: 'testOpenScreen'

### วัตถุประสงค์
การทดสอบนี้มีวัตถุประสงค์เพื่อตรวจสอบฟังก์ชัน `openScreen` เมื่อเปิดหน้าจอประเภทต่างๆ ที่แตกต่างกันและเปิดพร้อมกัน จะสามารถเปิดหน้าจอได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = ไม่มี Screen ใดเปิดอยู่
    * C2 = จำนวน Screen ที่สามารถเปิดได้

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: ไม่มี Screen ใดเปิดอยู่     | True  | False  |
  | C2: จำนวน Screen ที่สามารถเปิดได้ | 0  | >=1  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|------------------------|---------------------------|
  | C1: ไม่มี Screen ใดเปิดอยู่           | is Empty  | is not Empty  |
  | C2: จำนวน Screen ที่สามารถเปิดอยู่ได้  | 0  | 1   |

### Functionality-Base

* Develop characteristics
    * C1 = ประเภทของ Screen ที่เปิดได้
    * C2 = สั่งเปิด Screen ได้อย่างถูกต้อง   

* Partition characteristics

  | Characteristic                                | b1            | b2        | b3          | b4           |
  |----------------------------------------------|---------------|------------|------------|--------------|
  | C1: ประเภทของ Screen ที่เปิดได้              | 1             | 2          | 3            | 4            |
  | C2: สั่งเปิด Screen ได้อย่างถูกต้อง         | True          | False      |             |              |

* Identify (possible) values

  | Characteristic                                | b1                 | b2        | b3          | b4           |
  |--------------------------------------------------|---------------|------------|------------|--------------|
  | C1: ประเภทของ Screen ที่เปิดได้                | MENU     | GAME   | DIFFICULTY   | THEME_SELECT    |
  | C2: สั่งเปิด Screen ได้อย่างถูกต้อง            | True          | False      |             |              |

### Input domain modelling
1. Identify testable functions
    * openScreen()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: screen
    * Return type: ไม่มีการคืนค่า (void)
    * Return value: ไม่มีการคืนค่า (void)
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = ไม่มี Screen ใดเปิดอยู่
        * C2 = จำนวน Screen ที่สามารถเปิดได้
        * C3 = ประเภทของ Screen ที่เปิดได้
        * C4 = size ที่สั่งเปิด Screen   
    * Partition characteristics

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่              | True      | False  |             |              |
      | C2: จำนวน Screen ที่สามารถเปิดได้              | 0      | >=1  |             |              |
      | C3: ประเภทของ Screen ที่เปิดได้              | 1             | 2          | 3            | 4            |
      | C4: size ที่สั่งเปิด Screen         | True          | False      |             |              |
    * Identify (possible) values

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่เลย              | is Empty      | is not Empty  |             |              |
      | C2: จำนวน Screen ที่สามารถเปิดได้   | 0      | 2  |             |              |
      | C3: ประเภทของ Screen ที่เปิดได้          | MENU     | GAME   | DIFFICULTY   | THEME_SELECT    |
      | C4: size ที่สั่งเปิด Screen       | 0          | >=1      |             |              |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 4 * 2 = 8
       * C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b2, C2b1) (C1b2, C2b2)
       * C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b1, C3b3) (C1b1, C3b4) (C1b2, C3b1) (C1b2, C3b2) (C1b2, C3b3) (C1b2, C3b4)
       * C1:C4 -> (C1b1, C4b1) (C1b1, C4b2) (C1b2, C4b1) (C1b2, C4b2)
       * C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b1, C3b3) (C2b1, C3b4) (C2b2, C3b1) (C2b2, C3b2) (C2b2, C3b3) (C2b2, C3b4)
       * C2:C4 -> (C2b1, C4b1) (C2b1, C4b2) (C2b2, C4b1) (C2b2, C4b2)
       * C3:C4 -> (C3b1, C4b1) (C3b1, C4b2) (C3b2, C4b1) (C3b2, C4b2) (C3b3, C4b1) (C3b3, C4b2) (C3b4, C4b1) (C3b4, C4b2)
       * Combination -> (C1b1, C2b1, C3b1, C4b1) (C1b1, C2b2, C3b3, C4b2) (C1b2, C2b1, C3b2, C4b1) (C1b2, C2b2, C3b2, C4b2) (C1b1, C2b2, C3b1, C4b2) (C1b1, C2b2, C3b2, C4b2) (C1b1, C2b1, C3b3, C4b1) (C1b1, C2b2, C3b4, C4b1)

5. Derive test values

   | Test | Screen           | numScreen          | Screen Type        | Size                | Expected Value  |
   |------|------------------|--------------------|--------------------|---------------------|-----------------|
   | T1   | is Empty         | 0                  | MENU               | 0                   |    False        |
   | T2   | is Empty         | 1                  | DIFFICULTY         | 1                   |    Fail         |
   | T3   | is not Empty     | 0                  | GAME               | 0                   |    False        |
   | T4   | is not Empty     | 1                  | GAME               | 2                   |    True         |
   | T5   | is Empty         | 1                  | MENU               | 1                   |    True         |
   | T6   | is Empty         | 1                  | GAME               | 1                   |    Fail        |
   | T7   | is Empty         | 0                  | DIFFICULTY         | 0                   |    Fail        |
   | T8   | is Empty         | 1                  | THEME_SELECT       | 1                   |    True         |
  * T2 & T7 => Invalid Test เพราะว่าใน method openScreen ไม่สามารถเปิด DIFFICULTY ก่อนได้
  * T6 => Invalid Test เพราะว่าใน method openScreen ไม่สามารถเปิด GAME ก่อนได้


## T2: 'testOpenScreen'

### วัตถุประสงค์
เป็นการทดสอบการแปลงหน่วยจาก dp (density-independent pixels) เป็น px (pixels) ในแอปพลิเคชัน Android และเพื่อยืนยันว่าฟังก์ชัน testPxConversion() สามารถทำการแปลงค่าได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = DP Value ไม่เป็น 0 
    * C2 = ค่า PX ที่แปลงค่า

* Partition characteristics

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ไม่เป็น 0    | True   | False     |     |
  | C2: ค่า PX ที่แปลงค่า      | <=0   | 1     | >1    |

* Identify (possible) values

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ไม่เป็น 0    | 20   | 0     |     |
  | C2: ค่า PX ที่แปลงค่า      | -5  | 1.0  | 2.0  |

### Functionality-Base

* Develop characteristics
    * C1 = DP Value ที่ต้องการทดสอบ
    * C2 = ค่า PX ที่แปลงค่าเรียบร้อย

* Partition characteristics

  | Characteristic                               | b1            | b2              | b3          |
  |----------------------------------------------|---------------|-----------------|-------------|
  | C1: DP Value ที่ต้องการทดสอบ                   | <=0           | 1               | >1          |
  | C2: ค่า PX ที่แปลงค่าเรียบร้อย                     | < dpValue     | = dpValue       | > dpValue   |

* Identify (possible) values

  | Characteristic                               | b1  | b2  | b3  |
  |----------------------------------------------|----|----|----|
  | C1: DP Value ที่ต้องการทดสอบ                   | -5  | 1.0 | 2.0 |
  | C2: ค่า PX ที่แปลงค่าเรียบร้อย                     |-2.5 |  5  |  10 |

### Input domain modelling
1. Identify testable functions
    * px()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: dpValue
    * Return type: int
    * Return value: ค่า pixel ที่แปลงหน่วยแล้ว
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = DP Value ไม่เป็น 0 
        * C1 = DP Value ที่ต้องการทดสอบ
        * C2 = ค่า PX ที่แปลงค่าเรียบร้อย

    * Partition characteristics

      | Characteristic                                | b1            | b2              | b3          |
      |----------------------------------------------|---------------|-----------------|-------------|
      | C1: DP Value ไม่เป็น 0       | True   | False  |      |
      | C2: DP Value ที่ต้องการทดสอบ        | <=0           | 1               | >1          |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย     | < dpValue     | = dpValue       | > dpValue   |

    * Identify (possible) values

      | Characteristic                                | b1  | b2  | b3  |
      |----------------------------------------------|----|----|----|
      | C1: DP Value ไม่เป็น 0           | 5  | 0 |  |
      | C2: DP Value ที่ต้องการทดสอบ             | 0  | 1   | 2   |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย          | -1 | 1   | 4  |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 3 * 3 = 9
      	* C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b1, C2b3) (C1b2, C2b1) (C1b2, C2b2) (C1b2, C2b3)
      	* C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b1, C3b3) (C1b2, C3b1) (C1b2, C3b2) (C1b2, C3b3) 
      	* C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b1, C3b3) (C2b2, C3b1) (C2b2, C3b2) (C2b2, C3b3) (C2b3, C3b1) (C2b3, C3b2) (C2b3, C3b3)
      	* Combination -> (C1b1, C2b1, C3b2) (C1b1, C2b2, C3b2) (C1b1, C2b3, C3b2) (C1b2, C2b1, C3b1) (C1b2, C2b2, C3b1) (C1b2, C2b3, C3b1) (C1b1, C2b1, C3b3) (C1b1, C2b2, C3b3) (C1b1, C2b3, C3b3)

5. Derive test values

   | Test |     DP!=0     | DP Value | PX Value |  Expected Value |
   |------|---------------|----------|----------|-----------------|
   | T1   |     True      |  -5      |   -5     | true           |
   | T2   |     True      |  1       |   1      | true           |
   | T3   |     True      |  20      |   20     | true           |
   | T4   |     False     |  0       |   -5      | false            |
   | T5   |     False     |  1       |   -5      | Invalid         |
   | T6   |     False     |  20      |   -5      | Invalid         |
   | T7   |     True      |  -5      |   2      | false           |
   | T8   |     True      |  1       |   2      | false           |
   | T9   |     True      |  20      |   40      | false            |
   * T5 & T6 => Invalid Test เพราะว่า เงื่อนไข DP!=0 เป็น False ทำให้ไม่สามารถใส่ค่าอื่นได้นอกจาก 0



## T3: 'testGetBestTime()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นมาเพื่อตรวจสอบว่า function `getBestTime` คืนค่า bestTime  ถูกต้องตรงกับ expected result

### Interface-Base

* Develop characteristics
  * C1 = Theme id is correct
  * C2 = Difficulty value is correct

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct     | True  | False  |
  | C2: Difficulty value is correct | True  | False  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|------------------------|---------------------------|
  | C1: Theme id is correct          | 1  | -1  |
  | C2: Difficulty value is correct  | 1  | -1  |

### Functionality-Base

* Develop characteristics
  * C1 = สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences

* Partition characteristics

  | Characteristic                                | b1  | b2 |
  |----------------------------------------------|----|----|
  | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences              | True  | False  |
  
* Identify (possible) values

  | Characteristic                                | b1  | b2 |
  |----------------------------------------------|------------------------|---------------------------|
  | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences               |  (1, 1)  |  (-1, 0)  |

### Input domain modelling
1. Identify testable functions 
   * getBestTime()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: theme, difficulty
   * Return type: int
   * Return value: ค่าที่ได้จาก SharedPreferences ถ้าหากไม่พบค่าใน SharedPreferences จะคืนค่า-1
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = Theme id is correct
     * C2 = Difficulty value is correct
     * C3 = สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences
   * Partition characteristics
   
     | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: Theme id is correct                | True  | False  |
     | C2: Difficulty value is correct         | True  | False  |
     | C3: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences         | True  | False  |

   * Identify (possible) values

     | Characteristic                                | b1  | b2 |
     |----------------------------------------------|------------------------|---------------------------|
     | C1: Theme id is correct              | 1 | -1  |
     | C2: Difficulty value is correct         | 1  | -1  |
     | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences               |  (1, 1)  |  (-1, 0)  |

4. Combine partitions into tests
   * Assumption: choose all combinations (ACoC) 
   * Test requirements -- number of tests (lower bound) = 2 * 2 * 2 = 8
   * o	C1:C2:C3 -> (C1B1, C2B1, C3B1) , (C1B1, C1B1, C3B2), (C1B1, C2B2, C3B1), (C1B1, C2B2, C3B2), (C1B2, C2B1, C3B1) , (C1B2, C1B1, C3B2), (C1B2, C2B2, C3B1), (C1B2, C2B2, C3B2)
5. Derive test values
   
     |   Test  | Theme  |  Difficulty | Theme & Difficulty can create keys | Expected result |
     |----- | :-------------: | :-------------: | :-------------: | :-------------: |
     |T1 | 1 | 1  | True  | 25  |
     |T2| 1 | 1  | False  | Invalid  |
     |T3 | 1 | -1  | True| Invalid  |
     |T4 | 1 | -1  | False  | -1  |
     |T5| -1 | 1  | True  | Invalid  |
     |T6 | -1 | 1  | False  | -1  |
     |T7 | -1 | -1  | True| Invalid  |
     |T8 | -1 | -1  | False | -1  |
   * T2 => Invalid Test เพราะว่าค่า Theme & Difficulty ถูกทั้งคู่ต้องสามารถสร้าง key ได้
   * T3 & T5 & T7 => Invalid Test เพราะว่าค่า Theme or Difficulty ไม่ถูกต้องไม่สามารถสร้าง key ได้



## T4: 'testSaveTime()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นมาเพื่อตรวจสอบว่า passedSecs ที่ได้รับมาเท่ากับ bestTime ที่เก็บไว้อยู่หรือเปล่าถ้า passedSecs น้อยกว่า bestTime ค่า passedSecs จะถูกบันทึกเป็น bestTime อันใหม่

### Interface-Base

* Develop characteristics
  * C1 = Value of theme
  * C2 = Value of difficulty
  * C3 = Value of PassedSecs

* Partition characteristics

  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: Value of theme      | Less than 1  | Equal to 1  | Greater than 1 |
  | C2: Value of difficulty  | Less than 1  | Equal to 1  | Greater than 1 |
  | C3: Value of PassedSecs  | Less than bestTime  | Equal to bestTime  | Greater than bestTime |

* Identify (possible) values

  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: Value of theme      | 0  | 1  | 2 |
  | C2: Value of difficulty  | 0  | 1  | 2 |
  | C3: Value of PassedSecs  | 30  | 40  | 50 |

### Functionality-Base

* Develop characteristics
  * C1 = สร้าง key จาก theme และ difficulty ได้
  * C2 = ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences

* Partition characteristics

  | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: สร้าง key จาก theme และ difficulty ได้              | True  | False  |
     | C2: ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences         | True  | False  |
  
* Identify (possible) values

  | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: สร้าง key จาก theme และ difficulty ได้              | (1, 2)  | (-1, 0)  |
     | C2: ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences         | 30  | 50  |

### Input domain modelling
1. Identify testable functions 
   * saveTime()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: theme, difficulty, passedSecs
   * Return type: ไม่มีการคืนค่า (void)
   * Return value: ไม่มีการคืนค่า (void)
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = สร้าง key จาก theme และ difficulty ได้
     * C2 = ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences

   * Partition characteristics

      | Characteristic                                | b1  | b2 | b3 |
     |----------------------------------------------|----|----|----
     | C1: Value of theme      | Less than 1  | Equal to 1  | Greater than 1 |
     | C2: Value of difficulty  | Less than 1  | Equal to 1  | Greater than 1 |
     | C3: Value of PassedSecs  | Less than bestTime  | Equal to bestTime  | Greater than bestTime |
     | C4: สร้าง key จาก theme และ difficulty ได้  | True  | False  |
     | C5: ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences  | True  | False  |

   * Identify (possible) values

      | Characteristic                                | b1  | b2 | b3 |
     |----------------------------------------------|----|----|----|
     | C1: Value of theme      | 0 | 1  | 2 |
     | C2: Value of difficulty  | 0  | 1  | 2 |
     | C3: Value of PassedSecs  | 30  | 40  | 50 |
     | C4: สร้าง key จาก theme และ difficulty ได้              | (1, 2)  | (-1, 0)  |  |
     | C5: ค่า PassedSecs ถูกบันทึกใหม่ที่ SharedPreferences         | 30  | 50  |  |

5. Combine partitions into tests
   * Assumption: choose Each Choice Coverage (ECC) 
   * Test requirements -- number of tests  = 3
   * C1:C2 -> (C1B1, C2B1, C3B1, C4B1, C5B1) , (C1B2, C2B2, C3B2, C4B2, C5B2), (C1B3, C2B3, C3B3, C4B1, C5B1)
6. Derive test values
   
   |   Test  | Theme | Difficulty | PassedSecs | Theme & Difficulty can create keys | PassedSecs can Save to Shared Preferences |Expected result |
     |----- | :-------------: | :-------------: | :-------------: | :-------------: | :-------------: | :-------------: |
     |T1 | 0 | 0 | 30  | True | True | 30  |
     |T2 | 1 | 1 | 50  | False | False | Invalid Test  |
     |T3 | 2 | 2 | 50  |  True    |  True     |  40   |

* T2 => Invalid Test เพราะว่าค่า Theme & Difficulty ถูกทั้งคู่ต้องสามารถสร้าง key ได้



## T5: 'testValidDifficulty()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นเพื่อตรวจสอบว่า Board ได้มีการสร้างขึ้นอย่างถูกต้อง และเพื่อการตรวจสอบว่า การตรวจจับระดับความยากของ Board สามารถทำงานได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
  * C1 = Board สามารถสร้างขึ้นมาได้ 
  * C2 = จำนวน Board ที่สามารถสร้างได้

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: มีการสร้าง Board ขึ้นมา     | True | False  | 
  | C2: จำนวน Board ที่สามารถสร้างได้  | 0 | >= 1 |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: มีการสร้าง Board ขึ้นมา      | True | False  | 
  | C2: จำนวน Board ที่สามารถสร้างได้  | 0 | >= 1 |

### Functionality-Base

* Develop characteristics
  * C1: Board สามารถสร้างขึ้นได้อย่างถูกต้อง
  * C2: ระดับความยากของ Board ที่สร้างขึ้น

* Partition characteristics

  | Characteristic                    | b1   | b2    | b3  | b4 | b5  | b6 |
  |-----------------------------------|------|-------|-----|----|-----|----|
  | C1: Board สามารถสร้างขึ้นได้อย่างถูกต้อง | True | False |     |    |     |    |
  | C2: ระดับความยากของ Board ที่สร้างขึ้น  | 1    | 2     | 3   | 4  | 5   | 6  |
     
  
* Identify (possible) values

  | Characteristic                    | b1   | b2    | b3  | b4 | b5  | b6 |
  |-----------------------------------|------|-------|-----|----|-----|----|
  | C1: Board สามารถสร้างขึ้นได้อย่างถูกต้อง | True | False |     |    |     |    |
  | C2: ระดับความยากของ Board ที่สร้างขึ้น  | 1    | 2     | 3   | 4  | 5   | 6  |


### Input domain modelling
1. Identify testable functions 
   * BoardConfiguration()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: Difficulty (inner parameter)
   * Return type: ไม่มีการคืนค่า (void)
   * Return value: ไม่มีการคืนค่า (void)
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = มีการสร้าง Board ขึ้นมา
     * C2 = จำนวน Board ที่สามารถสร้างได้
     * C3 = Board สามารถสร้างขึ้นได้อย่างถูกต้อง
     * C4 = ระดับความยากของ Board ที่สร้างขึ้น

   * Partition characteristics
     
  | Characteristic                    | b1   | b2    | b3  | b4 | b5  | b6 |
  |-----------------------------------|------|-------|-----|----|-----|----|
  | C1: มีการสร้าง Board ขึ้นมา           | True | False |     |    |     |    |
  | C2: จำนวน Board ที่สามารถสร้างได้     | 0    | 1     |     |    |     |    |
  | C3: Board สามารถสร้างขึ้นได้อย่างถูกต้อง | True | False |     |    |     |    |
  | C4: ระดับความยากของ Board ที่สร้างขึ้น  | 1    | 2     | 3   | 4  | 5   | 6  |

   * Identify (possible) values

  | Characteristic                    | b1   | b2    | b3  | b4 | b5  | b6 |
  |-----------------------------------|------|-------|-----|----|-----|----|
  | C1: มีการสร้าง Board ขึ้นมา           | True | False |     |    |     |    |
  | C2: จำนวน Board ที่สามารถสร้างได้     | 0    | 1     |     |    |     |    |
  | C3: Board สามารถสร้างขึ้นได้อย่างถูกต้อง | True | False |     |    |     |    |
  | C4: ระดับความยากของ Board ที่สร้างขึ้น  | 1    | 2     | 3   | 4  | 5   | 6  |


4. Combine partitions into tests
   * Assumption: choose Multiple Base Choice (MBCC)
   * Test requirements -- number of tests (lower bound) = 4 + (4 * (2-1)) + (4 * (2-2)) + (4 * (2-2)) + (4*(6-2)) = 24
      *  Base = (C1b1, C2b1, C3b1, C4b1), (C1b1, C2b2, C3b1, C4b1), (C1b1, C2b1, C3b2, C4b1), (C1b1, C2b1, C3b1, C4b2),
      *  MBCC = (C1b1, C2b1, C3b1, C4b1), (C1b1, C2b1, C3b1, C4b2), (C1b1, C2b1, C3b1, C4b3), (C1b1, C2b1, C3b1, C4b4), (C1b1, C2b1, C3b1, C4b5), (C1b1, C2b1, C3b1, C4b6), (C1b2, C2b1, C3b1, C4b1), (C1b2, C2b1, C3b1, C4b2), (C1b2, C2b1, C3b1, C4b3), (C1b2, C2b1, C3b1, C4b4), (C1b2, C2b1, C3b1, C4b5), (C1b2, C2b1, C3b1, C4b6), (C1b1, C2b2, C3b1, C4b1), (C1b1, C2b2, C3b1, C4b2), (C1b1, C2b2, C3b1, C4b3), (C1b1, C2b2, C3b1, C4b4), (C1b1, C2b2, C3b1, C4b5), (C1b1, C2b2, C3b1, C4b6), (C1b1, C2b1, C3b2, C4b1), (C1b1, C2b1, C3b2, C4b2), (C1b1, C2b1, C3b2, C4b3), (C1b1, C2b1, C3b2, C4b4), (C1b1, C2b1, C3b2, C4b5), (C1b1, C2b1, C3b2, C4b6)

5. Derive test values
     |   Test  | numtiles  |  numTilesInRow | numRows | time | Expected result |
     |---------| :-------: | :------------: | :-----: | :--: | :-------------: |
     |   T1    |    6      |      3         |     2   |   60 |       Pass      |
     |   T2    |    12     |      4         |     3   |   90 |       Pass      |
     |   T3    |    18     |      6         |     3   |  120 |       Pass      |
     |   T4    |    28     |      7         |     4   |  150 |       Pass      |
     |   T5    |    32     |      8         |     4   |  180 |       Pass      |
     |   T6    |    50     |      10        |     5   |  210 |       Pass      |



## T6: 'testCreateAnimalsTheme()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นเพื่อตรวจสอบองค์ประกอบของคลาส Theme และตรวจสอบว่าคลาสที่สร้างใหม่ไม่เป็น Null

### Interface-Base

* Develop characteristics
  * C1 = สามารถสร้าง Theme ขึ้นมาได้
  * C2 = จำนวนของ Theme ที่สามารถสร้างได้

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: สามารถสร้าง Theme ขึ้นมาได้     | True | False  | 
  | C2: จำนวนของ Theme ที่สามารถสร้างได้  | 0 | >= 1 |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: สามารถสร้าง Theme ขึ้นมาได้     | True | False  | 
  | C2: จำนวนของ Theme ที่สามารถสร้างได้  | 0 | 1 |

### Functionality-Base

* Develop characteristics
  * C1: ประเภทของ Themes ที่เปิดได้
  * C2: Themes สามารถเปิดได้อย่างถูกต้อง

* Partition characteristics
  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: ประเภทของ Themes ที่เปิดได้    | 1 | 2  | 3 |
  | C2: Themes สามารถเปิดได้อย่างถูกต้อง | True | False |

  
* Identify (possible) values

  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: ประเภทของ Themes ที่เปิดได้    | Animals | Monsters  | Emoji |
  | C2: Themes สามารถเปิดได้อย่างถูกต้อง | True | False |

### Input domain modelling
1. Identify testable functions 
   * createAnimalsTheme()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: ไม่มี Parameters
   * Return type: ไม่มีการคืนค่า (void)
   * Return value: ไม่มีการคืนค่า (void)
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = สามารถสร้าง Theme ขึ้นมาได้
     * C2 = จำนวนของ Theme ที่สามารถสร้างได้
     * C3 = ประเภทของ Themes ที่เปิดได้
     * C4 = Themes สามารถเปิดได้อย่างถูกต้อง

   * Partition characteristics
     
  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: สามารถสร้าง Theme ขึ้นมาได้   | True | False  |   |
  | C2: จำนวนของ Theme ที่สามารถสร้างได้| 0 | 1 |
  | C3: ประเภทของ Themes ที่เปิดได้    | 1 | 2  | 3 |
  | C4: Themes สามารถเปิดได้อย่างถูกต้อง | True | False |
     

   * Identify (possible) values
     
  | Characteristic                              | b1  | b2 | b3 |
  |--------------------------------------------|----|----|----|
  | C1: สามารถสร้าง Theme ขึ้นมาได้   | True | False  |   |
  | C2: จำนวนของ Theme ที่สามารถสร้างได้| 0 | 1 | |
  | C3: ประเภทของ Themes ที่เปิดได้    | Animals | Monsters  | Emoji |
  | C4: Themes สามารถเปิดได้อย่างถูกต้อง | True | False | |

4. Combine partitions into tests
   * Assumption: choose Multiple Base Choice (MBCC)
   * Test requirements -- number of tests (lower bound) = 4 + (4*(2-1)) + (4*(2-2)) + (4*(3-2)) + (4*(2-2)) = 12
      *  Base = (C1b1, C2b1, C3b1, C4b1), (C1b1, C2b2, C3b1, C4b1), (C1b1, C2b1, C3b2, C4b1), (C1b1, C2b1, C3b1, C4b2),
      *  MBCC = (C1b1, C2b1, C3b1, C4b1), (C1b1, C2b1, C3b2, C4b1), (C1b1, C2b1, C3b3, C4b1), (C1b2, C2b1, C3b1, C4b1), (C1b2, C2b1, C3b2, C4b1), (C1b2, C2b1, C3b3, C4b1), (C1b1, C2b2, C3b1, C4b1), (C1b1, C2b2, C3b2, C4b1), (C1b1, C2b2, C3b3, C4b1), (C1b1, C2b1, C3b1, C4b2), (C1b1, C2b1, C3b2, C4b2), (C1b1, C2b1, C3b3, C4b2)

5. Derive test values
   
     |   Test  | ID  |  Name | backgroundImageUrl | backgroundImageUrl | Expected result |
     |---------| :-: | :---: | :----------------: | :----------------: | :-------------: |
     |T1 | 1 | Animals | back_animals | 28  | Pass  |
     |T2 | 2 | Monsters | back_horror | 40  | Pass  |
     |T3 | 3 | Emoji  | background | 40 | Pass  |




## T7: 'testIsPair()'

### วัตถุประสงค์
เพื่อตรวจสอบค่าของ  id1 เเละ id2 นั้นตรงกับที่ถูกเก็บไว้ใน Map หรือไม่

### Interface-Base

* Develop characteristics
    * C1 = id1 ที่มีค่าเป็น integer 
    * C2 = id2 ที่มีค่าเป็น integer 

* Partition characteristics

| Characteristic                   | b1               | b2          | b3               |
|----------------------------------|------------------|-------------|------------------|
| C1: ค่า id1 ที่มีค่าเป็น integer | negative integer | number zero | positive integer |
| C2: ค่า id2 ที่มีค่าเป็น integer | negative integer | number zero | positive integer |


* Identify (possible) values
  
| Characteristic                   | b1  | b2 | b3 |
|----------------------------------|-----|----|----|
| C1: ค่า id1 ที่มีค่าเป็น integer | -5  | 0  | 1  |
| C2: ค่า id2 ที่มีค่าเป็น integer | -10 | 0  | 2  |

### Functionality-Base

* Develop characteristics
    * C1 = ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map

* Partition characteristics

| Characteristic   | b1   | b2    |
|-----------------------------|------|-------|
| C1: ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map (มีค่า value ของ id1 ที่เป็น key เเละ ค่า value ของ id2 ที่เป็น value อยู่ใน Map) | True | False |



* Identify (possible) values

| Characteristic             | b1 | b2 |
|--------------------------------|----|----|
| C1: ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map (มีค่า value ของ id1 ที่เป็น key เเละ ค่า value ของ id2 ที่เป็น value อยู่ใน Map) | (1,2) | (1,8) |


### Input domain modelling
1. Identify testable functions
    * isPair() [com/snatik/matches/model/BoardArrangment.java]
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: int  id1, int id2
    * Return type: boolean(true, false)
    * Return value: true, false
    * Exceptional behavior: หากค่าของ  id1, id2 ไม่ได้มีค่าตรงกับที่ถูกเก็บไว้ใน Map
3. Model the input domain
    * Develop characteristics
        * C1 = ค่า id1 ที่มีค่าเป็น integer
        * C2 = ค่า id2 ที่มีค่าเป็น integer 
        * C3 = ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map
    * Partition characteristics

| Characteristic             | b1               | b2          | b3  |
|-----------------------------------------|------------------|-------------|------------------|
| C1:  ค่า id1 ที่มีค่าเป็น integer | negative integer | number zero | positive integer |
| C2:  ค่า id2 ที่มีค่าเป็น integer | negative integer | number zero | positive integer |
| C3: ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map (มีค่า value ของ id1 ที่เป็น key เเละ ค่า value ของ id2 ที่เป็น value อยู่ใน Map) | True | False |    

    * Identify (possible) values


| Characteristic              | b1   | b2   | b3 |
|-----------------------------|------|------|----|
| C1: ค่า id1 ที่มีค่าเป็น integer  | -1   | 0    | 1  |
| C2:  ค่า id2 ที่มีค่าเป็น integer | -2   | 0    | 2  | 
| C3: ค่าของ  id1 เเละ id2 ตรงกับค่าที่เก็บไว้อยู่ใน Map (มีค่า value ของ id1 ที่เป็น key เเละ ค่า value ของ id2 ที่เป็น value อยู่ใน Map) | (1,2) | (6,7) |  


4. Combine partitions into tests
    * Assumption: choose Base Choice Coverage(BCC)
    * Test requirements -- number of tests (lower bound) = 1 + (2 - 1) + (3 - 1) + (3 - 1) = 6
    * Base: (C1b3, C2b3, C3b1)
    * (BCC) -> (C1b3, C2b1, C3b1), (C1b3, C2b2, C3b1), (C1b3, C2b3, C3b2), (C1b1, C2b3, C3b1), (C1b2, C2b3, C3b1)
5. Derive test values

| Test                                          | id1 | id2 | pairsID | 
|-----------------------------------------------|-----|-----|---------|
| T1: [positive integer,  positive integer, True] | 1   | 2   | (1,2)    | 
| T2: [positive integer, negative integer, True]  | 2   | -1  | (2,-1)   |   
| T3: [positive integer, number zero, True]       | 3   | 0   | (3,0)    |  
| T4: [positive integer, positive integer, False] | 6   | 7   | (6,7)    |   
| T5: [negative integer, positive integer, True]  | -2  | 4   | (-2,4)   |  
| T6: [number zero, positive integer, True]       | 0   | 5   | (0,5)    |   




## T8: 'testSetGameState()'

### วัตถุประสงค์
 เพื่อตรวจสอบว่าเมื่อ method ได้รับค่า input เเล้วนั้นยังคงสามารถ ประมวลผล คำนวณ เเละ เเสดงผลลัพธ์การทำงานได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = ค่าเวลา หรือ remainedSeconds ใน gameState เป็น Integer
    * C2 = ค่าคะเเนน หรือ achievedScore  ใน gameState เป็น Integer
    * C3 = จำนวนดาว หรือ achievedStars ใน gameState เป็น Integer

* Partition characteristics

| Characteristic          | b1               | b2          | b3               |
|-------------------------------|------------------|-------------|------------------|
| C1: ค่าเวลา หรือ remainedSeconds ใน gameState เป็น Integer   | negative integer | number zero | positive integer |
| C2: ค่าคะเเนน หรือ  achievedScore  ใน gameState เป็น Integer | negative integer | number zero | positive integer |
| C3: จำนวนดาว หรือ  achievedStars  ใน gameState เป็น Integer  | negative integer | number zero | positive integer |


* Identify (possible) values

| Characteristic                                               | b1 | b2 | b3  |
|--------------------------------------------------------------|----|----|-----|
| C1: ค่าเวลา หรือ remainedSeconds ใน gameState เป็น Integer   | -1 | 0  | 60  |
| C2: ค่าคะเเนน หรือ  achievedScore  ใน gameState เป็น Integer | -2 | 0  | 100 |
| C3: ค่าดาว หรือ  achievedStars  ใน gameState                 | -3 | 0  | 250 |



### Functionality-Base

* Develop characteristics
    * C1 = ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน  GameState gameState บน popupView นั้นให้ค่าที่ถูก 
    * C2 = ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า remainedScore ที่ถูกสร้างไว้ใน  GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0
    * C3 = ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว หรือ remainedStars ที่ถูกสร้างไว้ใน  GameState gameState บน popupView 

* Partition characteristics

 | Characteristic                                                                                                                                         | b1          | b2    | b3 | b4 | b5 | b6          |
|--------------------------------------------------|-------------|-------|----|----|----|-------------|
| C1: ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน  GameState gameState บน popupView นั้นให้ค่าที่ถูก                              | True        | False |    |    |    |             |
| C2: ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า  achievedScore ที่ถูกสร้างไว้ใน  GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0 | True        | False |    |    |    |             |
| C3: ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว หรือ  achievedStars ที่ถูกสร้างไว้ใน  GameState gameState บน popupView                                | less than 0 | 0     | 1  | 2  | 3  | more than 3 |

* Identify (possible) values

| Characteristic | b1 | b2 | b3 | b4 | b5 | b6 |
|---------------|----|----|----|----|----|----|
| C1: ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน GameState gameState บน popupView นั้นให้ค่าที่ถูก | Input: remainedSeconds = 120 Output: mTime = 02:00 | Input: remainedSeconds = 120 Output: mTime = 00:00 |  |  |  |  |
| C2: ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า achievedScore ที่ถูกสร้างไว้ใน GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0 | Input: remainedScore = 100 Output: mSore = 0 | Input: remainedScore = 100 Output: mSore = 100 |  |  |  |  |
| C3: ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว หรือ achievedStars ที่ถูกสร้างไว้ใน GameState gameState บน popupView | เมื่อจำนวนดาว -1 จะหยุดการทำงาน | เมื่อจำนวนดาว 0 mStar1 => GONE (ดับ) mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) | เมื่อจำนวนดาว 1 mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 2 mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 5 จะหยุดการทำงาน |


### Input domain modelling
1. Identify testable functions
    * setGameState [com.snatik.matches.ui.PopupWonView]
    * animateStars  [com.snatik.matches.ui.PopupWonView]
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: GameState gameState เเละ int  start
    * Return type: ไม่มีการ return เนื่องจากเป็น void
    * Return value: ไม่มีการ return เนื่องจากเป็น void
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = ค่าเวลา หรือ remainedSeconds ใน gameState เป็น Integer
        * C2 = ค่าคะเเนน หรือ achievedScore  ใน gameState เป็น Integer
        * C3 = ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน  GameState gameState บน popupView นั้นให้ค่าที่ถูก
        * C4 = ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า remainedScore ที่ถูกสร้างไว้ใน  GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0
        * C5 = ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว โดยจำนวนดาว หรือ achievedStars ใน gameState เป็น Integer 



    * Partition characteristics

| Characteristic | b1 | b2 | b3 | b4 | b5 | b6 |
|---------------|----|----|----|----|----|----|
| C1: ค่าเวลาหรือ remainedSeconds ใน gameState เป็น Integer | negative integer | number zero | positive integer |  |  |  |
| C2: ค่าคะเเนนหรือ achievedScore ใน gameState เป็น Integer | negative integer | number zero | positive integer |  |  |  |
| C3: ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน GameState gameState บน popupView นั้นให้ค่าที่ถูก | True | False |  |  |  |  |
| C4: ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า achievedScore ที่ถูกสร้างไว้ใน GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0 | True | False |  |  |  |  |
| C5: ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว โดยจำนวนดาวหรือ achievedStars ใน gameState เป็น Integer | less than 0 | 0 | 1 | 2 | 3 | more than 3 |


   * Identify (possible) values

| Characteristic | b1 | b2 | b3 | b4 | b5 | b6 |
|---------------|----|----|----|----|----|----|
| C1: ค่าเวลาหรือ remainedSeconds ใน gameState เป็น Integer | -1 | 0 | 60 |  |  |  |
| C2: ค่าคะเเนนหรือ achievedScore ใน gameState เป็น Integer | -2 | 0 | 100 |  |  |  |
| C3: ค่า mTime ของเวลาที่ถูกคำนวณมาจาก remainedSeconds ที่ถูกสร้างไว้ใน GameState gameState บน popupView นั้นให้ค่าที่ถูก | Input: remainedSeconds = 120 Output: mTime = 02:00 | Input: remainedSeconds = 120 Output: mTime = 00:00 |  |  |  |  |
| C4: ค่า mSore ของคะเเนนให้ค่าเป็น 0 ทุกครั้งไม่ว่าจะใส่ค่า achievedScore ที่ถูกสร้างไว้ใน GameState gameState บน popupView เท่าใดก็ยังคงให้ค่าเป็น 0 | Input: remainedScore = 100 Output: mSore = 0 | Input: remainedScore = 100 Output: mSore = 100 |  |  |  |  |
| C5: ตรวจสอบการมองเห็นของดาวโดยอ้างอิงจากจำนวนดาว โดยจำนวนดาวหรือ achievedStars ใน gameState | เมื่อจำนวนดาว -1 จะหยุดการทำงาน | เมื่อจำนวนดาว 0 mStar1 => GONE (ดับ) mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) | เมื่อจำนวนดาว 1 mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 2 mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) | เมื่อจำนวนดาว 5 จะหยุดการทำงาน |


4. Combine partitions into tests
    * Assumption: choose  Base Choice Coverage(BCC)
    * Test requirements -- number of tests = 1 + (3 - 1) + (3 - 1) + (2 - 1) + (2 - 1) + (6 - 1) = 12
    * Base: (C1b3, C2b3, C3b1, C4b1, C5b5)
    * (BCC) -> (C1b1, C2b3, C3b1,C4b1, C5b5), (C1b2, C2b3, C3b1,C4b1, C5b5), (C1b3, C2b1, C3b1,C4b1, C5b5), (C1b3, C2b2, C3b1,C4b1, C5b5), (C1b3, C2b3, C3b2,C4b1, C5b5), (C1b3, C2b3, C3b1,C4b2, C5b5), (C1b3, C2b3, C3b1,C4b1, C5b1),(C1b3, C2b3, C3b1,C4b1, C5b2), (C1b3, C2b3, C3b1,C4b1, C5b3), (C1b3, C2b3, C3b1,C4b1, C5b4), (C1b3, C2b3, C3b1,C4b1, C5b6)

5. Derive test values

| Test | remainedSeconds | achievedScore | mTime | mScore | Star |
|------|-----------------|---------------|-------|--------|------|
| T1   | 60  | 10  | Input: remainedSeconds = 60 Output: mTime = 01:00| Input: achievedScore = 10 Output: mSore = 0| achievedStars = 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) |
| T2 ❗️ (เนื่องจากการคำนวณเวลาของ mTime ไม่ควรที่จะเป็นค่าที่ติดลบ)  | -1 | 10  | Input: remainedSeconds = -1 Output: mTime = 00:59 | Input: achievedScore = 10 Output: mSore = 0 | achievedStars = 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) | 
| T3   | 0   | 10  | Input: remainedSeconds = 0 Output: mTime = 00:00  | Input: achievedScore = 10 Output: mSore = 0 | achievedStars = 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) | 
| T4   | 100   | -1  | Input: remainedSeconds = 100 Output: mTime = 01:40 | Input: achievedScore = -1 Output: mSore = 0 |achievedStars = 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) |
| T5   | 120  | 0  | Input: remainedSeconds = 120 Output: mTime = 02:00 |Input: achievedScore = 0 Output: mSore = 0 |achievedStars = 3 mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) mStar3 => VISIBLE (สว่าง) |
| T6❗️ (Output จะออกมาผิดไม่ได้เนื่องจากการคำณวน mTime นั้นได้มีสูตรเขียนไว้ตายตัวเเล้ว)| 150| 20  |  Input: remainedSeconds = 150 Output: mTime = 02:00| Input: achievedScore = 20 Output: mSore  = 0|achievedStars = 3 mStar1 => VISIBLE  (สว่าง) mStar2 => VISIBLE  (สว่าง) mStar3 => VISIBLE  (สว่าง)|
| T7❗️ (Output จะออกมาผิดไม่ได้เนื่องจาก mScore นั้นเป็นค่าคงตัวไม่เปลี่ยนเเปลี่ยง)| 200  | 30   |  Input: remainedSeconds = 200 Output: mTime = 03:20| Input: achievedScore = 30 Output: mSore  = 30| achievedStars = 3 mStar1 => VISIBLE  (สว่าง) mStar2 => VISIBLE  (สว่าง) mStar3 => VISIBLE  (สว่าง)|
| T8❗️ (เนื่องจาก achievedStars หยุดการทำงาน)| 230   | 35  | Input: remainedSeconds = 230 Output: mTime = 03:50 | Input: achievedScore = 35 Output: mSore  = 0| achievedStars = -1 หยุดการทำงาน|
| T9   | 250   | 40    | Input: remainedSeconds = 250 Output: mTime = 04:10| Input: achievedScore = 40 Output: mSore = 0 |achievedStars = 0 mStar1 => GONE (ดับ) mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) |
| T10  | 300  | 41  | Input: remainedSeconds = 250 Output: mTime = 05:00| Input: achievedScore = 41 Output: mSore = 0 |achievedStars = 1 mStar2 => GONE (ดับ) mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) |
| T11  | 347  | 42   | Input: remainedSeconds = 250 Output: mTime = 05:47| Input: achievedScore = 42 Output: mSore = 0 |achievedStars = 2 mStar3 => GONE (ดับ) mStar1 => VISIBLE (สว่าง) mStar2 => VISIBLE (สว่าง) | 
| T12❗️ (เนื่องจาก achievedStars หยุดการทำงาน)| 350   | 43  |  Input: remainedSeconds = 250 Output: mTime = 05:50| Input: achievedScore = 43 Output: mSore  = 0| achievedStars = 5 หยุดการทำงาน|


## T9: 'testGetHighStars()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นมาเพื่อตรวจสอบว่า function `getHighStar` คืนค่า HighStars  ถูกต้องตรงกับ expected result

### Interface-Base

* Develop characteristics
  * C1 = Theme id is correct
  * C2 = Difficulty value is correct

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct     | True  | False  |
  | C2: Difficulty value is correct | True  | False  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|------------------------|---------------------------|
  | C1: Theme id is correct          | 1  | -1  |
  | C2: Difficulty value is correct  | 1  | -1  |

### Functionality-Base

* Develop characteristics
  * C1 = สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences

* Partition characteristics

  | Characteristic                                | b1  | b2 |
  |----------------------------------------------|----|----|
  | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences              | True  | False  |
  
* Identify (possible) values

  | Characteristic                                | b1  | b2 |
  |----------------------------------------------|------------------------|---------------------------|
  | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences               |  (1, 1)  |  (-1, 0)  |

### Input domain modelling
1. Identify testable functions 
   * getHighStars()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: theme, difficulty
   * Return type: int
   * Return value: ค่าที่ได้จาก SharedPreferences ถ้าหากไม่พบค่าใน SharedPreferences จะคืนค่า-1
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = Theme id is correct
     * C2 = Difficulty value is correct
     * C3 = สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences
   * Partition characteristics
   
     | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: Theme id is correct                | True  | False  |
     | C2: Difficulty value is correct         | True  | False  |
     | C3: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences         | True  | False  |

   * Identify (possible) values

     | Characteristic                                | b1  | b2 |
     |----------------------------------------------|------------------------|---------------------------|
     | C1: Theme id is correct              | 1 | -1  |
     | C2: Difficulty value is correct         | 1  | -1  |
     | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences               |  (1, 1)  |  (-1, 0)  |

4. Combine partitions into tests
   * Assumption: choose all combinations (ACoC) 
   * Test requirements -- number of tests (lower bound) = 2 * 2 * 2 = 8
   * o	C1:C2:C3 -> (C1B1, C2B1, C3B1) , (C1B1, C1B1, C3B2), (C1B1, C2B2, C3B1), (C1B1, C2B2, C3B2), (C1B2, C2B1, C3B1) , (C1B2, C1B1, C3B2), (C1B2, C2B2, C3B1), (C1B2, C2B2, C3B2)
5. Derive test values
   
     |   Test  | Theme  |  Difficulty | Theme & Difficulty can create keys | Expected result |
     |----- | :-------------: | :-------------: | :-------------: | :-------------: |
     |T1 | 1 | 1  | True  | 5  |
     |T2| 1 | 1  | False  | Invalid  |
     |T3 | 1 | -1  | True| Invalid  |
     |T4 | 1 | -1  | False  | -1  |
     |T5| -1 | 1  | True  | Invalid  |
     |T6 | -1 | 1  | False  | -1  |
     |T7 | -1 | -1  | True| Invalid  |
     |T8 | -1 | -1  | False | -1  |
   * T2 => Invalid Test เพราะว่าค่า Theme & Difficulty ถูกทั้งคู่ต้องสามารถสร้าง key ได้
   * T3 & T5 & T7 => Invalid Test เพราะว่าค่า Theme or Difficulty ไม่ถูกต้องไม่สามารถสร้าง key ได้
     



## T10: 'testgetBestTimeForStage()'

### วัตถุประสงค์
จุดประสงค์ของ test case คือ สร้างขึ้นมาเพื่อตรวจสอบว่า bestTime มีข้อมูลที่เก็บไว้อยู่หรือเปล่า ถ้ามีจะถูกแปลงหน่วยให้เป็น minutes, seconds และ คืนค่ากลับในรูปแบบ String 

### Interface-Base

* Develop characteristics
  * C1 = Theme id is correct
  * C2 = Difficulty value is correct
  * C3 = bestTime value is correct

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct      | True  | False  |
  | C2: Difficulty value is correct  | True  | False   |
  | C3: bestTime value is correct  | True | False  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct     | 1  | -1  |
  | C2: Difficulty value is correct  | 1  | -1  |
  | C3: bestTime value is correct  | 1  | -1  |

### Functionality-Base

* Develop characteristics
  * C1 = สามารถดึงข้อมูลที่ได้มาจาก theme และ difficulty เพื่อหาค่าใน Memory

* Partition characteristics

  | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences | True  | False  |

  
* Identify (possible) values

  | Characteristic                                | b1  | b2 |
     |----------------------------------------------|----|----|
     | C1: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences           | (1,1)  | (-1,0)  |


### Input domain modelling
1. Identify testable functions 
   * getBestTimeForStage()
2. Identify parameters, return types, return values, and exceptional behavior	
   * Parameters: theme, difficulty
   * Return type: String
   * Return value: ค่า bestTime ที่ถูกแปลงแล้ว
   * Exceptional behavior: ??
3. Model the input domain
   * Develop characteristics 
     * C1 = Theme id is correct
     * C2 = Difficulty value is correct
     * C3 = bestTime value is correct
     * C4 = สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct      | True  | False  |
  | C2: Difficulty value is correct  | True  | False   |
  | C3: bestTime value is correct  | True | False  |
  | C4: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences | True  | False  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: Theme id is correct     | 1  | -1  |
  | C2: Difficulty value is correct  | 1  | -1  |
  | C3: bestTime value is correct  | 1  | -1  |
  | C4: สามารถสร้าง key ที่ได้มาจาก Theme และ Difficulty เพื่อหาค่าใน SharedPreferences | (1,1)  | (-1,0)  |

4. Combine partitions into tests
   * Assumption: choose Each Choice Combinations (ECC) 
   * Test requirements -- number of tests = 2
   * C1:C2:C3:C4 -> (C1b1, C2b1, C3b1, C4b1) , (C1b2, C2b2, C3b2, C4b2)
5. Derive test values
   
   |   Test  | Theme  | Difficulty | BestTime | Theme & Difficulty can create keys |  Expected result |
     |----- | :-------------: | :-------------: | :-------------: | :-------------: | :-------------: |
     |T1 | 1 | 1  | 125   | True   | BEST : 02:05   |
     |T2 | -1 | -1  | -125  | False   | BEST : -  |



---
