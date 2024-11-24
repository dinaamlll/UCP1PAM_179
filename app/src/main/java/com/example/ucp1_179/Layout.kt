package com.example.ucp1_179

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Layout(modifier: Modifier = Modifier) {
        TampilanHeader()
        var origin by remember { mutableStateOf("") }
        var departure by remember { mutableStateOf("") }
        var arrival by remember { mutableStateOf("") }

        var dataorigin by remember { mutableStateOf("") }
        var datadeparture by remember { mutableStateOf("") }
        var dataarrival by remember { mutableStateOf("") }


        var transportation by remember { mutableStateOf("") }
        var datatransportation by remember { mutableStateOf("") }
        val dataTr = listOf("Bus", "Ship", "Train", "Plane")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Plan Your Adventures",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp

        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Let's plan exquisite adventure",
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp

        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = origin,
            onValueChange = { origin = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {
                Text("Origin")
            },
            placeholder = {
                Text("Masukkan Asal Anda")
            }
        )
        Row {
            dataTr.forEach { selectedTR ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = transportation == selectedTR,
                        onClick = {
                            transportation = selectedTR
                        })
                    Text(selectedTR)
                }

            }
        }

        TextField(
            value = departure,
            onValueChange = { departure = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            label = {
                Text("Departure")
            },
            placeholder = {
                Text("Masukkan Tanggal Kedatangan Anda")
            }
        )

        TextField(
            value = arrival,
            onValueChange = { arrival = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            label = {
                Text("Arrival")
            },
            placeholder = {
                Text("Masukkan Tanggal Kedatangan Anda")
            }
        )
        Button(onClick = {
            dataorigin = origin
            datadeparture = departure
            dataarrival = arrival
            datatransportation = transportation
        }, modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Simpan")
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Blue)
        ) {
            Column {
                TampilData(
                    judul = "Origin",
                    isinya = dataorigin
                )
                TampilData(
                    judul = "Departure",
                    isinya = datadeparture
                )

                TampilData(
                    judul = "Arrival",
                    isinya = dataarrival
                )
                TampilData(
                    judul = "Transportation",
                    isinya = datatransportation
                )
            }
        }
    }
}
@Composable
fun TampilData(
    judul: String,
    isinya: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(
            isinya,
            modifier = Modifier.weight(2f)
        )
    }
}
@Composable
fun TampilanHeader() {
    Box(
        modifier = Modifier.fillMaxWidth()
            .background(Color.Blue)
            .padding(50.dp)

    ) {
        Row {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painterResource(R.drawable.logoumy),
                    contentDescription = null
                )



            }

        }
    }
    }
