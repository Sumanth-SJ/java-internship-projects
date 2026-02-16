# 📘 Project Documentation

## 1️⃣ Introduction

This project simulates a basic E-Commerce system using Java and OOP principles.

---

## 2️⃣ System Architecture

Product (Abstract)
    ↑
ElectronicsProduct
ClothingProduct
BookProduct

ShoppingCart → Contains CartItems
Order → Contains ShoppingCart

---

## 3️⃣ UML Class Diagram (Text Version)

Product
- id
- name
- price
- stockQuantity
+ calculateDiscount()
+ getFinalPrice()

ElectronicsProduct
ClothingProduct
BookProduct

CartItem
- Product
- quantity

ShoppingCart
- List<CartItem>

Order
- orderId (static counter)
- cart
- finalAmount

---

## 4️⃣ Algorithms

Cart Total Calculation:
FOR each item in cart
    total += item.getItemTotal()

Add Item:
IF product exists
    increase quantity
ELSE
    add new item

---

## 5️⃣ Testing Cases

| Test Case | Expected Result |
|-----------|----------------|
| Add Product | Successfully added |
| View Cart | Correct total shown |
| Checkout | Order ID generated |

---

## 6️⃣ Conclusion

This project demonstrates real-world application of OOP concepts in Java.
