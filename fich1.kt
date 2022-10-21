import kotlin.math.PI
fun main()
{
val P:Point = Point(3,5)
println(P)
//affichera Point(x=3, y=5) si la classe est déclarée avec data 
//affichera Point@... si la classe n'est pas data
val C:Cercle=Cercle("vert")
println(C.toString())
// val C2:Cercle=Cercle("bleu",70f)
// println(C2.afficher())
// val C3:Cercle=Cercle("rose",50f,P)
// println(C3.afficher())
// println(C3.surface())

}

data class Point (var x:Int,var y:Int)
//La définition d'une data class permet au compilateur de générer
//les méthodes utilitaires telles que toString(), copy(), hashCode()
// et equals() en utilisant les attributs indiqués dans le constructeur
//primaire selon un modèle proposé par le système
abstract class Forme() 
//un constructeur primaine sans paramètres
{   var couleur:String
    init{couleur="blanc"}
    constructor(couleur:String):this()
    //Appel du constructeur primaire obligatoire s'il existe
    {this.couleur=couleur}
    constructor(forme:Forme):this()
    //Appel du constructeur primaire obligatoire s'il existe
    {this.couleur=forme.couleur}
abstract fun surface():Float
open fun afficher()="Couleur:"+couleur

}
class Cercle (couleur:String):Forme(couleur)
{var rayon :Float
 var centre:Point
    init
    {
        rayon=0f
        centre=Point(0,0)
    }
    constructor(couleur:String,rayon:Float):this(couleur)
    {
this.rayon=rayon
    }
    constructor(couleur:String,rayon:Float,centre:Point):this(couleur)
    {
this.rayon=rayon
this.centre=centre
    }
override fun afficher()=super.afficher() +"/rayon:"+rayon+"/centre x:"+centre.x + "/centre y:"+centre.y
override fun surface()=(PI*rayon*rayon).toString().toFloat()
override fun toString():String="Cercle de centre (" + centre.x+","+centre.y+")"+ " et de rayon :" +rayon +super.toString()
//il faut rajouter overrides sinon le message d'erreur 'toString' hides
// member of supertype 'Forme' and needs 'override' modifier va s'afficher
}



