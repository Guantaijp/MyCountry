package com.example.mycountry.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

//import com.example.mycountry.data.model.CountryModel

import com.welovecrazyquotes.countrylistapp.model.Country

//import com.example.mycountry.domain.item.CountryItem

@Composable
fun HomeScreen() {

    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val countries by homeViewModel.games.collectAsState()

    LazyColumn {
        items(countries) { country: Country ->
            CountryCard(country = country)
        }
    }
}

@Composable
fun CountryCard(country: Country) {

    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        Column {
            AsyncImage(
                model = country.flags.png ,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Text(
                text = country.name.common,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = country.region,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp))


        }
        }
    }
