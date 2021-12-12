package com.example.workexpt.model

class AllSuperheroes(
    var id: Int,
    var name: String,
    var biography: Biography,
    var connections: Connections,
    var images: Images
    )

class Biography(var fullName: String, var publisher: String)
class Connections(var groupAffiliation: String, var relatives: String)
class Images(var md: String, var lg: String)