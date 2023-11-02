# Лабораторна робота №9

## Функціональність програми

Програма представляє собою інструмент для взаємодії з API і конвертації JSON-відповідей в таблиці Excel. Завдяки цьому інструменту користувач може легко отримати дані з API і оформити їх у вигляді зрозумілої таблиці Excel.

## Опис роботи

Програма базується на трьох основних класах: ApiService, DataEndpoint та JsonExcelConverter.

#### ApiService
- Поля:
  - API_KEY: Ключ доступу для API.
  - ENDPOINT: Базовий URL кінцевої точки API.
- API:
  - callApi(String path, String arguments): Виконує запит до API і повертає відповідь у форматі рядка.
  - constructUrl(String path, String arguments): Створює URL для запиту.
  - setupConnection(URL url): Налаштовує з'єднання до API.
  - processResponse(HttpURLConnection connection): Обробляє відповідь з API та повертає її у форматі рядка.
#### DataEndpint
- Поля:
  - endpoint: URL кінцевої точки API.
  - key: Ключ доступу до API.
  - sheetName: Назва робочого аркушу у Excel.
  - arguments: Додаткові параметри для запиту.
- API:
  - getEndpoint(): Повертає URL кінцевої точки.
  - getKey(): Повертає ключ доступу.
  - getSheetName(): Повертає назву робочого аркушу.
  - getArguments(): Повертає додаткові параметри для запиту.
#### JsonExcelConverter
- API:
  - Convert(String jsonInput, String filename, String dataArrayKey, String sheetName): Конвертує JSON-дані у файл Excel.
  - getOrCreateWorkbook(String filename): Отримує існуючий робочий зошит або створює новий.
  - verifySheetDoesNotExist(Workbook workbook, String sheetName): Перевіряє наявність робочого аркушу у зошиті.
  - extractDataArrayFromJson(String jsonInput, String dataArrayKey): Видобуває масив даних з JSON.
  - createAndFillHeaderRow(Sheet sheet, JSONObject firstItem): Створює і заповнює заголовковий рядок робочого аркуша.
  - populateSheetWithData(Sheet sheet, JSONArray dataArray): Заповнює робочий аркуш даними з JSON.
  - adjustColumnsWidth(Sheet sheet, int columnCount): Налаштовує ширину стовпців робочого аркуша.
  - writeFile(Workbook workbook, String filePath): Записує файл Excel.

## [Unit Тести](../../../../../test/java/org/university/lab9/README.md)

## Висновок
Навчився працювати з зовнішніми API, з обробкою JSON відповідей і зберіганням даних в excel таблицях