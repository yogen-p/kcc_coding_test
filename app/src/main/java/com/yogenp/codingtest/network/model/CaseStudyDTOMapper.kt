package com.yogenp.codingtest.network.model

import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.domain.utils.DomainMapper

class CaseStudyDTOMapper : DomainMapper<CaseStudyDTO, CaseStudy>{
    override fun mapToDomainModel(model: CaseStudyDTO): CaseStudy {
        return CaseStudy(
            id = model.id,
            client = model.client,
            teaser = model.teaser,
            vertical = model.vertical,
            isEnterprise = model.isEnterprise,
            title = model.title,
            heroImage = model.heroImage,
            appStoreUrl = model.appStoreUrl,
            sections = model.sections
        )
    }

    override fun mapFromDomainModel(domainModel: CaseStudy): CaseStudyDTO {
        return CaseStudyDTO(
            id = domainModel.id,
            client = domainModel.client,
            teaser = domainModel.teaser,
            vertical = domainModel.vertical,
            isEnterprise = domainModel.isEnterprise,
            title = domainModel.title,
            heroImage = domainModel.heroImage,
            appStoreUrl = domainModel.appStoreUrl,
            sections = domainModel.sections
        )
    }

    fun toDomainList(initial: List<CaseStudyDTO>): List<CaseStudy>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<CaseStudy>): List<CaseStudyDTO>{
        return initial.map { mapFromDomainModel(it) }
    }
}