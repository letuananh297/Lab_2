class ShapeCollector {
    val listShape: MutableList<ColoredShape2d> = mutableListOf()

    fun addShape(shape: ColoredShape2d) {
        listShape.add(shape)
    }

    fun minArea(): Shape2d? {
        return if (listShape.isEmpty())
            null
        else {
            var min = listShape[0]
            for (temp in listShape) {
                if (temp.calcArea() < min.calcArea()) {
                    min = temp
                }
            }
            return min
        }
    }

    fun maxArea(): Shape2d? {
        return if (listShape.isEmpty())
            null
        else {
            var max = listShape[0]
            for (temp in listShape) {
                if (temp.calcArea() > max.calcArea()) {
                    max = temp
                }
            }
            return max
        }
    }

    fun sumArea(): Double {
        return if (listShape.isEmpty())
            0.0
        else {
            var sum = 0.0
            for (temp in listShape) {
                sum += temp.calcArea()
            }
            return sum
        }
    }

    fun shapesWithBorderColor(color: Color): List<ColoredShape2d> {
        return if (listShape.isEmpty())
            emptyList()
        else {
            val newList: MutableList<ColoredShape2d> = mutableListOf()
            for (temp in listShape) {
                if (temp.borderColor == color)
                    newList.add(temp)
            }
            return newList
        }
    }

    fun shapesWithFillColor(color: Color): List<ColoredShape2d> {
        return if (listShape.isEmpty())
            emptyList()
        else {
            val newList: MutableList<ColoredShape2d> = mutableListOf()
            for (temp in listShape) {
                if (temp.fillColor == color)
                    newList.add(temp)
            }
            return newList
        }
    }

    fun allShapes(): List<ColoredShape2d> {
        return listShape.toList()
    }

    fun numberShapes(): Int {
        var count = 0
        for (temp in listShape) {
            count += 1
        }
        return count
    }

    fun shapesGroupedByBorderColor(): Map<Color, List<ColoredShape2d>> {
        return if (listShape.isEmpty())
            emptyMap()
        else {
            val map = mutableMapOf<Color, List<ColoredShape2d>>()
            for (shape in listShape) {
                map[shape.borderColor] = shapesWithBorderColor(shape.borderColor)
            }
            return map
        }
    }

    fun shapesGroupedByFillColor(): Map<Color, List<ColoredShape2d>> {
        return if (listShape.isEmpty())
            emptyMap()
        else {
            val map = mutableMapOf<Color, List<ColoredShape2d>>()
            for (shape in listShape) {
                map[shape.fillColor] = shapesWithFillColor(shape.fillColor)
            }
            return map
        }
    }

    inline fun <reified T> shapesWithType(): List<ColoredShape2d> {
        return if (listShape.isEmpty())
            emptyList()
        else {
            val newList = mutableListOf<ColoredShape2d>()
            for (shape in listShape) {
                if (shape is T) {
                    newList.add(shape)
                }
            }
            return newList
        }
    }
}