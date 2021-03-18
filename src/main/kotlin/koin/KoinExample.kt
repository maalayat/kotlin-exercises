package koin

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

data class Address(private val name: String)

class AddressValidator() {
    fun validate(address: Address) {
    }
}

class UserService(private val addressValidator: AddressValidator) {
    fun createUser(name: String, address: Address) {
    }
}

val module = module {
    single { AddressValidator() }
    //The createdAtStart option tells Koin to create this
    // instance (and its dependencies) when the Koin application is started.
    single(createdAtStart = true) { UserService(get()) }
}

/**
 * Providing interface implementations
 */
interface IAddressValidator {
    fun validate(address: Address)
}
class AddressValidatorImpl : IAddressValidator {

    override fun validate(address: Address) {
        TODO("Not yet implemented")
    }

}


class ConfigurableComponent(val someProperty: String)

val myModule = module {
    fun provideUserService(addressValidator: AddressValidator): UserService {
        val userService = UserService(addressValidator)
        // more code to configure userService

        return userService
    }
    single { AddressValidator() }

    /**
     * Providing interface implementations
     */
    single<IAddressValidator> { AddressValidatorImpl() }

    /**
     * Factories
     */
    single { provideUserService(get()) }

    /**
     * Properties and configuration
     */
    single { ConfigurableComponent(getProperty("foo.bar")) }
}

val app = startKoin {
    fileProperties()
    modules(module)
}

/**
 * Retrieving objects from the Koin container
 */
fun main() {
    val service = app.koin.get<UserService>()
}

class MyApp : KoinComponent {
    private val userService by inject<UserService>()
}

