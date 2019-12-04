![](./img/opinder.gif)

# Opinder

Opinder app in Kotlin (WIP)

## General information

This app is the on-going test project for building a native Android app with Kotlin.
Opinder is the voting app where users can vote on different subjects within their social circle.

## Currently implemented features include

* Getting current votes from the api using coroutines for optimization
* Voting on a specific card (**currently unavailable**)
* Seeing the results with RecylerView

## Installation and running

The app can be launched with the emulator from Android Studio (any API starting with 23?) 
or the apk file can be manually installed to an android phone with `$ adb install path_to_apk` 
after it's compiled.

## Motivation and reasoning

This is initially a university semester project.
I decided to use exclusively Kotlin for this projects for several reasons:
  - The syntax is way nicer and concise in comparison with Java
  - Null Safety when dealing with NullPointerExceptions
  - Kotlin might be the future for Android, thus it's definitely worth learning

The app initially was supposed to use 'tinder-like' swipes to submit a vote. I intentionally opted 
for not using any external libraries to implement it as for me it's a learning project only.
The only exceptions are Retrofit, Moshi, and Glide - which are de facto the standard libraries 
for these kind of tasks at the moment. I don't currently use branching on Git for the app as
it's very small and basic.

## The following libraries were used (not including Kotlin libs and extensions)

 * [Retrofit](https://square.github.io/retrofit/) - HTTP client
 * [Moshi](https://github.com/square/moshi) - JSON parser 
 * [Glide](https://github.com/bumptech/glide) - Images management
 
