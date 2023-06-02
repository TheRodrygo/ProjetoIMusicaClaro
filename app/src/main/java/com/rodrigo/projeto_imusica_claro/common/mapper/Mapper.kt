package com.rodrigo.projeto_imusica_claro.common.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}