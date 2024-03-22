package com.example.meditationui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.ui.theme.AquaBlue
import com.example.meditationui.ui.theme.Beige3
import com.example.meditationui.ui.theme.BlueViolet2
import com.example.meditationui.ui.theme.BlueViolet3
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DarkerButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.LightGreen3
import com.example.meditationui.ui.theme.LightRed
import com.example.meditationui.ui.theme.OrangeYellow3
import com.example.meditationui.ui.theme.TextWhite

@Composable
fun HomeSCREEN(){
    //overlapping screen box have been created
    Box (modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()){
        Column {
            GreetingSection()

            FeelingSection(chip = listOf("Sweet sleep", "Insomnia", "Depression"))

            CurrentMeditation()






            FeatureSection(features = listOf(Feature("Sleep meditation"),
                Feature("Tips for sleeping"),
                Feature("Night Island"),
                Feature("Calming Sounds")))


        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            BottomMenu(items = listOf(
                BottomMenuContent("Home", R.drawable.home),
                BottomMenuContent("Meditation", R.drawable.lotus),
                BottomMenuContent("Sleep", R.drawable.sleeping),
                BottomMenuContent("Music", R.drawable.music),
                BottomMenuContent("Profile", R.drawable.user)
            ))
        }
    }
}


@Composable
fun GreetingSection(name : String = "Abhay"){

//basically the greeting section will contain to text view and search icon so basically
//row is going to be implemented

    Row (horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)){
                Column(verticalArrangement = Arrangement.Center) {
                        Text(
                            text = "Good Morning, $name",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White,
                            modifier = Modifier.padding(2.dp)
                        )
                    Text(
                        text = "We wish you have a good day!!",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)

                    )

                }
        Icon(painter = painterResource(id =R.drawable.search ),
            contentDescription = "it's a search icon",
            tint = Color.White,
            modifier = Modifier.size(24.dp))
    }
}

@Composable
fun FeelingSection(chip : List<String> ){

    var selectedChipIndex by remember{
        mutableIntStateOf(0)
    }
    LazyRow{
        items(chip.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ){
                Text(text = chip[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun CurrentMeditation(color : Color = LightRed){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
    ){
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Text(
                text = "Meditation 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)){
            Icon(painter = painterResource(id = R.drawable.play) , contentDescription = "it's a play button",
                modifier = Modifier.size(16.dp),
                tint = Color.White)

        }
    }
}

@Composable
fun FeatureSection(features : List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier
                .padding(15.dp)
                .padding(start = 5.dp)

        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
                .weight(1f)
        ) {
            val boxcolors = listOf(Color(0xff9fa5fe),Color(0xff11d79b),Color(0xfff9a27b),Color(0xfff4cf65))
            items(features.size) {index->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(boxcolors[index]),

                    contentAlignment = Alignment.Center
                ) {
                    // Your content for each box goes here
                    Text(
                        text = features[index].title, // Assuming features is a list of data objects
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }

            }
        }
    }
}

@Composable
fun BottomMenu(items:List<BottomMenuContent>,
modifier: Modifier = Modifier,
               activeHighlightColor : Color = ButtonBlue,
               activeTextColor : Color = Color.White,
               inactiveTextColor : Color = AquaBlue,
               initialSelectedItemIndex : Int = 0){
            var selectedItemIndex by remember {
                mutableIntStateOf(initialSelectedItemIndex)
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .background(DeepBlue)
                    .padding(top = 15.dp)
            ) {
                items.forEachIndexed{index, item ->
                    BottomMenuItem(
                        item = item,
                        isSelected = index == selectedItemIndex,
                        activeHighlightColor = activeHighlightColor,
                        activeTextColor = activeTextColor,
                        inactiveTextColor = inactiveTextColor
                    ) {
                        selectedItemIndex = index
                    }
                }

            }
}

@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected : Boolean = false,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    onItemClick:()->Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}