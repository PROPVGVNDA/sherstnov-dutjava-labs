# Unit тести до [Лабораторна робота №7](../../../../../main/java/org/university/lab7/README.md)

### Опис тестів:
- `testValidOrderCreation`: Перевірка правильності створення замовлення.
- `testOrderWithNullDetails`: Перевірка реакції на спробу створення замовлення без деталей.
- `testOrderWithEmptyDetails`: Перевірка реакції на спробу створення замовлення із порожніми деталями.
- `testOrderWithNegativeProductQuantity`: Перевірка реакції на спробу створення замовлення із від'ємною кількістю продуктів.
- `testSetNullOrderId`: Перевірка реакції на спробу встановити нульовий ідентифікатор замовлення.
- `testSetNullUserId`: Перевірка реакції на спробу встановити нульовий ідентифікатор користувача.
- `testValidProductCreation`: Перевірка правильності створення продукта.
- `testSetNegativePrice`: Перевірка реакції на спробу встановити від'ємну ціну продукту.
- `testSetNegativeStock`: Перевірка реакції на спробу встановити від'ємний запас продукту.
- `testSetNullProductName`: Перевірка реакції на спробу встановити нульове ім'я продукту.
- `testAddProductToCart`: Перевірка правильності додавання продукта до корзини користувача.
- `testRemoveProductFromCart`: Перевірка правильності видалення продукта з корзини користувача.
- `testRemoveNonExistentProductFromCart`: Перевірка реакції на спробу видалити неіснуючий продукт з корзини.
- `testAddNegativeQuantityToCart`: Перевірка реакції на спробу додати від'ємну кількість продукта до корзини.
- `testSetNullUsername`: Перевірка реакції на спробу встановити нульове ім'я користувача.
- `testAddUser` - перевіряє додавання користувача на платформу.
- `testAddUserWithExistingId` - перевіряє спробу додати користувача з існуючим ID.
- `testAddProduct` - перевіряє додавання продукту на платформу.
- `testAddProductWithExistingId` - перевіряє спробу додати продукт з існуючим ID.
- `testCreateOrder` - перевіряє створення замовлення для користувача.
- `testCreateOrderForNonexistentUser` - перевіряє спробу створення замовлення для неіснуючого користувача.
- `testUpdateProductStock` - перевіряє оновлення кількості продукту на складі.
- `testUpdateProductStockForNonexistentProduct` - перевіряє спробу оновити кількість на складі для неіснуючого продукту.
- `testUpdateProductStockToNegativeValue` - перевіряє спробу встановити негативну кількість продукту на складі.
- `testListProductsSortedByName` - перевіряє отримання списку продуктів, відсортованих за назвою.
- `testListProductsSortedByStock` - перевіряє отримання списку продуктів, відсортованих за кількістю на складі.
- `testFilterProductsByAvailability` - перевіряє фільтрацію продуктів за наявністю на складі.