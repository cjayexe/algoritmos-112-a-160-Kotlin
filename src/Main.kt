import kotlin.math.sqrt
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.PI

fun lerDouble(msg: String): Double {
    print(msg)
    return readln().replace(",", ".").toDouble()
}

fun lerInt(msg: String): Int {
    print(msg)
    return readln().toInt()
}

fun lerTexto(msg: String): String {
    print(msg)
    return readln()
}

fun algoritmo112() {
    val a = lerDouble("Primeiro numero: ")
    val b = lerDouble("Segundo numero: ")
    println("Menor: ${if (a < b) a else b}")
}

fun algoritmo113() {
    val a = lerDouble("Primeiro numero: ")
    val b = lerDouble("Segundo numero: ")
    if (a < b) println("Ordem crescente: $a, $b")
    else println("Ordem crescente: $b, $a")
}

fun algoritmo114() {
    val a = lerDouble("Primeiro numero: ")
    val b = lerDouble("Segundo numero: ")
    if (a > b) println("Ordem decrescente: $a, $b")
    else println("Ordem decrescente: $b, $a")
}

fun algoritmo115() {
    val x = lerDouble("Valor de X: ")
    val y = lerDouble("Valor de Y: ")
    if (x > y) {
        println("Quadrado do menor: ${y * y}")
        if (x >= 0) println("Raiz quadrada do maior: ${sqrt(x)}")
        else println("Nao e possivel calcular a raiz quadrada do maior numero.")
    } else if (y > x) {
        println("Quadrado do menor: ${x * x}")
        if (y >= 0) println("Raiz quadrada do maior: ${sqrt(y)}")
        else println("Nao e possivel calcular a raiz quadrada do maior numero.")
    } else println("Numeros iguais.")
}

fun algoritmo116() {
    val a = lerDouble("Primeiro numero: ")
    val b = lerDouble("Segundo numero: ")
    val c = lerDouble("Terceiro numero: ")
    println("Maior: ${maxOf(a, b, c)}")
}

fun algoritmo117() {
    val a = lerDouble("Primeiro numero: ")
    val b = lerDouble("Segundo numero: ")
    val c = lerDouble("Terceiro numero: ")
    var maior = a
    if (b > maior) maior = b
    if (c > maior) maior = c
    println("Maior: $maior")
}

fun algoritmo118() {
    val valores = doubleArrayOf(
        lerDouble("Primeiro numero: "),
        lerDouble("Segundo numero: "),
        lerDouble("Terceiro numero: ")
    )
    valores.sort()
    println("Ordem crescente: ${valores.joinToString(", ")}")
}

fun algoritmo119() {
    val valores = doubleArrayOf(
        lerDouble("Primeiro numero: "),
        lerDouble("Segundo numero: "),
        lerDouble("Terceiro numero: ")
    )
    valores.sortDescending()
    println("Ordem decrescente: ${valores.joinToString(", ")}")
}

fun algoritmo120() {
    val valores = doubleArrayOf(
        lerDouble("Primeiro numero: "),
        lerDouble("Segundo numero: "),
        lerDouble("Terceiro numero: ")
    ).sorted()
    println("Maior: ${valores[2]}")
    println("Intermediario: ${valores[1]}")
    println("Menor: ${valores[0]}")
}

fun algoritmo121() {
    val n = IntArray(5) { lerInt("Digite o ${it + 1} numero inteiro: ") }
    if (n.toSet().size != 5) {
        println("Os cinco numeros devem ser diferentes.")
    } else {
        println("Maior: ${n.maxOrNull()}")
        println("Menor: ${n.minOrNull()}")
    }
}

fun algoritmo122() {
    val a = lerDouble("Primeiro lado: ")
    val b = lerDouble("Segundo lado: ")
    val c = lerDouble("Terceiro lado: ")
    if (a > 0 && b > 0 && c > 0 && a < b + c && b < a + c && c < a + b)
        println("Podem ser lados de um triangulo.")
    else println("Nao podem ser lados de um triangulo.")
}

fun algoritmo123() {
    val a = lerDouble("Primeiro lado: ")
    val b = lerDouble("Segundo lado: ")
    val c = lerDouble("Terceiro lado: ")
    if (a <= 0 || b <= 0 || c <= 0 || a >= b + c || b >= a + c || c >= a + b) {
        println("As medidas nao formam um triangulo.")
    } else if (a == b && b == c) println("Triangulo equilatero.")
    else if (a == b || a == c || b == c) println("Triangulo isosceles.")
    else println("Triangulo escaleno.")
}

