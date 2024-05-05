package com.xxharutoxx.sortingapp.Design

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomCardGestion(
    nameAndLastName: String = "",
    pagare:String = "",
    montoUOtro:String = "",
    fechaPagare:String = "",
    TEAOCuotaUOtro:String = "",
    nota:String="",
    calificacion:String = "",
    numeroTelefono: String = "",
    contactoWhatsapp: String = "",
    mostrarEspaciado:Boolean = false
){
    val ctx = LocalContext.current
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFFFFFFF),
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp),
//        shadowElevation = 10.dp
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.wrapContentSize(),
                    color = Color(0xFFFFFFFF)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = nameAndLastName,
                            fontSize =  18.sp,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(6f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(65.dp))
                        Icon(
//                        painter = painterResource(id = R.drawable.cerdito),
                            imageVector = Icons.Outlined.Search,
                            tint = Color(0xFFCACACA),
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Pagaré: ${pagare}",
                    color = Color(0xFF9F9F9F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = montoUOtro,
                        fontSize =  12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF9F9F9F),
                        fontStyle = FontStyle.Italic,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .width(2.dp)
                            .background(Color(0xFF9F9F9F))
                            .height(15.dp)
//                            .weight(0.002f)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = fechaPagare,
                        fontSize =  12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF9F9F9F),
                        fontStyle = FontStyle.Italic,
                    )

                    if (mostrarEspaciado){
                        Spacer(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .background(Color(0xFF9F9F9F))
                                .height(15.dp)
//                            .weight(0.002f)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                    }else{
                        Spacer(modifier = Modifier.width(0.dp))
                    }
                    Text(
                        text = TEAOCuotaUOtro,
                        fontSize =  12.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color(0xFF9F9F9F),
                        fontStyle = FontStyle.Italic,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(4f)
                    ) {
                        Text(
                            text = "Nota: ${nota}",
                            fontSize =  11.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Spacer(modifier = Modifier.weight(2f))
                    OutlinedButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        onClick = { /*TODO*/ },
                        modifier = Modifier.weight(5f)
                    ) {
                        Text(
                            text = "Calif: ${calificacion}",
                            fontSize =  11.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Spacer(modifier = Modifier.weight(3f))

                    Icon(
//                        painter = painterResource(id = R.drawable.cerdito),
                        imageVector = Icons.Outlined.Phone,
                        tint = Color(0xFFCACACA),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                val u = Uri.parse("tel: $numeroTelefono")
                                val i = Intent(Intent.ACTION_DIAL, u)
                                try {
                                    ctx.startActivity(i)
                                } catch (s: SecurityException) {
                                    Toast
                                        .makeText(ctx, "An error occurred", Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                            .weight(1.5f)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clickable {
                                ctx.startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            java.lang.String.format(
                                                "https://api.whatsapp.com/send?phone=%s&text=%s",
                                                contactoWhatsapp,
                                                "Hola ${nameAndLastName.split(" ")[0]}"
                                            )
                                        )
                                    )
                                )
                            }
                            .weight(1.5f)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomSearchBar(){
//    SearchBar("Buscar")
    CustomCardGestion(
        nameAndLastName = "EMPRESA DE TRANSPORTE APU MARCARANI SOCIEDAD COMERCIAL DE RESPONSABILIDAD LIMITADA",
        pagare = "10651012598764",
        montoUOtro = "Monto Canelado: S/. 199.00",
        fechaPagare = "Fecha: 11/02/2024",
        TEAOCuotaUOtro = "",
        nota = "",
        calificacion = "",
        numeroTelefono = "934567609",
        contactoWhatsapp = "",
        mostrarEspaciado = true
    )
//    CustomExpandableMenu()
}

