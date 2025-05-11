# Click Counter

A simple Android application that demonstrates a counter functionality using Jetpack Compose. The app allows users to track the number of times they've clicked a button.

## Features

- Simple and intuitive UI built with Jetpack Compose
- Tracks and displays click count
- Material Design 3 implementation
- Support for light and dark themes

## Screenshots

*Screenshots will be added here*

## Prerequisites

- Android Studio Flamingo (2023.2.1) or newer
- Kotlin 2.0.21 or newer
- Minimum SDK: Android 7.0 (API level 24)
- Target SDK: Android 15 (API level 35)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/ClickCounter.git
cd ClickCounter
```

### Open and Run the Project

1. Open Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to the project directory and click "Open"
4. Wait for the Gradle sync to complete
5. Click the "Run" button (green triangle) or press Shift+F10 to run the app

## Project Structure

```
com.example.clickcounter/
├── MainActivity.kt       # Main entry point with the counter UI
└── ui/
    └── theme/           # Theme configuration
        ├── Color.kt     # Color definitions
        ├── Theme.kt     # Theme setup
        └── Type.kt      # Typography configuration
```

## How It Works

The app uses Jetpack Compose to create a responsive UI with:
- A text display showing the current count
- A button that increments the count when pressed
- State management using `mutableStateOf` to track and update the counter value

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
