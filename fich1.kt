
fun main()
{
val P:Point = Point(3,5)
val F1:Forme=Forme()
F1.couleur="rouge"
println(F1.couleur)
val F2:Forme=Forme(F1)
println(F2.couleur)
val C:Cercle=Cercle("vert")
println(C.afficher())
val C2:Cercle=Cercle("bleu",70f)
println(C2.afficher())
val C3:Cercle=Cercle("rose",50f,P)
println(C3.afficher())
}

class Point (var x:Int,var y:Int)
open class Forme() 
//un constructeur primaine sans paramètres
{   var couleur:String
    init{couleur="blanc"}
    constructor(couleur:String):this()
    //Appel du constructeur primaire obligatoire s'il existe
    {this.couleur=couleur}
    constructor(forme:Forme):this()
    //Appel du constructeur primaire obligatoire s'il existe
    {this.couleur=forme.couleur}
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
fun afficher()="Couleur:"+couleur +"/rayon:"+rayon+"/centre x:"+centre.x + "/centre y:"+centre.y

}