fun algoritmo124() {
    val lados = doubleArrayOf(
        lerDouble("Primeiro lado: "),
        lerDouble("Segundo lado: "),
        lerDouble("Terceiro lado: ")
    )
    if (lados.any { it <= 0 } ||
        lados[0] >= lados[1] + lados[2] ||
        lados[1] >= lados[0] + lados[2] ||
        lados[2] >= lados[0] + lados[1]) {
        println("As medidas nao formam um triangulo.")
    } else {
        lados.sort()
        val somaQuadrados = lados[0] * lados[0] + lados[1] * lados[1]
        val maiorQuadrado = lados[2] * lados[2]
        when {
            kotlin.math.abs(maiorQuadrado - somaQuadrados) < 0.000001 ->
                println("Triangulo retangulo.")
            maiorQuadrado > somaQuadrados -> println("Triangulo obtusangulo.")
            else -> println("Triangulo acutangulo.")
        }
    }
}

fun algoritmo125() {
    val idade = lerInt("Digite sua idade: ")
    when {
        idade < 0 -> println("Idade invalida.")
        idade > 65 -> println("Maior de 65 anos.")
        idade >= 18 -> println("Maior de idade.")
        else -> println("Menor de idade.")
    }
}

fun algoritmo126() {
    val x = lerDouble("Digite um numero: ")
    when {
        x == 5.0 -> println("O numero e 5.")
        x == 200.0 -> println("O numero e 200.")
        x == 400.0 -> println("O numero e 400.")
        x in 500.0..1000.0 -> println("Intervalo 500-1000.")
        else -> println("Fora dos escopos anteriores.")
    }
}

fun algoritmo127() {
    val nome = lerTexto("Nome do aluno: ")
    val n1 = lerDouble("Nota da PR1: ")
    val n2 = lerDouble("Nota da PR2: ")
    val media = (n1 + n2) / 2
    println("Aluno: $nome")
    println("PR1: $n1 | PR2: $n2 | Media: $media")
    println(when {
        media >= 7 -> "Aprovado"
        media < 3 -> "Reprovado"
        else -> "Em prova final"
    })
}

fun algoritmo128() {
    val verbo = lerTexto("Digite um verbo no infinitivo: ").trim()
    if (verbo.length < 2 || !verbo.endsWith("r", ignoreCase = true)) {
        println("Verbo nao esta no infinitivo.")
    } else {
        when (verbo[verbo.length - 2].lowercaseChar()) {
            'a' -> println("Verbo da 1a conjugacao.")
            'e', 'o' -> println("Verbo da 2a conjugacao.")
            'i' -> println("Verbo da 3a conjugacao.")
            else -> println("Terminacao nao reconhecida.")
        }
    }
}

fun algoritmo129() {
    val salario = lerDouble("Digite o salario: ")
    val desconto = when {
        salario <= 600 -> 0.0
        salario <= 1200 -> salario * 0.20
        salario <= 2000 -> salario * 0.25
        else -> salario * 0.30
    }
    println("Desconto do INSS: R$ %.2f".format(desconto))
}

fun algoritmo130() {
    val valor = lerDouble("Valor de compra do produto: ")
    val venda = if (valor < 20) valor * 1.45 else valor * 1.30
    println("Valor de venda: R$ %.2f".format(venda))
}

fun algoritmo131() {
    val nome = lerTexto("Nome do aluno: ").trim()
    if (nome.isEmpty()) {
        println("Nome invalido.")
        return
    }
    val inicial = nome.first().uppercaseChar()
    val sala = when (inicial) {
        in 'A'..'K' -> "101"
        in 'L'..'N' -> "102"
        in 'O'..'Z' -> "103"
        else -> null
    }
    if (sala == null) println("Nome invalido.")
    else println("$nome - Bloco F, sala $sala")
}

