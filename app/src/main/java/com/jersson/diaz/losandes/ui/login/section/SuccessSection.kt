package com.jersson.diaz.losandes.ui.login.section

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.util.Function
import com.jersson.diaz.domain.model.User
import com.jersson.diaz.losandes.R
import com.jersson.diaz.losandes.theme.Blue
import com.jersson.diaz.losandes.theme.Green
import com.jersson.diaz.losandes.theme.GreenAndroid

@Composable
fun SuccessSection(
    validateUser: Function<User, Unit>,
){
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Icon(
        modifier = Modifier.size(72.dp),
        painter = painterResource(id = R.drawable.ic_android_logo),
        contentDescription = null,
        tint = GreenAndroid,
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = user,
        label = {
            Text(text = stringResource(id = R.string.login_user))
        },
        onValueChange = { newText ->
            user = newText
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Blue,
        )
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        label = {
            Text(text = stringResource(id = R.string.login_password))
        },
        onValueChange = { newText ->
            password = newText
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green,
            unfocusedBorderColor = Blue,
        )
    )
    Spacer(modifier = Modifier.height(18.dp))
    Button(
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape = RoundedCornerShape(4.dp),
        enabled = user != "" && password != "",
        onClick = {
            validateUser.apply(
                User(
                    user = user,
                    password = password,
                )
            )
        }
    ) {
        Text(text = stringResource(id = R.string.login_enter))
    }
}