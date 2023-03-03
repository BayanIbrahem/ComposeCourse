package com.dev.bayan_ibrahim.composecourse.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AnimeCharacter(
    @StringRes val name: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val anime: Int,
    @StringRes val description: Int,
)