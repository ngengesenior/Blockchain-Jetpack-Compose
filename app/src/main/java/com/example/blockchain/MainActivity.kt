package com.example.blockchain

import android.os.Bundle
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blockchain.models.Coin
import com.example.blockchain.models.coins
import com.example.blockchain.models.defaultCoin
import com.example.blockchain.ui.theme.BlockchainTheme
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlockchainTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview
@Composable
fun Home() {
    val state = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        drawerContent = {
            DrawerContent()
        },
        scaffoldState = state,
        topBar = {
            TopAppBar(title = { Text(text = "Home") }, navigationIcon = {
                Icon(Icons.Filled.Menu, contentDescription = "", modifier = Modifier.clickable {

                    coroutineScope.launch {
                        state.drawerState.open()
                    }

                })
            })
        },

        bottomBar = {
            BottomAppBar {

                BottomBar()
            }
        },
        content = { CoinsList() }
    )
}

@Composable
fun BottomBar() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        Icon(Icons.Filled.Check, contentDescription = "")
        Icon(Icons.Filled.Star, contentDescription = "")
        Icon(Icons.Filled.Home, contentDescription = "")
        Icon(Icons.Filled.Send, contentDescription = "")
        Icon(Icons.Filled.Create, contentDescription = "")
    }
}


@Preview
@Composable
fun CoinItem(coin: Coin = defaultCoin) {

    Card(
        elevation = 3.dp,
        modifier = Modifier.height(130.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(id = coin.image),
                contentDescription = "",
                modifier = Modifier.size(35.dp)
            )

            Column(
                modifier = Modifier.padding(start = 12.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = coin.name,
                    modifier = Modifier.padding(top = 6.dp),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "US$${coin.myBalanceInDollars}", fontSize = 14.sp)
                Text(
                    text = "${coin.myBalanceInCoins} ${coin.symbol.toUpperCase()}",
                    style = MaterialTheme.typography.caption
                )

            }
            Spacer(modifier = Modifier.weight(0.5f))
            Column(modifier = Modifier) {

                Text(text = "US$${coin.currentPrice}")
                Row() {
                    Text(
                        style = MaterialTheme.typography.caption,
                        text = "${coin.percentageChangeIn24Hours}%",
                        color = if (coin.percentageChangeIn24Hours < 0) Color.Red else Color.Green
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(text = "24 hrs", style = MaterialTheme.typography.caption)
                }

            }


        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun CoinsList() {
    val listState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(state = listState)

    ) {
        VerifyEmailColumn()
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        TotalBalanceView()
        coins.forEach {
            CoinItem(it)
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Composable
fun DrawerContent() {
    Column(modifier = Modifier.padding(start = 8.dp)) {

        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.clickable {  }) {
            Icon(Icons.Filled.AccountBalanceWallet, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Addresses")

        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Icon(Icons.Filled.ShoppingBasket, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Buy Crypto")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Icon(Icons.Filled.AccountBalanceWallet, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Sell Crypto")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Icon(Icons.Filled.Help, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Support")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Icon(Icons.Filled.Air, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Airdrops")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Icon(Icons.Filled.Settings, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Settings")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Icon(Icons.Filled.AccountBalanceWallet, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Exchange")
        }
        
        Spacer(modifier = Modifier.weight(1f))

        Row {
            Icon(Icons.Filled.AccountBalanceWallet, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Pair Web Wallet")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Icon(Icons.Filled.Logout, contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Logout")
        }
        
        Spacer(modifier = Modifier.height(12.dp))

    }
}

@Composable
fun VerifyEmailColumn() {
    Card {

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(12.dp))
            Icon(Icons.Filled.Email, contentDescription = "")
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Verify Your Email Address",style = MaterialTheme.typography.body1,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "You need to confirm your email address so that we can keep you informed about your wallet",
                maxLines = 2,
                style = MaterialTheme.typography.caption)

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = {  },colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Blue,
                contentColor = Color.White),modifier = Modifier.fillMaxWidth()) {
                Text(text = "Verify Email Address")

            }

        }

    }

    
}

@Composable
fun TotalBalanceView() {
    Card() {
        Row(modifier = Modifier.padding(vertical = 16.dp,horizontal = 16.dp)) {

            Column() {
                Text(text = "Total Balance",style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "US$698.27",fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Text(text = "+US10.53 (1.53%)",color = Color.Green,fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "24 hrs",color = Color.LightGray,fontSize = 12.sp)
                }

            }


           RoundedCornerShape(3.dp)
        }

    }
}