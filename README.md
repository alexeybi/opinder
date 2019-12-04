![](./img/opinder.gif)

# Opinder

Opinder app in Kotlin

## General information

This app is the test project for building a native Android app with Kotlin.
Opinder is the voting app where users can vote on different subjects within their social circle.

## Currently implemented features include

* Getting current votes from the api using coroutines for optimization
* Seeing the results with RecylerView

## Installation and running

The app can be launched with the emulator from Android Studio (any API starting with 23)
or the apk file can be manually installed to an android phone with `$ adb install path_to_apk`
after it's compiled.

## The following libraries were used (not including Kotlin libs and extensions)

 * [Retrofit](https://square.github.io/retrofit/) - HTTP client
 * [Moshi](https://github.com/square/moshi) - JSON parser
 * [Glide](https://github.com/bumptech/glide) - Images management

