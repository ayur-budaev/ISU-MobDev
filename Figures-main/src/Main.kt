fun main() {

    val f = Rect(0,3,1,2)

    println("Rect")
    println("Current position(" + f.c_pos() + ")")
    f.rotate(RotateDirection.Turn,0,1)
    println("New position(" + f.c_pos() + ")")

    println("Current area(" + f.area() + ")")
    f.resize(2)
    println("New area(" + f.area() + ")")

    val f1 = Square(7,7,2)


    println("Square")
    println("Current position(" + f1.c_pos() + ")")
    f1.rotate(RotateDirection.CounterTurn,7,4)
    println("New position(" + f1.c_pos() + ")")

    println("Current area(" + f1.area() + ")")
    f1.resize(2)
    println("New area(" + f1.area() + ")")

    val f2 = Circle(2,2,3)

    println("Circle")
    println("Current position(" + f2.c_pos() + ")")
    f2.rotate(RotateDirection.Turn,0,0)
    println("New position(" + f2.c_pos() + ")")

    println("Current area(" + f2.area() + ")")
    f2.resize(2)
    println("New area(" +  f2.area() + ")")


}