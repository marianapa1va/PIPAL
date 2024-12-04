package com.example.pipal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image as Image
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import com.example.pipal.ui.theme.PIPALTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PIPALTheme {
                AppNavigation()
            }
            }
        }
    }


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tela_inicial"
    ) {
        composable("tela_inicial") { TelaInicial(navController) }
        composable("login") { TelaLogin(navController) }
        composable("cadastra-se") { TelaCadastro(navController) }
        composable("confirmar"){ Menu(navController) }
        composable("área do circulo") { Circulo(navController) }
        composable("área do cubo") { Cubo(navController) }
        composable("área do retangulo") { Retangulo(navController) }
        composable("área do romboedro") { Romboedro(navController) }
        composable("área do triângulo") { Triangulo(navController) }
        composable("área do losango") { Losango(navController) }
        composable("área do quadrado") { Quadrado(navController) }
        composable("área do cubóide") { Cuboide(navController) }
        composable("cadastro realizado") { TelaDeCadastroRealizado(navController) }
    }
}

@Composable
fun TelaInicial(navController: NavHostController) {
    val corBotao1 = Color(0xFF0CBCCC)
    val corBotao2 = Color(0xFF107ACC)


    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de background da tela inicial",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 70.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo do Pipal",
                modifier = Modifier
                    .size(210.dp)
                    .offset(y = 45.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Image(
                painter = painterResource(id = R.drawable.pipal),
                contentDescription = "Nome do aplicativo",
                modifier = Modifier
                    .offset(y = 5.dp)
                    .offset(x = 10.dp)
                    .size(100.dp)
            )
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 165.dp)
        ) {
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = corBotao1)
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("cadastra-se") },
                modifier = Modifier
                    .width(200.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = corBotao2)
            ) {
                Text(
                    text = "Cadastrar-se",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 19.sp
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLogin(navController: NavHostController) {

    val cor2 = Color(0xFF0CBCCC)
    val corbox = Color(0xFF3775A5)
    val cor = Color(0xFF95E5EC)
    val corbotao = Color(0xFF2652B2)


    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mostrarSenha by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de background da tela inicial",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo do Pipal",
                modifier = Modifier
                    .size(230.dp)
                    .padding(40.dp)
                    .offset(y = 40.dp)
            )

            Text(
                text = "Boas-vindas!",
                color = cor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(
                        color = corbox,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedTextColor = Color.Black,
                        containerColor = cor,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        cursorColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    visualTransformation = if (mostrarSenha) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { mostrarSenha = !mostrarSenha }) {
                            val iconId = if (mostrarSenha) R.drawable.eye_icon else R.drawable.eye
                            Icon(
                                painter = painterResource(id = iconId),
                                contentDescription = if (mostrarSenha) "Esconder senha" else "Mostrar senha",
                                tint = Color.DarkGray
                            )
                        }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = cor2,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = { navController.navigate("confirmar") },
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(corbotao)
                ) {
                    Text(
                        text = "Cadastrar",
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )

                }
            }


        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCadastro(navController: NavHostController) {

    val cor3 = Color(0xFF0CBCCC)
    val corbox = Color(0xFF3775A5)
    val cor = Color(0xFF95E5EC)

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var mostrarSenha by remember { mutableStateOf(false) }
    var mostrarConfirmarSenha by remember { mutableStateOf(false) }

    @Composable
    fun CampoTexto(
        value: String,
        onValueChange: (String) -> Unit,
        label: String,
        isPassword: Boolean = false,
        mostrarSenha: Boolean = false,
        onToggleSenha: () -> Unit = {}
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            visualTransformation = if (isPassword)
                if (mostrarSenha) VisualTransformation.None else PasswordVisualTransformation()
            else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = onToggleSenha) {
                        val iconId = if (mostrarSenha) R.drawable.eye_icon else R.drawable.eye
                        Icon(
                            painter = painterResource(id = iconId),
                            contentDescription = if (mostrarSenha) "Esconder senha" else "Mostrar senha",
                            tint = Color.DarkGray
                        )
                    }
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = cor,
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedLabelColor = Color.Black
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cor)
    ) {
        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de background da tela inicial",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo do Pipal",
                modifier = Modifier
                    .size(230.dp)
                    .padding(40.dp)
                    .offset(y = 40.dp)
            )

            Text(
                text = "Faça parte da nossa comunidade!",
                fontWeight = FontWeight.Bold,
                color = cor3,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .background(color = corbox, shape = RoundedCornerShape(20.dp))
                    .padding(20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CampoTexto(value = nome, onValueChange = { nome = it }, label = "Nome")
                    Spacer(modifier = Modifier.height(15.dp))
                    CampoTexto(value = email, onValueChange = { email = it }, label = "E-mail")
                    Spacer(modifier = Modifier.height(15.dp))
                    CampoTexto(
                        value = senha,
                        onValueChange = { senha = it },
                        label = "Senha",
                        isPassword = true,
                        mostrarSenha = mostrarSenha,
                        onToggleSenha = { mostrarSenha = !mostrarSenha }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    CampoTexto(
                        value = confirmarSenha,
                        onValueChange = { confirmarSenha = it },
                        label = "Confirmar senha",
                        isPassword = true,
                        mostrarSenha = mostrarConfirmarSenha,
                        onToggleSenha = { mostrarConfirmarSenha = !mostrarConfirmarSenha }
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = { navController.navigate("cadastro realizado") },
                        modifier = Modifier
                            .width(200.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(cor3)
                    ) {
                        Text(
                            text = "Cadastrar",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp
                        )
                    }

                }
            }

        }


    }
}


