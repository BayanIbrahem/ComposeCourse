package com.dev.bayan_ibrahim.composecourse.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.domain.model.AnimeCharacter
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

@Composable
fun AnimeCharacterListCard(modifier: Modifier = Modifier, character: AnimeCharacter) {
    var expanded by remember { mutableStateOf(false)}
    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow,
                )
            )
//            .background(color = MaterialTheme.colors.surface)
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                AnimeCharacterListCardImage(imageRes = character.imageRes)
                AnimeCharacterListCardInfo(
                    modifier = Modifier.weight(1f),
                    name = stringResource(id = character.name),
                    anime = stringResource(id = character.anime),
                )
               AnimeCharacterListCardIconButton(modifier = Modifier, expand = expanded, onClick = {
                   expanded = expanded.not()
               })
            }
            if (expanded) {
                AnimeCharacterListCardExtraInfo(description = stringResource(id = character.description))
            }
        }

    }
}

@Composable
fun AnimeCharacterListCardImage(modifier: Modifier = Modifier, @DrawableRes imageRes: Int) {
    Image(
        modifier = modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun AnimeCharacterListCardInfo(modifier: Modifier = Modifier, name: String, anime: String) {
    Column(
        modifier = modifier
            .padding(top = 16.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
//            color = MaterialTheme.colors.onSurface,
        )
        Text(
            text = anime,
            style = MaterialTheme.typography.caption,
//            color = MaterialTheme.colors.onSurface,
        )
    }
}

@Composable
fun AnimeCharacterListCardExtraInfo(description: String) {
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = description,
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Justify,
//        color = MaterialTheme.colors.onSurface,
    )
}

@Composable
fun AnimeCharacterListCardIconButton (modifier: Modifier = Modifier, onClick: () -> Unit, expand: Boolean) {
    val icon = if (expand) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore
    val description = if (expand) "tab to expand less" else "tab to expand more"
    Box(
        modifier = modifier
            .height(132.dp)
            .clickable {
                onClick()
            }
            .padding(end = 16.dp, bottom = 16.dp, top = 16.dp, start = 8.dp),
    ) {
        Icon (
            modifier = Modifier
                .align(Alignment.BottomEnd),
            imageVector = icon,
            contentDescription = description,
//            tint = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview (showBackground = true)
@Composable
fun AnimeCharacterListCardPreviewLight() {
    ComposeCourseTheme(darkTheme = false) {
        AnimeCharacterListCard(
            character = AnimeCharacter(
                name = R.string.anime_name_0,
                anime = R.string.anime_0,
                description = R.string.anime_description_0,
                imageRes = R.drawable.levi_ackerman
            ),
        )
    }
}
@Preview (showBackground = true)
@Composable
fun AnimeCharacterListCardPreviewDark() {
    ComposeCourseTheme(darkTheme = true) {
        AnimeCharacterListCard(
            character = AnimeCharacter(
                name = R.string.anime_name_0,
                anime = R.string.anime_0,
                description = R.string.anime_description_0,
                imageRes = R.drawable.levi_ackerman
            ),
        )
    }
}
