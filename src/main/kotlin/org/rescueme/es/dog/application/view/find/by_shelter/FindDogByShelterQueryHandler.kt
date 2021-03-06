package org.rescueme.es.dog.application.view.find.by_shelter

import org.axonframework.queryhandling.QueryHandler
import org.rescueme.es.dog.domain.view.find.by_shelter.DogByShelterFinder
import org.rescueme.es.dog.domain.view.find.by_shelter.FindDogByShelterQuery
import org.rescueme.es.dog.domain.view.toResponse
import org.rescueme.es.shelter.domain.ShelterId
import org.springframework.stereotype.Component

@Component
open class FindDogByShelterQueryHandler(private val finder: DogByShelterFinder) {

    @QueryHandler
    fun on(findDogByShelterQuery: FindDogByShelterQuery) =
        finder(ShelterId.fromString(findDogByShelterQuery.id)).toResponse()

}