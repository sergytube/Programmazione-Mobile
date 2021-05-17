package com.example.progettomobile

data class ProvinceModel(var img: Int, var text: String) {

    constructor() : this(0, "")

    @JvmName("getImg1")
    fun getImg(): Int {
        return img
    }

    @JvmName("getText1")
    fun getText(): String? {
        return text
    }

    @JvmName("setImg1")
    fun setImg(img: Int) {
        this.img = img
    }

    @JvmName("setText1")
    fun setText(text: String?) {
        this.text = text!!
    }
}

