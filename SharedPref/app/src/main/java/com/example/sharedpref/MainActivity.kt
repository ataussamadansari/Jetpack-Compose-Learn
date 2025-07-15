package com.example.sharedpref

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sharedpref.ui.theme.SharedPrefTheme
import com.example.sharedpref.utils.PrefManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val prefManager = PrefManager(this)

            SharedPrefTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (prefManager.isLogin()) {
                        HomeScreen(modifier = Modifier.padding(innerPadding))
                    } else {
                        LoginScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    val prefManager = PrefManager(context)

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }

    var nameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Login", fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(16.dp))

        /*Name*/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                name = it
                nameError = it.isBlank()
            },
            isError = nameError,
            label = {
                Text(text = "Name")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Person, contentDescription = null
                )
            },
            singleLine = true,
            placeholder = {
                Text("John Doe")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        if (nameError) {
            Text("Name is required", color = Color.Red, fontSize = 11.sp)
        }
        /*Email*/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
                emailError = !Patterns.EMAIL_ADDRESS.matcher(it).matches()
            },
            isError = emailError,
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Email, contentDescription = null
                )
            },
            singleLine = true,
            placeholder = {
                Text("example@gmail.com")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        if (emailError) {
            Text("Invalid email address", color = Color.Red, fontSize = 11.sp)
        }
        /*Password*/
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
                passwordError = it.length < 6
            },
            isError = passwordError,
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock, contentDescription = null
                )
            },
            trailingIcon = {
                val image =
                    if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                }
            },
            singleLine = true,
            placeholder = {
                Text("********")
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        if (passwordError) {
            Text("Password must be at least 6 characters", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                nameError = name.isBlank()
                emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                passwordError = password.length < 6

                if (!nameError && !emailError && !passwordError) {
                    prefManager.getUserData(name, email, password, true)
                }
            }
        ) {
            Text("Login")
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    val prefManger = PrefManager(context)

    val userdata = prefManger.getUserData()

    val formattedText = buildString {
        userdata.forEach { (key, value) ->
            append("$key: $value\n")
        }
    }

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Get User Data", fontSize = 30.sp)

        Text(text = formattedText)

        Button(onClick = {
            showDialog = true

        }) {
            Text(text = "LogOut")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(text = "Confirm Logout")
                },
                text = {
                    Text(text = "Are you sure you want to log out?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            prefManger.clearAllData()
                            showDialog = false
                        }
                    ) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
    }
}