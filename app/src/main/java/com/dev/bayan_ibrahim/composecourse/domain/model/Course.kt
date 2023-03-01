package com.dev.bayan_ibrahim.composecourse.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dev.bayan_ibrahim.composecourse.R

data class Course (
    @StringRes val nameStringResource: Int,
    @DrawableRes val imageDrawableResource: Int,
    val associatedCourses: Int
)

object DataSource {
    val courses = listOf(
        Course(nameStringResource =  R.string.architecture, associatedCourses = 58,  imageDrawableResource = R.drawable.architecture),
        Course(nameStringResource =  R.string.crafts,       associatedCourses = 121, imageDrawableResource = R.drawable.crafts),
        Course(nameStringResource =  R.string.business,     associatedCourses = 78,  imageDrawableResource = R.drawable.business),
        Course(nameStringResource =  R.string.culinary,     associatedCourses = 118, imageDrawableResource = R.drawable.culinary),
        Course(nameStringResource =  R.string.design,       associatedCourses = 423, imageDrawableResource = R.drawable.design),
        Course(nameStringResource =  R.string.fashion,      associatedCourses = 92,  imageDrawableResource = R.drawable.fashion),
        Course(nameStringResource =  R.string.film,         associatedCourses = 165, imageDrawableResource = R.drawable.film),
        Course(nameStringResource =  R.string.gaming,       associatedCourses = 164, imageDrawableResource = R.drawable.gaming),
        Course(nameStringResource =  R.string.drawing,      associatedCourses = 326, imageDrawableResource = R.drawable.drawing),
        Course(nameStringResource =  R.string.lifestyle,    associatedCourses = 305, imageDrawableResource = R.drawable.lifestyle),
        Course(nameStringResource =  R.string.music,        associatedCourses = 212, imageDrawableResource = R.drawable.music),
        Course(nameStringResource =  R.string.painting,     associatedCourses = 172, imageDrawableResource = R.drawable.painting),
        Course(nameStringResource =  R.string.photography,  associatedCourses = 321, imageDrawableResource = R.drawable.photography),
        Course(nameStringResource =  R.string.tech,         associatedCourses = 118, imageDrawableResource = R.drawable.tech)
    )
}
