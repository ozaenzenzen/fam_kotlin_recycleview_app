package com.example.famrecycleviewapp

import android.os.Parcel
import android.os.Parcelable

data class ModelPhone (
    val products: List<Phone>,
    val total: Long,
    val skip: Long,
    val limit: Long
)

data class Phone (
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
) : Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readValue(Long::class.java.classLoader) as Long,
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readValue(Long::class.java.classLoader) as Long,
//        parcel.readValue(Double::class.java.classLoader) as Double,
//        parcel.readValue(Double::class.java.classLoader) as Double,
//        parcel.readValue(Long::class.java.classLoader) as Long,
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.readString().toString(),
//        parcel.createStringArrayList() ?: emptyList()
//    )
constructor(parcel: Parcel) : this(
    parcel.readLong(),
    parcel.readString() ?: "",
    parcel.readString() ?: "",
    parcel.readLong(),
    parcel.readDouble(),
    parcel.readDouble(),
    parcel.readLong(),
    parcel.readString() ?: "",
    parcel.readString() ?: "",
    parcel.readString() ?: "",
    parcel.createStringArrayList() ?: ArrayList()
)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeLong(price)
        parcel.writeDouble(discountPercentage)
        parcel.writeDouble(rating)
        parcel.writeLong(stock)
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(thumbnail)
        parcel.writeStringList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Phone> {
        override fun createFromParcel(parcel: Parcel): Phone {
            return Phone(parcel)
        }

        override fun newArray(size: Int): Array<Phone?> {
            return arrayOfNulls(size)
        }
    }
}

