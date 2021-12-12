package com.information_systems.backend.convertors

interface AbstractConvertor<From, To> {
    fun convert(from: From): To
}