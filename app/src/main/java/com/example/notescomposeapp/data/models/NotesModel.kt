package com.example.notescomposeapp.data.models

import java.io.Serializable
import java.util.UUID

data class NotesModel (
    val notesId:String= UUID.randomUUID().toString(),
    val title:String,
    val description:String
):Serializable