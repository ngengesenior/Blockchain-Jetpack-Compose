package com.example.blockchain.models

import androidx.annotation.StringRes
import com.example.blockchain.R

data class Coin(
    val name:String,
    val symbol:String,
    @StringRes val image:Int,
    val currentPrice:Double,
    val myBalanceInDollars:Double = 0.0,
    val myBalanceInCoins:Double = 0.00,
    val percentageChangeIn24Hours:Double
)

val defaultCoin = Coin(
    name = "Bitcoin",
    symbol = "btc",
    image = R.drawable.btc,
    currentPrice = 54805.06,
    myBalanceInDollars = 665.45,
    myBalanceInCoins = 0.01225323,
    percentageChangeIn24Hours = 3.44
)

val coins = listOf<Coin>(
    Coin(
        name = "Bitcoin",
        symbol = "btc",
        image = R.drawable.btc,
        currentPrice = 54805.06,
        myBalanceInDollars = 665.45,
        myBalanceInCoins = 0.01225323,
        percentageChangeIn24Hours = 3.44
    ),
    Coin(name = "Ethereum",
        symbol = "eth",
        image = R.drawable.eth,
        currentPrice = 230.65,
        myBalanceInDollars = 660.04,
        myBalanceInCoins = 2.0,
        percentageChangeIn24Hours = -2.41),
    Coin(name = "Bitcoin Cash",
        symbol = "bch",
        image = R.drawable.bch,
        currentPrice = 539.91,
        myBalanceInDollars = 230.500,
        myBalanceInCoins = 1.2005,
    percentageChangeIn24Hours = 1.26),
    Coin(name = "Stellar",
        symbol = "xlm",
        image = R.drawable.xlm,
        currentPrice = 0.50,
        myBalanceInDollars = 0.0,
        myBalanceInCoins = 1.2005,
        percentageChangeIn24Hours = -3.79),
    Coin(name = "Algorand",
        symbol = "algo",
        image = R.drawable.algo,
        currentPrice = 1.08,
        myBalanceInDollars = 0.0,
        myBalanceInCoins = 0.0,
        percentageChangeIn24Hours = -6.90),
    Coin(name = "USD Digital",
        symbol = "usd-do",
        image = R.drawable.usd,
        currentPrice = 1.08,
        myBalanceInDollars = 0.0,
        myBalanceInCoins = 0.0,
        percentageChangeIn24Hours = 0.00)
    ,

    Coin(name = "Tether",
        symbol = "usdt",
        image = R.drawable.usdt,
        currentPrice = 1.00,
        myBalanceInDollars = 0.0,
        myBalanceInCoins = 0.0,
        percentageChangeIn24Hours = 0.00)
)
