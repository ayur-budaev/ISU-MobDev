import kotlin.math.cos
import kotlin.math.sin

class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Transforming, Figure(0) {

    var color: Int = -1

    lateinit var name: String
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int){
        width *= zoom; height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int){
        width = height.also { height = width }

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
        return (width*height).toFloat()
    }
}