fun algoritmo132() {
    val reais = lerDouble("Valor em reais: ")
    val moeda = lerTexto("Moeda (f=franco, l=libra, d=dolar, m=marco): ").lowercase()
    val nome = when (moeda) {
        "f" -> "francos suicos"
        "l" -> "libras esterlinas"
        "d" -> "dolares"
        "m" -> "marcos alemaes"
        else -> null
    }
    if (nome == null) {
        println("Moeda desconhecida.")
    } else {
        val cotacao = lerDouble("Valor de 1 $nome em reais: ")
        if (cotacao <= 0) println("Cotacao invalida.")
        else println("Total: %.2f $nome".format(reais / cotacao))
    }
}

fun algoritmo133() {
    val altura = lerDouble("Altura em metros: ")
    val sexo = lerTexto("Sexo (M/F): ").uppercase()
    val peso = when (sexo) {
        "M" -> 72.7 * altura - 58
        "F" -> 62.1 * altura - 44.7
        else -> {
            println("Sexo invalido.")
            return
        }
    }
    println("Peso ideal calculado: %.2f kg".format(peso))
}

fun algoritmo134() {
    val idade = lerInt("Idade do nadador: ")
    println(when {
        idade < 5 -> "Nao existe categoria para essa idade."
        idade <= 7 -> "Categoria Infantil A."
        idade <= 10 -> "Categoria Infantil B."
        idade <= 13 -> "Categoria Juvenil A."
        idade <= 17 -> "Categoria Juvenil B."
        else -> "Categoria Senior."
    })
}

fun algoritmo135() {
    val idade = lerInt("Digite a idade: ")
    println(when {
        idade < 0 -> "Idade invalida."
        idade < 16 -> "Nao eleitor."
        idade < 18 || idade > 65 -> "Eleitor facultativo."
        else -> "Eleitor obrigatorio."
    })
}

fun algoritmo136() {
    val nome = lerTexto("Nome: ")
    val idade = lerInt("Idade: ")
    val valor = when {
        idade < 0 -> null
        idade <= 10 -> 30
        idade <= 29 -> 60
        idade <= 45 -> 120
        idade <= 59 -> 150
        idade <= 65 -> 250
        else -> 400
    }
    if (valor == null) println("Idade invalida.")
    else println("$nome pagara R$ %.2f".format(valor.toDouble()))
}

fun algoritmo137() {
    val a = lerDouble("Valor de a: ")
    val b = lerDouble("Valor de b: ")
    val c = lerDouble("Valor de c: ")
    if (a == 0.0) {
        println("Nao e equacao do segundo grau.")
    } else {
        val delta = b * b - 4 * a * c
        if (delta < 0) println("Nao ha raizes reais.")
        else {
            val x1 = (-b + sqrt(delta)) / (2 * a)
            val x2 = (-b - sqrt(delta)) / (2 * a)
            println("X1 = $x1")
            println("X2 = $x2")
        }
    }
}

