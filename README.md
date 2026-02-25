# PillGuard Android Application

แอพพลิเคชัน Android สำหรับจัดการและติดตามการใช้ยา

## วิธีการติดตั้งและรันโปรเจกต์ (Getting Started)

### 1. การติดตั้ง Android Studio
* ดาวน์โหลดและติดตั้ง **Android Studio** (แนะนำเวอร์ชันล่าสุด) ได้ที่ [developer.android.com/studio](https://developer.android.com/studio)
* ติดตั้ง **Android SDK** และ **Emulator** (หรือเตรียมเครื่องจริง) ให้เรียบร้อย

### 2. การ Import โปรเจกต์เข้า Android Studio
1. เปิดโปรแกรม Android Studio
2. เลือก **Open** (หรือ **File > Open**)
3. ไปยังโฟลเดอร์ที่เก็บโปรเจกต์นี้ (`pillguard`) แล้วกด **OK**
4. รอให้ Android Studio ทำการ **Gradle Sync** เพื่อโหลด dependencies ที่จำเป็นทั้งหมด (ขั้นตอนนี้อาจใช้เวลาสักครู่ ขึ้นอยู่กับความเร็วอินเทอร์เน็ต)

### 3. การรันโปรเจกต์ (Running the App)
1. **เชื่อมต่ออุปกรณ์:**
   - **เครื่องจริง:** เปิดโหมด Developer และ USB Debugging แล้วเชื่อมต่อสาย USB
   - **Emulator:** เปิด Device Manager และ Start Virtual Device ที่สร้างไว้
2. เลือกเมนู **Run > Run 'app'** (หรือกดปุ่มลูกศรสีเขียวที่แถบเครื่องมือด้านบน)
3. เลือกอุปกรณ์ที่ต้องการรัน แล้วรอให้แอพพลิเคชันติดตั้งและเปิดขึ้นมา

---

## โครงสร้างโปรเจกต์ที่สำคัญ
* `app/src/main/java`: ซอร์สโค้ดภาษา Kotlin
* `app/src/main/res/layout`: ไฟล์ Layout (XML) สำหรับหน้าจอต่างๆ
* `app/src/main/res/navigation`: ไฟล์ Navigation Graph สำหรับจัดการลำดับการเปลี่ยนหน้าจอ
