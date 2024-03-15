package com.example.famrecycleviewapp

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
)

