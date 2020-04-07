package algorithm.kelvin.training.hb.recyclerview

data class Dummy(val group: String, val memberGroup: String, val statusGroup: Boolean)

fun getDataDummy(): ArrayList<Dummy> {
    val dataDummy = ArrayList<Dummy>()

    dataDummy.add(Dummy("Programming Language", "Java", true))
    dataDummy.add(Dummy("Programming Language", "Kotlin", true))
    dataDummy.add(Dummy("Programming Language", "Apple", false))
    dataDummy.add(Dummy("Programming Language", "MacBook", false))
    dataDummy.add(Dummy("Programming Language", "Swift", true))

    dataDummy.add(Dummy("Fruits", "Java", false))
    dataDummy.add(Dummy("Fruits", "Kotlin", false))
    dataDummy.add(Dummy("Fruits", "Apple", true))

    dataDummy.add(Dummy("Laptop", "Java", false))
    dataDummy.add(Dummy("Laptop", "Kotlin", false))

    dataDummy.add(Dummy("Animal", "Cow", true))
    dataDummy.add(Dummy("Animal", "Mango", false))
    dataDummy.add(Dummy("Animal", "Dog", true))
    dataDummy.add(Dummy("Animal", "Cat", true))

    return dataDummy
}