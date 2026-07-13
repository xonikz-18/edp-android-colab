package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

private val Maroon = Color(0xFF771C1B)
private val LightMaroon = Color(0xFFF8ECEC)
private val Background = Color(0xFFF6F3F2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold { padding ->
                    BusinessCard(
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Box(
            modifier = Modifier
                .size(220.dp)
                .offset((-70).dp, (-70).dp)
                .clip(CircleShape)
                .background(Maroon.copy(alpha = 0.12f))
        )

        Box(
            modifier = Modifier
                .size(170.dp)
                .align(Alignment.BottomEnd)
                .offset(60.dp, 60.dp)
                .clip(CircleShape)
                .background(Maroon.copy(alpha = 0.10f))
        )

        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .align(Alignment.Center)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(28.dp)
                ),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Profile Image
                androidx.compose.foundation.Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(
                            4.dp,
                            Maroon,
                            CircleShape
                        )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Nikki U. Pacatang",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Maroon
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "3rd Year IT Student",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.School,
                        contentDescription = null,
                        tint = Maroon,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Liceo de Cagayan University",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Aspiring Android Developer • UI Enthusiast",
                    style = MaterialTheme.typography.bodySmall,
                    color = Maroon.copy(alpha = .75f)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Divider(color = LightMaroon)

                Spacer(modifier = Modifier.height(20.dp))

                ContactCard(
                    Icons.Default.Phone,
                    "+63 926 663 9533"
                )

                Spacer(modifier = Modifier.height(12.dp))

                ContactCard(
                    Icons.Default.Email,
                    "npacatang89487@liceo.edu.ph"
                )
            }
        }
    }
}

@Composable
fun ContactCard(
    icon: ImageVector,
    text: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(LightMaroon)
            .clickable { }
            .padding(
                horizontal = 18.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Maroon),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun BusinessCardDarkPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}

@Preview(
    showBackground = true,
    fontScale = 1.5f,
    name = "Large Font"
)
@Composable
fun BusinessCardLargeFontPreview() {
    MyApplicationTheme {
        BusinessCard()
    }
}