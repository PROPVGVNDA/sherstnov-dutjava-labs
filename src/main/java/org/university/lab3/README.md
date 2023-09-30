# Лабораторна робота №3

## Функціональність програми

Програма представляє собою просту систему управління замовленнями та кошиками для продуктів. Ця система дозволяє користувачам додавати та видаляти продукти з кошика, створювати замовлення на основі кошика або списку продуктів, а також обробляти замовлення.

## Опис роботи

Програма базується на трьох основних сутностях: Cart, Order та Product.

#### Cart
- Поля:

  - products: Список продуктів у кошику.
- API:

  - getProducts(): Повертає список продуктів у кошику.
  - setProducts(ArrayList<Product> products): Встановлює список продуктів для кошика.
  - addProduct(Product... products): Додає один або декілька продуктів до кошика.
  - removeProduct(Product product): Видаляє продукт з кошика.
#### Order
- Поля:

  - orderId: Унікальний ідентифікатор замовлення.
  - products: Список продуктів у замовленні.
  - status: Статус замовлення (створено, очікує обробки, оброблено).
- API:

  - PlaceOrder(): Розміщує замовлення.
  - ProcessOrder(): Обробляє замовлення.
  - getOrderId(): Повертає ідентифікатор замовлення.
  - getProducts(): Повертає список продуктів у замовленні.
  - setProducts(ArrayList<Product> products): Встановлює список продуктів для замовлення.
  - getStatus(): Повертає статус замовлення.
#### Product
- Поля:

  - id: Унікальний ідентифікатор продукту.
  - name: Назва продукту.
  - price: Ціна продукту.
- API:

  - getId(): Повертає ідентифікатор продукту.
  - setId(int id): Встановлює ідентифікатор продукту.
  - getName(): Повертає назву продукту.
  - setName(String name): Встановлює назву продукту.
  - getPrice(): Повертає ціну продукту.
  - setPrice(double price): Встановлює ціну продукту.

## [Unit Тести](../../../../../test/java/org/university/lab3/README.md)

## Висновок
Навичвся працювати з JUnit5