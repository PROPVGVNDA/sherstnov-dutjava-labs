# Unit тести до [Лабораторна робота №5](../../../../../main/java/org/university/lab1/README.md)

### Опис тестів:
- `testDeposit` - Для перевірки, що після додавання грошей на рахунок, баланс збільшується на відповідну суму.
- `testNegativeAmountExceptionOnDeposit` - Для перевірки, що спроба поповнити рахунок на від'ємну суму викликає виняток `NegativeAmountException`.
- `testWithdraw` - Для перевірки, що після зняття грошей з рахунка, баланс зменшується на відповідну суму.
- `testInsufficientFundsExceptionOnWithdraw` - Для перевірки, що спроба зняти суму, якої немає на рахунку, викликає виняток `InsufficientFundsException`.
- `testNegativeAmountExceptionOnWithdraw` - Для перевірки, що спроба зняти від'ємну суму викликає виняток `NegativeAmountException`.
- `testCreateAccount` - Для перевірки, що рахунок може бути створено з позитивним початковим депозитом.
- `testNegativeAmountExceptionOnCreateAccount` - Для перевірки, що спроба створити рахунок з від'ємним початковим депозитом викликає виняток `NegativeAmountException`.
- `testFindAccount` - Для перевірки, що рахунок може бути знайдено за його унікальним номером.
- `testAccountNotFoundException` - Для перевірки, що спроба знайти рахунок за неіснуючим номером викликає виняток `AccountNotFoundException`.
- `testTransferMoney` - Для перевірки, що гроші можуть бути переведені з одного рахунка на інший.
- `testInsufficientFundsExceptionOnTransferMoney` - Для перевірки, що спроба перевести суму, якої немає на рахунку відправника, викликає виняток `InsufficientFundsException`.
- `testNegativeAmountExceptionOnTransferMoney` - Для перевірки, що спроба перевести від'ємну суму викликає виняток `NegativeAmountException`.