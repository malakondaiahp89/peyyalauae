Design discussion:

* Implemented /flight,/price service by using spring ***webflux*** to get the reactive  none blocking feature.
* Created some sample data in constructor of service to get Flight information to avoid complexity of database.
* Created ***5 separte downstream*** services which are running with different ports and responding with maximum delay of 800ms each.
* Calling them with ***Webclient*** instead of restTemplate to avoid blocking and executing in parallel with CompletableFuture objects runAsync methods.
* Eventhough all the services taking 800ms each, as we are running all at one time parallelly it should take overal 800ms or less.
* Join them by using CompletableFuture.allOf and join methods.
For simplicity not returning any data from those dummy services.
* ***Price service is implemented in separte microservice as it is getting very less requests and need not to scale that much frequently ***.
* Avoided placing /flight and /price in one microservice  becasue both load factor is totally opposite , if we want we can scal up flight service easily. Otherwise we have to scal /price service unneccerily.
* Using ***HazelCache distrubted cache mechanism ***to hold price details.
* Because it is distributed we can access price details throught different regions and datacenters where ever we deploy our service.
* For simplicity i just added cache mechanism for price service only for now, we can use it in flight service as well if require.
* written ***junit test cases*** to test service layer functional components and integration testing also done on controllers.
*Added docker files in airlines and airlinesprice projcets, it will be usefull while starting an container with all required softwares.
---- I can't say it is perfect solution for the requirement, but we can take it as starting point and improve the things progressively.---


