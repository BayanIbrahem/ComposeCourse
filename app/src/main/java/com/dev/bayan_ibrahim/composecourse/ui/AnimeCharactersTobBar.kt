package com.dev.bayan_ibrahim.composecourse.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.R

@Composable
fun AnimeCharactersTobBar(isList: Boolean, onSwitchView: () -> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = MaterialTheme.colors.primary)
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.temporary_icon),
            tint = MaterialTheme.colors.onPrimary,
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
        )
        AnimeCharactersTobBarSwitchViewButton(isList = isList, onClick = onSwitchView)
    }
}

@Composable
fun AnimeCharactersTobBarSwitchViewButton (
    modifier: Modifier = Modifier,
    isList: Boolean,
    onClick: () -> Unit
) {
    val icon = if(isList) Icons.Filled.GridView else Icons.Filled.ViewList
    IconButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeCharactersTobBarPreviewLight() {
    ComposeCourseTheme(darkTheme = false) {
        var isList by remember { mutableStateOf(true) }
        AnimeCharactersTobBar(true){
            isList = isList.not()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimeCharactersTobBarPreviewDark() {
    ComposeCourseTheme(darkTheme = true) {
        var isList by remember { mutableStateOf(true) }
        AnimeCharactersTobBar(true){
            isList = isList.not()
        }
    }
}
