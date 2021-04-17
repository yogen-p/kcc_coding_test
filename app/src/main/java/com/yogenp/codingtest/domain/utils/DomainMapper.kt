package com.yogenp.codingtest.domain.utils

// DomainMapper Interface
interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T

}