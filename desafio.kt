// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(var id: Int, val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 120)


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
        imprimeInscritos()
    }
    
    fun imprimeInscritos(){
        val names = mutableListOf<String>()
        inscritos.forEach{
            names.add(it.nome)
        }
        println("Alunos inscrito na formação: ${names.joinToString(", ")}")
    }
   
}

    fun validaFormacao(conteudos: List<ConteudoEducacional>){
        var maxDuracao = 0;
        val disciplinas = mutableListOf<String>()
        
        for(conteudo in conteudos){
            maxDuracao += conteudo.duracao
            disciplinas.add(conteudo.nome)
            
        	if(maxDuracao > 360){
            	 throw IllegalArgumentException("Formação com dicliplinas ${disciplinas.joinToString()}, excede a duração maxima.")
            }
              
		}
        println("Formação com dicliplinas ${disciplinas.joinToString()}, legivel para criação.")
    }



fun main() {
    val usuario1 = Usuario(1, "Valdionor")
    val usuario2 = Usuario(2, "Junior")
    val usuario3 = Usuario(3, "Rodrigo ")
    val usuario4 = Usuario(4, "Nataniel")
    
    val cursos3 = listOf(ConteudoEducacional("Kotlin"), ConteudoEducacional("java", 240), ConteudoEducacional("NodeJs",60))
    val cursos2 = listOf(ConteudoEducacional("Kotlin"), ConteudoEducacional("java", 120))
    val cursos1 = listOf(ConteudoEducacional("Kotlin", 240))
    
    val formacao1 = Formacao("Back-end Developer - Kotlin, Java e NodeJs", cursos3, Nivel.AVANÇADO)
    val formacao2 = Formacao("Back-end Developer - Java/Kotlin ", cursos2, Nivel.BASICO)
    val formacao3 = Formacao("Back-end Developer - Kotlin", cursos1, Nivel.INTERMEDIARIO)
    
    
    formacao3.matricular(usuario1, usuario2)
    formacao2.matricular(usuario3, usuario4)
    
    
    validaFormacao(formacao3.conteudos)
    validaFormacao(formacao2.conteudos)
    validaFormacao(formacao1.conteudos)
    
    
}
