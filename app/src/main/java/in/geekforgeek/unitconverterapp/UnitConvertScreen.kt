package `in`.geekforgeek.unitconverterapp

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnitConvert(modifier: Modifier) {

    val (selectedOption, optionSelected) = remember { mutableStateOf(unitList[0]) }
    var inputValue by remember { mutableStateOf(TextFieldValue("")) }
    var unitsList by remember { mutableStateOf(lengthList) }
    var selectedFrom by remember { mutableStateOf(unitsList[0]) }
    var selectedTo by remember { mutableStateOf(unitsList[0]) }
    var expandedFrom by remember { mutableStateOf(false) }
    var expandedTo by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Column(
        Modifier.padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(56.dp))

        Text(
            text = "Pick a Category",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            Modifier.horizontalScroll(rememberScrollState(),true)
        ) {
            unitList.forEach { list ->
                Card(
                    modifier = Modifier.padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if(list == selectedOption) Color.Red else Color.Gray
                    ),
                    onClick = {
                        optionSelected(list)
                        when(list.name){
                            Utility.LENGTH.name -> unitsList = lengthList
                            Utility.AREA.name -> unitsList = areaList
                            Utility.TIME.name -> unitsList = timeList
                            Utility.WEIGHT.name -> unitsList = weightList
                        }

                        selectedTo = unitsList[0]
                        selectedFrom = unitsList[0]
                    }
                ) {
                    Text(text = list.name, Modifier.padding(16.dp),
                        color = if(list == selectedOption) Color.White else Color.Black

                    )
                }
            }

        }

        Text(
            modifier = Modifier.padding(top = 32.dp).fillMaxWidth(),
            text = "Unit Converter",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        // Convert From
        Row {
            Text(
                modifier = Modifier.padding(all = 14.dp),
                text = "Convert From :" ,
                fontSize = 16.sp,
            )

            Box {
                Button(
                    onClick = {
                        expandedFrom = true
                    }
                ) {
                    Text(text = selectedFrom.unitName)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }

                DropdownMenu(
                    expanded = expandedFrom,
                    onDismissRequest = { expandedFrom = false },
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
                ) {
                    unitsList.forEach{ item ->
                        DropdownMenuItem(
                            text = {
                                Text(item.unitName)
                            },
                            onClick = {
                                selectedFrom = item
                                expandedFrom = false
                            }
                        )
                    }
                }
            }

        }

        // Convert To
        Row {
            Text(
                modifier = Modifier.padding(all = 14.dp),
                text = "Convert To :" ,
                fontSize = 16.sp,
            )

            Box {
                Button(
                    onClick = {
                        expandedTo = true
                    }
                ) {
                    Text(text = selectedTo.unitName)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }

                DropdownMenu(
                    expanded = expandedTo,
                    onDismissRequest = { expandedTo = false },
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
                ) {
                    unitsList.forEach{ item ->
                        DropdownMenuItem(
                            text = {
                                Text(item.unitName)
                            },
                            onClick = {
                                selectedTo = item
                                expandedTo = false
                            }
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            label = {
                Text("Enter Value")
            },
            placeholder = {
                Text("Enter Value")
            },
            value = inputValue,
            onValueChange = { input ->
                inputValue = input
            },
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                result = (inputValue.text.toDouble() * selectedTo.unitConstant / selectedFrom.unitConstant).toString()
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            enabled = inputValue.text != ""
        ) {
            Text("CONVERT")
        }

        Text(
            text = "Result : $result",
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

    }

}

@Preview(showBackground = true)
@Composable
fun unitDemo(){
    UnitConvert(Modifier)
}