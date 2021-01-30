package org.rescueme.es.dog.domain.view.create

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.rescueme.es.dog.*

class CreateDogViewOnDogCreatedEventHandlerSpec : Spek({

    val creator = mockk<DogViewCreator>()
    val handler = CreateDogViewOnDogCreatedEventHandler(creator)

    describe("#${CreateDogViewOnDogCreatedEventHandler::on.name}") {
        on("Dog created event") {
            every { creator.invoke(dogIdVO, shelterIdVO, createDogInformation(), dateTime) } returns Unit
            it("Should invoke creator to create view") {
                handler.on(createDogCreatedEvent())
                verify(exactly = 1) { creator.invoke(dogIdVO, shelterIdVO, createDogInformation(), dateTime) }
            }
        }
    }
})