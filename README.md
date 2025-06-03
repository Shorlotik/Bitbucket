# Rail Ninja CLI - Консольное приложение для поиска железнодорожных билетов

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Docker](https://img.shields.io/badge/Docker-supported-success)

Консольное приложение для поиска и сохранения информации о железнодорожных билетах с сайта Rail Ninja.

## 📌 Возможности

- Поиск билетов между городами
- Фильтрация по дате и количеству пассажиров
- Сохранение результатов в CSV формате
- Простое консольное управление
- Готовность к работе в Docker контейнере

## 🚀 Быстрый старт

### Предварительные требования

- Java 11 или выше
- Maven
- Docker (опционально)

### Установка и запуск

1. **Клонирование репозитория**
```bash
git clone https://github.com/yourusername/rail-ninja-cli.git
cd rail-ninja-cli
```

2. **Настройка окружения**
```bash
cp .env.example .env
```
Отредактируйте файл .env, указав ваш API ключ:
```bash
RAIL_NINJA_API_KEY=your_api_key_here
```
3. **Сборка приложения**
```bash
mvn clean package
```
4. **Запуск**
```bash
java -jar target/target/rail-ninja-cli-1.0-SNAPSHOT.jar
```
Использование Docker

Соберите образ:
```bash
docker-compose build
```
Запустите приложение:
```
docker-compose run --rm rail-ninja-cli
```
Использование
После запуска приложения следуйте инструкциям:

Введите город отправления (например: Paris)

Введите город прибытия (например: Lille)

Укажите дату поездки в формате YYYY-MM-DD (например: 2025-06-30)

Введите количество пассажиров (например: 1)

Результаты будут сохранены в CSV файл в папке output.

# Структура проекта
```
rail-ninja-cli/
├── src/                 # Исходный код
├── target/              # Собранные артефакты
├── output/              # Результаты поиска (CSV файлы)
├── .env.example         # Пример файла окружения
├── Dockerfile           # Конфигурация Docker
├── docker-compose.yml   # Конфигурация Docker Compose
└── pom.xml              # Конфигурация Maven
```

Ограничения
1. Для работы требуется API ключ от Rail Ninja

2. Поддерживаются только указанные маршруты

3. Формат даты строго YYYY-MM-DD