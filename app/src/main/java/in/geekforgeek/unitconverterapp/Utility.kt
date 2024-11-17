package `in`.geekforgeek.unitconverterapp

enum class Utility(val unitName:String, val unitConstant:Double) {
    LENGTH("Length", 0.0),
    AREA("Area", 0.0),
    TIME("Time", 0.0),
    WEIGHT("Weight", 0.0),

    // Length
    METER("Meter", 1.0),
    CENTIMETER("Centimeter", 100.0),
    MILI_MITER("Milimeter", 1000.0),
    FOOT("Foot", 3.28),

    // Area
    METER_SQUARE("Meter Square", 1.0),
    FOOT_SQUARE("Foot square", 10.76),
    CENTIMETER_SQUARE("Centimeter Square", 10000.0),
    ACRE("Acre", 0.000247),

    // Time
    MINUTE("Minute", 1.0),
    HOUR("Hour", 0.0167),
    SECONDS("Second", 60.0),

    // Weight
    GRAM("Gram", 1.0),
    KILOGRAM("Kilogram", 0.001),
    MIlI_GRAM("Miligram", 1000.0)

}

val unitList = arrayListOf(Utility.LENGTH, Utility.AREA, Utility.TIME, Utility.WEIGHT)
val lengthList = arrayListOf(Utility.METER, Utility.CENTIMETER, Utility.MILI_MITER, Utility.FOOT)
val areaList = arrayListOf(Utility.METER_SQUARE, Utility.FOOT_SQUARE, Utility.CENTIMETER_SQUARE, Utility.ACRE)
val timeList = arrayListOf(Utility.MINUTE, Utility.HOUR, Utility.SECONDS)
val weightList = arrayListOf(Utility.GRAM, Utility.KILOGRAM, Utility.MIlI_GRAM)