import kotlin.math.cos
import kotlin.math.sin

class Circle(var x: Int, var y: Int, var r: Int) : Movable, Transforming, Figure(2) {
    var color: Int = -1
    val pi: Double = 3.14

    lateinit var name: String
    constructor(circle: Circle) : this(circle.x, circle.y, circle.r)

    override fun resize(zoom: Int){
        r*=zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int){


        when(direction){
            RotateDirection.Turn -> {
                x = y - centerY + centerX.also { y = -1 * (x - centerX) + centerY }
            }
            RotateDirection.CounterTurn -> {
                x = -1 * (y - centerY) + centerX.also { y = x - centerX + centerY }
            }
        }
    }
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }
    override fun c_pos():String {
        return(("x:$x y:$y").toString())
    }

    override fun area(): Float {
        return  (pi*r*r).toFloat()
    }
}