package com.mwendwa.jetpackcompose

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mwendwa.jetpackcompose.ui.theme.JETPACKCOMPOSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JETPACKCOMPOSETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(20.dp)
                    ){
                        Column() {
                            ImageCard(painter = painterResource(id = R.drawable.back2),
                                contentDescription = "mycard",title ="this is a nature picture")
                            Spacer(modifier = Modifier.height(10.dp))
                            ImageCard1(painter1 = painterResource(id = R.drawable.back2),
                                contentDescription1 = "mycard1", title2 ="this is a nature picture")
                            Button(onClick = {val intent = Intent(
                                this@MainActivity,ScrollActivity::class.java)
                            startActivity(intent)})
                            {
                                Text(text = "LazyRow")
                                Spacer(modifier = Modifier.height(40.dp))
                            }
                            Button(onClick = {val intent = Intent(this@MainActivity,TopAppActivity::class.java)
                            startActivity(intent)}) {
                                Text(text = "TopAppActivity")

                            }

                            Button(onClick ={val intent = Intent(this@MainActivity,LazyColumnActivity::class.java)
                            startActivity(intent)}) {
                                Text(text = "LazyColumn")
                            }

                    }}
                }
            }
        }
    }
}
@Composable
fun ImageCard(painter: Painter, contentDescription:String,title:String){
    Column() {


        Card(
            modifier = Modifier.wrapContentWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(20.dp),
        ) {
            Box(
                modifier = Modifier.height(200.dp)
            )
            {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart
                )
                {
                    Text(
                        text = title,
                        color = Color.Red,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
@Composable
fun ImageCard1(painter1:Painter,contentDescription1:String,title2:String){
    Column() {


        Card(
            modifier = Modifier.wrapContentWidth(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(20.dp),
        ) {
            Box(
                modifier = Modifier.height(200.dp)
            )
            {
                Image(
                    painter = painter1,
                    contentDescription = contentDescription1,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .padding(15.dp),
                    contentAlignment = Alignment.BottomStart
                )
                {
                    Text(
                        text = title2,
                        color = Color.Red,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageCardPreview(){
    ImageCard(
        painter =  painterResource(id = R.drawable.pexels),
        contentDescription = "mycard",
        title = "this is a nature picture")
}
