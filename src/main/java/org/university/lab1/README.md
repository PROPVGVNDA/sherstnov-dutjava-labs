# Лабораторна робота №1

## Функціональність програми

Програма представляє собою систему управління бібліотекою, де можна додавати, видаляти та знаходити книги за їх назвою. Кожна книга має такі атрибути, як назва, автор, ISBN та рік публікації.

## Опис роботи

Програма базується на двох основних сутностях: Book та Library.

#### Book
- Поля:

  - title: Назва книги.
  - author: Автор книги.
  - isbn: Міжнародний стандартний номер книги.
  - publicationYear: Рік публікації книги.
- API:

  - getTitle(): Отримати назву книги.
  - getAuthor(): Отримати автора книги.
  - getIsbn(): Отримати ISBN книги.
  - getPublicationYear(): Отримати рік публікації книги.
  - toString(): Повертає рядкове представлення книги.
#### Library
- Поля:

  - books: Список всіх книг у бібліотеці.
- API:

  - AddBook(Book book): Додати книгу до бібліотеки.
  - DeleteBookByIsbn(String isbn): Видалити книгу за ISBN.
  - FindBookByTitle(String title): Знайти книгу за назвою.
  - ListBooks(): Вивести список всіх книг у бібліотеці.

## [Unit Тести](../../../../../test/java/org/university/lab1/README.md)

## Висновок
Познайомився з Java