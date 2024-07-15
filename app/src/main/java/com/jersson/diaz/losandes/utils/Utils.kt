package com.jersson.diaz.losandes.utils

import com.jersson.diaz.domain.model.Currency
import com.jersson.diaz.losandes.R
import java.text.DecimalFormat

fun getAccountType(currency: Currency): Int {
    return when(currency){
        Currency.PEN -> R.string.type_account_soles
        Currency.USD -> R.string.type_account_dollars
    }
}

fun getAccountAmount(currency: Currency, amount: Double): String {
    val formatter = DecimalFormat("${currency.symbol} #,##0.00")
    return formatter.format(amount)
}

fun getFormatAmount(amount: Double): String {
    val formatter = DecimalFormat("#,##0.00")
    return formatter.format(amount)
}