fun algoritmo138() {
    val numero = lerInt("Digite um numero de 1 a 12: ")
    val meses = listOf(
        "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    )
    if (numero in 1..12) println(meses[numero - 1])
    else println("Nao existe mes correspondente a esse numero.")
}

fun algoritmo139() {
    val municipio = lerTexto("Nome do municipio: ")
    val eleitores = lerInt("Numero de eleitores aptos: ")
    val votos = lerInt("Votos do candidato mais votado: ")
    if (eleitores > 0 && votos >= 0 && votos <= eleitores &&
        eleitores > 20000 && votos <= eleitores / 2) {
        println("$municipio tera segundo turno.")
    } else {
        println("$municipio nao tera segundo turno.")
    }
}

fun algoritmo140() {
    val nome = lerTexto("Primeiro nome do cliente: ")
    val conta = lerDouble("Valor da conta: ")
    if (nome.firstOrNull()?.uppercaseChar()?.let { it in listOf('A', 'O', 'M', 'S') } == true) {
        println("Valor com desconto: R$ %.2f".format(conta * 0.70))
    } else {
        println("Que pena. Nesta semana o desconto nao e para seu nome; mas continue nos prestigiando que sua vez chegara.")
    }
}

fun algoritmo141() {
    val nomes = Array(3) { lerTexto("Nome do ${it + 1}o finalista: ") }
    val pontos = IntArray(3) { lerInt("Pontos de ${nomes[it]}: ") }
    val colocacoes = (0..2).sortedByDescending { pontos[it] }
    println("Vencedor: ${nomes[colocacoes[0]]} - ${pontos[colocacoes[0]]} ptos")
    println("Segundo colocado: ${nomes[colocacoes[1]]} - ${pontos[colocacoes[1]]} ptos")
    println("Terceiro colocado: ${nomes[colocacoes[2]]} - ${pontos[colocacoes[2]]} ptos")
}

fun algoritmo142() {
    val pontos = IntArray(3) { lerInt("Pontos do jogador ${it + 1}: ") }
    println("Pontos em ordem decrescente: ${pontos.sortedDescending().joinToString(", ")}")
    val soma = pontos.sum()
    if (soma > 100) println("Media: %.2f".format(soma / 3.0))
    else println("Equipe desclassificada.")
}

fun algoritmo143() {
    val palavra = lerTexto("Digite uma palavra (minusculas): ")
    if (palavra.isEmpty()) {
        println("Palavra vazia.")
    } else if (palavra.length % 2 == 0) {
        val meio = palavra.length / 2
        val centrais = palavra.substring(meio - 1, meio + 1)
        if (centrais == "rr" || centrais == "ss") println("As letras centrais sao rr ou ss.")
        else println("As letras centrais nao sao rr nem ss.")
    } else {
        val central = palavra[palavra.length / 2]
        if (central in "aeiou") println("A letra central e vogal.")
        else println("A letra central nao e vogal.")
    }
}

fun algoritmo144() {
    val saldo = lerDouble("Saldo medio: ")
    val credito = when {
        saldo <= 500 -> 0.0
        saldo <= 1000 -> saldo * 0.30
        saldo <= 3000 -> saldo * 0.40
        else -> saldo * 0.50
    }
    println("Saldo medio: R$ %.2f".format(saldo))
    if (credito == 0.0) println("Voce nao tera credito.")
    else println("Credito: R$ %.2f".format(credito))
}

fun algoritmo145() {
    val livro = lerTexto("Nome do livro: ")
    val tipo = lerTexto("Tipo de usuario (professor/aluno): ").lowercase()
    val dias = when (tipo) {
        "professor" -> 10
        "aluno" -> 3
        else -> 0
    }
    if (dias == 0) println("Tipo de usuario desconhecido.")
    else {
        println("Nome do livro: $livro")
        println("Tipo de usuario: $tipo")
        println("Total de dias: $dias")
    }
}

fun algoritmo146() {
    val tipo = lerTexto("Tipo do carro (A/B/C): ").uppercase()
    val percurso = lerDouble("Percurso em km: ")
    val kmPorLitro = when (tipo) {
        "C" -> 12.0
        "B" -> 9.0
        "A" -> 8.0
        else -> 0.0
    }
    if (kmPorLitro == 0.0 || percurso < 0) println("Modelo ou percurso invalido.")
    else println("Consumo estimado: %.2f litros".format(percurso / kmPorLitro))
}

fun algoritmo147() {
    println("Prato: 1-Vegetariano 2-Peixe 3-Frango 4-Carne")
    val prato = lerInt("Opcao: ")
    val caloriasPrato = when (prato) {
        1 -> 180
        2 -> 230
        3 -> 250
        4 -> 350
        else -> 0
    }
    println("Sobremesa: 1-Abacaxi 2-Sorvete diet 3-Mousse diet 4-Mousse chocolate")
    val sobremesa = lerInt("Opcao: ")
    val caloriasSobremesa = when (sobremesa) {
        1 -> 75
        2 -> 110
        3 -> 170
        4 -> 200
        else -> 0
    }
    println("Bebida: 1-Cha 2-Suco de laranja 3-Suco de melao 4-Refrigerante diet")
    val bebida = lerInt("Opcao: ")
    val caloriasBebida = when (bebida) {
        1 -> 20
        2 -> 70
        3 -> 100
        4 -> 65
        else -> 0
    }
    if (caloriasPrato == 0 || caloriasSobremesa == 0 || caloriasBebida == 0)
        println("Uma ou mais opcoes sao invalidas.")
    else println("Total de calorias: ${caloriasPrato + caloriasSobremesa + caloriasBebida}")
}

fun algoritmo148() {
    println("Destino: 1-Norte 2-Nordeste 3-Centro-Oeste 4-Sul")
    val destino = lerInt("Opcao: ")
    val viagem = lerInt("Viagem: 1-Ida 2-Ida e volta: ")
    val preco = when (destino to viagem) {
        1 to 1 -> 500
        1 to 2 -> 900
        2 to 1 -> 350
        2 to 2 -> 650
        3 to 1 -> 350
        3 to 2 -> 600
        4 to 1 -> 300
        4 to 2 -> 550
        else -> null
    }
    if (preco == null) println("Opcao inexistente.")
    else println("Valor da passagem: R$ %.2f".format(preco.toDouble()))
}

fun algoritmo149() {
    val nome = lerTexto("Nome do produto: ")
    val compra = lerDouble("Valor da compra: ")
    val venda = when {
        compra < 10 -> compra * 1.70
        compra < 30 -> compra * 1.50
        compra < 50 -> compra * 1.40
        else -> compra * 1.30
    }
    println("$nome sera vendido por R$ %.2f".format(venda))
}

fun algoritmo150() {
    val angulo = lerDouble("Angulo em graus: ")
    val normalizado = ((angulo % 360) + 360) % 360
    val radianos = normalizado * PI / 180
    val quadrante = when {
        normalizado > 0 && normalizado <= 90 -> 1
        normalizado <= 180 -> 2
        normalizado <= 270 -> 3
        else -> 4
    }
    if (normalizado == 0.0) {
        println("Angulo sobre o eixo; nao pertence a um quadrante.")
    } else if (quadrante % 2 == 0) {
        println("Seno: ${sin(radianos)}")
    } else {
        println("Co-seno: ${cos(radianos)}")
    }
}

fun algoritmo151() {
    val nome = lerTexto("Nome do paciente: ")
    val peso = lerDouble("Peso em kg: ")
    val altura = lerDouble("Altura em metros: ")
    if (peso <= 0 || altura <= 0) {
        println("Peso ou altura invalido.")
        return
    }
    val imc = peso / (altura * altura)
    val risco = when {
        imc < 20 -> "Abaixo do peso"
        imc <= 25 -> "Normal"
        imc <= 30 -> "Excesso de peso"
        imc <= 35 -> "Obesidade"
        else -> "Obesidade morbida"
    }
    println("Paciente: $nome")
    println("IMC: %.2f".format(imc))
    println("Faixa indicada na tabela do exercicio: $risco")
}

fun algoritmo152() {
    println("EXERCICIO DIDATICO: calculo matematico baseado na tabela da apostila.")
    println("Isto nao e uma orientacao medica nem deve ser usado para administrar medicamento.")
    val peso = lerDouble("Peso em kg: ")
    val idade = lerInt("Idade: ")
    if (peso < 5) {
        println("A tabela do exercicio nao contempla peso abaixo de 5 kg. Consulte um profissional de saude.")
        return
    }
    val doseMg = if (idade >= 12) {
        if (peso >= 60) 1000.0 else 875.0
    } else {
        when {
            peso <= 9 -> 125.0
            peso <= 16 -> 250.0
            peso <= 24 -> 375.0
            peso <= 30 -> 500.0
            else -> 750.0
        }
    }
    val gotasCalculadas = doseMg / 25.0
    println("Dose hipotetica da tabela: $doseMg mg.")
    println("Equivalencia matematica da apostila: %.0f gotas.".format(gotasCalculadas))
    println("Nao utilize esse resultado como receita ou dose real.")
}

fun algoritmo153() {
    val indice = lerDouble("Indice de poluicao: ")
    when {
        indice >= 0.5 -> println("Suspender atividades das industrias dos grupos 1, 2 e 3.")
        indice >= 0.4 -> println("Suspender atividades das industrias dos grupos 1 e 2.")
        indice >= 0.3 -> println("Suspender atividades das industrias do grupo 1.")
        else -> println("Indice de poluicao aceitavel para todos os grupos.")
    }
}

fun algoritmo154() {
    val placa = lerTexto("Digite a placa do carro: ").trim()
    if (placa.isEmpty()) {
        println("Placa invalida.")
        return
    }
    val mes = when (placa.last()) {
        '1' -> "Janeiro"
        '2' -> "Fevereiro"
        '3' -> "Marco"
        '4' -> "Abril"
        '5' -> "Maio"
        '6' -> "Junho"
        '7' -> "Julho"
        '8' -> "Agosto"
        '9' -> "Setembro"
        '0' -> "Outubro"
        else -> null
    }
    if (mes == null) println("Opcao invalida.")
    else println("Renovacao do emplacamento: $mes.")
}

fun algoritmo155() {
    val palavra = lerTexto("Digite uma palavra: ")
    if (palavra.isEmpty()) {
        println("Palavra vazia.")
        return
    }
    val nova = if (palavra.first().lowercaseChar() == 'l' ||
        palavra.first().lowercaseChar() == 'd') {
        if (palavra.length >= 2) palavra.take(2) + palavra.last() else palavra
    } else {
        palavra.drop(1)
    }
    println("Nova palavra: $nova")
}

fun dataValida(dia: Int, mes: Int, ano: Int): Boolean {
    if (ano < 1 || mes !in 1..12 || dia < 1) return false
    val bissexto = ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)
    val diasMes = when (mes) {
        2 -> if (bissexto) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }
    return dia <= diasMes
}

