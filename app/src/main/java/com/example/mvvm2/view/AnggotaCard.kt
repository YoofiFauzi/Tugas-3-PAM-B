package com.example.mvvm2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mvvm2.model.Anggota

@Composable
fun anggotaCard(anggota: Anggota, onClick: (Anggota) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick(anggota) },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            // Gambar/foto anggota, diambil dari resource lokal (folder drawable)
            Image(
                painter = painterResource(anggota.foto),
                contentDescription = "Foto ${anggota.nama}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Column(Modifier.padding(start = 12.dp)) {
                Text(
                    text = anggota.nama,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Prodi: ${anggota.prodi}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Jabatan/Divisi: ${anggota.jabatan}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
