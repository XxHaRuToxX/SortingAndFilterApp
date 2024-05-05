package com.xxharutoxx.sortingapp.model

import androidx.lifecycle.MutableLiveData
import com.xxharutoxx.sortingapp.data.ListadoCancelado

class CanceladosViewModel {
    val liveListadoCancelado = MutableLiveData<List<ListadoCancelado>>()
    val listadoCancelado:MutableLiveData<List<ListadoCancelado>> = liveListadoCancelado
    private var nextPage = 0

    val liveListadoCanceladoConectados = MutableLiveData<List<ListadoCancelado>>()
    private var nextPageConectados = 0

    val liveListadoCanceladoNoConectados = MutableLiveData<List<ListadoCancelado>>()
    private var nextPageNoConectados = 0

    init {
        getListadoCancelado()
        getListadoCanceladoConectados()
        getListadoCanceladoNoConectados()
    }

    fun getListadoCancelado() {
        val listadoCancelado = liveListadoCancelado.value?.toMutableList() ?: mutableListOf()

        when (nextPage) {
            0 -> listadoCancelado.addAll(
                listOf(
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción completada con éxito.",
                        persNombre = "Juan Pérez",
                        ctaCod = "C123456",
                        saldoCap = "5000.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "A+",
                        fecha = "2024-04-05",
                        telefonoContacto = "+1234567890"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error de conexión.",
                        persNombre = "María García",
                        ctaCod = "C789012",
                        saldoCap = "10000.00",
                        prdEstado = "Inactivo",
                        colocNota = "Regular",
                        calificacion = "B-",
                        fecha = "2024-03-04",
                        telefonoContacto = "+9876543210"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Pago realizado correctamente.",
                        persNombre = "Pedro Martínez",
                        ctaCod = "C345678",
                        saldoCap = "3000.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "A",
                        fecha = "2024-01-02",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Fondos insuficientes.",
                        persNombre = "Ana López",
                        ctaCod = "C901234",
                        saldoCap = "200.00",
                        prdEstado = "Activo",
                        colocNota = "Mala",
                        calificacion = "D+",
                        fecha = "2024-01-05",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción exitosa.",
                        persNombre = "Carlos Sánchez",
                        ctaCod = "C567890",
                        saldoCap = "8000.00",
                        prdEstado = "Activo",
                        colocNota = "Excelente",
                        calificacion = "A+",
                        fecha = "2024-04-01",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Cuenta inactiva.",
                        persNombre = "Laura Rodríguez",
                        ctaCod = "C234567",
                        saldoCap = "15000.00",
                        prdEstado = "Inactivo",
                        colocNota = "Regular",
                        calificacion = "C",
                        fecha = "2024-02-30",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Operación completada.",
                        persNombre = "Luis Hernández",
                        ctaCod = "C890123",
                        saldoCap = "600.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "B+",
                        fecha = "2024-03-21",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error de autenticación.",
                        persNombre = "Sofía Gómez",
                        ctaCod = "C456789",
                        saldoCap = "4000.00",
                        prdEstado = "Activo",
                        colocNota = "Mala",
                        calificacion = "D",
                        fecha = "2024-03-05",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción realizada con éxito.",
                        persNombre = "Diego Pérez",
                        ctaCod = "C012345",
                        saldoCap = "12000.00",
                        prdEstado = "Activo",
                        colocNota = "Excelente",
                        calificacion = "A+",
                        fecha = "2024-04-04",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error en el proceso.",
                        persNombre = "Julia Martínez",
                        ctaCod = "C678901",
                        saldoCap = "7000.00",
                        prdEstado = "Activo",
                        colocNota = "Regular",
                        calificacion = "C+",
                        fecha = "2024-04-03",
                        telefonoContacto = "+9988776655"
                    )
                )
            )
        }

