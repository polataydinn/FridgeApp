package com.ayse.fridgeapp.constants

import com.ayse.fridgeapp.R


object Constants {
    val MONTHS_HASHMAP: HashMap<Int, String> = hashMapOf(
        1 to "Ocak",
        2 to "Şubat",
        3 to "Mart",
        4 to "Nisan",
        5 to "Mayıs",
        6 to "Haziran",
        7 to "Temmuz",
        8 to "Ağustos",
        9 to "Eylül",
        10 to "Ekim",
        11 to "Kasım",
        12 to "Aralık"
    )

    val FOOD_ICONS_HASHMAP: HashMap<String, Int> = hashMapOf(
        "Ekmek" to R.drawable.image_bread,
        "Pankek" to R.drawable.image_pancake,
        "Waffle" to R.drawable.image_waffle,
        "Simit" to R.drawable.image_bagel,
        "Kek" to R.drawable.image_pancake,
        "Donat" to R.drawable.image_doughnut,
        "Hamburger" to R.drawable.image_hamburger,
        "Pizza" to R.drawable.image_pizza,
        "Sandviç" to R.drawable.image_sandwich,
        "Sosis" to R.drawable.image_hot_dog,
        "Patetes Kızartma" to R.drawable.image_french_fries,
        "Elma" to R.drawable.image_apple,
        "Portakal" to R.drawable.image_orange,
        "Muz" to R.drawable.image_banana,
        "Üzüm" to R.drawable.image_grape
    )
}