# Jetpack Compose 🚀
## 1.1 Jetpack Compose Kya Hai?
**Jetpack Compose** is a modern UI toolkit for building native Android UIs using Kotlin code only (no XML).

* Declarative UI: UI automatically updates when data changes.

* No XML files: UI is written directly in Kotlin.

* Part of Jetpack libraries by Google.

**📌 Why use it?**

* Less boilerplate code

* Easier to manage state

* Faster UI development

## 1.2 XML vs Compose

| Feature |  XML + View Binding  | Jetpack Compose |
|:-----|:--------:|------:|
| UI Language  | XML | Kotlin |
| Layout updates   | 	Manually via `findViewById`  |   Automatically via state |
| Preview   | _Android Studio XML Preview_ |    Compose Preview Annotation |


## 1.3 @Composable Functions
Har Jetpack Compose UI function ko `@Composable` annotation ke saath likha jata hai.
```kotlin
@Composable
fun MyFirstComposable() {
    Text(text = "Hello Jetpack Compose!")
}
```
* `@Composable` function me UI elements call kar sakte ho.

* Isse XML ki jagah Kotlin code me hi UI banate ho.

## 1.4 `setContent {}` in MainActivity
`MainActivity.kt` me `onCreate()` ke andar `setContent {}` block me tum composable call karte ho.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposable()
        }
    }
}
```

## 1.5 `@Preview` Annotation
Code likhne ke baad bina app run kiye Android Studio me preview dekhne ke liye:

```kt
@Preview(showBackground = true)
@Composable
fun MyPreview() {
    MyFirstComposable()
}
```

## 1.6 Basic UI Elements
```kt
@Composable
fun BasicUI() {
    Column {
        Text(text = "Welcome to Compose")
        Button(onClick = { /* TODO */ }) {
            Text("Click Me")
        }
    }
}
```
* `Text` – shows text

* `Button` – clickable button

* `Column` – vertical layout

* `Row` – horizontal layout

* `Box` – overlap layout (like FrameLayout)

## 1.7 State Hoisting & `remember`
```kt
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    
    Column {
        Text("Count: $count")
        Button(onClick = { count++ }) {
            Text("Increase")
        }
    }
}
```
* `remember` – local state store karta hai

* `mutableStateOf` – reactive value

## 1.8 Modifier
Modifiers se layout ka padding, background, size, etc. control karte hain.

```kt
Text(
    text = "Styled Text",
    modifier = Modifier
        .padding(16.dp)
        .background(Color.Yellow)
        .fillMaxWidth()
)
```
