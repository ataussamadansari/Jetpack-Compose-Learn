package com.example.contactappjc.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.contactappjc.R
import com.example.contactappjc.entity.Contact
import com.example.contactappjc.navigation.Destination
import com.example.contactappjc.ui.theme.GreenJC
import com.example.contactappjc.viewmodel.ContactViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailScreen(
    contact: Contact,
    viewModel: ContactViewModel,
    navController: NavController
) {
    val context = LocalContext.current.applicationContext

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically)
                    ) {
                        Text(text = "Contact Details", fontSize = 18.sp)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Contact Details", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_circle_user),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GreenJC,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Destination.Edit.createRoute(contact.id))
            }, containerColor = GreenJC) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Contact",
                    tint = if (!isSystemInDarkTheme()) Color.White else Color.Black
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
//                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(
                                width = 1.dp,
                                shape = CircleShape,
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = .15f),
                                        Color.Black.copy(alpha = .15f),
                                    )
                                )
                            ),
//                        colors = CardDefaults.cardColors(Color.White),
                        shape = CircleShape,
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(contact.image),
                            contentDescription = contact.name,
                            modifier = Modifier
                                .size(128.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(16.dp),
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = .15f),
                                        Color.Black.copy(alpha = .15f),
                                    )
                                )
                            ),
//                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Name: ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                contact.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(16.dp),
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = .15f),
                                        Color.Black.copy(alpha = .15f),
                                    )
                                )
                            ),
//                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Phone Number: ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                contact.phoneNumber,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(16.dp),
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = .15f),
                                        Color.Black.copy(alpha = .15f),
                                    )
                                )
                            ),
//                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Email: ",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                contact.email,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

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
                            colors = ButtonDefaults.buttonColors(GreenJC),
                            onClick = {
                                viewModel.deleteContact(contact)
                                navController.popBackStack()
                            }) {
                            Text(
                                text = "Delete Contact",
                                color = if (!isSystemInDarkTheme()) Color.White else Color.Black
                            )
                        }
                    }

                }
            }
        }
    }
}