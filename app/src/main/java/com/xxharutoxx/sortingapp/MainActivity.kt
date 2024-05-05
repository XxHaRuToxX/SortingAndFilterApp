package com.xxharutoxx.sortingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.xxharutoxx.sortingapp.data.Item
import com.xxharutoxx.sortingapp.data.ListadoCancelado
import com.xxharutoxx.sortingapp.data.datosCancelados
import com.xxharutoxx.sortingapp.data.datosCanceladosContactados
import com.xxharutoxx.sortingapp.data.datosCanceladosNoContactados
import com.xxharutoxx.sortingapp.model.CanceladosViewModel
import com.xxharutoxx.sortingapp.ui.theme.SortingAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel = CanceladosViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SortingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    SortingDataDescendeteAndAscendente()
//                    SortingSimpleData()
//                    ProbandoSorting()
                    obtenerListadoCancelados(
                        liveDatosCancelados = viewModel.liveListadoCancelado,
                        liveDatosCanceladosContactados = viewModel.liveListadoCanceladoConectados,
                        liveDatosCanceladosNoContactados = viewModel.liveListadoCanceladoNoConectados
                    )
                }
            }
        }
    }

    @Composable
    private fun ProbandoSorting() {
        val sortedList = datosCancelados.sortedWith(
            compareByDescending<ListadoCancelado> {
                it.fecha
            }.thenBy {
                it.persNombre
            }
        )
        val valor = remember { mutableStateOf(1) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
        ) {
            Button(
                onClick = { valor.value = 0 },
                modifier = Modifier
                    .weight(2f)
                    .padding(2.dp)
            ) {
                Text(text = "To")
            }
            Button(
                onClick = { valor.value = 1 },
                modifier = Modifier
                    .weight(2f)
                    .padding(2.dp)
            ) {
                Text(text = "Con")
            }
            Button(
                onClick = { valor.value = 2 },
                modifier = Modifier
                    .weight(2f)
                    .padding(2.dp)
            ) {
                Text(text = "No")
            }
            Button(
                onClick = { valor.value = 3 },
                modifier = Modifier
                    .weight(2f)
                    .padding(2.dp)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
            Button(
                onClick = { valor.value = 4 },
                modifier = Modifier
                    .weight(2f)
                    .padding(2.dp)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
            }

        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*itemsIndexed(sortedList) { index, item ->
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }*/
            itemsIndexed(
                when (valor.value) {
                    0 -> datosCancelados
                    1 -> datosCanceladosContactados
                    2 -> datosCanceladosNoContactados
                    else -> datosCancelados
                }
            ) { index, item ->
                Text(text = "${item.persNombre} - ${item.fecha}")
            }
        }
    }

    @Composable
    fun obtenerListadoCancelados(
        liveDatosCancelados: LiveData<List<ListadoCancelado>>,
        liveDatosCanceladosContactados: LiveData<List<ListadoCancelado>>,
        liveDatosCanceladosNoContactados: LiveData<List<ListadoCancelado>>
    ){
        Column {
            val datosCancelados by liveDatosCancelados.observeAsState(initial = emptyList())
            val datosCanceladosContactados by liveDatosCanceladosContactados.observeAsState(initial = emptyList())
            val datosCanceladosNoContactados by liveDatosCanceladosNoContactados.observeAsState(initial = emptyList())

            var text by remember { mutableStateOf(TextFieldValue()) }
            val searchQuery = remember { mutableStateOf("") }
            val valor = remember { mutableStateOf("0") }
            val valorFiltro = remember { mutableStateOf("") }
            val filteredItems = if (searchQuery.value.isEmpty()) {
                datosCancelados
            } else {
                datosCancelados.filter { item ->
                    item.persNombre.contains(searchQuery.value, ignoreCase = true)
                }
            }

            val filteredItemsContactados = if (searchQuery.value.isEmpty()) {
                datosCanceladosContactados
            } else {
                datosCanceladosContactados.filter { item ->
                    item.persNombre.contains(searchQuery.value, ignoreCase = true)
                }
            }

            val filteredItemsNoContactados = if (searchQuery.value.isEmpty()) {
                datosCanceladosNoContactados
            } else {
                datosCanceladosNoContactados.filter { item ->
                    item.persNombre.contains(searchQuery.value, ignoreCase = true)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                Button(
                    onClick = { valor.value = "0"; valorFiltro.value = "" },
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                ) {
                    Text(text = "To")
                }
                Button(
                    onClick = { valor.value = "1"; valorFiltro.value = "" },
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                ) {
                    Text(text = "Con")
                    println("DAto Valor ${valor.value}")
                }
                Button(
                    onClick = { valor.value = "2" },
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                ) {
                    Text(text = "No")
                }
                Button(
                    onClick = { valorFiltro.value = "0" },
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
                    //Menor a Mayor
                }
                Button(
                    onClick = { valorFiltro.value = "1" },
                    modifier = Modifier
                        .weight(2f)
                        .padding(2.dp)
                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
                    //Mayor a Menor
                }

            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val sortedListDescendente = filteredItems.sortedWith(
                    compareByDescending {
                        it.persNombre
                    }
                )
                val sortedListAscendente = filteredItems.sortedWith(
                    compareBy {
                        it.persNombre
                    }
                )
                if(valor.value == "0"){
                    if(valor.value == "0" && valorFiltro.value == "0"){
                        itemsIndexed(items = sortedListAscendente) { index, item ->
                            if (index == filteredItems.lastIndex) {
                                viewModel.getListadoCancelado()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }else if(valor.value == "0" && valorFiltro.value == "1"){
                        itemsIndexed(items = sortedListDescendente) { index, item ->
                            if (index == filteredItems.lastIndex) {
                                viewModel.getListadoCancelado()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }else{
                        itemsIndexed(items = filteredItems) { index, item ->
                            if (index == filteredItems.lastIndex) {
                                viewModel.getListadoCancelado()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }
                }
                else if(valor.value == "1"){
                    val sortedListDescendenteContactados = filteredItemsNoContactados.sortedWith(
                        compareByDescending {
                            it.persNombre
                        }
                    )
                    val sortedListAscendenteNoContactados = filteredItemsNoContactados.sortedWith(
                        compareBy {
                            it.persNombre
                        }
                    )
                    /*itemsIndexed(items = filteredItemsContactados) { index, item ->
                        if (index == filteredItemsContactados.lastIndex) {
                            viewModel.getListadoCanceladoConectados()
                        }
                        Text(text = "${item.persNombre} - ${item.fecha}")
                    }*/
                    if(valor.value == "1" && valorFiltro.value == "0"){
                        itemsIndexed(items = sortedListAscendenteNoContactados) { index, item ->
                            if (index == filteredItems.lastIndex) {
                                viewModel.getListadoCanceladoConectados()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }else if(valor.value == "1" && valorFiltro.value == "1"){
                        itemsIndexed(items = sortedListDescendenteContactados) { index, item ->
                            if (index == filteredItems.lastIndex) {
                                viewModel.getListadoCanceladoConectados()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }else{
                        itemsIndexed(items = filteredItemsContactados) { index, item ->
                            if (index == filteredItemsContactados.lastIndex) {
                                viewModel.getListadoCanceladoConectados()
                            }
                            Text(text = "${item.persNombre} - ${item.fecha}")
                        }
                    }
                }else if(valor.value == "2"){
                    itemsIndexed(items = filteredItemsNoContactados) { index, item ->
                        if (index == filteredItemsNoContactados.lastIndex) {
                            viewModel.getListadoCanceladoNoConectados()
                        }
                        Text(text = "${item.persNombre} - ${item.fecha}")
                    }
                }
            }
        }
    }

    @Composable
    private fun SortingDataDescendeteAndAscendente() {
        val itemList = listOf(
            Item("A", 123),
            Item("B", 32),
            Item("A", 25),
            Item("C", 112),
            Item("C", 54),
            Item("A", 372),
            Item("B", 4),
            Item("C", 10),
            Item("B", 538),
        )
        val sortedList = itemList.sortedWith(
            compareByDescending<Item> {
                it.group
            }.thenBy {
                it.num
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(sortedList) { index, item ->
                Text(text = "${item.group} - ${item.num}")
            }
        }
    }

    @Composable
    private fun SortingSimpleData() {
        val itemList = listOf(
            "A-123",
            "B-032",
            "A-025",
            "C-112",
            "C-054",
            "A-372",
            "B-004",
            "C-010",
            "B-538"
        )
        /*val sortedList = itemList.sortedBy {
                        it.first()
                    }*/
        val sortedList = itemList.sortedWith(
            compareBy<String> {
                it.first()
            }.thenByDescending {
                it.slice(2..4)
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(sortedList) { index, item ->
                Text(text = item)
            }
        }
    }
}
