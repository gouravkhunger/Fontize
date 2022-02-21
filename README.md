<div align="center">
<h1>Fontize Android Library</h1>

<a href="https://android-arsenal.com/api?level=23" target="blank">
    <img src="https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat" alt="Fontize Android Library Licence" />
</a>
<a href="https://jitpack.io/#GouravKhunger/Fontize" target="blank">
    <img src="https://jitpack.io/v/GouravKhunger/Fontize.svg" alt="Fontize Android Library Licence" />
</a>
<a href="https://github.com/gouravkhunger/Fontize/blob/main/LICENSE" target="blank">
    <img src="https://img.shields.io/github/license/gouravkhunger/Fontize" alt="Fontize Android Library Licence" />
</a>
<a href="https://github.com/gouravkhunger/Fontize/stargazers" target="blank">
    <img src="https://img.shields.io/github/stars/gouravkhunger/Fontize" alt="Fontize Android Library Stars"/>
</a>
<a href="https://github.com/gouravkhunger/Fontize/fork" target="blank">
    <img src="https://img.shields.io/github/forks/gouravkhunger/Fontize" alt="Fontize Android Library Forks"/>
</a>
<a href="https://github.com/gouravkhunger/Fontize/issues" target="blank">
    <img src="https://img.shields.io/github/issues/gouravkhunger/Fontize" alt="Fontize Android Library Issues"/>
</a>
</div>

<div align="center">
    <sub>Built with ❤︎ by
        <a href="https://github.com/gouravkhunger">Gourav Khunger</a>
    </sub>
</div>

<br />

Fontize is an Android library, written in kotlin, that enables your android app have multiple fonts for your `TextView`s
and switch  between them in a jiffy!

A quick demo:

<div align="center">
    <img src="https://raw.githubusercontent.com/gouravkhunger/Fontize/main/media/demo.gif" alt="Fontize Android Library Demo GIF" height="500" />
</div>

## Adding Fontize to your project

Include jitpack in your root `build.gradle` file.

```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

And add it's dependency to your app level `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.gouravkhunger:Fontize:1.0.1"
}
```

Sync the project and you'll have imported Fontize successfully.

## Start using Fontize

Make sure you have all your fonts in the `res/font/` directory. Support for font files in the `assets` folder will ship soon!

Rename all the `TextView`s or `AppCompatTextView`s in your project to `com.github.gouravkhunger.fontize.FontizeTextView` - You don't have to change anything else, and the view would still perform the same :)

Before:

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/switch_font_to"
    android:layout_marginTop="150dp"
    android:textSize="18sp"/>
```

After:

```xml
<com.github.gouravkhunger.fontize.FontizeTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/switch_font_to"
    android:layout_marginTop="150dp"
    android:textSize="18sp"/>
```

To set up a default font for the `TextView`s that should load at the startup, add this line to the beginning of your launcher activity:

```kotlin
Fontize(this).setDefaultFont(R.font.exo_2) // replace with the font you desire
```

To update the font for all of your app, simple call this line from anywhere inside the app:

```kotlin
Fontize(this).updateFont(R.font.zen_old_mincho) // updates fontFamily of all the TextViews throughout app
```

**Note**:

- `this` must be an Acitvity or Application context.
- This requires recreation of the activity, which can be done by `recreate()`, or prompt the user to relaunch the app to make the changes take effect.

## How does it work?

Fontize saves the resource ID of the font you provide to `SharedPreferences`. It extends `AppCompatTextView` class to inherit all the properties of a `TextView`, but overrides the default inflating behaviour. It applies the typography when the view is inflated.

### Only `TextViews`?
I'll try to add support for other views in the future. Contributions are always welcome.


## 🛡 License

This project is [`MIT`](https://github.com/gouravkhunger/Fontize/blob/main/LICENSE) Licensed.

```
MIT License

Copyright (c) 2021 Gourav Khunger

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

There are some fonts used in the demo app, their licenses are available [here](https://github.com/gouravkhunger/Fontize/tree/main/font-licenses).

---

<div align="center">
Fontize needs a ⭐ from you =)
</div>
