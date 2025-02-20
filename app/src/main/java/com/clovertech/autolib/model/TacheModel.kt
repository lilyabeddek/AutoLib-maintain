package com.clovertech.autolib.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taskModel")
data class TacheModel(
    @PrimaryKey var id: Int,
    var taskModelName: String,
    var steps: List<Step>
) {
}