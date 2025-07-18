package com.example.contactappjc.screens

import android.util.Patterns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.contactappjc.R
import com.example.contactappjc.entity.Contact
import com.example.contactappjc.ui.theme.GreenJC
import com.example.contactappjc.utils.copyUriToInternalStorage
import com.example.contactappjc.viewmodel.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreen(contact: Contact, viewModel: ContactViewModel, navController: NavController) {
    val context = LocalContext.current.applicationContext
    var imageUri by remember { mutableStateOf(contact.image) }
    var name by remember { mutableStateOf(contact.name) }
    var phoneNumber by remember { mutableStateOf(contact.phoneNumber) }
    var email by remember { mutableStateOf(contact.email) }

    var nameError by remember { mutableStateOf(false) }
    var phoneNumberError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    val brush = Brush.verticalGradient(
        listOf(
            Color.Cyan,
            Color.Green,
            Color.Blue)
    )

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            uri?.let { newUri ->
                val internalPath = copyUriToInternalStorage(
                    context,
                    newUri,
                    "${name}_${System.currentTimeMillis()}.jpg"
                )
                internalPath?.let { path -> imageUri = path }
            }
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(text = "Edit Contact", fontSize = 18.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_user_pen),
                            contentDescription = "Edit Contact"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenJC,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(132.dp)
                    .background(brush = brush, shape = CircleShape), // or your preferred size
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Check mark",
                    tint = if(!isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier
                        .padding(6.dp)
                        .border(2.dp, color = if(!isSystemInDarkTheme()) Color.White else Color.Black, CircleShape)
                        .padding(2.dp)
                        .align(Alignment.BottomEnd)
                        .size(24.dp)
                        .background(if(isSystemInDarkTheme()) Color.White else Color.Black, CircleShape)
                        .padding(4.dp)
                        .clickable(onClick = { launcher.launch("image/*") })
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            /*Name*/
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = .15f),
                                Color.Black.copy(alpha = .15f),
                            )
                        )
                    ),
//                        colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = it.isBlank()
                    },
                    isError = nameError,
                    label = { Text(text = "Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.DarkGray,
                        focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    )
                )
            }

            /*Phone Number*/
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = .15f),
                                Color.Black.copy(alpha = .15f),
                            )
                        )
                    ),
//                        colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                TextField(
                    value = phoneNumber,
                    onValueChange = {
                        phoneNumber = it
                        val phoneRegex = Regex("^[6-9]\\d{9}$")
                        phoneNumberError = !phoneRegex.matches(it)
                    },
                    isError = phoneNumberError,
                    label = { Text(text = "Phone Number") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.DarkGray,
                        focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                )
            }

            /*Email*/
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(8.dp),
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = .15f),
                                Color.Black.copy(alpha = .15f),
                            )
                        )
                    ),
//                        colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                TextField(
                    value = email,
                    onValueChange = {
                        email = it
                        emailError = !Patterns.EMAIL_ADDRESS.matcher(it).matches()
                    },
                    isError = emailError,
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedContainerColor = if (!isSystemInDarkTheme()) Color.White else Color.DarkGray,
                        focusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedTextColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedLabelColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        focusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        unfocusedIndicatorColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        cursorColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            val imagePath = System.currentTimeMillis()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(
                        width = 1.dp,
                        shape = CircleShape,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                GreenJC.copy(alpha = .15f),
                                GreenJC.copy(alpha = .15f),
                            )
                        )
                    ),
                colors = CardDefaults.cardColors(GreenJC),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                    var isValid = true

                    // Validate fields
                    if (name.isBlank()) {
                        nameError = true
                        isValid = false
                    }

                    // Phone validation (digits + length 10 + starts with 6-9)
                    val phoneRegex = Regex("^[6-9]\\d{9}$")
                    if (!phoneRegex.matches(phoneNumber)) {
                        phoneNumberError = true
                        isValid = false
                    }
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        emailError = true
                        isValid = false
                    }

                    if (imageUri.equals(null)) {
                        Toast.makeText(context, "Please choose an image", Toast.LENGTH_SHORT)
                            .show()
                        isValid = false
                    }

                    if (isValid) {
                        val updateContact = contact.copy(
                            image = imageUri,
                            name = name.trim(),
                            phoneNumber = phoneNumber.trim(),
                            email = email.trim()
                        )
                        viewModel.updateContact(updateContact)
                        navController.popBackStack()
                    }
                }, colors = ButtonDefaults.buttonColors(GreenJC)) {
                    Text(
                        text = "Edit Contact",
                        color = if (!isSystemInDarkTheme()) Color.White else Color.Black
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContactScreenOld(
    contact: Contact,
    viewModel: ContactViewModel,
    navController: NavController
) {
    val context = LocalContext.current.applicationContext
    var imageUri by remember { mutableStateOf(contact.image) }
    var name by remember { mutableStateOf(contact.name) }
    var phoneNumber by remember { mutableStateOf(contact.phoneNumber) }
    var email by remember { mutableStateOf(contact.email) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            uri?.let { newUri ->
                val internalPath = copyUriToInternalStorage(
                    context,
                    newUri,
                    "${name}_${System.currentTimeMillis()}.jpg"
                )
                internalPath?.let { path -> imageUri = path }
            }
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(text = "Edit Contact", fontSize = 18.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.ic_user_pen),
                            contentDescription = "Edit Contact"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenJC,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUri),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { launcher.launch("image/*") },
                colors = ButtonDefaults.buttonColors(GreenJC)
            ) {
                Text(text = "Choose Image")
            }

            Spacer(modifier = Modifier.height(16.dp))

            /*Name*/
            TextField(
                value = name, onValueChange = { name = it },
                label = { Text(text = "Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            /*Phone Number*/
            TextField(
                value = phoneNumber, onValueChange = { phoneNumber = it },
                label = { Text(text = "Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            /*Email*/
            TextField(
                value = email, onValueChange = { email = it },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            val imagePath = System.currentTimeMillis()
            Button(onClick = {
                val updateContact = contact.copy(
                    image = imageUri,
                    name = name,
                    phoneNumber = phoneNumber,
                    email = email
                )
                viewModel.updateContact(updateContact)
                navController.popBackStack()
            }, colors = ButtonDefaults.buttonColors(GreenJC)) {
                Text(text = "Edit Contact")
            }
        }
    }
}
