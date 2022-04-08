import kotlin.math.sqrt

class Circle(private val r: Double,
             override val borderColor: Color,
             override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        return Math.PI * r * r
    }
    override fun toString(): String {
        return "Circle($r, $borderColor, $fillColor)"
    }
             }

class Square(private val a: Double,
             override val borderColor: Color,
             override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        return a * a
    }
    override fun toString(): String {
        return "Square($a, $borderColor, $fillColor)"
    }
             }

class Rectangle(private val a: Double,
                private val b: Double,
                override val borderColor: Color,
                override val fillColor: Color) : ColoredShape2d {
    override fun calcArea(): Double {
        return a * b
    }
    override fun toString(): String {
        return "Rectangle($a, $b, $borderColor, $fillColor)"
    }
                }

class Triangle(private val a: Double,
               private val b: Double,
               private val c: Double,
               override val borderColor: Color,
               override val fillColor: Color) : ColoredShape2d {
    private val p : Double = (a+b+c)/2
    override fun calcArea(): Double {
        return sqrt(p*(p-a)*(p-b)*(p-c))
    }

    override fun toString(): String {
        return "Triangle($a, $b, $c, $borderColor, $fillColor)"
    }
               }