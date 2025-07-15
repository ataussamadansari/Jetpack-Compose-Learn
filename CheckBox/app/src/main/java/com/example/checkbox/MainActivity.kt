package com.example.checkbox

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.state.ToggleableState
import com.example.checkbox.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckBoxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CheckboxMinimalExample()
                        Divider()
                        CheckboxParentExample()
                        Divider()
                        AssistChipExample()
                        Divider()
                        FilterChipExample()
                        Divider()
                        InputChipExample("Samad") { Log.d("TAG", "Chip dismissed") }
                    }
                }
            }
        }
    }
}

@Composable
fun CheckboxMinimalExample(modifier: Modifier = Modifier) {
    var checked by remember {
        mutableStateOf(true)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Minimal checkbox")
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
            )
        }

        Text(
            text = if (checked) "Checkbox is checked" else "Checkbox is unchecked"
        )
    }

}

@Composable
fun CheckboxParentExample(modifier: Modifier = Modifier) {
    val childCheckState = remember { mutableStateListOf(false, false, false) }

    val parentState = when {
        childCheckState.all { it } -> ToggleableState.On
        childCheckState.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    childCheckState.forEachIndexed { index, _ ->
                        childCheckState[index] = newState
                    }
                }
            )
        }

        //Child Checkbox
        childCheckState.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = { isChecked ->
                        childCheckState[index] = isChecked
                    }
                )
            }
        }
        if (childCheckState.all { it }) {
            Text(text = "All options selected")
        }
    }
}

@Composable
fun AssistChipExample(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext
    AssistChip(
        onClick = {
            Toast.makeText(context, "Assist chip", Toast.LENGTH_SHORT).show()
        },
        label = { Text(text = "Assist chip") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Localized desc.",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipExample(modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text = "Filter chip")
        },
        selected = selected,
        leadingIcon = {
            if (selected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            } else {
                null
            }
        },
    )
}

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit,
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}