fun algoritmo156() {
    val dia = lerInt("Dia: ")
    val mes = lerInt("Mes: ")
    val ano = lerInt("Ano: ")
    println(if (dataValida(dia, mes, ano)) "DATA VALIDA" else "DATA INVALIDA")
}

fun algoritmo157() {
    val data = lerTexto("Data no formato ddmmaaaa: ").trim()
    if (data.length != 8 || !data.all { it.isDigit() }) {
        println("DATA INVALIDA")
        return
    }
    val dia = data.substring(0, 2).toInt()
    val mes = data.substring(2, 4).toInt()
    val ano = data.substring(4, 8).toInt()
    println(if (dataValida(dia, mes, ano)) "DATA VALIDA" else "DATA INVALIDA")
}

fun algoritmo158() {
    val x = lerDouble("Digite o valor de x: ")
    if (x == 2.0) println("A funcao nao pode ser calculada para x = 2.")
    else println("f(x) = ${8 / (2 - x)}")
}

fun algoritmo159() {
    val x = lerDouble("Digite o valor de x: ")
    if (x > 4 || x < -4) {
        val resultado = (5 * x + 3) / sqrt(x * x - 16)
        println("f(x) = $resultado")
    } else println("A funcao nao pode ser calculada para esse valor de x.")
}

