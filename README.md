# 🛒 E-Commerce Website Automation using Selenium & TestNG

This project automates a full user flow on an e-commerce website (Magento), including:
- Account creation
- Product selection
- Cart interaction
- Checkout with shipping and payment

---

## 📁 Project Structure

E_commerce_Website_Selenium/
│    
├── src/
│ ├── main/
│ │ └── java/pages/
│ │ ├── CreateAccountPage.java
│ │ ├── ShoppingPage.java
│ │ └── ShippingPage.java
│ └── test/
│ └── java/org/example/
│ └── EcommerceTest.java
│
├── pom.xml
└── README.md


---

## 🔧 Technologies Used

| Tool          | Purpose                             |
|---------------|-------------------------------------|
| Java          | Main programming language           |
| Selenium WebDriver | Browser automation             |
| TestNG        | Test framework                      |
| Maven         | Build and dependency management     |
| ChromeDriver  | Chrome browser control              |

---

## 🚀 Scenario Covered

1. **Navigate to Create Account page**
2. **Register a new user**
3. **Navigate through Women > Tops > Hoodies**
4. **Select a hoodie, set size, color, quantity**
5. **Add to cart and proceed to checkout**
6. **Enter shipping details**
7. **Select shipping method**
8. **Proceed to next step**

---

## 🧪 How to Run the Project

### ✅ Prerequisites
- Java JDK 17+ installed
- Maven installed
- Chrome browser installed
- ChromeDriver compatible with your Chrome version
- IntelliJ or any Java IDE

### ✅ Steps
1. Clone the repository
2. Open in your IDE
3. Run `EcommerceTest.java` as TestNG test

---

## ⚙️ Maven Dependencies (pom.xml)

Make sure you have the following dependencies:
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.18.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>

📸 Screenshots 
 

https://github.com/user-attachments/assets/c872ba80-dff3-4132-a48c-15d0b72a28da


✨ Improvements for Future
Add assertions to validate success messages

Integrate with reporting (Allure/Extent)

Parameterize test data (via TestNG DataProvider or external file)

Use PageFactory or a more advanced POM framework

👤 Author
Name: Marina Amine

GitHub: https://github.com/meraamine

📄 License
This project is for learning/demo purposes and does not use a specific license.

1. ✅ Automate the 3 test cases

| Test Case                  | الوصف                                                                 |
| -------------------------- | --------------------------------------------------------------------- |
| TC01 - Create Account      | فتح صفحة إنشاء حساب، وملء البيانات، والضغط على "Create Account"       |
| TC02 - Add Product to Cart | التصفح للقسم، اختيار منتج، تحديد المقاس واللون والكمية، وإضافته للسلة |
| TC03 - Complete Checkout   | ملء بيانات الشحن، اختيار طريقة الشحن، الضغط على Place Order           |




