package org.rescueme.es.dog.domain.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.dogIdVO
import org.rescueme.es.dog.dogInformation
import org.rescueme.es.dog.shelterIdVO

class DogCreatorSpec : Spek({

    val repository = mockk<DogRepository>()
    val creator = DogCreator(repository)

    describe("#${DogCreator::invoke.name}") {
        on("Invoke dog creation") {
            every { repository.new(dogIdVO, shelterIdVO, dogInformation) } returns Unit
            it("Should create dog ok calling repository") {
                creator(dogIdVO, shelterIdVO, dogInformation)
                verify(exactly = 1) { repository.new(dogIdVO, shelterIdVO, dogInformation) }
            }
        }


    }
})