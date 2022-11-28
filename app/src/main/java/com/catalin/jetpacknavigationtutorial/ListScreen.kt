package com.catalin.jetpacknavigationtutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.catalin.jetpacknavigationtutorial.model.Hero
import com.catalin.jetpacknavigationtutorial.model.HeroesData

//@Composable
////fun ListScreen(navController: NavHostController) {
////    val hero = HeroesData.heroes
////    LazyColumn(modifier = Modifier.background(Color.LightGray)) {
////        items(hero) {
////            Row(modifier = Modifier
////                .padding(4.dp)
////                .fillMaxWidth()
////                .clip(RoundedCornerShape(4.dp))
////                .background(Color.White)
////                .padding(4.dp)
////                .clickable { navController.navigate(Destination.Detail.createRoute(hero)) }
////            ) {
////                Text(text = "Element $hero")
////            }
////        }
////    }
////}

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val heroes = remember { HeroesData.heroes }

    Box(
        modifier = modifier,
    ) {
        LazyColumn {
            items(
                items = heroes,
                itemContent = {
                    HeroListItem(hero = it, modifier, navController)
                })

        }
    }
}

@Composable
fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier,
    navController: NavHostController

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { navController.navigate(Destination.Detail.createRoute(it))}
    ) {
        AsyncImage(
            model = hero.photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = hero.name,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp)

        )
    }
}

