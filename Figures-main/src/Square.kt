import kotlin.math.cos
import kotlin.math.sin

class Square(var x: Int, var y: Int, var h_w: Int) : Movable, Transforming, Figure(1) {

    var color: Int = -1

    lateinit var name: String
    constructor(square: Square) : this(square.x, square.y, square.h_w)

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int){
        h_w*=zoom
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

    override fun c_pos():String {
        return(("x:$x y:$y").toString())
    }

    override fun area(): Float {
        return  (h_w*h_w).toFloat()
    }
}