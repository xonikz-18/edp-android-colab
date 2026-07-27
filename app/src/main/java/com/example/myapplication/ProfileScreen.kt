package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import android.content.res.Configuration

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .border(2.dp, MaterialTheme.colorScheme.onPrimary, CircleShape),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "NP",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.headlineSmall
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "NIKKI U. PACATANG",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "BSIT 3-1",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                InfoRow(
                    icon = Icons.Default.Person,
                    label = "Full Name",
                    value = "NIKKI U. PACATANG"
                )

                InfoRow(
                    icon = Icons.Default.Person,
                    label = "Course",
                    value = "Bachelor of Science in Information Technology"
                )

                InfoRow(
                    icon = Icons.Default.Person,
                    label = "Section",
                    value = "BSIT 3-1"
                )

                InfoRow(
                    icon = Icons.Default.Phone,
                    label = "Mobile Number",
                    value = "+63 926 663 9533"
                )

                InfoRow(
                    icon = Icons.Default.Email,
                    label = "Email Address",
                    value = "npacatang89487@liceo.edu.ph"
                )

            }

        }

    }

}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

        }

    }

}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun ProfileScreenLightPreview() {
    MyApplicationTheme {
        ProfileScreen()
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfileScreenDarkPreview() {
    MyApplicationTheme {
        ProfileScreen()
    }
}