fun algoritmo160() {
    val x = lerDouble("Digite o valor de x: ")
    val y = when {
        x <= 1 -> 1.0
        x <= 2 -> 2.0
        x <= 3 -> x * x
        else -> x * x * x
    }
    println("Valor de f(x): $y")
}

fun main() {
    println("===== ALGORITMOS 112 A 160 =====")
    println("Digite o numero do algoritmo que deseja executar.")
    println("Digite 0 para sair.")

    while (true) {
        val opcao = lerInt("\nAlgoritmo (112-160): ")
        if (opcao == 0) {
            println("Programa encerrado.")
            break
        }

        when (opcao) {
            112 -> algoritmo112()
            113 -> algoritmo113()
            114 -> algoritmo114()
            115 -> algoritmo115()
            116 -> algoritmo116()
            117 -> algoritmo117()
            118 -> algoritmo118()
            119 -> algoritmo119()
            120 -> algoritmo120()
            121 -> algoritmo121()
            122 -> algoritmo122()
            123 -> algoritmo123()
            124 -> algoritmo124()
            125 -> algoritmo125()
            126 -> algoritmo126()
            127 -> algoritmo127()
            128 -> algoritmo128()
            129 -> algoritmo129()
            130 -> algoritmo130()
            131 -> algoritmo131()
            132 -> algoritmo132()
            133 -> algoritmo133()
            134 -> algoritmo134()
            135 -> algoritmo135()
            136 -> algoritmo136()
            137 -> algoritmo137()
            138 -> algoritmo138()
            139 -> algoritmo139()
            140 -> algoritmo140()
            141 -> algoritmo141()
            142 -> algoritmo142()
            143 -> algoritmo143()
            144 -> algoritmo144()
            145 -> algoritmo145()
            146 -> algoritmo146()
            147 -> algoritmo147()
            148 -> algoritmo148()
            149 -> algoritmo149()
            150 -> algoritmo150()
            151 -> algoritmo151()
            152 -> algoritmo152()
            153 -> algoritmo153()
            154 -> algoritmo154()
            155 -> algoritmo155()
            156 -> algoritmo156()
            157 -> algoritmo157()
            158 -> algoritmo158()
            159 -> algoritmo159()
            160 -> algoritmo160()
            else -> println("Opcao invalida. Escolha um numero entre 112 e 160.")
        }
    }
}