@Composable
fun Menu(navController: NavHostController) {
    val corBotao = Color(0xFF107ACC)
    val cor = Color(0xFF004173)
    val cor3 = Color(0xFF95E5EC)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de background da tela",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Escolha qual forma que deseja calcular a área:",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp)
            )

            Button(
                onClick = {navController.navigate("área do circulo")},
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Circulo",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do cubo") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Cubo",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do retangulo") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Retângulo",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do romboedro") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Roboedro",
                    fontWeight = FontWeight.Medium,
                    color = cor3,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do triângulo") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Triângulo",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do losango") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Losango",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do quadrado") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Quadrado",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("área do cubóide") },
                modifier = Modifier
                    .width(300.dp)
                    .height(58.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(corBotao)
            ) {
                Text(
                    text = "Cubóide",
                    color = cor3,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Circulo(navController: NavHostController) {

    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var raio by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Por favor, insira o raio do círculo abaixo:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = raio,
                onValueChange = { raio = it },
                label = { Text("Digite o raio do círculo") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val raioDouble = raio.toDoubleOrNull()
                    if (raioDouble != null) {
                        area = Math.PI * raioDouble * raioDouble
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do Círculo: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cubo(navController: NavHostController) {

    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var lado by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas utilizadas para calcular",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Por favor, insira o lado do cubo abaixo:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = lado,
                onValueChange = { lado = it },
                label = { Text("Digite o lado do cubo") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val ladoDouble = lado.toDoubleOrNull()
                    if (ladoDouble != null) {
                        area = 6 * ladoDouble * ladoDouble
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do Cubo: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Retangulo(navController: NavHostController) {

    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas utilizadas para calcular",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Por favor, insira os valores do retângulo abaixo:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = largura,
                onValueChange = { largura = it },
                label = { Text("Digite a largura do retângulo") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Digite a altura do retângulo") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val larguraDouble = largura.toDoubleOrNull()
                    val alturaDouble = altura.toDoubleOrNull()
                    if (larguraDouble != null && alturaDouble != null) {
                        area = larguraDouble * alturaDouble
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do retângulo: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Romboedro(navController: NavHostController) {

    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var lado by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Por favor, insira o valor do lado do Romboedro abaixo:",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = lado,
                onValueChange = { lado = it },
                label = { Text("Digite o lado do Romboedro") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val ladoDouble = lado.toDoubleOrNull()
                    if (ladoDouble != null) {
                        area = 6 * ladoDouble * ladoDouble
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área total do Romboedro: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Triangulo(navController: NavHostController) {

    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var base by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Cálculo da área do Triângulo",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = base,
                onValueChange = { base = it },
                label = { Text("Digite a base do Triângulo") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Digite a altura do Triângulo") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val baseDouble = base.toDoubleOrNull()
                    val alturaDouble = altura.toDoubleOrNull()

                    if (baseDouble != null && alturaDouble != null) {
                        area = (baseDouble * alturaDouble) / 2
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do Triângulo: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Losango(navController: NavHostController) {
    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var diagonalMaior by remember { mutableStateOf("") }
    var diagonalMenor by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Cálculo da área do Losango",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = diagonalMaior,
                onValueChange = { diagonalMaior = it },
                label = { Text("Digite a diagonal maior") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = diagonalMenor,
                onValueChange = { diagonalMenor = it },
                label = { Text("Digite a diagonal menor") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val diagonalMaiorDouble = diagonalMaior.toDoubleOrNull()
                    val diagonalMenorDouble = diagonalMenor.toDoubleOrNull()

                    if (diagonalMaiorDouble != null && diagonalMenorDouble != null) {
                        area = (diagonalMaiorDouble * diagonalMenorDouble) / 2
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do losango: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quadrado(navController: NavHostController) {
    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var lado by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Cálculo da área do Quadrado",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = lado,
                onValueChange = { lado = it },
                label = { Text("Digite o lado do Quadrado") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val ladoDouble = lado.toDoubleOrNull()
                    if (ladoDouble != null) {
                        area = ladoDouble * ladoDouble
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área do Quadrado: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cuboide(navController: NavHostController) {
    val cor1 = Color(0xFF107ACC)
    val cor2 = Color(0xFF004173)
    val cor3 = Color(0xFF0CBCCC)
    val cor4 = Color(0xFF95E5EC)

    var comprimento by remember { mutableStateOf("") }
    var largura by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de fundo das telas utilizadas para calcular",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Cálculo da área do Cubóide",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))


            TextField(
                value = comprimento,
                onValueChange = { comprimento = it },
                label = { Text("Digite o comprimento") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor =  Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = largura,
                onValueChange = { largura = it },
                label = { Text("Digite a largura") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Digite a altura") },
                modifier = Modifier.fillMaxWidth(0.8f),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = cor1,
                    focusedIndicatorColor = cor2,
                    unfocusedIndicatorColor = cor3,
                    focusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val comprimentoDouble = comprimento.toDoubleOrNull()
                    val larguraDouble = largura.toDoubleOrNull()
                    val alturaDouble = altura.toDoubleOrNull()

                    if (comprimentoDouble != null && larguraDouble != null && alturaDouble != null) {
                        area = 2 * (comprimentoDouble * larguraDouble +
                                comprimentoDouble * alturaDouble +
                                larguraDouble * alturaDouble)
                    } else {
                        area = null
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = cor3,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(text = "Calcular Área")
            }

            Spacer(modifier = Modifier.height(16.dp))

            area?.let {
                Text(
                    text = "Área total do Cubóide: %.2f".format(it),
                    color = cor4,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun TelaDeCadastroRealizado(navController: NavHostController) {
    val cor4 = Color(0xFF95E5EC)




    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.teste3),
            contentDescription = "Imagem de background da tela de cadastro realizado",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = {
                navController.navigate("confirmar") {
                    popUpTo("cadastro realizado") { inclusive = true }
                }
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Fechar",
                tint = Color.White
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 70.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo do Pipal",
                modifier = Modifier
                    .size(190.dp)
                    .offset(y = 45.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Image(
                painter = painterResource(id = R.drawable.pipal),
                contentDescription = "Nome do aplicativo",
                modifier = Modifier
                    .offset(y = 5.dp)
                    .offset(x = 10.dp)
                    .size(85.dp)
            )

            Spacer(modifier = Modifier.height(19.dp))

            Text(
                text = "Cadastro realizado com sucesso!",
                color = cor4,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(19.dp))

            Image(
                painter = painterResource(id = R.drawable.check_),
                contentDescription = "Aprovação do cadastro",
                modifier = Modifier.size(70.dp)
            )



        }
    }
}




