# iMusica Compose Project

This is an app that showcases various functionalities and best practices of Jetpack Compose. It interacts with the Reddit API, displaying a list of posts. The app is highly regionalizable, with support for multiple languages and various screen sizes.

## Features

1. **Remote API communication**: The app communicates with the public Reddit API to fetch a list of posts.
2. **Localization**: The app supports multiple languages and allows users to change the app's language.
3. **Support for different screen sizes**: The app is optimized for screen sizes between 320dp and 960dp.
4. **Component Customization**: Various components have been customized.
5. **Notifications**: The app sends a notification to the user after 20 seconds of inactivity.
6. **Loading animation**: An animation is displayed while the data is loaded from the API.
7. **Camera Access**: Users can take a picture that will be displayed on the language change screen.
8. **Material Design**: The app follows Material Design principles.

## Installation

Clone this repository and import it into Android Studio. To run the app on your device, follow [these instructions](https://developer.android.com/studio/run).

## Usage

On the first screen, you'll see a list of Reddit posts.

In the top bar, you can access the configuration screen, where you can change the app's language and take a picture.

If you remain inactive for more than 20 seconds, the app will send you a notification.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

*Read this in other languages: [Português](README.pt.md)*