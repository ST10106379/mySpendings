# MySpendings 

A personal *Budget Tracker Android App* built with Kotlin and Android Studio. MySpendings helps users manage their finances by tracking expenses, setting budget goals, and organizing spending by category — all stored locally on the device.

---

## Features

- *User Login* — Secure access to the app using a username and password
- *Expense Categories* — Create and manage custom categories to organize expense and budget entries
- *Expense Entries* — Log detailed expense entries including date, start and end times, description, and category
- *Photo Attachments* — Optionally attach a photograph to any expense entry for reference
- *Budget Goals* — Set a minimum and maximum monthly spending goal to stay on track
- *Expense List* — View all expense entries for a user-selectable time period, with the ability to access any attached photos directly from the list
- *Category Spending Summary* — View the total amount spent per category over a user-selectable period
- *Offline Storage* — All data is saved locally using RoomDB, ensuring the app works fully offline without needing an internet connection

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Primary programming language |
| Android Studio | Development environment |
| RoomDB | Local database for offline data persistence |
| SQLite | Underlying database engine |
| Android Jetpack | Navigation, ViewModel, LiveData |

---

## Getting Started

### Prerequisites
- Android Studio (latest version recommended)
- Android device or emulator running API 21 or higher
- JDK 8 or above

### Installation

1. Clone the repository:
   bash
   git clone https://github.com/your-ST10106379/mySpendings.git
   
2. Open the project in *Android Studio*
3. Let Gradle sync and resolve all dependencies
4. Run the app on an emulator or physical Android device

---

## How to Use

1. *Log in* with your username and password
2. *Create categories* to group your expenses (e.g. Food, Transport, Entertainment)
3. *Add expense entries* with a date, time range, description, and category — optionally attach a photo
4. *Set monthly budget goals* — define a minimum and maximum spending target
5. *View your expenses* by selecting a date period to filter the list
6. *Check category totals* to see how much you've spent per category over any selected period

---

## Project Structure


mySpendings/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/myspendings/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── fragments/
│   │   │   │   ├── database/
│   │   │   │   └── models/
│   │   │   └── res/
│   │   │       ├── layout/
│   │   │       └── navigation/
├── build.gradle.kts
└── README.md


---

## License

This project was developed as part of a practical assessment for *The Independent Institute of Education (IIE) © 2026*.
