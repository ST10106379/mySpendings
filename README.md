# mySpendings 

**mySpendings** is an Android budget tracking app that helps users log expenses, organise spending into categories, set monthly budget goals, and visualise their financial habits — all backed by a local Room database and secured with Firebase Authentication.

---

##  Purpose of the App

Managing personal finances can be overwhelming, especially for students and young professionals juggling irregular income and multiple expense categories. **mySpendings** was built to make budgeting simple, visual, and even a little fun.

The app allows users to:
- Securely register and log in
- Log expenses with a date, category, and amount
- Create and manage their own custom categories
- Set minimum and maximum monthly spending goals
- View graphs showing spending per category over a selected period
- Track progress toward budget goals in a clear visual format
- Earn badges and rewards for healthy budgeting habits

---

## Tech Stack

| Component | Technology |
|---|---|
| Language | Kotlin |
| UI | XML Layouts, Material Design Components |
| Navigation | Android Navigation Component (Fragments) |
| Local Database | Room (SQLite) |
| Authentication | Firebase Authentication |
| Charts/Graphs | MPAndroidChart |
| Async | Kotlin Coroutines |
| Build System | Gradle (Kotlin DSL), KSP for annotation processing |
| Version Control | Git & GitHub |

---

## Design Considerations

- **Fragment-based architecture** — A single `MainActivity` hosts all screens (Dashboard, Add Expense, Expenses, Categories, Budget Goals, Analytics, Achievements) via the Navigation Component, giving the app a smooth, single-activity feel with a consistent navigation drawer.

- **Separation of concerns** — Data access is isolated in DAOs (`UserDao`, `ExpenseDao`, `CategoryDao`), with `AppDatabase` as the single Room database instance, keeping UI code free of direct SQL logic.

- **Session management** — `SessionManager` bridges Firebase Authentication with the local Room database, mapping each Firebase user to a local numeric `userId` so that all expenses, categories, and goals remain scoped to the logged-in user.

- **Security** — Authentication is handled entirely by Firebase (email/password), removing the need to store passwords locally and providing a production-grade login system.

- **Visual feedback** — Progress bars, charts, and colour-coded indicators were used throughout so users get immediate visual insight into their spending habits without needing to read numbers closely.

---

##  Custom Features

In addition to the core requirements, two custom features were implemented:

### 1. Firebase Authentication
The original prototype used a locally stored username/password system in Room. For the final submission, this was replaced with **Firebase Authentication** (email & password). This gives the app:
- Secure, industry-standard credential handling
- Real account creation and sign-in flows
- A foundation for future features like password reset or Google Sign-In

 *Look for it in:* `LoginActivity.kt`, `RegisterActivity.kt`, `SessionManager.kt`

### 2. Gamification / Achievements System
A dedicated **Achievements** screen rewards users with badges for good budgeting behaviour, including:
- First Steps — logging your first expense
- Consistent Logger — active 5+ days in a week
- Budget Guardian — staying within the monthly budget
- Category Master — creating 3+ categories
- Expense Explorer — logging 10+ expenses
- Savings Hero — spending 20% under budget
- Streak Master — active 20+ days in the last 30
- Budget Alert — a warning badge when over budget

Each badge includes a progress bar showing how close the user is to unlocking it, encouraging consistent engagement with the app.
 *Look for it in:* `GamificationFragment.kt`, `fragment_gamification.xml`, `item_badge.xml`

---

## Key Screens

- **Dashboard** — overview of recent spending and quick stats
- **Add Expense** — log a new expense with date, category, and amount
- **Expenses** — full list of logged expenses
- **Categories** — create and manage custom spending categories
- **Budget Goals** — set minimum and maximum monthly spending goals
- **Analytics** — graph of spending per category over a selectable period, with min/max goal lines, plus a visual indicator of how well the user is tracking against their goals
- **Achievements** — gamified badges rewarding good budgeting habits

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/mySpendings.git
   ```
2. Open the project in **Android Studio**
3. Add your own `google-services.json` file to the `app/` directory (for Firebase Authentication)
4. Sync Gradle (`File → Sync Project with Gradle Files`)
5. Run the app on an emulator or physical device (`Build → Run`)

---

## Version Control & GitHub

This repository was initialised with a README and developed using regular, incremental commits to track progress feature-by-feature (database setup, UI screens, Firebase integration, analytics, gamification).

**Workflow used:**
- Feature-based commits (e.g. "Add gamification fragment", "Integrate Firebase Auth", "Fix Room/KSP dependency conflict")
- Regular pushes to `main` to keep the remote repository up to date
- Issues encountered (e.g. KAPT → KSP migration, Kotlin/Firebase version conflicts) were resolved and committed as fixes, documenting the development process

---

## Authors

- ST10106379
- ST10233093

---

## 📄 License

This project was developed for academic purposes as part of a Mobile App Development module.
