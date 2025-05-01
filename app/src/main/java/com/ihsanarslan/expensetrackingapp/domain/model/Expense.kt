package com.ihsanarslan.expensetrackingapp.domain.model

import com.google.firebase.database.IgnoreExtraProperties
import java.util.Date

@IgnoreExtraProperties
data class Expense(
    val id : String = "",
    val userId : String = "",
    val title : String = "",
    val description : String = "",
    val amount : Double = 0.0,
    val date : Date = Date(),
)