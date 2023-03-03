package com.dev.bayan_ibrahim.composecourse.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.domain.model.AnimeCharacter
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

@Composable
fun AnimeCharacterGridCard(modifier: Modifier = Modifier, character: AnimeCharacter) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow,
                )
            )
            .width(IntrinsicSize.Max)
//            .background(color = MaterialTheme.colors.surface)
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column {
            AnimeCharacterGridCardImage(imageRes = character.imageRes)
            Row (
                modifier = Modifier
//                    .width(IntrinsicSize.Max),
            ){
                AnimeCharacterGridCardInfo(
                    name = stringResource(id = character.name),
                    anime = stringResource(id = character.anime),
                )
                Spacer(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp))
                AnimeCharacterGridCardIconButton(modifier = Modifier, expand = expanded, onClick = {
                    expanded = expanded.not()
                })
            }
            if (expanded) {
                AnimeCharacterGridCardExtraInfo(description = stringResource(id = character.description))
            }
        }

    }
}

@Composable
fun AnimeCharacterGridCardImage(modifier: Modifier = Modifier, @DrawableRes imageRes: Int) {
    Image(
        modifier = modifier
            .padding(16.dp)
            .aspectRatio(ratio = 1f)
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun AnimeCharacterGridCardInfo(modifier: Modifier = Modifier, name: String, anime: String) {
    Column(
        modifier = modifier
            .padding(start = 16.dp),
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = anime,
            style = MaterialTheme.typography.body2,
        )
    }
}

@Composable
fun AnimeCharacterGridCardExtraInfo(description: String) {
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = description,
        style = MaterialTheme.typography.caption,
    )
}

@Composable
fun AnimeCharacterGridCardIconButton (modifier: Modifier = Modifier, onClick: () -> Unit, expand: Boolean) {
    val icon = if (expand) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore
    val description = if (expand) "tab to expand less" else "tab to expand more"
    IconButton(onClick = onClick) {
        Icon (
            modifier = Modifier,
//                .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
//                .size(48.dp),
            imageVector = icon,
            contentDescription = description,
//            tint = MaterialTheme.colors.primary,
        )
    }
//    Box(
//        modifier = modifier
//            .clickable {
//                onClick()
//            }
//            .padding(end = 16.dp, bottom = 16.dp, top = 16.dp, start = 8.dp),
//    ) {
//        Icon (
//            modifier = Modifier
//                .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
//                .size(48.dp),
////                .align(Alignment.BottomEnd),
//            imageVector = icon,
//            contentDescription = description,
//            tint = MaterialTheme.colors.primary,
//        )
//    }
}

@Preview(showBackground = false)
@Composable
fun AnimeCharacterGridCardPreviewLight() {
    ComposeCourseTheme(darkTheme = false) {
        AnimeCharacterGridCard(
            character = AnimeCharacter(
                name = R.string.anime_name_0,
                anime = R.string.anime_0,
                description = R.string.anime_description_0,
                imageRes = R.drawable.levi_ackerman
            ),
        )
    }
}
@Preview(showBackground = false)
@Composable
fun AnimeCharacterGridCardPreviewDark() {
    ComposeCourseTheme(darkTheme = true) {
        AnimeCharacterGridCard(
            character = AnimeCharacter(
                name = R.string.anime_name_0,
                anime = R.string.anime_0,
                description = R.string.anime_description_0,
                imageRes = R.drawable.levi_ackerman
            ),
        )
    }
}