        liveListadoCancelado.value = listadoCancelado
        nextPage++
    }

    fun getListadoCanceladoConectados() {
        val listadoCanceladoConectados = liveListadoCanceladoConectados.value?.toMutableList() ?: mutableListOf()

        when (nextPageConectados) {
            0 -> listadoCanceladoConectados.addAll(
                listOf(
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Cuenta inactiva.",
                        persNombre = "Laura Rodríguez",
                        ctaCod = "C234567",
                        saldoCap = "15000.00",
                        prdEstado = "Inactivo",
                        colocNota = "Regular",
                        calificacion = "C",
                        fecha = "2024-02-30",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Operación completada.",
                        persNombre = "Luis Hernández",
                        ctaCod = "C890123",
                        saldoCap = "600.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "B+",
                        fecha = "2024-03-21",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error de autenticación.",
                        persNombre = "Sofía Gómez",
                        ctaCod = "C456789",
                        saldoCap = "4000.00",
                        prdEstado = "Activo",
                        colocNota = "Mala",
                        calificacion = "D",
                        fecha = "2024-03-05",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción realizada con éxito.",
                        persNombre = "Diego Pérez",
                        ctaCod = "C012345",
                        saldoCap = "12000.00",
                        prdEstado = "Activo",
                        colocNota = "Excelente",
                        calificacion = "A+",
                        fecha = "2024-04-04",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error en el proceso.",
                        persNombre = "Julia Martínez",
                        ctaCod = "C678901",
                        saldoCap = "7000.00",
                        prdEstado = "Activo",
                        colocNota = "Regular",
                        calificacion = "C+",
                        fecha = "2024-04-03",
                        telefonoContacto = "+9988776655"
                    )
                )
            )
        }

        liveListadoCanceladoConectados.value = listadoCanceladoConectados
        nextPageConectados++
    }

    fun getListadoCanceladoNoConectados() {
        val listadoCanceladoNoConectados = liveListadoCanceladoNoConectados.value?.toMutableList() ?: mutableListOf()

        when (nextPageNoConectados) {
            0 -> listadoCanceladoNoConectados.addAll(
                listOf(
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción completada con éxito.",
                        persNombre = "Juan Pérez",
                        ctaCod = "C123456",
                        saldoCap = "5000.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "A+",
                        fecha = "2024-04-05",
                        telefonoContacto = "+1234567890"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Error de conexión.",
                        persNombre = "María García",
                        ctaCod = "C789012",
                        saldoCap = "10000.00",
                        prdEstado = "Inactivo",
                        colocNota = "Regular",
                        calificacion = "B-",
                        fecha = "2024-03-04",
                        telefonoContacto = "+9876543210"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Pago realizado correctamente.",
                        persNombre = "Pedro Martínez",
                        ctaCod = "C345678",
                        saldoCap = "3000.00",
                        prdEstado = "Activo",
                        colocNota = "Buena",
                        calificacion = "A",
                        fecha = "2024-01-02",
                        telefonoContacto = "+1122334455"
                    ),
                    ListadoCancelado(
                        respuesta = "No",
                        mensaje = "Fondos insuficientes.",
                        persNombre = "Ana López",
                        ctaCod = "C901234",
                        saldoCap = "200.00",
                        prdEstado = "Activo",
                        colocNota = "Mala",
                        calificacion = "D+",
                        fecha = "2024-01-05",
                        telefonoContacto = "+9988776655"
                    ),
                    ListadoCancelado(
                        respuesta = "Sí",
                        mensaje = "Transacción exitosa.",
                        persNombre = "Carlos Sánchez",
                        ctaCod = "C567890",
                        saldoCap = "8000.00",
                        prdEstado = "Activo",
                        colocNota = "Excelente",
                        calificacion = "A+",
                        fecha = "2024-04-01",
                        telefonoContacto = "+1122334455"
                    )
                )
            )
        }

        liveListadoCanceladoNoConectados.value = listadoCanceladoNoConectados
        nextPageNoConectados++
    }
}